package wootz;

import java.io.IOException;

public class WootzMain {
    private static final String PROTO_FILE = "src/main/resources/inception_v1.prototxt";

    public static void main(String[] args) {
        try {
            TFConverter tfConverter = new TFConverter();
            String code = tfConverter.generateTensorFlowCode(PROTO_FILE);
            System.out.println("output");
            System.out.println(code);
        } catch (IOException e) {

            System.err.println(String.format("File not found; name: %s", PROTO_FILE));
            e.printStackTrace();

        }
    }
}
