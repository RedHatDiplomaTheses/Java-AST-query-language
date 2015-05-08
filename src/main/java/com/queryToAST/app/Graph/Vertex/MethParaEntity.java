/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
import com.tinkerpop.frames.annotations.gremlin.GremlinParam;

/**
 *
 * @author Niriel
 */
public interface MethParaEntity extends BaseEntity{
    
    @GremlinGroovy("it.as('x').out('annotatedRelated').except('x').has('name',name)")
    public AnnotatedEntity getAnnotatedRelated(@GremlinParam("name") String name);
    
    @Property("index")
    public void setIndex(int index);
    @Property("index")
    public int getIndex();    
    
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (); //Return new Vertex
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedRelated);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    Iterable<AnnotatedEntity> getAnnotatedRelated();
}
