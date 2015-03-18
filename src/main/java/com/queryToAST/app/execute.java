/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;

import com.queryToAST.app.Graph.GraphContext;
import com.queryToAST.app.Metadata.JarMetadata;
import com.tinkerpop.blueprints.Vertex;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class execute {
    private GraphContext _graphContext = null;

    public execute(String path) throws IOException {
        _graphContext = new GraphContext();
        
        new JarMetadata(path, _graphContext);   
    }
    
    public List<Vertex> query(String query){
        _graphContext.PrintVertex();
        _graphContext.PrintEdge();
        return null;
    }
        
}
