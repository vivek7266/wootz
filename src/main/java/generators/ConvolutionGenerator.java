package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class ConvolutionGenerator extends BaseGenerator {


    @Override
    public GeneratorOutput generate(Layer layer,
                                    MLModel model, int indent, StringBuilder metaData, String lastBranchName) {
        if (layer.getName().startsWith("Mixed")) {
            return new GeneratorOutput(genrateMixedLayer(layer, model, indent, lastBranchName).toString(), 1);
        } else if (layer.getName().startsWith("Logits")) {
            return new GeneratorOutput(generateLogitsLayer(layer, indent).toString(), 1);
        }

        StringBuilder out = new StringBuilder();

        Utils.indentNextLine(out, indent);
        generateName(layer, out);
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        generateLayerSlimFunction(layer, out, "net", "net", "end_point", getLayerType(layer));
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        generateEndPointsMap(out);
        out.append(System.lineSeparator());

        return new GeneratorOutput(out.toString(), 1);
    }

    private StringBuilder generateLogitsLayer(Layer layer, int indent) {
        StringBuilder out = new StringBuilder();

        indent++;
        Utils.indentNextLine(out, indent);
        out.append("logits").append(" = ").append("slim.").append("conv2d").append("(")
                .append("num_classes").append(", ");
        out.append("[");
        String kernel_size = layer.getAttr("convolution_param.kernel_size");
        out.append(kernel_size).append(", ").append(kernel_size).append("]").append(", ");
        out.append("activation_fn=None").append(", ");
        out.append("normalizer_fn=None").append(", ");
        out.append("scope=").append("'").append(layer.getName().split("/")[1]).append("'").append(")");
        out.append(System.lineSeparator());
        return out;
    }


    private StringBuilder genrateMixedLayer(Layer layer, MLModel model, int indent, String lastBranchName) {

        String[] nameSplit = layer.getName().split("/");
        String branchName = nameSplit[1];
        String scopeName = nameSplit[2];
        String lastLayerName = branchName;
        StringBuilder out = new StringBuilder();

        indent++;
        if (!lastBranchName.equals(branchName)) {
            lastLayerName = "net";
            Utils.indentNextLine(out, indent);
            out.append("with tf.variable_scope(").append("'").append(branchName).append("'):");
            out.append(System.lineSeparator());
        }
        indent++;

        Utils.indentNextLine(out, indent);
        generateLayerSlimFunction(layer, out, branchName, lastLayerName, scopeName, getLayerType(layer));
        out.append(System.lineSeparator());
        return out;
    }

    private String getLayerType(Layer layer) {
        String layerType = "conv2d";
        if (layer.getType().equalsIgnoreCase("Pooling")) {
            if (layer.getName().startsWith("Max")) {
                layerType = "max_pool2d";
            } else if (layer.getName().startsWith("Avg")) {
                layerType = "avg_pool2d";
            }
        }
        return layerType;
    }

    private void generateEndPointsMap(StringBuilder out) {
        out.append("end_points[end_point] = net");
    }

    private void generateLayerSlimFunction(Layer layer, StringBuilder out,
                                           String intialVariable, String lastLayerName, String scopeName, String layerType) {
        if (layer.getType().equals("Pooling")) {
            generatePoolingLayerSlimFunction(layer, out, intialVariable, scopeName, layerType);
            return;
        }
        out.append(intialVariable);
        out.append(" = ");
        out.append("slim.");
        out.append(layerType);
        out.append("(");
        out.append((layer.getLayerIndex() > 2) ? lastLayerName : layer.getBottom()).append(", ");
        out.append(layer.getAttr("convolution_param.num_output")).append(", ");
        out.append("[");
        String kernel_size = layer.getAttr("convolution_param.kernel_size");
        out.append(kernel_size).append(", ").append(kernel_size).append("]").append(", ");
        if (layer.getAttr("convolution_param.stride") != null) {
            out.append("stride=").append(layer.getAttr("convolution_param.stride")).append(", ");
        }
        out.append("scope=").append("'").append(scopeName).append("'").append(")");
    }

    private void generatePoolingLayerSlimFunction(Layer layer, StringBuilder out,
                                                  String intialVariable, String scopeName, String layerType) {
        String kernel_size;
        if (!layer.getAttr().containsKey("pooling_param.kernel_size")) {
            String[] name_split = layer.getName().split("x");
            kernel_size = name_split[1].split("_")[0];
        } else {
            kernel_size = layer.getAttr("pooling_param.kernel_size");
        }
        out.append(intialVariable);
        out.append(" = ");
        out.append("slim.");
        out.append(layerType);
        out.append("(")
                .append("net").append(", ")
                .append("[")
                .append(kernel_size).append(", ").append(kernel_size)
                .append("]").append(",");
        if (layer.getAttr("pooling_param.stride") != null) {
            out.append("stride=").append(layer.getAttr("pooling_param.stride")).append(", ");
        }
        out.append("scope=").append("'").append(scopeName).append("'").append(")");
    }

    private void generateName(Layer layer, StringBuilder out) {
        out.append("end_point");
        out.append(" = ");
        out.append("'");
        out.append(layer.getName());
        out.append("'");
    }
}
