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
        System.out.println("Autor: Vladim�r Falt�n\n"
                + "Email: xfalty06@stud.fit.vutbr.cz\n"
                + "N�zev pr�ce: Rychl� dotazov�n� nad metadaty jazyka Java.\n"
                + "Typ pr�ce: Bakal��sk�\n"
                + "Rok: 2015\n"
                + "\n"
                + "Argumenty pro spu�t�n� konzolov� aplikace.\n"
                + "-help\t\tN�ov�da aplikace.\n"
                + "-console\tSpu�ten� jako consolov� aplikace.\n"
                + "\n"
                + "Ovl�d�n� aplikace\n"
                + "P�i spu�t�n� aplikace budete vyzv�ni k zadan� jar souboru i s\n"
                + "cestou, ve kter�m chcete vyhled�vat t��dy. Po zadan� se jar \n"
                + "soubor dekompiluje a vytvo�� se z n�j grafonv� datab�ze, do \n"
                + "kter� se n�sledn� m��ete dotazovat. D�lka dekompilace je z�v-\n"
                + "isl� na velikosti jar souboru a po�tu t��d, kter� obsahuje."
                            );
    }
}
