package com.queryToAST.app.QueryLanguage;

// Generated from query.g by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link queryParser}.
 */
public interface queryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link queryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(queryParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(queryParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(queryParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(queryParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSpec(queryParser.SpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSpec(queryParser.SpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(queryParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(queryParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(queryParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(queryParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#st_co}.
	 * @param ctx the parse tree
	 */
	void enterSt_co(queryParser.St_coContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#st_co}.
	 * @param ctx the parse tree
	 */
	void exitSt_co(queryParser.St_coContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#prop}.
	 * @param ctx the parse tree
	 */
	void enterProp(queryParser.PropContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#prop}.
	 * @param ctx the parse tree
	 */
	void exitProp(queryParser.PropContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(queryParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(queryParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#st_in}.
	 * @param ctx the parse tree
	 */
	void enterSt_in(queryParser.St_inContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#st_in}.
	 * @param ctx the parse tree
	 */
	void exitSt_in(queryParser.St_inContext ctx);
}