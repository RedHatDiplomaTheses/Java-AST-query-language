/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;

import com.queryToAST.app.Metadata.ClassMetadata;
import com.queryToAST.app.Setting;
import com.strobel.assembler.metadata.JarTypeLoader;
import com.strobel.core.StringUtilities;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.languages.Languages;
import com.tinkerpop.blueprints.Graph;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Niriel
 */
public class JarGraph {
    private Setting _settings = null;
    
    public JarGraph(String _internalName) {        
        _settings= new Setting(_internalName,null);
    }
    
    public JarGraph(String _internalName, String _output) {       
        _settings= new Setting(_internalName,_output);
    }
    
    public Graph Factory() throws IOException {
        DecompilerSettings settings = DecompilerSettings.javaDefaults();
        settings.setLanguage(Languages.bytecode());
        
        final File jarFile = new File(this._settings.getInternalName());

        if (!jarFile.exists()) {
            System.out.println("File not found: " + this._settings.getInternalName());
        }
        final JarFile jar = new JarFile(jarFile);
        final Enumeration<JarEntry> entries = jar.entries();
        
        settings.setShowSyntheticMembers(false);

        settings.setTypeLoader(           
                new JarTypeLoader(jar)                            
        );
        
        this._settings.setSettings(settings);
        
        try {                        
            while (entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();
                final String name = entry.getName();

                if (!name.endsWith(".class")) {
                    continue;
                }                
                final String internalName = StringUtilities.removeRight(name, ".class");
                
                this._settings.setInternalName(internalName);
                
                ClassGraph graph = new ClassGraph(_settings);
                graph.getGraphMeta();
            }
        }
        finally {
         System.out.println("Doplnit hlaseni");
        }
        return null;
    }
}