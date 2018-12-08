package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class DropoutGenerator extends BaseGenerator {

    @Override
    public GeneratorOutput generate(Layer layer,
                                    MLModel model, int indent, StringBuilder mixedLayerData, String flag) {
        StringBuilder out = new StringBuilder();
        indent++;

        Utils.indentNextLine(out, indent);
        out.append("net");
        out.append(" = ");
        out.append("slim.dropout");
        out.append("(")
                .append("net").append(", ")
                .append(layer.getAttr("dropout_param.dropout_ratio")).append(", ")
                .append("scope=").append("'").append(layer.getName().split("/")[1]).append("'")
                .append(")");
        out.append(System.lineSeparator());
        return new GeneratorOutput(out.toString(), 1);
    }
}
