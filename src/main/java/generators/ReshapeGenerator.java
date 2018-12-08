package generators;

import wootz.GeneratorOutput;
import wootz.Layer;
import wootz.MLModel;
import wootz.Utils;

public class ReshapeGenerator extends BaseGenerator {

    @Override
    public GeneratorOutput generate(Layer layer,
                                    MLModel model, int indent, StringBuilder logitsLayerData, String flag) {
        StringBuilder out = new StringBuilder();

        Utils.indentNextLine(out, indent);
        out.append("end_point = 'Logits'");
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        out.append("with tf.variable_scope(end_point):");
        out.append(System.lineSeparator());
        indent++;

        out.append(logitsLayerData);

        Utils.indentNextLine(out, indent);
        out.append("logits = tf.squeeze(logits, [1, 2], name='SpatialSqueeze')");
        out.append(System.lineSeparator());

        Utils.indentNextLine(out, indent);
        out.append("end_points[end_point] = logits");
        out.append(System.lineSeparator());
        return new GeneratorOutput(out.toString(), 1);
    }
}
