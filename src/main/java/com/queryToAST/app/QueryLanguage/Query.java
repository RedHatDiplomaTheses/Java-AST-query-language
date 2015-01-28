/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage;

import com.queryToAST.app.Core.TypFile;
import com.queryToAST.app.Graph.JarGraph;
import com.tinkerpop.blueprints.Edge;
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
        
        //qT();
        queryToDB(query);
    }
    
    private void qT(){
        GremlinPipeline pipe = new GremlinPipeline();
        //pipe.start(graph.getVertex(0));
        pipe.start(graph.getVertices());
        
        /*
         * Classes importing/extending class C.        Dodelat importy 
         */
        //1. pipe.has("typ", TypFile.CLASS).has("name","C").out("extend").has("typ", TypFile.CLASS);
        
        /*
         * Interfaces extending interface Iext.
         */        
        //2. pipe.as("I").has("typ",TypFile.INTERFACE).out("implement").has("name", "Iext").back("I");
        
        //pipe.has("typ",TypFile.INTERFACE).has("name", "I").outE().inV();
        //pipe.has("typ",TypFile.INTERFACE).has("name", "I").out("implement");
        
        /*
         * Classes implemeting interface Iext.
         */
        //3. pipe.as("I").out("implement").has("typ", TypFile.INTERFACE).has("name", "Iext").back("I");
        
        /*
         * Classes calling a method of interface I.
         */
        //pipe.has("typ", TypFile.INTERFACE).inE().outV().has("typ", TypFile.CLASS).out("contain").in("call");
        //4. pipe.has("typ", TypFile.INTERFACE).has("name", "I").in("implement").out("contain").has("typ", TypFile.METODA).in("call").in("contain");
        
        /*
         * Classes calling a method of interface which extends interface Iext.
         */
        //5. pipe.has("typ", TypFile.INTERFACE).has("name", "Iext").in("implement").has("typ", TypFile.INTERFACE).in("implement").out("contain").has("typ",TypFile.METODA).in("call").in("contain");
        
        /*
         * Classes calling a method of given name of interface which extends interface I with given parameters.
         */
        
        for(Object x: pipe){
            Vertex x2=(Vertex)x;
            //System.out.println(x2.getProperty("name"));
            
//            Edge x2=(Edge)x;
//            System.out.println(x2.getLabel());
            
        }

        
//        pipe.as("class").out("extend").back("class");
//        System.out.println(pipe.toList());
//        
//        for ( Object x: pipe.toList()){
//            Vertex x2 = (Vertex)x;
//            System.out.println("dsads " + x2.getProperty("Name"));
//        }
        
    }
    
    
    
    private void queryToDB(String query){
                
        Matcher mQuery = Pattern.compile("^([\\w/\\*]*) *(.*)$").matcher(query);
        GremlinPipeline pipe = new GremlinPipeline();
        
        //A (Path) (Query)
        if(!mQuery.find()){
            System.out.println("Error: Dotaz neodpovídá!");
            return;
        }
        //System.out.println(mQuery.group(1));
        
        //B (Path count)
        pipe.start(graph.getVertices());
//        boolean findEverywhere = false;
//        for(String sPath :mQuery.group(1).toString().split("/")){
//            if(sPath.compareTo("*") == 0){
//                findEverywhere = true;                
//            }else if(sPath.compareTo("") == 0){
//                break;
//            }else {
//                if(findEverywhere){
//                    
//                }else{
//                    pipe.out("contain").has("name",sPath);
//                    //System.out.println("Pipe:" + pipe);
//                }
//            }
//            //System.out.println("Spath:" + sPath);
//        }
        
        pipe.as("result");
        
        //C (Konecny automat meho jazyka)
        for(String step:mQuery.group(2).toString().split("\\.")){
            //System.out.println(step);
            Matcher mStep = Pattern.compile("(!?)([\\w]*)(?:\\(([\\w,@=\" ]*)\\))?").matcher(step);
            if(!mStep.find()) {
                System.out.println("Error Chyba jazyka!!");
                break;
            }
            //System.out.println("Prohledenj jen zde: " + mStep.group(1));
            System.out.println("KeyWord: " + mStep.group(2));
            System.out.println("Condition: " + mStep.group(3));
            
            boolean FindSubclass = true;
            if(mStep.group(1).toString().compareTo("!") == 0){
                FindSubclass = false;    
            }
            
            switch(mStep.group(2)){
                case "":
                case KeyWords.CLASS:
                    pipe.has("typ", TypFile.CLASS);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.EXTEND:
                    pipe.out("extend");                    
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.IMPLEMENT:
                    pipe.out("implement");                    
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.IMPORT:
                    pipe.out("import");
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.METHOD:
                    pipe.out("contain").has("typ", TypFile.METODA);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.PROPERTY:
                    break;
                case KeyWords.CALLMETHOD:
                    pipe.out("contain").has("typ", TypFile.METODA);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                default:
                    System.out.println("Error:nezname Klicove slovo\"" + mStep.group(1) + "\"");
                    break;
            }
        }
        
        pipe.back("result");
        
        for ( Object x: pipe.toList()){
            Vertex x2 = (Vertex)x;
            System.out.println("Výsledek jmeno: " + x2.getProperty("name"));
            System.out.println("           typ: " + x2.getProperty("typ"));
        }
        
    }
    
    
    
    private void condition(GremlinPipeline pipe, String cond){
        String[] s = cond.split("=");
        pipe.has(s[0], s[1]);        
    }
    
    
    
}
