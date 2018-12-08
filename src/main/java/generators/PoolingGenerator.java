package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoolingGenerator extends BaseGenerator {

    @Override
    public GeneratorOutput generate(Layer layer, MLModel model, int indent, StringBuilder metaData, String flag) {
        if (layer.getName().startsWith("Mixed")) {
            return new GeneratorOutput("", 1);
        }
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
        String kernel_size = layer.getAttr("pooling_param.kernel_size");
        out.append("net");
        out.append(" = ");
        out.append("slim.max_pool2d");
        out.append("(")
                .append("net").append(",")
                .append("[")
                .append(kernel_size).append(", ").append(kernel_size)
                .append("]").append(",");
        if (layer.getAttr("pooling_param.stride") != null) {
            out.append("stride=").append(layer.getAttr("pooling_param.stride")).append(",");
        }
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
