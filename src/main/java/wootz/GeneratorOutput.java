package wootz;

public class GeneratorOutput {
    public final String code;
    public final int numLayersTranslated;

    public GeneratorOutput(String code, int n) {
        this.code = code;
        this.numLayersTranslated = n;
    }
}
