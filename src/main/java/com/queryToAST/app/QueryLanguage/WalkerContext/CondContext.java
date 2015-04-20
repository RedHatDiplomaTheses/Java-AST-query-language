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
public class CondContext implements IContext{
    // <editor-fold defaultstate="collapsed" desc=" Property ">
    private boolean equal;
    private boolean innerSelect;
    private boolean EXCLAMANTION;
    private boolean EXIST;
    private boolean NOT_EXIST;
    private Operators OPERATORS;   //predelat
    private String ALIAS;
    private String NAME;    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public CondContext() {
        this.equal = false;
        this.innerSelect = false;
        this.EXCLAMANTION = false;
        this.EXIST = false;
        this.NOT_EXIST = false;
        this.OPERATORS = null;
        this.ALIAS = null;
        this.NAME = null;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public boolean Equal() {
        return equal;
    }
    
    public void Equal(boolean equal) {
        this.equal = equal;
    }
    
    public boolean InnerSelect() {
        return innerSelect;
    }
    
    public void InnerSelect(boolean innerSelect) {
        this.innerSelect = innerSelect;
    }
    
    public boolean EXCLAMANTION() {
        return EXCLAMANTION;
    }
    
    public void EXCLAMANTION(boolean EXCLAMANTION) {
        this.EXCLAMANTION = EXCLAMANTION;
    }
    
    public boolean EXIST() {
        return EXIST;
    }
    
    public void EXIST(boolean EXIST) {
        this.EXIST = EXIST;
    }
    
    public boolean NOT_EXIST() {
        return NOT_EXIST;
    }
    
    public void NOT_EXIST(boolean NOT_EXIST) {
        this.NOT_EXIST = NOT_EXIST;
    }
    
    public Operators OPERATORS() {
        return OPERATORS;
    }
    
    public void OPERATORS(Operators OPERATORS) {
        this.OPERATORS = OPERATORS;
    }
    
    public String ALIAS() {
        return ALIAS;
    }
    
    public void ALIAS(String ALIAS) {
        this.ALIAS = ALIAS;
    }
    
    public String NAME() {
        return NAME;
    }
    
    public void NAME(String NAME) {
        this.NAME = NAME;
    }

// </editor-fold>

}
