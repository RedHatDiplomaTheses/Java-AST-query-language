/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;

import com.queryToAST.app.AST.ClassAST;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.Metadata.ClassMetadata;
import com.queryToAST.app.Setting;
import com.strobel.decompiler.languages.java.ast.AstNode;
import com.strobel.decompiler.languages.java.ast.CompilationUnit;

import com.tinkerpop.blueprints.Graph;
/**
 *
 * @author Niriel
 */
public class ClassGraph {        
    private Setting _settings = null;
    
    public ClassGraph(Setting settings) {
        this._settings = settings;
    }
    
    public Graph getGraphMeta() {
        ClassMetadata meta = new ClassMetadata(_settings);   //Strom Metadat
        System.out.println(meta.getTree());
        System.out.println();
        return factory(meta.getTree());        
    }
    
    public Graph getGraphAST() {
        return factory(new ClassAST(_settings).getUnitAST()); //Strom AST
    }
    
    private Graph factory(Tree tree) {
        return null;
    }
    
    private Graph factory(CompilationUnit unitAST) {
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
}
