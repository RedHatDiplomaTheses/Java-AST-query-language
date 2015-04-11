/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;

import com.queryToAST.app.QueryLanguage.queryExecute;
import com.queryToAST.app.QueryLanguage.queryLexer;
import com.queryToAST.app.QueryLanguage.queryParser;
import java.io.IOException;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author Niriel
 */
public class QueryTest extends TestCase{
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QueryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
        
    public void testQuery() throws IOException{
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream("select * from *");
        
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
        walker.walk(execute, tree); // walk parse tree
        
        System.out.println(execute); // print results
        
        assertTrue(true);
    }
}
