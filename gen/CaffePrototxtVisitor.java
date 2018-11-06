// Generated from /Users/saurabh/IdeaProjects/wootz/src/main/java/CaffePrototxt.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CaffePrototxtParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CaffePrototxtVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#prototxt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototxt(CaffePrototxtParser.PrototxtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#solver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolver(CaffePrototxtParser.SolverContext ctx);
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(CaffePrototxtParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#layer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayer(CaffePrototxtParser.LayerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(CaffePrototxtParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueObject}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueObject(CaffePrototxtParser.ValueObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueLeaf}
	 * labeled alternative in {@link CaffePrototxtParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueLeaf(CaffePrototxtParser.ValueLeafContext ctx);
	/**
	 * Visit a parse tree produced by {@link CaffePrototxtParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(CaffePrototxtParser.ObjectContext ctx);
}