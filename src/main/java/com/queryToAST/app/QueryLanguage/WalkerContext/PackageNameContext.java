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
public class PackageNameContext implements IContext{
    // <editor-fold defaultstate="collapsed" desc=" Property ">
    private String STRING;
    private boolean EXCLAMANTION;
    private boolean innerClass;
    private boolean STAR;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public PackageNameContext() {
        this.STRING = null;
        this.EXCLAMANTION = false;
        this.innerClass = false;
        this.STAR = false;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public String STRING() {
        return this.STRING;
    }
    
    public void STRING(String string) {
        this.STRING = string;
    }
    
    public boolean EXCLAMANTION() {
        return EXCLAMANTION;
    }
    
    public void EXCLAMANTION(boolean EXCLAMANTION) {
        this.EXCLAMANTION = EXCLAMANTION;
    }
    
    public boolean InnerClass() {
        return innerClass;
    }
    
    public void InnerClass(boolean innerClass) {
        this.innerClass = innerClass;
    }
    
    public boolean STAR() {
        return STAR;
    }
    
    public void STAR(boolean STAR) {
        this.STAR = STAR;
    }

// </editor-fold>        
}
