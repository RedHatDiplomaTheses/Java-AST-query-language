package com.queryToAST.app;

import com.queryToAST.app.QueryLanguage.execute;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String internalName;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to the jar file:");
        
        internalName = in.nextLine();
        if(internalName.compareTo("") == 0)
        {
            internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
            //internalName= "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\Java-AST-query-language\\target\\queryToAST-app-1.0-SNAPSHOT.jar";
        }
        
        execute exec = new execute(internalName);
        
        while(true)
        {
            System.out.print("<: ");
            String query = in.nextLine();
            if(query.compareTo("") == 0)
            {
                break;
            }
            List<ClassEntity> result = exec.query2(query);
            for(ClassEntity ce : result){
                System.out.println("FQN : " + ce.getFQN());
            }                     
        }
    }                    
}
