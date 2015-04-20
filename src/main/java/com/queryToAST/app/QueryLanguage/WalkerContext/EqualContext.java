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
public class EqualContext implements IContext{
    // <editor-fold defaultstate="collapsed" desc=" Property ">

    private String NAME;
    private boolean ANNOTATED;
    private Operators OPERATORS;
    private String alias;    
    private RightStatmentContext rsctx;
    private MethodContext method;

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public EqualContext() {
        this.NAME = null;
        this.ANNOTATED = false;
        this.OPERATORS = null;
        this.alias = null;
        this.rsctx = null;
        this.method = null;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public String getAlias() {
        return alias;
    }
    
    public MethodContext getMethod() {
        return method;
    }
    
    public String getNAME() {
        return NAME;
    }
    
    public Operators getOPERATORS() {
        return OPERATORS;
    }
    
    public RightStatmentContext getRsctx() {
        return rsctx;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public void setMethod(MethodContext method) {
        this.method = method;
    }
    
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    
    public void setOPERATORS(Operators OPERATORS) {
        this.OPERATORS = OPERATORS;
    }
    
    public void setRsctx(RightStatmentContext rsctx) {
        this.rsctx = rsctx;
    }

    public void setANNOTATED(boolean ANNOTATED) {
        this.ANNOTATED = ANNOTATED;
    }
    
    public boolean isANNOTATED() {
        return ANNOTATED;
    }
    
// </editor-fold>        
    
}
