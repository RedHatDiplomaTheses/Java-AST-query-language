package com.queryToAST.app;

import com.queryToAST.app.Graph.GraphContext;
import com.queryToAST.app.Graph.Vertex.BaseEntity;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.JarEntity;
import com.tinkerpop.frames.FramedGraph;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
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

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        
        GraphContext graphContext = new GraphContext();        
        FramedGraph framed = graphContext.getFramed();
        JarEntity jar =  (JarEntity) framed.frame(graphContext.getGraph().addVertex(null), JarEntity.class);
        jar.setName("ProjektNemesis");
        jar.setType("jar");
        ClassEntity classTMP = jar.addClassRelated();
        classTMP.setName("Parser");
        classTMP.setType("class");
        classTMP.setFullyQualifiedName("com.test.parser.class");
        System.out.println(jar.getClassRelated().iterator().next().getFullyQualifiedName());
        assertTrue( true );        
    }
    
    public void testApp2(){
        assertTrue(true);
    }
}
