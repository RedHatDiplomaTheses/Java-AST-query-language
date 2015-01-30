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
    
    private Graph graph;
    
    public Query(Graph graph) throws IOException {        
        this.graph = graph;
        //qT();
        //queryToDB(query);
    }
        
    
    
    public GremlinPipeline queryToDB(String query){
                
        Matcher mQuery = Pattern.compile("^([\\w/\\*]*) ([\\(\\)\\.\\w!?\\d=]+)?$").matcher(query);
        GremlinPipeline pipe = new GremlinPipeline();
        
        //A (Path) (Query)
        if(!mQuery.find()){
            System.out.println("Error: Dotaz neodpovídá!");
            return null;
        }
        //System.out.println(mQuery.group(1));
        
        //B (Path count)        
        if(mQuery.group(1).compareTo("*") == 0)
            pipe.start(graph.getVertices());
        else{
            pipe.start(graph.getVertex(0));            
            for(String sPath :mQuery.group(1).toString().split("/")){
                pipe.out("contain").has("typ",TypFile.PACKAGE).has("name", sPath);
            }
            pipe.out("contain");
        }
                
        if(mQuery.group(2) == null)
            return pipe;
        //C (Konecny automat meho jazyka)
        for(String step:mQuery.group(2).toString().split("\\.")){
            //System.out.println(step);
            Matcher mStep = Pattern.compile("(!?)([\\w]*)(?:\\(([\\w,@=\" ]*)\\))?").matcher(step);
            if(!mStep.find()) {
                System.out.println("Error: chyba jazyka!");
                break;
            }
            //System.out.println("Prohledenj jen zde: " + mStep.group(1));
//            System.out.println("KeyWord: " + mStep.group(2));
//            System.out.println("Condition: " + mStep.group(3));
            
            boolean reverse = false;
            if(mStep.group(1).toString().compareTo("!") == 0){
                reverse = true;    
            }
            
            switch(mStep.group(2)){                
                case "":
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.CLASS:
                    if(reverse)
                        pipe.hasNot("typ", TypFile.CLASS);
                    else
                        pipe.has("typ", TypFile.CLASS);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.EXTEND:
                    if(reverse)
                        pipe.in("extend");
                    else
                        pipe.out("extend");
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.IMPLEMENT:
                    if(reverse)
                        pipe.in("implement");
                    else
                        pipe.out("implement");
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        System.out.println("String1");
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.IMPORT:
                    if(reverse)
                        pipe.in("import");
                    else
                        pipe.out("import");
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.METHOD:
                    if(reverse)
                        pipe.in("contain");
                    else
                        pipe.out("contain").has("typ", TypFile.METODA);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.PROPERTY:
                    break;
                case KeyWords.CALLMETHOD:
                    if(reverse){
                        pipe.in("call").has("typ", TypFile.METODA);
                    }
                    else
                        pipe.out("call").has("typ", TypFile.METODA);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.CONTAION:
                    if(reverse)
                        pipe.in("contain");
                    else
                        pipe.out("contain");
                    break;
                case KeyWords.PACKAGE:
                    if(reverse)
                        pipe.hasNot("typ",TypFile.PACKAGE);
                    else
                        pipe.has("typ",TypFile.PACKAGE);
                    if(mStep.group(3) != null)
                    for(String cond:mStep.group(3).toString().split(",")){
                        condition(pipe,cond);
                    }
                    break;
                case KeyWords.AS:
                    pipe.as(mStep.group(3));
                    break;
                case KeyWords.BACK:
                    pipe.back(mStep.group(3));
                    break;
                default:
                    System.out.println("Error: nezname Klicove slovo\"" + mStep.group(1) + "\"");
                    return null;                    
            }
        }        
        
        return pipe;
    }
    
    
    
    private void condition(GremlinPipeline pipe, String cond){
        String[] s = cond.split("=");
        if(s[0].compareTo("typ")==0){
            switch(s[1]){
                case "class": ;
                    pipe.has(s[0], TypFile.CLASS);
                    break;
                case "interface":
                    pipe.has(s[0], TypFile.INTERFACE);
                    break;
                case "method":
                    pipe.has(s[0], TypFile.METODA);
                    break;
                case "annotation":
                    pipe.has(s[0], TypFile.ANNOTATION);
                    break;
                case "enum":
                    pipe.has(s[0], TypFile.ENUMERATION);
                    break;
                case "package":
                    pipe.has(s[0], TypFile.PACKAGE);
                default:
                    System.out.println("Spatne parametry");
                    break;
            }
        }else if(s[0].compareTo("name") == 0){            
            pipe.has(s[0], s[1]);
        }else if(s[0].compareTo("annotation") == 0){
            System.out.println("Dosud neimplementováno Annotation");
        }else if(s[0].compareTo("argument") == 0){
            System.out.println("Dosud neimplementováno Argument");
        }else{
            System.out.println("Neznamí atribut");
        }
    }
    
    
    
    private void qT(){
        GremlinPipeline pipe = new GremlinPipeline();
        //pipe.start(graph.getVertex(0));
        pipe.start(graph.getVertices());
        
        /*
         * Classes importing/extending class C.        Dodelat importy 
         */
        //1. pipe.has("typ", TypFile.CLASS).has("name","C").out("extend").has("typ", TypFile.CLASS);
        //pipe.as("C").in("extend").
        
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



}
