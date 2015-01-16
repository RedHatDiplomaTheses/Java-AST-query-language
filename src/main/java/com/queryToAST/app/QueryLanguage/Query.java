/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage;

import com.queryToAST.app.Graph.JarGraph;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pøíjme dotaz a rozparsuje ho a vykonna
 * @author Niriel
 */
public class Query {
    Graph graph;
    public Query(String path,String query) throws IOException {        
        JarGraph jar = new JarGraph(path, false, true);
        graph = jar.Factory();
        queryToDB(query);
    }
    
    private void queryToDB(String query){
        Matcher mQuery = Pattern.compile("^([\\w/\\*]*) *(.*)$").matcher(query);

        GremlinPipeline pipe = new GremlinPipeline();

        pipe.start(graph.getVertex(0));
        
//        for(Object x: pipe.toList()){
//            Vertex x2=(Vertex)x;
//            System.out.println(x2.getProperty("name"));
//        }
        
        //System.out.println(graph.getVertex(0).getProperty("name"));
        
        //A (Path) (Query)
        if(!mQuery.find()){
            System.out.println("Error: Dotaz neodpovídá!");
            return;
        }
        //System.out.println(mQuery.group(1));
        
        boolean findEverywhere = false;
        for(String sPath :mQuery.group(1).toString().split("/")){
            if(sPath.compareTo("*") == 0){
                findEverywhere = true;                
            }else if(sPath.compareTo("") == 0){
                break;
            }else {
                if(findEverywhere){
                    
                }else{
                    pipe.out("contain").has("name",sPath);
                    //System.out.println("Pipe:" + pipe);
                }
            }
            //System.out.println("Spath:" + sPath);
        }
        
        mQuery.group(2);        
        for(String step:mQuery.group(2).toString().split("\\.")){
            System.out.println(step);
            Matcher mStep = Pattern.compile("(!?)([\\w]*)(?:\\(([\\w,@=\" ]*)\\))?").matcher(step);
            if(!mStep.find()) {
                break;
            }
            System.out.println("Prohledenj jen zde: " + mStep.group(1));
            System.out.println("KeyWord: " + mStep.group(2));
            System.out.println("Condition: " + mStep.group(3));
            
            boolean FindSubclass = true;
            if(mStep.group(1).toString().compareTo("!") == 0){
                FindSubclass = false;    
            }
            
            switch(mStep.group(1)){
                case "":
                    ;
                case KeyWords.CLASS:
                    if(FindSubclass){
                        for(String cond:mStep.group(3).toString().split(",")){
                            condition(pipe,cond);
                        }
                    }
                    break;
                case KeyWords.EXTEND:
                    break;
                case KeyWords.IMPLEMENT:
                    break;
                case KeyWords.IMPORT:
                    break;
                case KeyWords.METHOD:
                    break;
                case KeyWords.PROPERTY:
                    break;
            }
        }
    }
    
    private void condition(GremlinPipeline pipe, String cond){
        String[] s = cond.split("=");
        pipe.has(s[0], s[1]);        
    }
}
