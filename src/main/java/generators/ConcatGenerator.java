package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class ConcatGenerator extends BaseGenerator {


    private StringBuilder generateMixedLayerConcat(Layer layer, int indent, StringBuilder mixedLayerData, Boolean multiplexing) {
        StringBuilder codeMod = new StringBuilder();

        Utils.indentNextLine(codeMod, indent);
        generateName(layer, codeMod);
        codeMod.append(System.lineSeparator());

        if (multiplexing){
            Utils.indentNextLine(codeMod, indent);
            codeMod.append("net = selectinput(end_point, net)");
            codeMod.append(System.lineSeparator());
        }

        Utils.indentNextLine(codeMod, indent);
        codeMod.append("with tf.variable_scope(end_point):");
        indent++;
        codeMod.append(System.lineSeparator());

        codeMod.append(mixedLayerData);

        Utils.indentNextLine(codeMod, indent);
        codeMod.append("net").append(" = ").append("tf.concat").append("(");
        codeMod.append("axis=3").append(", ").append("values=").append("[")
                .append(buildBranches(ConvolutionGenerator.lastVarCount)).append("]")
                .append(")");
        codeMod.append(System.lineSeparator());
        indent--;

        Utils.indentNextLine(codeMod, indent);
        generateEndPointsMap(codeMod);
        codeMod.append(System.lineSeparator());
        ConvolutionGenerator.lastVarCount = -1;
        return codeMod;
    }

    private StringBuilder getBottomsNames(Layer layer) {
        StringBuilder bottoms = new StringBuilder();
        int idx = 0;
        for (String bottom : layer.getBottoms()) {
            if (idx > 0) {
                bottoms.append(", ");
            }
            bottoms.append(bottom.split("/")[1]);
            idx++;
        }
        return bottoms;
    }

    private StringBuilder buildBranches(int numBranches){
        StringBuilder branches = new StringBuilder();
        for (int i = 0; i <= numBranches;i++){
            if (i > 0) {
                branches.append(", ");
            }
            branches.append("branch_").append(i);
        }
        return branches;
    }


    @Override
    public GeneratorOutput generate(Layer layer,
                                    MLModel model, int indent, StringBuilder mixedLayerData, String flag, Boolean multiplexing) {
        StringBuilder out = generateMixedLayerConcat(layer, indent, mixedLayerData, multiplexing);

        return new GeneratorOutput(out.toString(), 1);
    }

    private void generateEndPointsMap(StringBuilder out) {
        out.append("end_points[end_point] = net");
    }

    private void generateName(Layer layer, StringBuilder out) {
        out.append("end_point").append(" = ").append("'").append(layer.getName()).append("'");
    }
}
