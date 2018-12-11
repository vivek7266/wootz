package wootz;

public interface SymbolGenerator {
    public GeneratorOutput generate(Layer layer, MLModel model, int indent, StringBuilder metaData, String flag, Boolean multiplexing);
}
