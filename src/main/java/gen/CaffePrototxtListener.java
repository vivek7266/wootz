package gen;// Generated from /Users/saurabh/IdeaProjects/wootz/src/main/java/CaffePrototxt.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CaffePrototxtParser}.
 */
public interface CaffePrototxtListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#prototxt}.
	 * @param ctx the parse tree
	 */
	void enterPrototxt(CaffePrototxtParser.PrototxtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#prototxt}.
	 * @param ctx the parse tree
	 */
	void exitPrototxt(CaffePrototxtParser.PrototxtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#solver}.
	 * @param ctx the parse tree
	 */
	void enterSolver(CaffePrototxtParser.SolverContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#solver}.
	 * @param ctx the parse tree
	 */
	void exitSolver(CaffePrototxtParser.SolverContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(CaffePrototxtParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(CaffePrototxtParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#layer}.
	 * @param ctx the parse tree
	 */
	void enterLayer(CaffePrototxtParser.LayerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#layer}.
	 * @param ctx the parse tree
	 */
	void exitLayer(CaffePrototxtParser.LayerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(CaffePrototxtParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(CaffePrototxtParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueObject}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueObject(CaffePrototxtParser.ValueObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueObject}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueObject(CaffePrototxtParser.ValueObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueLeaf}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLeaf(CaffePrototxtParser.ValueLeafContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueLeaf}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLeaf(CaffePrototxtParser.ValueLeafContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaffePrototxtParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(CaffePrototxtParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaffePrototxtParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(CaffePrototxtParser.ObjectContext ctx);
}