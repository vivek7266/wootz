package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class SoftmaxGenerator extends BaseGenerator {

    @Override
    public GeneratorOutput generate(Layer layer,
                                    MLModel model, int indent, StringBuilder mixedLayerData, String flag) {
        StringBuilder out = new StringBuilder();

        Utils.indentNextLine(out, indent);
        out.append("end_points").append("[")
                .append("'").append(layer.getName()).append("'").append("]")
                .append(" = ")
                .append("slim.").append("softmax")
                .append("(").append("logits").append(", ")
                .append("scope=").append("'").append(layer.getName()).append("'").append(")");
        out.append(System.lineSeparator());
        return new GeneratorOutput(out.toString(), 1);
    }
}
