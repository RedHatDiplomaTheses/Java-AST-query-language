/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import com.tinkerpop.frames.modules.typedgraph.TypeField;

/**
 *
 * @author Niriel
 */
@TypeField("type")
public interface BaseEntity extends VertexFrame {
@Property("name")
public void setName(String name);
@Property("name")
public String getName();

@Property("type")
public void setType(String name);
@Property("type")
public String GetType();
}
