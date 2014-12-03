package com.queryToAST.app;

import com.queryToAST.app.Graph.JarGraph;
import com.tinkerpop.blueprints.Graph;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {        
        String internalName = "C:\\Users\\Niriel\\Documents\\BP\\decompiler.jar";
        internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
        JarGraph jar = new JarGraph(internalName, false, true);
        jar.Factory();
    }
}
