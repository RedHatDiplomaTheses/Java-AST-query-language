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
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 *
 * @author Niriel
 */
//@TypeValue("method")
public interface MethodEntity extends BaseEntity{
    
    @GremlinGroovy("it.as('x').out('callRelated').except('x').has('fqn',fqn)")
    public MethodEntity getCallRelated(@GremlinParam("fqn") String fqn);    
    
    @GremlinGroovy("it.in('callRelated')")
    public Iterable<MethodEntity> getInCallRelated();
    
    @Property("countPara")
    public void setCountPara(int count);
    @Property("countPara")
    public int getCountPara();
    
    @Property("briefDescription")
    public void setBriefDescription(String brief);
    @Property("briefDescription")
    public String getBriefDescription();
    
    @Adjacency(label = "methodRelated", direction=Direction.IN)
    ClassEntity getInClassRelated();
    
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
    
    //@Adjacency(label = "callRelated", direction=Direction.IN)
    //MethodEntity getInCallRelated();
    //Iterable<MethodEntity> getInCallRelated();
    
    //annotation
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (); //Return new Vertex
    @Adjacency(label= "annotatedRelated",direction=Direction.OUT)
    AnnotatedEntity addAnnotatedRelated (AnnotatedEntity annotatedRelated);  //Add an existing Vertex    
    @Adjacency(label = "annotatedRelated", direction=Direction.OUT)
    Iterable<AnnotatedEntity> getAnnotatedRelated();
}
