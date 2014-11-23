/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Core;

import com.queryToAST.app.SettingQuery;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Niriel
 */
public abstract class ProcessingData {    
    protected OutputStream _outputVar;         
    protected String _internalName;
    protected String _outputFile;
    
    public ProcessingData(SettingQuery settings) {
        _internalName = settings.getInternalName();
        _outputFile = settings.getOutput();
        this._outputVar = new OutputStream() {
                private StringBuilder string = new StringBuilder();
                @Override
                public void write(int b) throws IOException {
                   this.string.append((char) b );
                }                
                @Override
                public String toString(){
                   return this.string.toString();
                }
            };
    }
     
     public String getOut() {
        
        return _outputVar.toString();
    }    
}
