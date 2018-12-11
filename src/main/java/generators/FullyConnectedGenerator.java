package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class FullyConnectedGenerator extends BaseGenerator {

    @Override
    public GeneratorOutput generate(Layer layer, MLModel model, int indent, StringBuilder metaData, String flag, Boolean multiplexing) {
        StringBuilder out = new StringBuilder();

        Utils.indentNextLine(out, indent);
        generateName(layer, out);
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        generateLayerSlimFunction(layer, out);
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        generateEndPointsMap(out);
        out.append(System.lineSeparator());

        return new GeneratorOutput(out.toString(), 1);
    }

    private void generateEndPointsMap(StringBuilder out) {
        out.append("end_points[end_point] = net");
    }

    private void generateLayerSlimFunction(Layer layer, StringBuilder out) {
        out.append("net");
        out.append(" = ");
        out.append("slim.fully_connected");
        out.append("(")
                .append("net").append(", ");
        out.append("scope=end_point").append(")");
    }

    private void generateName(Layer layer, StringBuilder out) {
        out.append("end_point");
        out.append(" = ");
        out.append("'");
        out.append(layer.getName());
        out.append("'");
    }
}
