/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Direction;

/**
 *
 * @author Niriel
 */
public class TitanGrafFactory {    
    public TitanGrafFactory(){
        Graph graph = new TinkerGraph();
        Vertex a = graph.addVertex(null);
        Vertex b = graph.addVertex(null);

        a.setProperty("name", "marko");
        b.setProperty("name", "peter");
        Edge e = graph.addEdge(null, a, b, "knows");
        System.out.println(e.getVertex(Direction.OUT).getProperty("name") + "--" + e.getLabel() + "-->" + e.getVertex(Direction.IN).getProperty("name"));
    }
}
