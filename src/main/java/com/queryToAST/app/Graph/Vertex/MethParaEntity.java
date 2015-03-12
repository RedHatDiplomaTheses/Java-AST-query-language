/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;

/**
 *
 * @author Niriel
 */
public interface MethParaEntity extends BaseEntity{
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (); //Return new Vertex
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedRelated);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    Iterable<AnnotatedEntity> getAnnotatedRelated();
}
