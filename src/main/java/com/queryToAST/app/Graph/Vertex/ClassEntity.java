/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.queryToAST.app.Graph.Edge.ImportRelated;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
import com.tinkerpop.frames.annotations.gremlin.GremlinParam;

/**
 *
 * @author Niriel
 */
//@TypeValue("class")
public interface ClassEntity extends BaseEntity{
    
    @GremlinGroovy("it.as('x').out('classRelated').except('x').has('name',name)")
    public ClassEntity getClassRelated(@GremlinParam("name") String name);
    
    @GremlinGroovy("it.as('x').out('methodRelated').except('x').has('name',name)")
    public Iterable<MethodEntity> getMethodRelated(@GremlinParam("name") String name);
    
    @GremlinGroovy("it.as('x').out('methodRelated').except('x').has('briefDescription',briefDescription)")
    public MethodEntity getMethodRelatedBriefDescription(@GremlinParam("briefDescription") String briefDescription);
    
    @GremlinGroovy("it.as('x').out('importRelated').except('x').has('fqn',fqn)")
    public ClassEntity getImportRelated(@GremlinParam("fqn") String fqn);
    
    @GremlinGroovy("it.outE('importRelated').as('x').inV.has('fqn',fqn).except('x')")
    public ImportRelated getImportEdge(@GremlinParam("fqn") String fqn);
    
    @GremlinGroovy("it.as('x').out('annotatedRelated').except('x').has('name',name)")
    public AnnotatedEntity getAnnotatedRelated(@GremlinParam("name") String name);
        
    @GremlinGroovy("it.as('x').out('extendsRelated').except('x').has('fqn',fqn)")
    ClassEntity getExtendsRelated(@GremlinParam("fqn") String fqn);
    
    @GremlinGroovy("it.as('x').out('implementsRelated').except('x').has('fqn',fqn)")
    ClassEntity getImplementsRelated(@GremlinParam("fqn") String fqn);
    
    @Property("inner")
    public void setInner(boolean inner);
    @Property("inner")
    public boolean isInner();       
    
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
    @Adjacency(label = "importRelated", direction=Direction.IN)
    Iterable<ClassEntity> getInImportRelated();
    
    //extends
    @Adjacency(label= "extendsRelated",direction=Direction.OUT)
    ClassEntity addExtendsRelated (); //Return new Vertex
    @Adjacency(label= "extendsRelated",direction=Direction.OUT)
    ClassEntity addExtendsRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "extendsRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getExtendsRelated();
    @Adjacency(label = "extendsRelated", direction=Direction.IN)
    Iterable<ClassEntity> getInExtendsRelated();
    
    //implements
    @Adjacency(label= "implementsRelated",direction=Direction.OUT)
    ClassEntity addImplementsRelated (); //Return new Vertex
    @Adjacency(label= "implementsRelated",direction=Direction.OUT)
    ClassEntity addImplementsdRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "implementsRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getImplementsRelated();
    @Adjacency(label = "implementsRelated", direction=Direction.IN)
    Iterable<ClassEntity> getInImplementsRelated();
    
    //inner Class
    @Adjacency(label= "classRelated",direction=Direction.OUT)
    ClassEntity addClassRelated (); //Return new Vertex
    @Adjacency(label= "classRelated",direction=Direction.OUT)
    ClassEntity addClassRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "classRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getClassRelated();
    @Adjacency(label = "classRelated", direction=Direction.IN)
    Iterable<ClassEntity> getInClassRelated();
}
