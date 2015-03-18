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
@TypeValue("jar")
public interface JarEntity extends BaseEntity{
    @Property("fqjn")
    public void setFQJN(String fqjn);
    @Property("fqjn")
    public String getFQJN();
    
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
