/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app;

import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.QueryLanguage.SemanticExecute.execute;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niriel
 */
public class QueryJUnitTest {
    private execute exec;
    public QueryJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
        try {
            this.exec = new execute(internalName);
        } catch (IOException ex) {
            Logger.getLogger(QueryJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void AllClass() {
        List<ClassEntity> result = query("select * from *");        
        assertEquals(42, result.size());        
    }
    
    @Test
    public void Extends() {
        List<ClassEntity> result = query("select extends from *");
        assertEquals(3, result.size());        
    }
    
    @Test
    public void Import() {
        List<ClassEntity> result = query("select import from *");
        assertEquals(50, result.size());        
    }
    
    @Test
    public void Implements() {
        List<ClassEntity> result = query("select implements from *");
        assertEquals(9, result.size());        
    }
    
    @Test
    public void Calls() {
        List<ClassEntity> result = query("select call[*] from *");
        assertEquals(13, result.size());        
    }
    
    @Test
    public void WhereName() {
        List<ClassEntity> result = query("where name='C'");
        assertEquals(1, result.size());        
    }
    
    @Test
    public void Annotated() {
        List<ClassEntity> result = query("where @Dependencies.value[0].@Dependency.value='C'");
        assertEquals(1, result.size());        
    }
    
    @Test
    public void DependencyAnnotated() {
        List<ClassEntity> result = query("select to.* from (where @Dependencies.value[0].@Dependency.value='C') as po, * as to where to.name = po.@Dependencies.value[0].@Dependency.value");
        assertEquals(1, result.size());
    }
    
    public List<ClassEntity> query(String q) {
        return exec.query(q);
    }
}
