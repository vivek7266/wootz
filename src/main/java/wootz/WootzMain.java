package wootz;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class WootzMain {
    private static String PROTO_FILE = "src/main/resources/inception_v1.prototxt";
    private static Boolean multiplexing = Boolean.FALSE;

    public static void main(String[] args) {
        System.setErr(new PrintStream(new OutputStream() {
            public void write(int b) {
            }
        }));
        try {
            if (args.length >= 1) {
                PROTO_FILE = args[0];
            }
            if (args.length >= 2) {
                multiplexing = Boolean.parseBoolean(args[1]);
            }
            TFConverter tfConverter = new TFConverter(multiplexing);
            String code = tfConverter.generateTensorFlowCode(PROTO_FILE);
//            System.out.println(code);
            String saveFileName = "compiledDNNTF";
            try {
                if (PROTO_FILE.contains("/") && PROTO_FILE.endsWith(".prototxt")) {
                    String[] saveFileNameSplit = PROTO_FILE.split(".prototxt")[0].split("/");
                    saveFileName = saveFileNameSplit[saveFileNameSplit.length - 1];
                    if (multiplexing) {
                        saveFileName += "-multiplex";
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in renaming file with different name; default name used");
            }
            saveFileName += ".py";
            try (PrintWriter out = new PrintWriter(saveFileName)) {
                out.println(code);
                out.flush();
                System.out.println(String.format("Saved file in location: %s",saveFileName));
            } catch (Exception e) {
                System.out.println("Exception in saving file");
            }

        } catch (IOException e) {

            System.out.println(String.format("File not found; name: %s", PROTO_FILE));
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println(String.format("Compiler Error: %s", e.getMessage()));
            e.printStackTrace();
        }
    }
}
