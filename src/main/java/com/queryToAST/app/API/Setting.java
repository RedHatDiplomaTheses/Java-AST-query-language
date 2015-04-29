/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.API;

import com.strobel.decompiler.DecompilerSettings;

/**
 *
 * @author Niriel
 */
public class Setting {
    private String _internalName;
    private String _output;
    private boolean _ast = false;
    private boolean _metadata = false;
    private DecompilerSettings _settings;
    
    public Setting(String _internalName, String _output) {
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

    public boolean isAst() {
        return _ast;
    }

    public void setAst(boolean ast) {
        this._ast = ast;
    }

    public boolean isMetadata() {
        return _metadata;
    }

    public void setMetadata(boolean metadata) {
        this._metadata = metadata;
    }

    public DecompilerSettings getSettings() {
        return _settings;
    }

    public void setSettings(DecompilerSettings _settings) {
        this._settings = _settings;
    }   
}
