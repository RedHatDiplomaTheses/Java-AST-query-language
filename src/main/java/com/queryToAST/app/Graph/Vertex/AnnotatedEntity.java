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
public interface AnnotatedEntity extends BaseEntity{
    @Property("name")
    public void setName(String name);
    @Property("name")
    public String getName();
    
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnParaEntity addAnnParaRelated (); //Return new Vertex
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnParaEntity addAnnParaRelated (AnnParaEntity annParaEntity);  //Add an existing Vertex    
    @Adjacency(label = "annParaRelated", direction=Direction.OUT)
    Iterable<AnnParaEntity> getAnnParaRelated();
}
