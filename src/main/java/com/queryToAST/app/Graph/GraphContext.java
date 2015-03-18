/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;


import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.JarEntity;
import com.queryToAST.app.Graph.Vertex.PackageEntity;
import com.strobel.assembler.ir.Instruction;
import com.strobel.assembler.metadata.MethodDefinition;
import com.strobel.assembler.metadata.TypeDefinition;
import com.strobel.assembler.metadata.annotations.CustomAnnotation;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.typedgraph.TypedGraphModuleBuilder;
import java.util.Iterator;
import java.util.List;

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

    public void CreateClassMetadata(TypeDefinition metadata) {
        System.out.println(
                "name : " + metadata.getName()
                + "\nfullname : " + metadata.getFullName()
                + "\nErasedSignature : " + metadata.getErasedSignature()
                + "\nSignature : " + metadata.getSignature()
                + "\ndescription : " + metadata.getDescription()
                + "\nErasedDescription : " + metadata.getErasedDescription()
                + "\nPackageName : " + metadata.getPackageName()
                + "\nsimpleDesctiption : " + metadata.getSimpleDescription()
                + "\nSimpleName : " + metadata.getSimpleName()
                + "\nBriefDescription : " + metadata.getBriefDescription()
        );
        
        setClassAnnotation(metadata.getAnnotations());
        setClassMethod(metadata.getDeclaredMethods());
//        ClassEntity classTMP = jar.addClassRelated();
//        classTMP.setName("Parser");
//        classTMP.setType("class");
//        classTMP.setFullyQualifiedName("com.test.parser.class");
    }

    public void setName(String name) {
        JarEntity jar =  (JarEntity) framed.frame(graph.addVertex(null), JarEntity.class);        
        jar.setName(name.replaceAll(".*\\\\", "").replaceAll("\\.jar", ""));
        jar.setType("jar");
        jar.setFQJN(name);
    }
    
    public void PrintVertex(){
        for(Vertex v :graph.getVertices()){
            System.out.println(
                    v.getProperty("type")
                    + ":" +
                    v.getProperty("name")
                    + "  " +
                    v.getProperty("fqjn")
            );
        }
    }
    
    public void PrintEdge(){
        for(Edge e :graph.getEdges()){
            System.out.println(
                    e.getLabel()
                    + ":" +
                    e.getVertex(Direction.OUT).getProperty("name")
                    + "<-->" +
                    e.getVertex(Direction.IN).getProperty("name")
            );
        }
    }

    private void setClassAnnotation(List<CustomAnnotation> annotations) {

    }

    private void setClassMethod(List<MethodDefinition> declaredMethods) {
        for(MethodDefinition m :declaredMethods){
            if(!m.getName().contains("cmp"))
                continue;
            System.out.println(
                    "Name : " + m.getName()
                    + "\nBriefDescription : " + m.getBriefDescription()
                    + "\nDescription : " + m.getDescription()
                    + "\nErasedDescription : " + m.getErasedDescription()
                    + "\nErasedSignature : " + m.getErasedSignature()
                    + "\nFullName : " + m.getFullName()
                    + "\nSignature : " + m.getSignature()
                    + "\nSimpleDescription : " + m.getSimpleDescription()                    
            );
            for (Instruction i :m.getBody().getInstructions()) {
                System.out.println( "->>"+
                        i.toString()
                );
            }
        }
    }
    
}
