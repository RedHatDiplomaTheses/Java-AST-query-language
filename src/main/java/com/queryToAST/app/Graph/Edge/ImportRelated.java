/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Edge;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Niriel
 */
public interface ImportRelated extends BaseRelated{
    @Property("static")
    public void setStatic(boolean value);
    @Property("static")
    public boolean getStatic(boolean no);
}
