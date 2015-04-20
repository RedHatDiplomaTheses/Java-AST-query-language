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
public class PackageLinkContext implements IContext{
    // <editor-fold defaultstate="collapsed" desc=" Property ">

    private boolean STAR;
    private String AS;

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public PackageLinkContext() {
        this.STAR = false;
        this.AS = null;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public boolean isSTAR() {
        return STAR;
    }
    
    public void setSTAR(boolean STAR) {
        this.STAR = STAR;
    }
    
    public String getAS() {
        return AS;
    }
    
    public void setAS(String AS) {
        this.AS = AS;
    }

// </editor-fold>
    
}
