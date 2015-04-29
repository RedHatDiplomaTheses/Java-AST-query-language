/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Metadata;

import com.queryToAST.app.Core.ProcessingData;
import com.queryToAST.app.API.Setting;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Niriel
 */
public class ClassMetadata extends ProcessingData{   
    private TypeDefinition _typeDefinition;
    private boolean log =false;
    
    public ClassMetadata(Setting settings) {
        super(settings);
        Build(settings.getSettings());
        if(log)
        System.out.println(_outputVar);
    }
   
    public TypeDefinition getMetadata(){
        return _typeDefinition;
    }
    private void Build(final DecompilerSettings settings){        
        
        if(_outputFile == null) {
            try (final OutputStreamWriter writer = new OutputStreamWriter(_outputVar)) {
            decompile(_internalName, new PlainTextOutput(writer), settings);            
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }else {
            try (final FileOutputStream stream = new FileOutputStream(_outputFile);                
                final OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                decompile(_internalName, new PlainTextOutput(writer), settings);
            }
            catch (final IOException e) {
                System.out.println(e);
            }
        }
    }
    
    public void decompile(final String internalName, final ITextOutput output, final DecompilerSettings settings) {
        VerifyArgument.notNull(internalName, "internalName");
        VerifyArgument.notNull(settings, "settings");

        final ITypeLoader typeLoader = settings.getTypeLoader() != null ? settings.getTypeLoader() : new InputTypeLoader();
        final MetadataSystem metadataSystem = new MetadataSystem(typeLoader);

        final TypeReference type;

        if (internalName.length() == 1) {
            //
            // Hack to get around classes whose descriptors clash with primitive types.
            //

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
//        ArrayAnnotationElement ar = (ArrayAnnotationElement)resolvedType.getAnnotations().iterator().next().getParameters().iterator().next().getValue();
//        AnnotationAnnotationElement ann = (AnnotationAnnotationElement) ar.getElements()[0];
//        ConstantAnnotationElement cone =(ConstantAnnotationElement) ann.getAnnotation().getParameters().iterator().next().getValue();
//        cone.getConstantValue();
//        System.out.println(cone.getConstantValue());
        
        _typeDefinition = resolvedType;
        settings.getLanguage().decompileType(resolvedType, output, options);
    }
}
