/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;


import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.JarEntity;
import com.queryToAST.app.Graph.Vertex.PackageEntity;
import com.strobel.assembler.ir.Instruction;
import com.strobel.assembler.ir.attributes.SourceAttribute;
import com.strobel.assembler.metadata.MethodDefinition;
import com.strobel.assembler.metadata.ParameterDefinition;
import com.strobel.assembler.metadata.TypeDefinition;
import com.strobel.assembler.metadata.annotations.AnnotationAnnotationElement;
import com.strobel.assembler.metadata.annotations.AnnotationElement;
import com.strobel.assembler.metadata.annotations.AnnotationParameter;
import com.strobel.assembler.metadata.annotations.ArrayAnnotationElement;
import com.strobel.assembler.metadata.annotations.ClassAnnotationElement;
import com.strobel.assembler.metadata.annotations.ConstantAnnotationElement;
import com.strobel.assembler.metadata.annotations.CustomAnnotation;
import com.strobel.assembler.metadata.annotations.EnumAnnotationElement;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.typedgraph.TypedGraphModuleBuilder;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class GraphContext {

    private Graph graph;            // základní graf    
    private FramedGraph<Graph> framed;     // rozšíøený graf    
    private JarEntity _jar;
    
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
                "C"
                + "\nname : " + metadata.getName()
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
        
        ClassEntity tmp = framed.frame(graph.addVertex(null), ClassEntity.class);
        tmp.setName(metadata.getName());
        tmp.setFQCN(metadata.getFullName());
        if(metadata.isClass()){
            tmp.setType("class");
        }else if (metadata.isInterface()) {            
            tmp.setType("interface");
        }else if(metadata.isEnum()){
            tmp.setType("enum");
        }else if (metadata.isAnnotation()){
            tmp.setType("annotation");
        }
        
        setAnnotation(metadata.getAnnotations());
        setClassMethod(metadata.getDeclaredMethods());

    }

    public void setName(String name) {
        _jar =  (JarEntity) framed.frame(graph.addVertex(null), JarEntity.class);        
        _jar.setName(name.replaceAll(".*\\\\", "").replaceAll("\\.jar", ""));
        _jar.setType("jar");
        _jar.setFQJN(name);
    }
    
    public void PrintVertex(){
        for(Vertex v :graph.getVertices()){
            System.out.println(
                    "VERTEX"
                    + "\ntype : " + v.getProperty("type")
                    + "\nname : " + v.getProperty("name")
                    + "\nFQCN : " + v.getProperty("fqcn")
            );
        }
    }
    
    public void PrintEdge(){
        for(Edge e :graph.getEdges()){
            System.out.println(
                    "EDGE"
                    + "\nLable : " + e.getLabel()
                    + "" + e.getVertex(Direction.OUT).getProperty("name")
                    + "<-->" + e.getVertex(Direction.IN).getProperty("name")
            );
        }
    }

    private void setAnnotation(List<CustomAnnotation> annotations) {        
        for(CustomAnnotation ca:annotations){
            System.out.println(
                    "@"
                    + "\nDescription : " + ca.getAnnotationType().getDescription()
                    + "\nBriefDescription : " + ca.getAnnotationType().getBriefDescription()
                    + "\nName : " + ca.getAnnotationType().getName()
                    + "\nPackage : " + ca.getAnnotationType().getPackageName()
            );
            
            for (AnnotationParameter ap : ca.getParameters()) {
                
                System.out.println(
                        "P"
                        + "\nMember : " + ap.getMember());
                switch(ap.getValue().getElementType()){
                    case Annotation:
                        setAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue());
                        break;
                    case Array:
                        setArrayAnnotationElement((ArrayAnnotationElement)ap.getValue());
                        break;
                    case Constant:
                        setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue());
                        break;
                    case Class:
                        setClassAnnotationElement((ClassAnnotationElement)ap.getValue());
                        break;
                    case Enum:
                        setEnumAnnotationElementType((EnumAnnotationElement)ap.getValue());
                        break;
                }
            }
        }

    }
        
    private void setClassMethod(List<MethodDefinition> declaredMethods) {
        for(MethodDefinition m :declaredMethods){            
            setAnnotation(m.getAnnotations());            
            for(ParameterDefinition pd:m.getParameters()){
                setAnnotation(pd.getAnnotations());
                System.out.println(
                        "Parametr"
                        + "\nname : " + pd.getName()
                );
                
            }
            System.out.println(
                    "M"
                    + "\nName : " + m.getName()
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

    private void setAnnotationAnnotationElement(AnnotationAnnotationElement annotationAnnotationElement) {        
        System.out.println(
                    "@"
                    + "\nDescription : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getDescription()
                    + "\nBriefDescription : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getBriefDescription()
                    + "\nName : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getName()
                    + "\nPackage : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getPackageName()
            );
        for(AnnotationParameter ap : annotationAnnotationElement.getAnnotation().getParameters()){
            System.out.println(
                        "P"
                        + "\nMember : " + ap.getMember());            
            switch(ap.getValue().getElementType()){
                case Annotation:
                    setAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue());
                    break;
                case Array:
                    setArrayAnnotationElement((ArrayAnnotationElement)ap.getValue());
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue());
                    break;
                case Class:
                    setClassAnnotationElement((ClassAnnotationElement)ap.getValue());
                    break;
                case Enum:
                    setEnumAnnotationElementType((EnumAnnotationElement)ap.getValue());
                    break;
            }
        }
    }

    private void setArrayAnnotationElement(ArrayAnnotationElement arrayAnnotationElement) {        
        for(AnnotationElement ae : arrayAnnotationElement.getElements()){
            switch(ae.getElementType()){
                case Annotation:                    
                    setAnnotationAnnotationElement((AnnotationAnnotationElement)ae);
                    break;
                case Array:
                    setArrayAnnotationElement((ArrayAnnotationElement)ae);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ae);
                    break;
                case Class:
                    setClassAnnotationElement((ClassAnnotationElement)ae);
                    break;
                case Enum:
                    setEnumAnnotationElementType((EnumAnnotationElement)ae);
                    break;
            }
        }
    }

    private void setConstantAnnotationElement(ConstantAnnotationElement constantAnnotationElement) {
        System.out.println(
                "ConstantAnnotationElement"
                + "\nValue : " + constantAnnotationElement.getConstantValue()
        );
    }

    private void setClassAnnotationElement(ClassAnnotationElement classAnnotationElement) {
        System.out.println(
                "ClassAnnotationElement"
                + "" + classAnnotationElement.getClassType().getName()
        );
    }

    private void setEnumAnnotationElementType(EnumAnnotationElement enumAnnotationElement) {
        System.out.println(
            "EnumAnnotationElementType"
            + "\nEnumConstantName : " + enumAnnotationElement.getEnumConstantName()
        );
    }
    
}
