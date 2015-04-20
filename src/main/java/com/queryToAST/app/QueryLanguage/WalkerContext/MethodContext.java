/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.WalkerContext;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Niriel
 */
public class MethodContext {
    // <editor-fold defaultstate="collapsed" desc=" Property ">
    private Map<String, String> arg;
    private boolean STAR;
    private String description;

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Constructor ">
    public MethodContext() {
        this.arg = null;
        this.STAR = false;
        this.description = null;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public Map<String, String> getArg() {
        return arg;
    }
    
    public void Arg(String name, String string) {
        if (this.arg == null) {
            this.arg = new TreeMap<String, String>();
        }
        this.arg.put(name, string);
    }
    
    public boolean STAR() {
        return STAR;
    }
    
    public void STAR(boolean STAR) {
        this.STAR = STAR;
    }
    
    public String Description() {
        return description;
    }
    
    public void Description(String description) {
        this.description = description;
    }

// </editor-fold> 
}
