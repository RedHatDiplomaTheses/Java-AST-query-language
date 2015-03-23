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

}
