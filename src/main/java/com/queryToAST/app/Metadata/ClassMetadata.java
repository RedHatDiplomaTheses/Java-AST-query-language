/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Metadata;

import com.queryToAST.app.Core.ProcessingData;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.Setting;
import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Niriel
 */
public class ClassMetadata extends ProcessingData{   
    private Tree _tree;
    
    public ClassMetadata(Setting settings) {
        super(settings);
        Build(settings.getSettings());
        ParserMetadata parserMetadata = new ParserMetadata();
        _tree = parserMetadata.ParserMetadata(getOut());
        //System.out.println(getOut());
    }    
    
    public Tree getTree(){
        return _tree;
    }
   
    private void Build(final DecompilerSettings settings){        
        
        if(_outputFile == null) {
            try (final OutputStreamWriter writer = new OutputStreamWriter(_outputVar)) {
            Decompiler.decompile(_internalName, new PlainTextOutput(writer), settings);            
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }else {
            try (final FileOutputStream stream = new FileOutputStream(_outputFile);                
                final OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                Decompiler.decompile(_internalName, new PlainTextOutput(writer), settings);
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }
    }        
}
