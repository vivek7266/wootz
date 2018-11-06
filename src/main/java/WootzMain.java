import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class WootzMain {
    public static final String PROTO_FILE = "/Users/saurabh/IdeaProjects/wootz/src/main/resources/inception_v1.prototxt";

    public static void main(String[] args) {
        try {

            CharStream codePointCharStream = CharStreams.fromFileName(PROTO_FILE);
            CaffePrototxtLexer lexer;

            lexer = new CaffePrototxtLexer(codePointCharStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CaffePrototxtParser parser = new CaffePrototxtParser(tokens);
            ParseTree tree = parser.prototxt();
            System.out.println(tree.toStringTree());
            ParseTreeWalker walker = new ParseTreeWalker();
            CPLoader loader = new CPLoader();
            walker.walk(loader, tree);
            System.out.println(loader.input);
            System.out.println(loader.inputLayer);
            System.out.println(loader.layer);
        } catch (IOException e) {

            System.err.println(String.format("File not found; name: %s", PROTO_FILE));
            e.printStackTrace();

        }
    }
}
