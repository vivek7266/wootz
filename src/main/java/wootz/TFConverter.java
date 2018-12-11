package wootz;

import gen.CaffePrototxtLexer;
import gen.CaffePrototxtParser;
import generators.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

public class TFConverter {
    private final MLModel mlModel;
    private final SymbolGeneratorFactory generators;
    private final Boolean multiplexing;

    public TFConverter(Boolean multiplexing) {
        this.mlModel = new MLModel();
        this.generators = SymbolGeneratorFactory.getInstance();
        this.multiplexing = multiplexing;
        addGenerators();
    }

    private void addGenerators() {
        generators.addGenerator("Convolution", new ConvolutionGenerator());
        generators.addGenerator("Pooling", new ConvolutionGenerator());
        generators.addGenerator("Concat", new ConcatGenerator());
        generators.addGenerator("Dropout", new DropoutGenerator());
        generators.addGenerator("Reshape", new ReshapeGenerator());
        generators.addGenerator("Softmax", new SoftmaxGenerator());
        generators.addGenerator("SoftmaxWithLoss", new SoftmaxGenerator());
    }

    public String generateTensorFlowCode(String filename) throws IOException {

        generateMLModel(filename);

        List<Layer> layers = mlModel.getNonDataLayers();

        StringBuilder layerData = new StringBuilder();
        StringBuilder interimData = new StringBuilder();
        String lastBranchName = "";
        String numClasses = "100";
        String inputImageSize = "223";
        String inputName = "input";
        if (layers.get(1).getPrototxt().split(" ")[0].equals("input_shape")) {
            List<String> inputImageSizeArr = layers.get(1).getAttrList("dim");
            inputImageSize = inputImageSizeArr.get(inputImageSize.length() - 1);
        }
        if (layers.get(0).getPrototxt().split(":")[0].equals("input")) {
            inputName = layers.get(0).getPrototxt().split(": ")[1].replace("\"", "");
        }
        for (int layerIndex = 0; layerIndex < layers.size(); ) {
            Layer layer = layers.get(layerIndex);
            if (layer.getType().equals("ReLU") || layer.getType().equals("BatchNorm")) {
                layerIndex++;
                continue;
            }
            SymbolGenerator generator = generators.getGenerator(layer.getType());
            if (generator != null) { // If we have a generator
                // Generate code
                GeneratorOutput out = generator.generate(layer, mlModel, 3, interimData, lastBranchName, multiplexing);
                String segment = out.code;
                if (layer.getName().startsWith("Mixed")) {
                    if (layer.getType().equalsIgnoreCase("Concat")) {
                        layerData.append(segment);
                        layerData.append(System.lineSeparator());
                        interimData = new StringBuilder();
                    } else {
                        lastBranchName = layer.getName().split("/")[1];
                        interimData.append(segment);
                    }
                } else if (layer.getName().startsWith("Logits")) {
                    if (layer.getType().equalsIgnoreCase("Reshape")) {
                        layerData.append(segment);
                        layerData.append(System.lineSeparator());
                        interimData = new StringBuilder();
                    } else {
                        interimData.append(segment);
                    }
                } else {
                    layerData.append(segment);
                    layerData.append(System.lineSeparator());
                }

                if (layer.getName().equals("Logits/Conv2d_0c_1x1")) {
                    numClasses = layer.getAttr("convolution_param.num_output");
                }
                // Update layerIndex depending on how many layers we ended up translating
                layerIndex += out.numLayersTranslated;

            } else { // If we don't have a generator
                // We've decided to skip this layer. Generate no code. Just increment layerIndex
                // by 1 and move on to the next layer.
                layerIndex++;
            }
        }

        StringBuilder code = generateOverallConversion(layerData, numClasses, inputImageSize, inputName);

        return code.toString();
    }

    private void generateMLModel(String filename) throws IOException {
        CharStream codePointCharStream = CharStreams.fromFileName(filename);
        CaffePrototxtLexer lexer;

        lexer = new CaffePrototxtLexer(codePointCharStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CaffePrototxtParser parser = new CaffePrototxtParser(tokens);
        ParseTree tree = parser.prototxt();
        ParseTreeWalker walker = new ParseTreeWalker();
        CPLoader loader = new CPLoader(parser, mlModel);
        walker.walk(loader, tree);
    }

    private StringBuilder generateOverallConversion(StringBuilder layerData,
                                                    String numClasses, String inputImageSize, String inputName) {
        int indent = 0;
        StringBuilder code = new StringBuilder();
        generateImports(code);
        code.append(System.lineSeparator());
        generateSlim(code);
        code.append(System.lineSeparator());

        generateMLFunction(numClasses, inputName, code);
        code.append(System.lineSeparator());
        indent++;

        if (multiplexing) {
            generateMultiplexingTemplate(code, indent);
        }

        Utils.indentNextLine(code, indent);
        code.append("with tf.variable_scope(scope, \"Model\", reuse=reuse):");
        code.append(System.lineSeparator());
        indent++;

        Utils.indentNextLine(code, indent);
        code.append("with slim.arg_scope(default_arg_scope(is_training)):");
        code.append(System.lineSeparator());
        indent++;

        Utils.indentNextLine(code, indent);
        code.append("end_points = {}");
        code.append(System.lineSeparator());

        code.append(layerData);
        code.append(System.lineSeparator());

        code.append(mlModel.getName().toLowerCase()).append(".default_image_size").append(" = ").append(inputImageSize);
        code.append(System.lineSeparator());
        code.append(System.lineSeparator());

        code.append(generateDefaultArgScope());

        return code;
    }

    private StringBuilder generateDefaultArgScope() {
        StringBuilder out = new StringBuilder();
        out.append("# The code is applicable to any model. It is adapted from \n" +
                "# https://github.com/tensorflow/models/blob/master/research/slim/nets/inception_utils.py\n" +
                "def default_arg_scope(is_training=True, \n" +
                "                        weight_decay=0.00004,\n" +
                "                        use_batch_norm=True,\n" +
                "                        batch_norm_decay=0.9997,\n" +
                "                        batch_norm_epsilon=0.001,\n" +
                "                        batch_norm_updates_collections=tf.GraphKeys.UPDATE_OPS):\n" +
                "\n" +
                "   batch_norm_params = {\n" +
                "      # Decay for the moving averages.\n" +
                "      'decay': batch_norm_decay,\n" +
                "      # epsilon to prevent 0s in variance.\n" +
                "      'epsilon': batch_norm_epsilon,\n" +
                "      # collection containing update_ops.\n" +
                "      'updates_collections': batch_norm_updates_collections,\n" +
                "      # use fused batch norm if possible.\n" +
                "      'fused': None,\n" +
                "   }\n" +
                "   if use_batch_norm:\n" +
                "       normalizer_fn = slim.batch_norm\n" +
                "       normalizer_params = batch_norm_params\n" +
                "   else:\n" +
                "       normalizer_fn = None\n" +
                "       normalizer_params = {}\n" +
                "\n" +
                "   # Set training state \n" +
                "   with slim.arg_scope([slim.batch_norm, slim.dropout],\n" +
                "                        is_training=is_training):\n" +
                "       # Set weight_decay for weights in Conv and FC layers.\n" +
                "       with slim.arg_scope([slim.conv2d, slim.fully_connected],\n" +
                "                        weights_regularizer=slim.l2_regularizer(weight_decay)):\n" +
                "       # Set batch norm \n" +
                "       with slim.arg_scope(\n" +
                "          [slim.conv2d],\n" +
                "          normalizer_fn=normalizer_fn,\n" +
                "          normalizer_params=normalizer_params):\n" +
                "           # Set default padding and stride\n" +
                "           with slim.arg_scope([slim.conv2d, slim.max_pool2d],\n" +
                "                      stride=1, padding='SAME') as sc:\n" +
                "               return sc");
        return out;
    }

    private void generateMLFunction(String numClasses, String inputName, StringBuilder code) {
        code.append("def ");
        code.append(mlModel.getName().toLowerCase());
        code.append("(")
                .append(inputName).append(", ")
                .append("num_classes=").append(numClasses).append(", ")
                .append("is_training=").append("True").append(", ")
                .append("reuse=").append("None").append(", ")
                .append("scope=").append("'").append(mlModel.getName()).append("'");
        if (multiplexing) {
            code.append(", ").append("config=None");
        }
        code.append("):");
    }

    private void generateImports(StringBuilder code) {
        code.append("from __future__ import absolute_import");
        code.append(System.lineSeparator());
        code.append("from __future__ import division");
        code.append(System.lineSeparator());
        code.append("from __future__ import print_function");
        code.append(System.lineSeparator());
        code.append("import tensorflow as tf");
        code.append(System.lineSeparator());
    }

    private void generateSlim(StringBuilder code) {
        code.append("slim = tf.contrib.slim\n");
    }

    private void generateMultiplexingTemplate(StringBuilder code, int indent) {
        Utils.indentNextLine(code, indent);
        code.append("selectdepth = lambda k,v: int(config[k]['ratio']*v) if config and k in config and 'ratio' in config[k] else v");
        code.append(System.lineSeparator());
        Utils.indentNextLine(code, indent);
        code.append("selectinput = lambda k, v: config[k]['input'] if config and k in config and 'input' in config[k] else v");
        code.append(System.lineSeparator());
    }
}
