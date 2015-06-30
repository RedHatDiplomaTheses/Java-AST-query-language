package com.queryToAST.app.Metadata;

import com.queryToAST.app.Graph.GraphContext.GraphContext;
import com.queryToAST.app.exec.Setting;
import com.strobel.assembler.metadata.JarTypeLoader;
import com.strobel.core.StringUtilities;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.languages.Languages;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Niriel
 */
public class JarDecompilerAndAstProcessor
{
    private Setting _settings = null;
    private GraphContext _graphContext = null;
    private boolean load = false;
    private boolean error = false;

    public JarDecompilerAndAstProcessor(String _internalName, GraphContext graphContext) {
        _graphContext = graphContext;
        _settings = new Setting(_internalName,null);
        _settings.setMetadata(true);
    }


    /**
     *
     * @return
     * @throws IOException
     */
    public void process(String singleClassName) {
        DecompilerSettings settings = DecompilerSettings.javaDefaults();
        settings.setLanguage(Languages.bytecode()); //metadata
        //settings.setLanguage(Languages.java()); // plna dekompilace a AST
        final File jarFile = new File(this._settings.getInternalName());
        if (!jarFile.exists()) {
            System.out.println("File not found: " + this._settings.getInternalName());
            error = true;
            return;
        }
        JarFile jar = null;
        try {
            jar = new JarFile(jarFile);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            error = true;
            return;
        }
        final Enumeration<JarEntry> jarEntries = jar.entries();
        settings.setShowSyntheticMembers(false);
        settings.setTypeLoader(new JarTypeLoader(jar));
        this._settings.setSettings(settings);
        _graphContext.setName(jar.getName());

        try {
            while (jarEntries.hasMoreElements()) {
                final JarEntry entry = jarEntries.nextElement();
                final String name = entry.getName();
                if (!name.endsWith(".class")) {
                    continue;
                }

                final String internalName = StringUtilities.removeRight(name, ".class");
                this._settings.setInternalName(internalName);

                // Only for debugging! Performs badly.
                if( singleClassName != null && !internalName.contains(singleClassName))
                    continue;

                // TODO: Separate ClassDecompiler and ClassMetadata
                ClassDecompiler meta = new ClassDecompiler(_settings);
                _graphContext.createClassMetadata(meta.getMetadata());
            }
        }
        finally {
            //System.out.println("Doplnit hlaseni pøekladu JarDecompilerAndAstProcessor");
        }
    }

    public boolean isError(){
        return error;
    }
}