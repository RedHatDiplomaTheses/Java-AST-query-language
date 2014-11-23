/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;

import com.tinkerpop.gremlin.java.GremlinPipeline;

/**
 *
 * @author Niriel
 */
public class PipeFactory {
    PipeFactory(){
        GremlinPipeline pipe = new GremlinPipeline();
        //pipe.start(g.getVertex(1)).out("knows").property("name");
    }
}
