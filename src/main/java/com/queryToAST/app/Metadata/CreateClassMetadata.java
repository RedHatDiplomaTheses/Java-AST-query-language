/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Metadata;

import com.queryToAST.app.Core.ProcessingData;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.SettingQuery;
import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import com.strobel.decompiler.languages.Languages;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Niriel
 */
public class CreateClassMetadata extends ProcessingData{   
    private Tree _tree;
    
    public CreateClassMetadata(SettingQuery settings) {
        super(settings);
        Build();
        _tree = new ParserMetadata().ParserMetadata(getOut());
    }
    
    public CreateClassMetadata(String _internalName, String _output) {
        super(new SettingQuery(_internalName,_output));
        Build();
        _tree = new ParserMetadata().ParserMetadata(getOut());
    }
    
    public Tree getTree(){
        return _tree;
    }
   
    private void Build(){
        final DecompilerSettings settings = DecompilerSettings.javaDefaults();
        settings.setLanguage(Languages.bytecode());                
        
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
