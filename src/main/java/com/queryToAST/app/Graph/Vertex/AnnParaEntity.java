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
public interface AnnParaEntity extends BaseEntity{
    
    @GremlinGroovy("it.as('x').out('annParaRelated').except('x').has('index', index)")
    public AnnParaEntity getIndexRelated(@GremlinParam("index") int index);
    
    @GremlinGroovy("it.as('x').out('annParaRelated').except('x').has('name', name)")
    public AnnParaEntity getAnnParaRelated(@GremlinParam("name") String name);
    
    
    @GremlinGroovy("it.as('x').out('annotatedRelated').except('x').has('name', name)")
    public AnnotatedEntity getAnnotatedRelated(@GremlinParam("name") String name);
    
    @Property("value")
    public void setValue(String value);
    @Property("value")
    public String getValue();
    
    @Property("index")
    public void setIndex(int index);
    @Property("index")
    public int getIndex();    
    
    
    //Pole Anotaci
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    public AnnotatedEntity addAnnotatedRelated (); //Return new Vertex    
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    public AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedEntity);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    public Iterable<AnnotatedEntity> getAnnotatedRelated();
    
    //Pole AnnPara
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    public AnnParaEntity addAnnParaRelated (); //Return new Vertex    
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    public AnnParaEntity addAnnParaRelated (AnnParaEntity AnnParaEntity);  //Add an existing Vertex    
    @Adjacency(label = "annParaRelated", direction=Direction.OUT)
    public Iterable<AnnParaEntity> getAnnParaRelated();
    
}
