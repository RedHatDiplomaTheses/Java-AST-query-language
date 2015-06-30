package com.queryToAST.app.Metadata;

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
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author Niriel
 *
 * TODO: Separate ClassMetadata from ClassDecompiler!
 * TODO: Make AlternativeOutput not-base-class.
 */
public class ClassDecompiler extends AlternativeOutput {
    private boolean log =false;

    public ClassDecompiler(Setting settings) {
        super(settings);
        doDecompile(settings.getSettings());
        if(log)
            System.out.println(_outputVar);
    }

    // TODO: Move to ClassMetadata.
    private TypeDefinition _typeDefinition;
    public TypeDefinition getMetadata(){
        return _typeDefinition;
    }


    private void doDecompile(final DecompilerSettings settings){

        try {
            OutputStream os = _outputFile == null
                ? _outputVar
                : new FileOutputStream(_outputFile);

            try(Writer writer = new OutputStreamWriter(os))
            {
                decompile(_internalName, new PlainTextOutput(writer), settings);
            }
            catch( final Exception e )
            {
                System.out.println(e);
            }
        }
        catch(Exception ex) {
            System.out.println("Failed processing class: " + ex.getMessage());
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
