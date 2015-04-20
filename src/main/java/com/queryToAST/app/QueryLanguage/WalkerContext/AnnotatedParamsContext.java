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
public class AnnotatedParamsContext implements IContext{
    private String AT_NAME;
    private String Name;
    private IndexContext index;

    public AnnotatedParamsContext() {
        this.AT_NAME = null;
        this.Name = null;
        this.index = null;
    }

    public String getAT_NAME() {
        return AT_NAME;
    }

    public IndexContext getIndex() {
        return index;
    }

    public String getName() {
        return Name;
    }

    public void setAT_NAME(String AT_NAME) {
        this.AT_NAME = AT_NAME;
    }

    public void setIndex(IndexContext index) {
        this.index = index;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
