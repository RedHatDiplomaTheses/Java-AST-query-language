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
    private static execute exec;
    private String q;    
    List<ClassEntity> result;
    
    public QueryJUnitTest() {
        String internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\Java-AST-query-language\\JavaTestQueryToAST.jar";
        this.exec = new execute(internalName);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {        
        
    }
    
    @After
    public void tearDown() {
        System.out.println("");
        System.out.println(q);
        if(result == null){
            System.out.println("----");
            return;
        }
        for(int i = 0; i < result.size() && i < 3; i++){
            System.out.println("-" + result.get(i).getFQN());
        }
        if(result.size() > 3) {
            System.out.println("-...");
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void AllClass() {
        q="select * from *";
        result = query(q);
        assertEquals(44, result.size());        
    }
    
    @Test
    public void Extends() {
        q="select extends from *";
        result = query(q);
        assertEquals(5, result.size());        
    }
    
    @Test
    public void Import() {
        q="select import from *";
        result = query(q);
        assertEquals(60, result.size());        
    }
    
    @Test
    public void Implements() {
        q="select implements from *";
        result = query(q);
        assertEquals(10, result.size());        
    }
    
    @Test
    public void Calls() {
        q="select call[*] from *";
        result = query(q);
        assertEquals(29, result.size());        
    }
    
    @Test
    public void WhereName() {
        q="where name='C'";
        result = query(q);
        assertEquals(1, result.size());        
    }
    
    @Test
    public void Annotated() {
        q="where @Dependencies.value[0].@Dependency.value='C'";
        result = query(q);
        assertEquals(1, result.size());        
    }
    
    @Test
    public void DependencyAnnotated() {
        q="select to.* from (where @Dependencies.value[0].@Dependency.value='C') as po, * as to where to.name = po.@Dependencies.value[0].@Dependency.value";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void MethodAnnotated() {
        q="select * from * where method[*]@Constructor";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void MethodParametrAnnotated() {
        q="select * from * where method[*][*]@Inject";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test1() {
        q="SELECT po.* FROM (SELECT extends, import WHERE name = 'C') AS po WHERE (SELECT !extends WHERE name='I') IN po.implements unique";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test2() {
        q="SELECT !implements WHERE name='I'";
        result = query(q);
        assertEquals(2, result.size());
    }
    
    @Test
    public void Test3() {
        q="SELECT call[*] WHERE name='I'";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test4() {        
        q = "SELECT call[*] WHERE (WHERE name='I') IN extends";
        result = query(q);
        assertEquals(1, result.size());
    }
    
     @Test
    public void Test5() {        
        q = "SELECT call[name='easy', arg=''] WHERE (WHERE name='I') IN extends";
        result = query(q);
        assertEquals(1, result.size());
    }
    
     @Test
    public void Test6() {        
        q = "SELECT call[*] WHERE @Abasic AND (WHERE name='Iext') IN implements UNIQUE";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test7() {        
        q = "SELECT * WHERE @Aauthor.email='jannovak@seznam.cz' AND (WHERE name='I') IN implements";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test8() {        
        q = "SELECT * WHERE @Abasic";
        result = query(q);
        assertEquals(2, result.size());
    }
    
    @Test
    public void Test9() {        
        q = "SELECT * WHERE (SELECT !extends WHERE name='supClassB') IN import";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test10() {        
        q = "SELECT * WHERE (SELECT !extends WHERE (SELECT !extends WHERE name='I') IN implements) IN import";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test11() {        
        q = "SELECT za.* FROM (WHERE name='Protokol') AS po, * AS za WHERE za.name=po.@Dependencies.value[0].@Dependency.value";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test12() {        
        q = "SELECT (SELECT (SELECT (SELECT extends)))";
        result = query(q);
        assertEquals(5, result.size());
    }
    
    @Test
    public void Test13() {        
        q = "SELECT * WHERE name!='C'";
        result = query(q);
        assertEquals(43, result.size());
    }
    
    @Test
    public void Test14() {        
        q = "SELECT ap.* FROM (SELECT implements) AS ap, (SELECT extends) join (SELECT import) AS ExIm WHERE ap.name=ExIm.name UNIQUE";
        result = query(q);
        assertEquals(4, result.size());
    }
    
    @Test
    public void Test15() {
        q = "SELECT ps.* FROM (WHERE name=r'.*In.*') AS ps WHERE EXIST (SELECT WHERE EXIST (SELECT * WHERE ps.name=name)) UNIQUE";
        result = query(q);
        assertEquals(8, result.size());
    }
    
    @Test
    public void Test16() {
        q = "SELECT ps.*,pe.* FROM * AS ps, * AS pe WHERE ps.inner AND pe.interface";
        result = query(q);
        assertEquals(6, result.size());
    }
    
    @Test
    public void Test17() {
        q = "SELECT * WHERE @Retention AND @Target";
        result = query(q);
        assertEquals(8, result.size());
    }
    
    @Test
    public void Test18() {
        q = "SELECT call[name='getName'] FROM 'test'";
        result = query(q);
        assertEquals(2, result.size());
    }
    
    @Test
    public void Test19() {
        q = "SELECT extends FROM !'langTest.One'";
        result = query(q);
        assertEquals(1, result.size());
    }
    
    @Test
    public void Test20() {
        q = "SELECT extends FROM 'langTest.One'";
        result = query(q);
        assertEquals(3, result.size());
    }
    
    @Test
    public void Test21() {
        q = "SELECT extend WHERE name='C' AND interface";
        result = query(q);
        assertEquals(null, result);
    }
    
    @Test
    public void Test22() {
        q = "SELECT po.extends FROM * AS pe WHERE po.name='C'";
        result = query(q);
        assertEquals(null, result);
    }
    
    @Test
    public void Test23() {
        q = "SELECT po.extends FROM * AS pe WHERE EXIST (SELECT pe.extends FROM * AS po) AND po.name='C'";
        result = query(q);
        assertEquals(null, result);
    }
    
    @Test
    public void Test24() {
        q = "SELECT call[name='getName', arg='int,String', name='setName'] FROM * WHERE name='NormalTest";
        result = query(q);
        assertEquals(null, result);
    }
    
    public List<ClassEntity> query(String q) {
        return exec.query(q);
    }
}
