/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;

import com.queryToAST.app.AST.ClassAST;
import com.queryToAST.app.Core.Data;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.Core.Tree.Node;
import com.queryToAST.app.Core.TypFile;
import com.queryToAST.app.Metadata.ClassMetadata;
import com.queryToAST.app.Setting;
import com.strobel.decompiler.languages.java.ast.AstNode;
import com.strobel.decompiler.languages.java.ast.CompilationUnit;


import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
/**
 *
 * @author Niriel
 */
public class ClassVertex {        
    private Setting _settings = null;
    
    public ClassVertex(Setting settings) {
        this._settings = settings;
    }
    
    public Vertex getVertexMeta(Graph graph) {
        ClassMetadata meta = new ClassMetadata(_settings);   //Strom Metadat
//        System.out.println(meta.getOut());
//        System.out.println();
        return factory(meta.getTree(), graph);        
    }
    
    public Vertex getVertexAST(Graph graph) {
        return factory(new ClassAST(_settings).getUnitAST(), graph); //Strom AST
    }
    
    private Vertex factory(Tree tree, Graph graph) {
        Data data = ((Data)tree.getRoot().getdata());
        Vertex a = FindVertex(graph,data.getName());    //.replaceAll("[^\\.]*\\.", "")        
        a.setProperty("Typ",data.getTypFile());
                
        if(data.getExtends() != null) {
            Vertex e = FindVertex(graph,data.getExtends());
            graph.addEdge(null, a, e, "extend");
        }
        
        if(data.getImplements() != null) {
            Vertex i;
            for(String imple: data.getImplements()){
                i = FindVertex(graph,imple);
                graph.addEdge(null, a, i, "implement");
            }
        }
        
        for(Object node : tree.getRoot().getChildren()) {
            Data dataN = (Data)((Node)node).getdata();
            Vertex b = graph.addVertex(null);
            b.setProperty("Name",dataN.getName());
            b.setProperty("Typ",dataN.getName());
            graph.addEdge(null, a, b, "contain");
        }                
        return a;
    }
    
    private Vertex factory(CompilationUnit unitAST, Graph graph) {
            int i=0;    
            for(AstNode n :unitAST.getChildren()){
                    
                    int l=0;
                    for(AstNode p :n.getChildren()){
                        System.out.println(p.getNodeType() + " " +" " + p.getRole() + " " + p.getText());
                        
                        //System.out.println(p.getNodeType() + " " + p.getText());
                        if(l++>10)
                            break;
                    }                                        
            }
        return null;          
    }
    
    /**
     * Najdi vertex, pokud nenajde vytvoø vertex
     * @param g
     * @param name
     * @return
     */
    public Vertex FindVertex(Graph g,String name) {
        for(Vertex v:g.getVertices()) {
            if(v.getProperty("Name") == name) {
                return v;
            }
        }
        Vertex n = g.addVertex(null);
        n.setProperty("Name",name);
        n.setProperty("Typ",TypFile.NONE);
        return n;
    }
}
