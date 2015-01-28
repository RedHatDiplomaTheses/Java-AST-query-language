/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;

import com.queryToAST.app.AST.ClassAST;
import com.queryToAST.app.Core.Data;
import com.queryToAST.app.Core.Data.Arg;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.Core.Tree.Node;
import com.queryToAST.app.Core.TypFile;
import com.queryToAST.app.Metadata.ClassMetadata;
import com.queryToAST.app.Setting;
import com.strobel.decompiler.languages.java.ast.AstNode;
import com.strobel.decompiler.languages.java.ast.CompilationUnit;
import com.tinkerpop.blueprints.Direction;


import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Niriel
 */
public class ClassVertex {        
    
    
    
    public ClassVertex() { }
    
    
    
    /**
     *
     * @param graph
     * @param _settings
     * @return
     */
    public Vertex getVertexMeta(Graph graph,Setting _settings) {
        ClassMetadata meta = new ClassMetadata(_settings);
        return factory(meta.getTree(), graph);        
    }
    
    
    
    /**
     *
     * @param graph
     * @param _settings
     * @return
     */
    public Vertex getVertexAST(Graph graph, Setting _settings) {
        return factory(new ClassAST(_settings).getUnitAST(), graph);
    }
    
    
    
    private Vertex factory(Tree tree, Graph graph) {
        Data data = ((Data)tree.getRoot().getdata());
        Vertex a = FindVertex(graph,data.getName());    //.replaceAll("[^\\.]*\\.", "")
        a.setProperty("typ",data.getTypFile());
        if(data.getAnnotated() != null){
            a.setProperty("annotation", data.getAnnotated());
        }
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
                        
            Vertex b = FindVertexMethod(graph, data.getName(), dataN.getName());
            if(dataN.getCallMethod() != null){
                for(String sTMP: dataN.getCallMethod()) {
                    Matcher mTMP = Pattern.compile("([^\\.]*)\\.([^:]*):\\(([^\\)]*)\\)([^;]*);?").matcher(sTMP);
                    if(mTMP.find()){
                        //dodelat
                        //System.out.println(mTMP.group(3));
                        if(mTMP.group(3).compareTo("") != 0){
                            List<Arg> arg=new ArrayList<Arg>();
                            arg.add(null);
                        }
                        graph.addEdge(null, b, FindVertexMethod(graph,mTMP.group(1),mTMP.group(2)), "call");
                        //System.out.println("Trida: "+mTMP.group(1)+ ", Metoda: " + mTMP.group(2) + ", Argumenty: " + mTMP.group(3) + ", Return: " + mTMP.group(4));
                    }
                    //System.out.println(sTMP);
                }
            }
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
        //System.out.println(name);
        for(Vertex v:g.getVertices()) {
            if(v.getProperty("name").toString().compareTo(name) == 0) {
                //System.out.println(name);
                return v;                
            }
        }
        Vertex n = g.addVertex(null);
        n.setProperty("name",name);
        n.setProperty("typ",TypFile.NONE);
        //System.out.println(name);
        return n;
    }
    
    
    
    /**
     * Najdi vertex metody tridy, nebo ho vytvor
     * @param g
     * @param _class
     * @param _method
     * @return
     */
    public Vertex FindVertexMethod(Graph g, String _class, String _method){
        Vertex v = FindVertex(g, _class);
        for(Vertex vTMP: v.getVertices(Direction.OUT, "contain")) {
            if(vTMP.getProperty("name").toString().compareTo(_method) == 0) {
                //System.out.println(_method);
                return vTMP;
            }
        }
        Vertex n = g.addVertex(null);
        n.setProperty("name",_method);
        n.setProperty("typ",TypFile.METODA);
        g.addEdge(null, v, n, "contain");
        //System.out.println(_class +" -> "+ _method);
        return n;
    }
}
