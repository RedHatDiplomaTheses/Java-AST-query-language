/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.WalkerContext;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Niriel
 */
public class ParamNameContext implements IContext {
    // <editor-fold defaultstate="collapsed" desc=" Property ">

    private boolean EXCLAMANTION;
    private boolean STAR;
    private boolean innerSelect;
    private String ALIAS;
    private String NAME;
    private MethodContext method;

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public ParamNameContext() {
        this.EXCLAMANTION = false;
        this.STAR = false;
        this.innerSelect = false;
        this.ALIAS = null;
        this.NAME = null;
        this.method = null;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Get-set ">
    public boolean EXCLAMANTION() {
        return EXCLAMANTION;
    }
    
    public void EXCLAMANTION(boolean EXCLAMANTION) {
        this.EXCLAMANTION = EXCLAMANTION;
    }
    
    public boolean STAR() {
        return STAR;
    }
    
    public void STAR(boolean STAR) {
        this.STAR = STAR;
    }
    
    public boolean InnerSelect() {
        return innerSelect;
    }
    
    public void InnerSelect(boolean innerSelect) {
        this.innerSelect = innerSelect;
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
    
    public MethodContext Method() {
        return method;
    }
    
    public void Method(MethodContext method) {
     
        this.method = method;
    }   
// </editor-fold>    
}

