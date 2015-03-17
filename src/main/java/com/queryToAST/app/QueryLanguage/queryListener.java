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
	 * Enter a parse tree produced by {@link queryParser#sel_li_prop}.
	 * @param ctx the parse tree
	 */
	void enterSel_li_prop(queryParser.Sel_li_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#sel_li_prop}.
	 * @param ctx the parse tree
	 */
	void exitSel_li_prop(queryParser.Sel_li_propContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#sel_prop}.
	 * @param ctx the parse tree
	 */
	void enterSel_prop(queryParser.Sel_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#sel_prop}.
	 * @param ctx the parse tree
	 */
	void exitSel_prop(queryParser.Sel_propContext ctx);
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
	 * Enter a parse tree produced by {@link queryParser#pack}.
	 * @param ctx the parse tree
	 */
	void enterPack(queryParser.PackContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#pack}.
	 * @param ctx the parse tree
	 */
	void exitPack(queryParser.PackContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#fro_pac}.
	 * @param ctx the parse tree
	 */
	void enterFro_pac(queryParser.Fro_pacContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#fro_pac}.
	 * @param ctx the parse tree
	 */
	void exitFro_pac(queryParser.Fro_pacContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(queryParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(queryParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(queryParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(queryParser.CondContext ctx);
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
	 * Enter a parse tree produced by {@link queryParser#annot}.
	 * @param ctx the parse tree
	 */
	void enterAnnot(queryParser.AnnotContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#annot}.
	 * @param ctx the parse tree
	 */
	void exitAnnot(queryParser.AnnotContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(queryParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(queryParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(queryParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(queryParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#an_value}.
	 * @param ctx the parse tree
	 */
	void enterAn_value(queryParser.An_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#an_value}.
	 * @param ctx the parse tree
	 */
	void exitAn_value(queryParser.An_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(queryParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(queryParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(queryParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(queryParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(queryParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(queryParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#order_by}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by(queryParser.Order_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#order_by}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by(queryParser.Order_byContext ctx);
}