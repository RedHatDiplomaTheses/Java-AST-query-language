package com.queryToAST.app;

import com.queryToAST.app.Graph.JarGraph;
import com.queryToAST.app.QueryLanguage.Query;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import java.io.Console;
import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {        
        String internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
        
        JarGraph jar = new JarGraph(internalName, false, true);
        Graph graph = jar.Factory();
        Query q = new Query(graph);
        String query = null;
        Scanner in = new Scanner(System.in);
        
        while(true){
           System.out.print(graph.getVertex(0).getProperty("name") + ":< ");
           query = in.nextLine();
           if(query.compareTo("") == 0)
                break;
           GremlinPipeline pipe = q.queryToDB(query);
           if(pipe != null){
               System.out.println(pipe);
                for(Object x:pipe.toList()){
                    Vertex v = (Vertex)x;
                    System.out.print(graph.getVertex(0).getProperty("name") + ":> ");
                    System.out.println(v.getProperty("typ") + ": " + v.getProperty("name"));
                }
           }else{
               System.out.println("Null");
           }
        }
    }
}
