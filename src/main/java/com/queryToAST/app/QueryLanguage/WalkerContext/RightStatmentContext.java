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
public class RightStatmentContext implements IContext{
    // <editor-fold defaultstate="collapsed" desc=" Property ">
    private String STRING;
    private String NAME;
    private String PATTERN;
    private String alias;
    private boolean annotated;

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public RightStatmentContext() {
        this.STRING = null;
        this.NAME = null;
        this.PATTERN = null;
        this.alias = null;
        this.annotated = false;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public String getNAME() {
        return NAME;
    }
    
    public String getPATTERN() {
        return PATTERN;
    }
    
    public String getSTRING() {
        return STRING;
    }
    
    public boolean isAnnotated() {
        return annotated;
    }
    
    public void setAnnotated(boolean annotated) {
        this.annotated = annotated;
    }
    
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    
    public void setPATTERN(String PATTERN) {
        this.PATTERN = PATTERN;
    }
    
    public void setSTRING(String STRING) {
        this.STRING = STRING;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public String getAlias() {
        return alias;
    }
    
    // </editor-fold>

    
}
