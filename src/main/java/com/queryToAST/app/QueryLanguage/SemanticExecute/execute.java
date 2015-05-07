/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.SemanticExecute;

import com.queryToAST.app.Graph.GraphContext.GraphContext;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Metadata.JarMetadata;
import com.queryToAST.app.QueryLanguage.LexerParser.queryLexer;
import com.queryToAST.app.QueryLanguage.LexerParser.queryParser;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Niriel
 */
public class execute {
    private GraphContext _graphContext = null;
    private boolean log=false;
    private boolean load=false;
    private boolean error = false;
    public execute(String path) throws IOException {
        if(load)
        System.out.println("Inicializace grafu.");
        _graphContext = new GraphContext();
        if(load)
        System.out.println("Zahájení dekompilace a tvorby databáze grafu.");
        JarMetadata jarMetadata = new JarMetadata(path, _graphContext);
        error = jarMetadata.isError();
    }
    
    public List<ClassEntity> queryOld(String query){
        if(log)
        _graphContext.PrintVertex();
        
        if(log)
        _graphContext.PrintEdge();
        
        if(log)
        _graphContext.PrintGraph();
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(query);
        
        //Listner
        queryLexer lexer = new queryLexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        queryParser parser = new queryParser(tokens);
        
        ParseTree tree = parser.program(); // begin parsing at init rule
        // create a standard ANTLR parse tree walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // create listener then feed to walker
        queryExecute execute = new queryExecute();
        execute.setContext(_graphContext);
        walker.walk(execute, tree); // walk parse tree         
        execute.printErr();
        
        return execute.getResult();
    }
    
    public List<ClassEntity> query(String query){
        if(log)
        _graphContext.PrintVertex();
        
        if(log)
        _graphContext.PrintEdge();
        
        if(log)
        _graphContext.PrintGraph();
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(query);
        
        //Listner
        queryLexer lexer = new queryLexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        queryParser parser = new queryParser(tokens);
        
        ParseTree tree = parser.program(); // begin parsing at init rule
        // create a standard ANTLR parse tree walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // create listener then feed to walker
        SemanticGenerator semGen = new SemanticGenerator();        
        walker.walk(semGen, tree); // walk parse tree
        
        if(semGen.isError()) {
            semGen.PrintErr();
            return null;
        }
        
        Stack stack = semGen.getStack();
        stack.setGraphContext(_graphContext);
        return stack.run();
    }
    
    public boolean isError(){
        return error;
    }
}
