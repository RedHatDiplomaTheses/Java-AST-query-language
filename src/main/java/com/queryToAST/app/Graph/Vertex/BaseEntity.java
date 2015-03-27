/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.Vertex;

import com.queryToAST.app.Graph.Edge.ImportRelated;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Incidence;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import com.tinkerpop.frames.modules.typedgraph.TypeField;

/**
 *
 * @author Niriel
 */
//@TypeField("type")
public interface BaseEntity extends VertexFrame {
    @Property("name")
    public void setName(String name);
    @Property("name")
    public String getName();

    @Property("fqn")
    public void setFQN(String fqn);
    @Property("fqn")
    public String getFQN();

    @Property("type")
    public void setType(String type);
    @Property("type")
    public String getType();

    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();

    @Property("notDecompile")
    public void setNotDecompile(boolean notDecompile);
    @Property("notDecompile")
    public boolean getNotDecompile();
    
    @Property("final")
    public void setFinal(boolean Final);
    @Property("final")
    public boolean isFinal();
    
    @Property("public")
    public void setPublic(boolean Public);
    @Property("public")
    public boolean isPublic();
    
    @Property("protected")
    public void setProtected(boolean Protected);
    @Property("protected")
    public boolean isProtected();
    
    @Property("private")
    public void setPrivate(boolean Private);
    @Property("private")
    public boolean isPrivate();
    
    @Property("static")
    public void setStatic(boolean Static);
    @Property("static")
    public boolean isStatic();
        
}
