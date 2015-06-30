/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.AST;

import com.queryToAST.app.util.AlternativeOutput;
import com.queryToAST.app.exec.Setting;
import com.strobel.assembler.InputTypeLoader;
import com.strobel.assembler.metadata.DeobfuscationUtilities;
import com.strobel.assembler.metadata.IMetadataResolver;
import com.strobel.assembler.metadata.ITypeLoader;
import com.strobel.assembler.metadata.MetadataParser;
import com.strobel.assembler.metadata.MetadataSystem;
import com.strobel.assembler.metadata.TypeDefinition;
import com.strobel.assembler.metadata.TypeReference;
import com.strobel.core.VerifyArgument;
import com.strobel.decompiler.DecompilationOptions;
import com.strobel.decompiler.DecompilerSettings;

import com.strobel.decompiler.ITextOutput;
import com.strobel.decompiler.PlainTextOutput;
import com.strobel.decompiler.languages.java.JavaFormattingOptions;
import com.strobel.decompiler.languages.java.JavaLanguage;
import com.strobel.decompiler.languages.java.ast.CompilationUnit;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Niriel
 */
public class ClassAST extends AlternativeOutput{
    private CompilationUnit _unitAST = null;
    
    public ClassAST(Setting settings){
        super(settings);
        Build(settings.getSettings());
    }
    
    public CompilationUnit getUnitAST() {
        return _unitAST;
    }
    
    private void Build(DecompilerSettings settings){        
        
        if(_outputFile == null) {
            try (final OutputStreamWriter writer = new OutputStreamWriter(_outputVar)) {            
                subBuild(writer, settings);                                                      
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }else {
            try (final FileOutputStream stream = new FileOutputStream(_outputFile);
                final OutputStreamWriter writer = new OutputStreamWriter(stream)) {            
                subBuild(writer, settings);                                                      
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }
        
                
    }
    
    private void subBuild(OutputStreamWriter writer,DecompilerSettings settings) {
        final String internalName = _internalName;
            final ITextOutput output = new PlainTextOutput(writer);                        
            
            VerifyArgument.notNull(internalName, "internalName");
            VerifyArgument.notNull(settings, "settings");

            final ITypeLoader typeLoader = settings.getTypeLoader() != null ? settings.getTypeLoader() : new InputTypeLoader();
            final MetadataSystem metadataSystem = new MetadataSystem(typeLoader);

            final TypeReference type;

            if (internalName.length() == 1) {                    
                final MetadataParser parser = new MetadataParser(IMetadataResolver.EMPTY);
                final TypeReference reference = parser.parseTypeDescriptor(internalName);
                type = metadataSystem.resolve(reference);
            }
            else {
                type = metadataSystem.lookupType(internalName);
            }
            final TypeDefinition resolvedType;

            if (type == null || (resolvedType = type.resolve()) == null) {
                output.writeLine("!!! ERROR: Failed to load class %s.", internalName);
                return;
            }

            DeobfuscationUtilities.processType(resolvedType);

            final DecompilationOptions options = new DecompilationOptions();

            options.setSettings(settings);
            options.setFullDecompilation(true);

            if (settings.getFormattingOptions() == null) {
                settings.setFormattingOptions(JavaFormattingOptions.createDefault());
            }
                 
            settings.getLanguage().decompileType(resolvedType, output, options);
            JavaLanguage _javaLanguage = (JavaLanguage) settings.getLanguage();
            _unitAST = _javaLanguage.decompileTypeToAst(resolvedType, options);            
    }
}
