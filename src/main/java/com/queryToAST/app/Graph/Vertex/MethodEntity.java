/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 *
 * @author Niriel
 */
@TypeValue("method")
public interface MethodEntity extends BaseEntity{
    
    //parametr
    @Adjacency(label= "methParaRelated",direction=Direction.OUT)
    MethParaEntity addMethParaRelated (); //Return new Vertex
    @Adjacency(label= "methParaRelated",direction=Direction.OUT)
    MethParaEntity addMethParaRelated (MethParaEntity methParaRelated);  //Add an existing Vertex    
    @Adjacency(label = "methParaRelated", direction=Direction.OUT)
    Iterable<MethParaEntity> getMethParaRelated();
    
    //call
    @Adjacency(label= "callRelated",direction=Direction.OUT)
    MethodEntity addCallRelated (); //Return new Vertex
    @Adjacency(label= "callRelated",direction=Direction.OUT)
    MethodEntity addCallRelated (MethodEntity methodRelated);  //Add an existing Vertex    
    @Adjacency(label = "callRelated", direction=Direction.OUT)
    Iterable<MethodEntity> getCallRelated();
    
    //annotation
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (); //Return new Vertex
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedRelated);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    Iterable<AnnotatedEntity> getAnnotatedRelated();
}
