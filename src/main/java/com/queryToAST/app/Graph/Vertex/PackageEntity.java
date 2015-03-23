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
//@TypeValue("package")
public interface PackageEntity extends BaseEntity{
    @GremlinGroovy("it.as('x').out('packageRelated').except('x').has('name',name)")
    public PackageEntity getPackageRelated(@GremlinParam("name") String name);
    
    @GremlinGroovy("it.as('x').out('classRelated').except('x').has('name',name)")
    public ClassEntity getClassRelated(@GremlinParam("name") String name);
    
    @Adjacency(label= "classRelated",direction=Direction.OUT)
    ClassEntity addClassRelated (); //Return new Vertex
    @Adjacency(label= "classRelated",direction=Direction.OUT)
    ClassEntity addClassRelated (ClassEntity classRelated);  //Add an existing Vertex    
    @Adjacency(label = "classRelated", direction=Direction.OUT)
    Iterable<ClassEntity> getClassRelated();
    
    @Adjacency(label= "packageRelated",direction=Direction.OUT)
    PackageEntity addPackageRelated ();
    @Adjacency(label= "packageRelated",direction=Direction.OUT)
    PackageEntity addPackageRelated (PackageEntity packageRelated);    
    @Adjacency(label = "packageRelated", direction=Direction.OUT)
    Iterable<PackageEntity> getPackageRelated();
}
