package com.queryToAST.app;

import com.queryToAST.app.AST.CreateClassAST;
import com.queryToAST.app.Metadata.CreateClassMetadata;
import com.strobel.decompiler.languages.java.ast.CompilationUnit;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {   
        // Zenit !!! pøed uploudem na Git !!!
        String _internalName =  "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\build\\classes\\javatestquerytoast\\NormalTest.class";
        String _output = null;//"C:\\Users\\Niriel\\Documents\\BP\\out\\out.txt";
        
        SettingQuery settings= new SettingQuery(_internalName,_output);
                       
        //CompilationUnit UnitAST = new CreateClassAST(settings).getUnitAST();
                        
        CreateClassMetadata createClassMetadata = new CreateClassMetadata(settings);
        //System.out.println(createClassMetadata.getOut());        
        
    }
}
