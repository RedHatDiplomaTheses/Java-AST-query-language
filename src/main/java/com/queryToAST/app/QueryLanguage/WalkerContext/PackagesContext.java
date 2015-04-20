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
public class PackagesContext implements IContext{
    private boolean STAR;
    public PackagesContext() {
        this.STAR = false;
    }

    public boolean STAR() {
        return STAR;
    }

    public void STAR(boolean STAR) {
        this.STAR = STAR;
    }
    
}
