/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 *
 * @author Niriel
 */
@TypeValue("package")
public interface PackageEntity extends BaseEntity{
    @Property("fullyQualifiedName")
    public void setFullyQualifiedName(String fullyQualifiedName);
    @Property("fullyQualifiedName")
    public String getFullyQualifiedName();
    
    
}
