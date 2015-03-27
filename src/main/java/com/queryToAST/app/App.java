package com.queryToAST.app;

import com.queryToAST.app.Graph.Vertex.ClassEntity;
import java.util.List;

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
     
        List<ClassEntity> result = exec.query("? (? fqn='langTest.One.imp.Classes2') in name");
        for(ClassEntity ce : result){
            System.out.println("FQN : " + ce.getFQN());
        }
    }                    
}
