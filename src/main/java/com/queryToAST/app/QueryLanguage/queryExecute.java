/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage;

import com.queryToAST.app.Graph.GraphContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Niriel
 */
public class queryExecute extends queryBaseListener{
    private GraphContext context = null;

    public GraphContext getContext() {
        return context;
    }

    public void setContext(GraphContext context) {
        this.context = context;
    }    

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParamAnnotated(queryParser.ParamAnnotatedContext ctx) {
        super.exitParamAnnotated(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterParamAnnotated(queryParser.ParamAnnotatedContext ctx) {
        super.enterParamAnnotated(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAnnotatedParams(queryParser.AnnotatedParamsContext ctx) {
        super.exitAnnotatedParams(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAnnotatedParams(queryParser.AnnotatedParamsContext ctx) {
        super.enterAnnotatedParams(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAnnotatedStatment(queryParser.AnnotatedStatmentContext ctx) {
        super.exitAnnotatedStatment(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAnnotatedStatment(queryParser.AnnotatedStatmentContext ctx) {
        super.enterAnnotatedStatment(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIndex(queryParser.IndexContext ctx) {
        super.exitIndex(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIndex(queryParser.IndexContext ctx) {
        super.enterIndex(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitMethod(queryParser.MethodContext ctx) {
        super.exitMethod(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterMethod(queryParser.MethodContext ctx) {
        super.enterMethod(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAnnotated(queryParser.AnnotatedContext ctx) {
        super.exitAnnotated(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAnnotated(queryParser.AnnotatedContext ctx) {
        super.enterAnnotated(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitInnerSelect(queryParser.InnerSelectContext ctx) {
        super.exitInnerSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterInnerSelect(queryParser.InnerSelectContext ctx) {
        super.enterInnerSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitCond(queryParser.CondContext ctx) {
        super.exitCond(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterCond(queryParser.CondContext ctx) {
        super.enterCond(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitConditions(queryParser.ConditionsContext ctx) {
        super.exitConditions(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterConditions(queryParser.ConditionsContext ctx) {
        super.enterConditions(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPackageName(queryParser.PackageNameContext ctx) {
        super.exitPackageName(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPackageName(queryParser.PackageNameContext ctx) {
        super.enterPackageName(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPackages(queryParser.PackagesContext ctx) {
        super.exitPackages(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPackages(queryParser.PackagesContext ctx) {
        super.enterPackages(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParamName(queryParser.ParamNameContext ctx) {
        super.exitParamName(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterParamName(queryParser.ParamNameContext ctx) {
        super.enterParamName(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParamSelect(queryParser.ParamSelectContext ctx) {
        super.exitParamSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterParamSelect(queryParser.ParamSelectContext ctx) {
        super.enterParamSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSelectStatment(queryParser.SelectStatmentContext ctx) {
        super.exitSelectStatment(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSelectStatment(queryParser.SelectStatmentContext ctx) {
        super.enterSelectStatment(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitProgram(queryParser.ProgramContext ctx) {
        System.out.println(ctx.getText());
        super.exitProgram(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterProgram(queryParser.ProgramContext ctx) {
        super.enterProgram(ctx); //To change body of generated methods, choose Tools | Templates.
    }

}
