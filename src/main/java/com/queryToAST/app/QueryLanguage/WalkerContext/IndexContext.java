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
public class IndexContext implements IContext{
    private boolean STAR;
    private int INDEX;

    public IndexContext() {
        this.STAR = false;
        this.INDEX = 0;
    }

    public int getINDEX() {
        return INDEX;
    }

    public boolean isSTAR() {
        return STAR;
    }

    public void setINDEX(int INDEX) {
        this.INDEX = INDEX;
    }

    public void setSTAR(boolean STAR) {
        this.STAR = STAR;
    }
    
}
