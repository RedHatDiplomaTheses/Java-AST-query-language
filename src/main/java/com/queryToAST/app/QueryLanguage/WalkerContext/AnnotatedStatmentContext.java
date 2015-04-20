/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.WalkerContext;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class AnnotatedStatmentContext implements IContext{
    private String AT_NAME;
    private List<AnnotatedParamsContext> apctx;

    public AnnotatedStatmentContext() {
        this.AT_NAME = null;
        this.apctx = new ArrayList();
    }

    public List<AnnotatedParamsContext> getApctx() {
        return apctx;
    }

    public String getAT_NAME() {
        return AT_NAME;
    }

    public void setAT_NAME(String AT_NAME) {
        this.AT_NAME = AT_NAME;
    }

    public void setApctx(AnnotatedParamsContext apctx) {    
        this.apctx.add(apctx);
    }
    
}
