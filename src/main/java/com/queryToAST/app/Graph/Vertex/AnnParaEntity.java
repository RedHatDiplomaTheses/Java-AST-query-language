/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;

/**
 *
 * @author Niriel
 */
public interface AnnParaEntity extends BaseEntity{
    //TYPE: value[](string,enum,int) AnnotatedRelated[](Annotation) AnnParaEntity[](AnnParaEntity)
    
    //Pole Value[]        
    @Adjacency(label= "valueRelated",direction=Direction.OUT)
    public String addValueRelated (String value);  //Add an existing Vertex    
    @Adjacency(label = "valueRelated", direction=Direction.OUT)
    public Iterable<String> getValueRelated();
    
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
