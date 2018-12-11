package wootz;

import gen.CaffePrototxtBaseListener;
import gen.CaffePrototxtParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CPLoader extends CaffePrototxtBaseListener {

    private final MLModel mlModel;
    private final CaffePrototxtParser parser;
    private final Stack<String> keys;
    private Layer currentLayer;
    private Map<String, String> currentParams;
    private final Utils utils;

    public CPLoader(CaffePrototxtParser parser, MLModel mlModel) {
        this.parser = parser;
        this.mlModel = mlModel;
        this.keys = new Stack<String>();
        this.currentParams = new HashMap<String, String>();
        this.utils = new Utils();
    }

    Integer pair = 0;
    Integer value = 0;
    Integer object = 0;
    Integer layer = 0;
    Integer inputLayer = 0;
    Integer input = 0;


    @Override
    public void enterName(CaffePrototxtParser.NameContext ctx) {
        super.enterName(ctx);
    }

    @Override
    public void exitName(CaffePrototxtParser.NameContext ctx) {
        String name = ctx.STRING().toString();
        mlModel.setName(utils.setProperName(name));
    }

    @Override
    public void enterLayer(CaffePrototxtParser.LayerContext ctx) {
        if (ctx.ID().getText().equals("layer")) {
            layer++;
        } else if (ctx.ID().getText().equals("input_shape")) {
            inputLayer++;
        } else if (ctx.ID().getText().equals("input")) {
            input++;
        }
        keys.clear();
        currentLayer = new Layer();
    }

    @Override
    public void exitLayer(CaffePrototxtParser.LayerContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String prototxt = getPrototxt(tokens, ctx.getStart().getTokenIndex(), ctx.getStop().getTokenIndex());

        if (currentLayer.getTops().size() == 1) {
            currentLayer.addAttr("top", currentLayer.getTops().get(0));
        }

        if (currentLayer.getBottoms().size() == 1) {
            currentLayer.addAttr("bottom", currentLayer.getBottoms().get(0));
        }

        currentLayer.setPrototxt(prototxt);
        mlModel.addLayer(currentLayer);
    }


    @Override
    public void enterPrototxt(CaffePrototxtParser.PrototxtContext ctx) {
        super.enterPrototxt(ctx);
    }

    @Override
    public void exitPrototxt(CaffePrototxtParser.PrototxtContext ctx) {
        mlModel.setLayerList(mlModel.reOrderLayers(mlModel.getLayerList()));
    }

    @Override
    public void enterSolver(CaffePrototxtParser.SolverContext ctx) {
        super.enterSolver(ctx);
    }

    @Override
    public void exitSolver(CaffePrototxtParser.SolverContext ctx) {
        super.exitSolver(ctx);
    }

    @Override
    public void enterPair(CaffePrototxtParser.PairContext ctx) {
        pair++;
        String key = ctx.getStart().getText();
        keys.push(key);
    }

    @Override
    public void exitPair(CaffePrototxtParser.PairContext ctx) {
        pair--;
        if (getCurrentKey().equals("param")) {
            currentLayer.getParams().add(currentParams);
            currentParams = new HashMap<String, String>();
        }

        keys.pop();
    }

    @Override
    public void enterValueObject(CaffePrototxtParser.ValueObjectContext ctx) {
        super.enterValueObject(ctx);
    }

    @Override
    public void exitValueObject(CaffePrototxtParser.ValueObjectContext ctx) {
        super.exitValueObject(ctx);
    }

    @Override
    public void enterValueLeaf(CaffePrototxtParser.ValueLeafContext ctx) {
        super.enterValueLeaf(ctx);
    }

    @Override
    public void exitValueLeaf(CaffePrototxtParser.ValueLeafContext ctx) {
        String value = ctx.getText();
        value = utils.removeQuotes(value);
        processKeyValue(getCurrentKey(), value);
    }

    @Override
    public void enterObject(CaffePrototxtParser.ObjectContext ctx) {
        object++;
    }

    @Override
    public void exitObject(CaffePrototxtParser.ObjectContext ctx) {
        object--;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
//        System.out.println(node.getText() + " - pair: " + pair + " - layer: " + layer + " - object: " + object);
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    private String getPrototxt(TokenStream stream, int start, int end) {
        StringBuilder prototxt = new StringBuilder();
        for (int i = start; i <= end; i++) {
            Token token = stream.get(i);
            prototxt.append(token.getText());
        }
        String strPrototxt = prototxt.toString();
        return strPrototxt.replaceAll(" +num_examples:.*\\s", "");
    }

    private String getCurrentKey() {
        StringBuilder sb = new StringBuilder();
        for (String s : keys) {
            sb.append(s).append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    protected void processKeyValue(String key, String value) {
        switch (key) {
            case "name":
                currentLayer.setName(value);
                break;
            case "top":
                currentLayer.addTop(value);
                return;
            case "bottom":
                currentLayer.addBottom(value);
                return;
        }

        if (key.toLowerCase().startsWith("param.")) {
            currentParams.put(key, value);
        }

        currentLayer.addAttr(key, value);
    }

}
