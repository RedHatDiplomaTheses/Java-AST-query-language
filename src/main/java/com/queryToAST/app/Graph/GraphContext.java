/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;


import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.JarEntity;
import com.queryToAST.app.Graph.Vertex.PackageEntity;
import com.tinkerpop.blueprints.Graph;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.typedgraph.TypedGraphModuleBuilder;

/**
 *
 * @author Niriel
 */
public class GraphContext {

    private Graph graph;            // základní graf    
    private FramedGraph<Graph> framed;     // rozšíøený graf
        
    public Graph getGraph() {
        return graph;
    }   

    public FramedGraph getFramed() {
        return framed;
    }       
        
    public GraphContext() {
        graph = new TinkerGraph();        

        FramedGraphFactory factory = new FramedGraphFactory(
			    new TypedGraphModuleBuilder()
			    .withClass(ClassEntity.class)
                            .withClass(JarEntity.class)
			    .withClass(PackageEntity.class)			    
			    .build()
        );
        
        framed = factory.create(graph);
    }    
}
