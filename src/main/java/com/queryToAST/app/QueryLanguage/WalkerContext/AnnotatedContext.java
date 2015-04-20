/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.WalkerContext;

/**
 *
 * @author Niriel
 */
public class AnnotatedContext implements IContext{
    private MethodContext method;
    private AnnotatedStatmentContext asctx;
    private IndexContext index;

    public AnnotatedContext() {
        this.method = null;
        this.asctx = null;
        this.index =null;
    }

    public AnnotatedStatmentContext getAsctx() {
        return asctx;
    }

    public MethodContext getMethod() {
        return method;
    }

    public void setAsctx(AnnotatedStatmentContext asctx) {
        this.asctx = asctx;
    }

    public void setMethod(MethodContext method) {
        this.method = method;
    }

    public IndexContext getIndex() {
        return index;
    }

    public void setIndex(IndexContext index) {
        this.index = index;
    }
    
    
}
