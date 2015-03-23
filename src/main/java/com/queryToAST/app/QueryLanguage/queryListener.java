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
	 * Enter a parse tree produced by {@link queryParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(queryParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(queryParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#selectStatment}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatment(queryParser.SelectStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#selectStatment}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatment(queryParser.SelectStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#paramSelect}.
	 * @param ctx the parse tree
	 */
	void enterParamSelect(queryParser.ParamSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#paramSelect}.
	 * @param ctx the parse tree
	 */
	void exitParamSelect(queryParser.ParamSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#paramName}.
	 * @param ctx the parse tree
	 */
	void enterParamName(queryParser.ParamNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#paramName}.
	 * @param ctx the parse tree
	 */
	void exitParamName(queryParser.ParamNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#packages}.
	 * @param ctx the parse tree
	 */
	void enterPackages(queryParser.PackagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#packages}.
	 * @param ctx the parse tree
	 */
	void exitPackages(queryParser.PackagesContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(queryParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(queryParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(queryParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(queryParser.ConditionsContext ctx);
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
	 * Enter a parse tree produced by {@link queryParser#innerSelect}.
	 * @param ctx the parse tree
	 */
	void enterInnerSelect(queryParser.InnerSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#innerSelect}.
	 * @param ctx the parse tree
	 */
	void exitInnerSelect(queryParser.InnerSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#annotated}.
	 * @param ctx the parse tree
	 */
	void enterAnnotated(queryParser.AnnotatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#annotated}.
	 * @param ctx the parse tree
	 */
	void exitAnnotated(queryParser.AnnotatedContext ctx);
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
	 * Enter a parse tree produced by {@link queryParser#annotatedStatment}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedStatment(queryParser.AnnotatedStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#annotatedStatment}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedStatment(queryParser.AnnotatedStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#annotatedParams}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedParams(queryParser.AnnotatedParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#annotatedParams}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedParams(queryParser.AnnotatedParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link queryParser#paramAnnotated}.
	 * @param ctx the parse tree
	 */
	void enterParamAnnotated(queryParser.ParamAnnotatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link queryParser#paramAnnotated}.
	 * @param ctx the parse tree
	 */
	void exitParamAnnotated(queryParser.ParamAnnotatedContext ctx);
}