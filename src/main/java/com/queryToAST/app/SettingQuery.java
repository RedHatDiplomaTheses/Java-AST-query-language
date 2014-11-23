/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;

/**
 *
 * @author Niriel
 */
public class SettingQuery {
    private String _internalName;
    private String _output;
    
    public SettingQuery(String _internalName, String _output) {
        this._internalName = _internalName;
        this._output = _output;
    }
    
    public String getInternalName() {
        return _internalName;
    }

    public void setInternalName(String _internalName) {
        this._internalName = _internalName;
    }

    public String getOutput() {
        return _output;
    }

    public void setOutput(String _output) {
        this._output = _output;
    }    
}
