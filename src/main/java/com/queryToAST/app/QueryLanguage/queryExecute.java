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
    public void enterQuery(queryParser.QueryContext ctx) {
        super.enterQuery(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitQuery(queryParser.QueryContext ctx) {
        super.exitQuery(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSelect(queryParser.SelectContext ctx) {
        super.enterSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSelect(queryParser.SelectContext ctx) {
        super.exitSelect(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSel_li_prop(queryParser.Sel_li_propContext ctx) {
        super.enterSel_li_prop(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSel_li_prop(queryParser.Sel_li_propContext ctx) {
        super.exitSel_li_prop(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSel_prop(queryParser.Sel_propContext ctx) {
        super.enterSel_prop(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSel_prop(queryParser.Sel_propContext ctx) {
        super.exitSel_prop(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterFrom(queryParser.FromContext ctx) {
        super.enterFrom(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitFrom(queryParser.FromContext ctx) {
        super.exitFrom(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPack(queryParser.PackContext ctx) {
        super.enterPack(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPack(queryParser.PackContext ctx) {
        super.exitPack(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterFro_pac(queryParser.Fro_pacContext ctx) {
        super.enterFro_pac(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitFro_pac(queryParser.Fro_pacContext ctx) {
        super.exitFro_pac(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterWhere(queryParser.WhereContext ctx) {
        super.enterWhere(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitWhere(queryParser.WhereContext ctx) {
        super.exitWhere(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterCond(queryParser.CondContext ctx) {
        super.enterCond(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitCond(queryParser.CondContext ctx) {
        super.exitCond(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSt_co(queryParser.St_coContext ctx) {
        super.enterSt_co(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSt_co(queryParser.St_coContext ctx) {
        super.exitSt_co(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAnnot(queryParser.AnnotContext ctx) {
        super.enterAnnot(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAnnot(queryParser.AnnotContext ctx) {
        super.exitAnnot(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterMethod(queryParser.MethodContext ctx) {
        super.enterMethod(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitMethod(queryParser.MethodContext ctx) {
        super.exitMethod(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIndex(queryParser.IndexContext ctx) {
        super.enterIndex(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIndex(queryParser.IndexContext ctx) {
        super.exitIndex(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAn_value(queryParser.An_valueContext ctx) {
        super.enterAn_value(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAn_value(queryParser.An_valueContext ctx) {
        super.exitAn_value(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterParams(queryParser.ParamsContext ctx) {
        super.enterParams(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParams(queryParser.ParamsContext ctx) {
        super.exitParams(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterParam(queryParser.ParamContext ctx) {
        super.enterParam(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParam(queryParser.ParamContext ctx) {
        super.exitParam(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPara(queryParser.ParaContext ctx) {
        super.enterPara(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPara(queryParser.ParaContext ctx) {
        super.exitPara(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterOrder_by(queryParser.Order_byContext ctx) {
        super.enterOrder_by(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitOrder_by(queryParser.Order_byContext ctx) {
        super.exitOrder_by(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
