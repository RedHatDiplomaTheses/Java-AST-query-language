package com.queryToAST.app.exec;

import com.queryToAST.app.QueryLanguage.SemanticExecute.QueryProcessor;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        if(args.length != 1) {           
            help();
        }
        else if(args[0].compareToIgnoreCase("-help")==0) {
            help();
        }
        else if(args[0].compareToIgnoreCase("-console")==0) {
            console();
        }
        console();
    }
    
    public static void console() {
        System.out.print("Zadejte cestu k jar souboru:");
        Scanner in = new Scanner(System.in);
        String internalName = in.nextLine();
        
        if(internalName.compareTo("") == 0)
        {
            //C:\Users\Niriel\Documents\NetBeansProjects\Java-AST-query-language\JavaTestQueryToAST.jar
            //internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
            //internalName= "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\Java-AST-query-language\\target\\queryToAST-app-1.0-SNAPSHOT.jar";
        }
        
        QueryProcessor exec = new QueryProcessor(internalName);
        
        if(exec.isError()) {
            return;
        }
        
        while(true)
        {
            System.out.print("<: ");
            String query = in.nextLine();
            if(query.compareTo("") == 0)
            {
                break;
            }            
            List<ClassEntity> result = exec.query(query);
            if(result != null) {
                for(ClassEntity ce : result){
                    System.out.println("FQN : " + ce.getFQN());
                }
            }
        }   
    }
    
    public static void help(){       
        System.out.println("Autor: Vladimír Faltýn\n"
                + "Email: xfalty06@stud.fit.vutbr.cz\n"
                + "Název práce: Rychlé dotazování nad metadaty jazyka Java.\n"
                + "Typ práce: Bakaláøská\n"
                + "Rok: 2015\n"
                + "\n"
                + "Argumenty pro spuštìní konzolové aplikace.\n"
                + "-help\t\tNáovìda aplikace.\n"
                + "-console\tSpuštení jako consolová aplikace.\n"
                + "\n"
                + "Ovládání aplikace\n"
                + "Pøi spuštìní aplikace budete vyzváni k zadaní jar souboru i s\n"
                + "cestou, ve kterém chcete vyhledávat tøídy. Po zadaní se jar \n"
                + "soubor dekompiluje a vytvoøí se z nìj grafonvá databáze, do \n"
                + "které se následnì mùžete dotazovat. Délka dekompilace je záv-\n"
                + "islá na velikosti jar souboru a poètu tøíd, které obsahuje."
                            );
    }
}
