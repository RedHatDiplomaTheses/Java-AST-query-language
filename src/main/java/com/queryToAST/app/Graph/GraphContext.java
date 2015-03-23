/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph;


import com.queryToAST.app.Graph.Vertex.AnnParaEntity;
import com.queryToAST.app.Graph.Vertex.AnnotatedEntity;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.JarEntity;
import com.queryToAST.app.Graph.Vertex.MethParaEntity;
import com.queryToAST.app.Graph.Vertex.MethodEntity;
import com.queryToAST.app.Graph.Vertex.PackageEntity;
import com.strobel.assembler.ir.Instruction;
import com.strobel.assembler.metadata.FieldDefinition;
import com.strobel.assembler.metadata.MethodDefinition;
import com.strobel.assembler.metadata.ParameterDefinition;
import com.strobel.assembler.metadata.TypeDefinition;
import com.strobel.assembler.metadata.TypeReference;
import com.strobel.assembler.metadata.annotations.AnnotationAnnotationElement;
import com.strobel.assembler.metadata.annotations.AnnotationElement;
import com.strobel.assembler.metadata.annotations.AnnotationParameter;
import com.strobel.assembler.metadata.annotations.ArrayAnnotationElement;
import com.strobel.assembler.metadata.annotations.ClassAnnotationElement;
import com.strobel.assembler.metadata.annotations.ConstantAnnotationElement;
import com.strobel.assembler.metadata.annotations.CustomAnnotation;
import com.strobel.assembler.metadata.annotations.EnumAnnotationElement;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.gremlingroovy.GremlinGroovyModule;
import com.tinkerpop.frames.modules.typedgraph.TypedGraphModuleBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class GraphContext {

    private Graph graph;            // základní graf    
    private FramedGraph<Graph> framed;     // rozšíøený graf    
    private JarEntity _jar;
    private boolean log = false;
    private ClassEntity _tmp = null;
    public Graph getGraph() {
        return graph;
    }   

    public FramedGraph getFramed() {
        return framed;
    }       
        
    public GraphContext() {
        graph = new TinkerGraph();        

//        FramedGraphFactory factory2 = new FramedGraphFactory(
//			    new TypedGraphModuleBuilder()
//			    .withClass(ClassEntity.class)
//                            .withClass(JarEntity.class)
//			    .withClass(PackageEntity.class)			    
//			    .build()
//        );
        FramedGraphFactory factory = new FramedGraphFactory(new GremlinGroovyModule()); //Use the gremlin groovy module
        
        framed = factory.create(graph);
    }

    public void CreateClassMetadata(TypeDefinition metadata) {
        if(log)
        System.out.println(
                "C"
                + "\nName : " + metadata.getName()
                + "\nfullname : " + metadata.getFullName()
                + "\nErasedSignature : " + metadata.getErasedSignature()
                + "\nSignature : " + metadata.getSignature()
                + "\ndescription : " + metadata.getDescription()
                + "\nErasedDescription : " + metadata.getErasedDescription()
                + "\nPackageName : " + metadata.getPackageName()
                + "\nsimpleDesctiption : " + metadata.getSimpleDescription()
                + "\nSimpleName : " + metadata.getSimpleName()
                + "\nBriefDescription : " + metadata.getBriefDescription()
                + "\nImplements : " + metadata.getExplicitInterfaces()
                + "\nBaseType(extend) : "  + metadata.getBaseType().getFullName()
                + "\nResolve : " + metadata.resolve().getFullName()
                + "\nInner : " + metadata.isInnerClass()
        );                
        
        ClassEntity tmp = getClass(metadata.getFullName());
        _tmp = tmp;
        tmp.setName(metadata.getName());        
        tmp.setDescription(metadata.getDescription());
        tmp.setNotDecompile(false);
        tmp.setFQN(metadata.getFullName());
        tmp.setInner(metadata.isInnerClass());
        tmp.setFinal(metadata.isFinal());
        tmp.setPrivate(metadata.isPrivate());
        tmp.setProtected(metadata.isProtected());
        tmp.setPublic(metadata.isPublic());
        if(!(metadata.getBaseType().getFullName().compareTo("java.lang.Object") == 0 || 
                metadata.getBaseType().getFullName().compareTo("java.lang.Enum") == 0)){
                tmp.addExtendsRelated(getClass(metadata.getBaseType().getFullName()));
                setImport(metadata.getBaseType().getFullName());
        }
        
        //umisteni v baliku
        setPKG(tmp);
        
        //implementace
        for(TypeReference ei:metadata.getExplicitInterfaces()){
            setImport(ei.getFullName());
            tmp.addImplementsdRelated(getClass(ei.getFullName()));
        }
        
        
        //propperty        
        for(FieldDefinition df:metadata.getDeclaredFields()){
            if(log)
            System.out.println("FILED"
                    + "\nName : " + df.getName()
                    + "\nType : " + df.getFieldType().getFullName()
            );
            setImport(df.getFieldType().getFullName());
        }
        
        //Innerclass
        if(log)
        for(TypeDefinition dt:metadata.getDeclaredTypes()){
            System.out.println("Decoared : " + dt.getName());
        }
        
        if(metadata.isClass()){
            tmp.setType("class");
            if(metadata.hasAnnotations()){
                setAnnotation(metadata.getAnnotations(),tmp.addAnnotatedRelated());
            }
            for(MethodDefinition m:metadata.getDeclaredMethods()){
                boolean cmp = true;
                for(Vertex v :graph.getVertices()){
                    if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(m.getFullName()) == 0){
                        MethodEntity meqt = framed.frame(v, MethodEntity.class);
                        if(meqt.getBriefDescription().compareTo(m.getBriefDescription()) == 0){
                            cmp = false;                            
                            tmp.addMethodRelated(meqt);
                            setMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                setMethod(m,tmp.addMethodRelated());
            }
        }else if (metadata.isInterface()) {
            tmp.setType("interface");            
            if(metadata.hasAnnotations()){
                setAnnotation(metadata.getAnnotations(),tmp.addAnnotatedRelated());
            }
           for(MethodDefinition m:metadata.getDeclaredMethods()){
                boolean cmp = true;
                for(Vertex v :graph.getVertices()){
                    if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(m.getFullName()) == 0){
                        MethodEntity meqt = framed.frame(v, MethodEntity.class);
                        if(meqt.getBriefDescription().compareTo(m.getBriefDescription()) == 0){
                            cmp = false;                            
                            tmp.addMethodRelated(meqt);
                            setMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                setMethod(m,tmp.addMethodRelated());
            }
        }else if(metadata.isEnum()){
            tmp.setType("enum");
        }else if (metadata.isAnnotation()){
            if(metadata.hasAnnotations()){
                setAnnotation(metadata.getAnnotations(),tmp.addAnnotatedRelated());
            }
            tmp.setType("annotation");
        }       
    }

    public void setName(String name) {
        _jar =  (JarEntity) framed.frame(graph.addVertex(null), JarEntity.class);        
        _jar.setName(name.replaceAll(".*\\\\", "").replaceAll("\\.jar", ""));
        _jar.setType("jar");
        _jar.setFQN(name);
    }
    
    public void PrintVertex(){
        for(Vertex v :graph.getVertices()){            
            System.out.println(
                    "\nVERTEX"
                    + "\ntype : " + v.getProperty("type")
                    + "\nname : " + v.getProperty("name")
                    + "\nFQN : " + v.getProperty("fqn")
                    + "\nDescription : " + v.getProperty("description")
                    + "\nValue : " + v.getProperty("value")
                    + "\nNotDecompile : " + v.getProperty("notDecompile")
            );
        }
    }
    
    public void PrintEdge(){
        for(Edge e :graph.getEdges()){
            System.out.println(
                    "\nEDGE"
                    + "\nLable : " + e.getLabel()
                    + "\n" + e.getVertex(Direction.OUT).getProperty("name")
                    + "<-->" + e.getVertex(Direction.IN).getProperty("name")
            );
        }
    }

    private void setAnnotation(List<CustomAnnotation> annotations, AnnotatedEntity AE) {
        for(CustomAnnotation ca:annotations){
            if(log)
            System.out.println(
                    "@"
                    + "\nDescription : " + ca.getAnnotationType().getDescription()
                    + "\nBriefDescription : " + ca.getAnnotationType().getBriefDescription()
                    + "\nName : " + ca.getAnnotationType().getName()
                    + "\nPackage : " + ca.getAnnotationType().getPackageName()
                    + "\nFullName : " + ca.getAnnotationType().getFullName()
            );
            AE.setName(ca.getAnnotationType().getName());
            AE.setFQN(ca.getAnnotationType().getFullName());
            AE.setType("annotated");
            AE.setDescription(ca.getAnnotationType().getDescription());
            //import
            setImport(AE.getFQN());
            
            for (AnnotationParameter ap : ca.getParameters()) {
                if(log)
                System.out.println(
                        "@P"
                        + "\nMember : " + ap.getMember());
                AnnParaEntity ape = AE.addAnnParaRelated();
                ape.setName(ap.getMember());
                switch(ap.getValue().getElementType()){
                    case Annotation:
                        setAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue(), ape);
                        break;
                    case Array:
                        setArrayAnnotationElement((ArrayAnnotationElement)ap.getValue(), ape);
                        break;
                    case Constant:
                        setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue(), ape);
                        break;
                    case Class:
                        setClassAnnotationElement((ClassAnnotationElement)ap.getValue(), ape);
                        break;
                    case Enum:
                        setEnumAnnotationElementType((EnumAnnotationElement)ap.getValue(), ape);
                        break;
                }
            }
        }
    }
        
    private void setMethod(MethodDefinition m,MethodEntity ME) {
            if(log)
            System.out.println(
                    "M"
                    + "\nName : " + m.getName()
                    + "\nBriefDescription : " + m.getBriefDescription()
                    + "\nDescription : " + m.getDescription()
                    + "\nErasedDescription : " + m.getErasedDescription()
                    + "\nErasedSignature : " + m.getErasedSignature()
                    + "\nFullName : " + m.getFullName()
                    + "\nSignature : " + m.getSignature()
                    + "\nSimpleDescription : " + m.getSimpleDescription()
                    + "\nReturnType : " + m.getReturnType().getFullName()
            );
            ME.setBriefDescription(m.getBriefDescription());
            ME.setName(m.getName());
            ME.setType("method");
            ME.setFQN(m.getFullName());
            ME.setDescription(m.getDescription());
            ME.setNotDecompile(false);
            ME.setPrivate(m.isPrivate());
            ME.setPublic(m.isPublic());
            ME.setProtected(m.isProtected());
            ME.setFinal(m.isFinal());
            ME.setStatic(m.isStatic());
            //Import
            setImport(getType(m.getReturnType().getFullName().replaceAll("\\[|\\]", "")));
            
            if(m.hasAnnotations()){
                setAnnotation(m.getAnnotations(),ME.addAnnotatedRelated());
            }
            
            //body
            int count =0;
            for(ParameterDefinition pd:m.getParameters()){                
                if(log)
                System.out.println(
                        "MP"
                        + "\nname : " + pd.getName()
                        + "\ntype : " + pd.getParameterType().getName()
                        + "\nfullName : " + pd.getParameterType().getFullName()
                        + "\ndeclarName :" + pd.getDeclaringType().getName()
                        + "\ndeclarFullName :" + pd.getDeclaringType().getFullName()                        
                );
                
                MethParaEntity mpe = ME.addMethParaRelated();
                mpe.setType("parametr");
                mpe.setName(pd.getName());
                mpe.setFQN(pd.getParameterType().getFullName());
                mpe.setIndex(count);
                
                //import
                setImport(pd.getParameterType().getFullName());
                
                if(pd.hasAnnotations()){
                    setAnnotation(pd.getAnnotations(),mpe.addAnnotatedRelated());
                }
                count++;
            }
            ME.setCountPara(count);
            if(log)
            System.out.println("\nMB-CODE");
            if(m.getBody()!= null)
                //m.getBody().getVariables().listIterator().next().getDeclaringType()
            for (Instruction ins :m.getBody().getInstructions()) {
                if(log)
                System.out.println(
                        "\nString : " + ins.toString()
                        + "\nLable : " + ins.hasLabel()
                        + "\nOffset : " + ins.hasOffset()
                        + "\nOperand : " + ins.hasOperand()
                        + "\nCode : " + ins.hashCode()
                );
                if(ins.toString().contains("INVOKE"))
                    setCall(ins.toString(), ME);                    
            }
    }

    private void setAnnotationAnnotationElement(AnnotationAnnotationElement annotationAnnotationElement, AnnParaEntity APE) {        
        if(log)
        System.out.println(
                    "@@"
                    + "\nDescription : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getDescription()
                    + "\nBriefDescription : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getBriefDescription()
                    + "\nName : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getName()
                    + "\nPackage : " + annotationAnnotationElement.getAnnotation().getAnnotationType().getPackageName()
            );
        APE.setType("annotated");
        APE.setName(annotationAnnotationElement.getAnnotation().getAnnotationType().getName());
        APE.setFQN(annotationAnnotationElement.getAnnotation().getAnnotationType().getFullName());
        APE.setDescription(annotationAnnotationElement.getAnnotation().getAnnotationType().getDescription());
        
        //import
        setImport(annotationAnnotationElement.getAnnotation().getAnnotationType().getFullName());
        
        for(AnnotationParameter ap : annotationAnnotationElement.getAnnotation().getParameters()){
            if(log)
            System.out.println(
                        "@@P"
                        + "\nMember : " + ap.getMember());
            AnnParaEntity ape = APE.addAnnParaRelated();
            ape.setName(ap.getMember());
            switch(ap.getValue().getElementType()){
                case Annotation:
                    setAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue(), ape);
                    break;
                case Array:
                    setArrayAnnotationElement((ArrayAnnotationElement)ap.getValue(), ape);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue(), ape);
                    break;
                case Class:
                    setClassAnnotationElement((ClassAnnotationElement)ap.getValue(),ape);
                    break;
                case Enum:
                    setEnumAnnotationElementType((EnumAnnotationElement)ap.getValue(),ape);
                    break;
            }
        }
    }

    private void setArrayAnnotationElement(ArrayAnnotationElement arrayAnnotationElement, AnnParaEntity APE) {
        APE.setType("array");
        for(AnnotationElement ae : arrayAnnotationElement.getElements()){
            AnnParaEntity ape = APE.addAnnParaRelated();            
            switch(ae.getElementType()){
                case Annotation:                    
                    setAnnotationAnnotationElement((AnnotationAnnotationElement)ae,ape);
                    break;
                case Array:
                    setArrayAnnotationElement((ArrayAnnotationElement)ae,ape);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ae,ape);
                    break;
                case Class:
                    setClassAnnotationElement((ClassAnnotationElement)ae,ape);
                    break;
                case Enum:
                    setEnumAnnotationElementType((EnumAnnotationElement)ae,ape);
                    break;
            }
        }
    }

    private void setConstantAnnotationElement(ConstantAnnotationElement constantAnnotationElement, AnnParaEntity APE) {
        APE.setType("constant");
        APE.setValue((String) constantAnnotationElement.getConstantValue());
        if(log)
        System.out.println(
                "ConstantAnnotationElement"
                + "\nValue : " + constantAnnotationElement.getConstantValue()                
        );
    }

    private void setClassAnnotationElement(ClassAnnotationElement classAnnotationElement,AnnParaEntity APE) {
        APE.setValue(classAnnotationElement.getClassType().getName());
        if(log)
        System.out.println(
                "ClassAnnotationElement"
                + "" + classAnnotationElement.getClassType().getName()
                + "" + classAnnotationElement.getClassType().getFullName()
        );
    }

    private void setEnumAnnotationElementType(EnumAnnotationElement enumAnnotationElement,AnnParaEntity APE) {
        APE.setValue(enumAnnotationElement.getEnumConstantName());
        APE.setType("enum");
        APE.setFQN(enumAnnotationElement.getEnumType().getFullName());
        APE.setDescription(enumAnnotationElement.getEnumType().getFullName() + "." + enumAnnotationElement.getEnumType().getFullName());
        if(log)
        System.out.println(
            "\nEnumValue"
            + "\nEnumConstantName : " + enumAnnotationElement.getEnumConstantName()
            + "\nEnumTyp : " + enumAnnotationElement.getEnumType().getFullName()
        );
    }

    private void setCall(String INS, MethodEntity ME) {
        if(log)
        System.out.println(
                "\nfull : " +INS.replaceAll(".*INVOKE[A-Z]* ","")                        
                + "\nClass : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll("\\..*", "")
                 + "\nMethod : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "")
                + "\nParametrs : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "")
                + "\nReturn : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\)", "")
                + "\nFQN : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(":\\(.*", "")
                );
        String Full = INS.replaceAll(".*INVOKE[A-Z]* ","");
        String Class = INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll("\\..*", "");
        String Method = INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "");
        String Param = INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "");
        String Return =INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\)", "");
        String FQN = INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(":\\(.*", "");
        
        List<String> result = convertType(Param);
        List<String> ret = convertType(Return);               
        
        String Brief = (ret.isEmpty() ? "void" : ret.get(ret.size()-1))
                + " " + Method + "(" + 
                (result.isEmpty()?"":result.toString()).replaceAll("(^\\[)|(\\]$)", "").replaceAll("/", ".")
                + ")" ;
        
        for(Vertex v :graph.getVertices()){
            if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(FQN) == 0){
                MethodEntity meqt = framed.frame(v, MethodEntity.class);
                if(meqt.getBriefDescription().compareTo(Brief) == 0){
                    ME.addCallRelated(meqt);
                    return;
                }
            }
        }
        
        MethodEntity me =  (MethodEntity) framed.frame(graph.addVertex(null), MethodEntity.class);        
        me.setName(Method);
        me.setType("method");
        me.setBriefDescription(Brief);
        me.setFQN(FQN);
        me.setNotDecompile(true);        
        
    }
    
    private List<String> convertType(String type){
        char[]  s = type.toCharArray();
        int i=0;
        List<String> result = new ArrayList();
        while(i<s.length){
            switch(s[i]){
                case 'B':
                    result.add("byte");
                    break;
                case 'C':
                    result.add("char");
                    break;
                case 'D':
                    result.add("double");
                    break;
                case 'F':
                    result.add("float");
                    break;
                case 'I':
                    result.add("int");
                    break;
                case 'J':
                    result.add("long");
                    break;
                case 'L':
                    String re="";
                    while(s[++i] !=';'){
                        re += s[i];
                    }
                    result.add(re);
                    break;
                case 'S':
                    result.add("short");
                    break;
                case 'Z':
                    result.add("boolean");
                    break;
                case '[':
                    String ar = "[]";
                    boolean go = true;
                    while(++i<s.length && go){
                        switch(s[i]){
                            case 'B':
                                ar = "byte" + ar;
                                go=false;
                                break;
                            case 'C':
                                ar = "char" + ar;
                                break;
                            case 'D':
                                ar = "double" + ar;
                                break;
                            case 'F':
                                ar = "float" + ar;
                                go=false;
                                break;
                            case 'I':
                                ar = "int" + ar;
                                go=false;
                                break;
                            case 'J':
                                ar = "long" + ar;
                                go=false;
                                break;
                            case 'L':
                                String re2="";
                                while(s[++i] !=';'){
                                    re2 += s[i];
                                }
                                ar = re2 + ar;
                                go=false;
                                break;
                            case 'S':
                                ar = "short" + ar;
                                go=false;
                                break;
                            case 'Z':
                                ar = "boolean" + ar;
                                go=false;
                                break;
                            case '[':
                                ar = "[]" + ar;                                        
                                break;
                        }
                    }
                    result.add(ar);
                    break;
            }
            i++;
        }
        return result;
    }

    private ClassEntity getClass(String fullName) { //predelat k urychleni
        for(Vertex v : graph.getVertices()){
            if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(fullName) == 0){
            return framed.frame(v, ClassEntity.class);            
            }
        }
        ClassEntity ce = framed.frame(graph.addVertex(null), ClassEntity.class);
        ce.setFQN(fullName);
        ce.setNotDecompile(true);
        return ce;
    }

    private void setPKG(ClassEntity CE) {
        String[] paths = null;        
        if(CE.isInner()){            
            paths = CE.getFQN().replaceFirst(CE.getName().replaceAll("\\$1", ".") + "$", "").split("\\.");
            
        }else{
            paths= CE.getFQN().replaceFirst("\\..*$", "").split(".");
            
        }        
        
        PackageEntity pe = null;
        if(paths.length == 0){
            _jar.addClassRelated(CE);
            return;
        }else{            
            pe = _jar.getPackageRelated(paths[0]);
            if(pe == null){
               pe = _jar.addPackageRelated();
               pe.setName(paths[0]);
               pe.setType("package");                              
            }
        }
                
        for(int i = 1; i < paths.length ; i++){            
            PackageEntity tmp = pe.getPackageRelated(paths[i]);
            if(tmp == null){
                tmp = pe.addPackageRelated();
                tmp.setName(paths[i]);
                tmp.setType("package");
                pe = tmp;
            }else{
                pe = tmp;
            }
        }
        pe.addClassRelated(CE);
    }

    private void setImport(String fullName) {
        if(fullName == null || fullName.compareTo("") == 0)
            return;        
        if(_tmp.getFQN().replaceFirst("\\.\\w*$", "").compareTo(fullName.replaceFirst("\\.\\w*$", "")) == 0)
            return;
        if(_tmp.getImportRelated(fullName) == null){
            _tmp.addImportRelated(getClass(fullName));
        }
    } 

    private String getType(String imp) {
        switch(imp){
                case "void" :
                case "int" :
                case "byte" :
                case "boolean" :                
                case "short" :
                case "float" :
                case "double" :
                case "char" :
                case "long" :                    
                case "java.lang.String" :
                case "java.lang.Iterable" :
                    break;
                default :
                    return imp;               
            }
        return null;
    }
}
