package com.queryToAST.app;

import com.queryToAST.app.Graph.GraphContext;
import com.queryToAST.app.Graph.JarGraph;
import com.queryToAST.app.QueryLanguage.Query;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
import com.tinkerpop.frames.modules.gremlingroovy.GremlinGroovyModule;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import java.io.Console;
import java.io.File;
import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {   
        
        new GraphContext();
        if(true)
            return;
        String internalName = "C:\\Users\\Niriel\\Documents\\NetBeansProjects\\JavaTestQueryToAST\\dist\\JavaTestQueryToAST.jar";
        
        JarGraph jar = new JarGraph(internalName, false, true);
        Graph graph = jar.Factory();
        Query q = new Query(graph);
        String query = null;
        Scanner in = new Scanner(System.in);
        
      //  test();
        
        while(true){
           System.out.print(graph.getVertex(0).getProperty("name") + ":< ");
           query = in.nextLine();
           if(query.compareTo("") == 0)
                break;
           GremlinPipeline pipe = q.queryToDB(query);
           if(pipe != null){
               System.out.println(pipe);
                for(Object x:pipe.toList()){
                    Vertex v = (Vertex)x;
                    System.out.print(graph.getVertex(0).getProperty("name") + ":> ");
                    System.out.println(v.getProperty("typ") + ": " + v.getProperty("name"));
                }
           }else{
               System.out.println("Null");
           }
        }
    }
    
    
    public static void test(){
        TinkerGraph graph = (TinkerGraph) factoryGraf();
        //TinkerGraph graph = TinkerGraphFactory.createTinkerGraph(); //This graph is pre-populated.
        FramedGraphFactory factory = new FramedGraphFactory(new GremlinGroovyModule()); //(1) Factories should be reused for performance and memory conservation.

        FramedGraph framedGraph = factory.create(graph); //Frame the graph.

        //Person person = framedGraph.getVertex(1, Person.class);
        Person person = (Person) framedGraph.getVertex(0, Person.class);
        System.out.println(person.getName()); // equals "marko"
//        for(Person p:person.getKnowsPeople()){
//            System.out.println(p.getName());
//        }
    }
    public static Graph factoryGraf(){
        Graph graph = new TinkerGraph();
        Vertex v =  graph.addVertex(null);
        v.setProperty("name", "Jan");
        return graph;
    }
    public interface Person {
        @Property("name")
        public String getName();

        @Adjacency(label="knows")
        public Iterable<Person> getKnowsPeople();

        @Adjacency(label="knows")
        public void addKnowsPerson(final Person person);

        @GremlinGroovy("it.out('knows').out('knows').dedup") //Make sure you use the GremlinGroovy module! #1
        public Iterable<Person> getFriendsOfAFriend();
    }
    
}
