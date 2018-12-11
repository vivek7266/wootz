package wootz;

import java.io.IOException;
import java.io.PrintWriter;

public class WootzMain {
    private static String PROTO_FILE = "src/main/resources/inception_v1.prototxt";
    private static Boolean multiplexing = Boolean.FALSE;
    public static void main(String[] args) {
        try {
            multiplexing = Boolean.TRUE;
            TFConverter tfConverter = new TFConverter(multiplexing);
            String code = tfConverter.generateTensorFlowCode(PROTO_FILE);
            System.out.println("output");
            System.out.println(code);

            try (PrintWriter out = new PrintWriter("compiledDNNTF.py")) {
                out.println(code);
                out.flush();
            }

        } catch (IOException e) {

            System.err.println(String.format("File not found; name: %s", PROTO_FILE));
            e.printStackTrace();

        }
    }
}
