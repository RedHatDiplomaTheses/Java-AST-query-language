package com.queryToAST.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {           
        String internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
        execute exec = new execute(internalName);        
        
        exec.query("select import,!extend");
    }                    
}
