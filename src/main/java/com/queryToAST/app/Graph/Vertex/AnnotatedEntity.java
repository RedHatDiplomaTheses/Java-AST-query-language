package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
import com.tinkerpop.frames.annotations.gremlin.GremlinParam;

/**
 *
 * @author Niriel
 */
//@TypeValue("class")
public interface AnnotatedEntity extends BaseEntity {

    @GremlinGroovy("it.as('x').out('annParaRelated').except('x').has('name',name)")
    public AnnotationAttributeEntity getAnnParaRelated(@GremlinParam("name") String name);

    //add
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnotationAttributeEntity addAnnParaRelated (); //Return new Vertex
    @Adjacency(label= "annParaRelated",direction=Direction.OUT)
    AnnotationAttributeEntity addAnnParaRelated (AnnotationAttributeEntity annParaEntity);  //Add an existing Vertex

    //get
    @Adjacency(label = "annParaRelated", direction=Direction.OUT)
    Iterable<AnnotationAttributeEntity> getAnnParaRelated();
}
