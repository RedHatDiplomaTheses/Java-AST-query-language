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
//@TypeValue("class")
public interface AnnotatedEntity extends BaseEntity{
    //add
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnParaEntity addAnnParaRelated (); //Return new Vertex    
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnParaEntity addAnnParaRelated (AnnParaEntity annParaEntity);  //Add an existing Vertex    
    
    //get
    @Adjacency(label = "annParaRelated", direction=Direction.OUT)
    Iterable<AnnParaEntity> getAnnParaRelated();
}
