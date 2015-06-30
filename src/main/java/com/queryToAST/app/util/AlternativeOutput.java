package com.queryToAST.app.util;

import com.queryToAST.app.exec.Setting;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Niriel
 */
public abstract class AlternativeOutput {
    protected OutputStream _outputVar;
    protected String _internalName;
    protected String _outputFile;

    public AlternativeOutput(Setting settings) {
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
