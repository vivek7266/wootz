import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CPLoader extends CaffePrototxtBaseListener {

    Integer name = 0;
    Integer layer = 0;
    Integer inputLayer = 0;
    Integer input = 0;

    @Override
    public void enterName(CaffePrototxtParser.NameContext ctx) {
        super.enterName(ctx);
    }

    @Override
    public void exitName(CaffePrototxtParser.NameContext ctx) {
//        System.out.println(String.format("name : %s", ctx.STRING().getText()));
//        if (ctx.ID().getText().equals("name")){
//            layer++;
//        }
        super.exitName(ctx);
    }

    @Override
    public void enterLayer(CaffePrototxtParser.LayerContext ctx) {
        super.enterLayer(ctx);
    }

    @Override
    public void exitLayer(CaffePrototxtParser.LayerContext ctx) {
//        System.out.println(String.format("layer : %s", ctx.ID().getText()));
        if (ctx.ID().getText().equals("layer")) {
            layer++;
        } else if (ctx.ID().getText().equals("input_shape")) {
            inputLayer++;
        } else if (ctx.ID().getText().equals("input")) {
            input++;
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }
}
