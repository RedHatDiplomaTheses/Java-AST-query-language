/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 *
 * @author Niriel
 */
@TypeValue("class")
public interface ClassEntity extends BaseEntity{
    @Property("fullyQualifiedName")
    public void setFullyQualifiedName(String fullyQualifiedName);
    @Property("fullyQualifiedName")
    public String getFullyQualifiedName();                
        
    //Method
    @Adjacency(label= "methodRelated",direction=Direction.OUT)
    MethodEntity addMethodRelated (); //Return new Vertex
    @Adjacency(label= "methodRelated",direction=Direction.OUT)
    MethodEntity addMethodRelated (MethodEntity methodRelated);  //Add an existing Vertex    
    @Adjacency(label = "methodRelated", direction=Direction.OUT)
    Iterable<MethodEntity> getMethodRelated();
    
    //Annotation
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (); //Return new Vertex
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedRelated);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    Iterable<AnnotatedEntity> getAnnotatedRelated();
    
    //import
    @Adjacency(label= "importRelated",direction=Direction.OUT)
    ClassEntity addImportRelated (); //Return new Vertex
    @Adjacency(label= "importRelated",direction=Direction.OUT)
    ClassEntity addImportRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "importRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getImportRelated();
    
    //extends
    @Adjacency(label= "extendsRelated",direction=Direction.OUT)
    ClassEntity addExtendsRelated (); //Return new Vertex
    @Adjacency(label= "extendsRelated",direction=Direction.OUT)
    ClassEntity addExtendsRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "extendsRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getExtendsRelated();
    
    //implements
    @Adjacency(label= "implementsRelated",direction=Direction.OUT)
    ClassEntity addImplementsRelated (); //Return new Vertex
    @Adjacency(label= "implementsRelated",direction=Direction.OUT)
    ClassEntity addImplementsdRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "implementsRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getImplementsRelated();
}
