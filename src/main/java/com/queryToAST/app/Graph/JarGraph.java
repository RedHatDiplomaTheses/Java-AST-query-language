/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;



import com.queryToAST.app.Setting;
import com.strobel.assembler.metadata.JarTypeLoader;
import com.strobel.core.StringUtilities;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.languages.Languages;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 *
 * @author Niriel
 */
public class JarGraph {
    private Setting _settings = null;
    
    public JarGraph(String _internalName, boolean isAst, boolean isMetadata) {        
        _settings = new Setting(_internalName,null);
        _settings.setAst(isAst);
        _settings.setMetadata(isMetadata);
    }
    
    
    
    /**
     *
     * @param _internalName cesta k souboru
     * @param _output vystupni soubor pri dekompilaci
     * @param isAst Udelat graf z AST
     * @param isMetadata Udelat graf z Metadat
     */
    public JarGraph(String _internalName, String _output, boolean isAst, boolean isMetadata) {
        _settings = new Setting(_internalName,_output);
        _settings.setAst(isAst);
        _settings.setMetadata(isMetadata);
    }
    
    
    
    /**
     *
     * @return
     * @throws IOException
     */
    public Graph Factory() throws IOException {
        DecompilerSettings settings = DecompilerSettings.javaDefaults();
        settings.setLanguage(Languages.bytecode()); //Zkontrolovat nasteveni jazyka AST Metadata        
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
        
        
        Graph graph = new TinkerGraph();
        Vertex j = graph.addVertex(null);        
        j.setProperty("name",getNameJar());
        j.setProperty("typ","Jar");        
        ClassVertex classVertex = new ClassVertex();
        
        try {                        
            while (entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();
                final String name = entry.getName();
                if (!name.endsWith(".class")) {
                    continue;
                }
                final String internalName = StringUtilities.removeRight(name, ".class");
                this._settings.setInternalName(internalName);
                
                
                Vertex a = null;
                if(this._settings.isMetadata())                    
                    a = classVertex.getVertexMeta(graph, _settings);
                if(this._settings.isAst())
                    a = classVertex.getVertexMeta(graph, _settings);
                
                //zapis vztahu tridy do Grafu
                graph.addEdge(null, setPathPackages(graph, j, internalName), a, "contain");
            }
        }
        finally {
         //System.out.println("Doplnit hlaseni pøekladu JarGraph");
        }
        
        //odstranìní pøebyteèných dat pro optimalizace by chtelo predejít tomuto
        for(Vertex x: graph.getVertices()){            
            x.setProperty("name", x.getProperty("name").toString().replaceAll("[\\w]*/", ""));
            //System.out.println(x.getProperty("name"));
        }
        return graph;
    }

    
    
    private String getNameJar() {
        Pattern reg = Pattern.compile("([^\\\\\\./]*).jar$");
        Matcher m = reg.matcher(this._settings.getInternalName());
        m.find();
        return m.group(1);
    }
    
    
    
    /**
     * Vrátí Vrchol na který se nová tøída pøipojí
     * @param g Graph
     * @param J Vertex
     * @param internalName
     * @return
     */
    private Vertex setPathPackages(Graph g, Vertex j, String internalName){
        if(internalName.contains("/")){            
            String NamePack = internalName.replaceFirst("/.*", "");             
            internalName = internalName.replaceFirst("[^/]*/", "");
            GremlinPipeline<Vertex,Vertex> pipe = new GremlinPipeline();
            for(Vertex  v : pipe.start(j).out("contain").toList()) {
                if(v.getProperty("name").equals(NamePack)){                    
                     return setPathPackages(g, v, internalName);                     
                 }
            }
            //System.out.println(NamePack);
            Vertex r = g.addVertex(null);
            r.setProperty("name", NamePack);
            r.setProperty("typ", "package");
            g.addEdge(null, j, r, "contain");
            return setPathPackages(g, r, internalName);
        }
        //System.out.println(j.getProperty("Name") + " --> " + internalName);
        return j;
    }
    
    
    
    private Graph testGraph() {
        Graph g = new TinkerGraph();
        
        Vertex a = g.addVertex(null);
        a.setProperty("name","Procyon");
        a.setProperty("typ","jar");
        
            Vertex b = g.addVertex(null);
            b.setProperty("name","CompileTools");
            b.setProperty("typ","package");
            Edge e = g.addEdge(null, a, b, "contain");
            
                Vertex c = g.addVertex(null);
                c.setProperty("name", "Decompile");
                c.setProperty("typ", "class");
                e = g.addEdge(null, b, c, "contain");
                
                c = g.addVertex(null);
                c.setProperty("name", "Asemble");
                c.setProperty("typ", "class");
                e = g.addEdge(null, b, c, "contain");
                
            b = g.addVertex(null);
            b.setProperty("name","Decompile");
            b.setProperty("typ","Package");
            e = g.addEdge(null, a, b, "contain");
                
                c = g.addVertex(null);
                c.setProperty("name", "DecompileDriver");
                c.setProperty("typ", "class");
                e = g.addEdge(null, b, c, "contain");
                
                c = g.addVertex(null);
                c.setProperty("name", "ParserMetadata");
                c.setProperty("typ", "class");
                e = g.addEdge(null, b, c, "contain");
        GremlinPipeline<Vertex,Vertex> pipe = new GremlinPipeline();
        
//        for(Vertex v :pipe.start(a).out("contain").toList()) {
//            System.out.println(v.getProperty("Name"));
//        }
        
        
        return g;
    }
}