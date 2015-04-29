/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Graph.GraphContext;


import com.queryToAST.app.Graph.Vertex.*;
import com.strobel.assembler.ir.Instruction;
import com.strobel.assembler.metadata.*;
import com.strobel.assembler.metadata.annotations.*;
import com.tinkerpop.blueprints.*;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.gremlingroovy.GremlinGroovyModule;
import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Lists;
import com.strobel.assembler.ir.ConstantPool;

/**
 *
 * @author Niriel
 */
public class GraphContext {
       
    private boolean error = false;
    private final Graph graph;            // základní graf    
    private final FramedGraph<Graph> framed;     // rozšíøený graf    
    private JarEntity _jar;
    private final boolean log = false;
    private ClassEntity _tmp = null;

    public boolean isError() {
        return error;
    }
    
    public Graph getGraph() {
        return graph;
    }   

    public FramedGraph getFramed() {
        return framed;
    }       
        
    public GraphContext() {        
        graph = new TinkerGraph();     
        FramedGraphFactory factory = new FramedGraphFactory(new GremlinGroovyModule()); //TODO spomaleni na zaèatku programu
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
        
        ClassEntity classEntity = getClass(metadata.getFullName());
        _tmp = classEntity;
        classEntity.setName(metadata.getName());        
        classEntity.setDescription(metadata.getDescription());
        classEntity.setNotDecompile(false);
        classEntity.setFQN(metadata.getFullName());
        classEntity.setInner(metadata.isInnerClass());
        classEntity.setFinal(metadata.isFinal());
        classEntity.setPrivate(metadata.isPrivate());
        classEntity.setProtected(metadata.isProtected());
        classEntity.setPublic(metadata.isPublic());
        
        //import BaseType extends
        if(!(metadata.getBaseType().getFullName().compareTo("java.lang.Object") == 0 || 
                metadata.getBaseType().getFullName().compareTo("java.lang.Enum") == 0)){
                classEntity.addExtendsRelated(getClass(metadata.getBaseType().getFullName()));
                setImport(metadata.getBaseType().getFullName());
        }
        
        //umisteni v baliku
        setPKG(classEntity);
        
        //implementace
        for(TypeReference ei:metadata.getExplicitInterfaces()){
            if(ei.getFullName().compareTo("java.lang.annotation.Annotation")==0)
                break;
            setImport(ei.getFullName());
            classEntity.addImplementsdRelated(getClass(ei.getFullName()));
        }
        
        if(metadata.hasAnnotations()){
            for(CustomAnnotation ca:metadata.getAnnotations()){                
                setAnnotation(ca,classEntity.addAnnotatedRelated());
            }
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
        
        if(log)
        for(ConstantPool.Entry ent:metadata.getConstantPool())
            if(ent!=null)
                System.out.println(ent);

        //Innerclass
        if(log)
        for(TypeDefinition dt:metadata.getDeclaredTypes()){
            System.out.println("Decoared : " + dt.getName());
        }
            
        if(metadata.isClass())
        {
            classEntity.setType("class");           
            for(MethodDefinition m:metadata.getDeclaredMethods()){
                boolean cmp = true;
                for(Vertex v :graph.getVertices()){
                    if(v.getProperty("fqn") != null
                            && v.getProperty("fqn").toString().compareTo(m.getFullName()) == 0){
                        MethodEntity meqt = framed.frame(v, MethodEntity.class);
                        if(meqt.getBriefDescription().compareTo(m.getBriefDescription()) == 0){
                            cmp = false;                            
                            classEntity.addMethodRelated(meqt);
                            setMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                setMethod(m,classEntity.addMethodRelated());
            }
        }else if (metadata.isAnnotation()){            
            classEntity.setType("annotation");
        }else if (metadata.isInterface()) {
            classEntity.setType("interface");
           for(MethodDefinition m:metadata.getDeclaredMethods()){
                boolean cmp = true;
                for(Vertex v :graph.getVertices()){
                    if(v.getProperty("fqn") != null
                            && v.getProperty("fqn").toString().compareTo(m.getFullName()) == 0){
                        MethodEntity meqt = framed.frame(v, MethodEntity.class);
                        if(meqt.getBriefDescription().compareTo(m.getBriefDescription()) == 0){
                            cmp = false;                            
                            classEntity.addMethodRelated(meqt);
                            setMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                setMethod(m,classEntity.addMethodRelated());
            }
        }else if(metadata.isEnum()){
            classEntity.setType("enum");
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
                    + "\n" + e.getVertex(Direction.OUT).getProperty("fqn")
                    + "<-->" + e.getVertex(Direction.IN).getProperty("fqn")
            );
        }
    }
    
    public void PrintGraph(){
        for(PackageEntity pes: _jar.getPackageRelated()){
            System.out.println("\nPACKAGE"
                    + "\nName : " + pes.getName()
            );
            for(ClassEntity ces : pes.getClassRelated()){
                System.out.println("\tCLASS"
                    + "\n\tName : " + ces.getName()
                );
                for(ClassEntity ex:ces.getExtendsRelated())
                    System.out.println("\t\tEXTEND : " + ex.getName());
                for(ClassEntity im: ces.getImplementsRelated())
                    System.out.println("\t\tIMPLEMENTS : " + im.getName());
                for(ClassEntity imp: ces.getImportRelated())
                    System.out.println("\t\tIMPORT : " + imp.getFQN());
                for(AnnotatedEntity an:ces.getAnnotatedRelated()){
                    System.out.println("\t\tAnnotated : " + an.getName());
                    for(AnnParaEntity ap: an.getAnnParaRelated()){
                        System.out.println("\t\t\tAnnParam : " + ap.getName() + " type : " + ap.getType());
                        for(AnnParaEntity ps : ap.getAnnParaRelated()){
                            System.out.println("\t\t\tAnnParam : " + ps.getFQN() + " type : " + ps.getType() + " value : " + ps.getValue());
                            for( AnnParaEntity abs:ps.getAnnParaRelated()){
                                System.out.println("\t\tAnnotated : " + abs.getName()  + " type : " + abs.getType() + " value : " + abs.getValue());
                            }
                        }
                    }
                }
                for(MethodEntity me:ces.getMethodRelated()){
                    System.out.println(
                            "\t\tMETHOD : " + me.getDescription()
                    );
                    for(AnnotatedEntity anr:me.getAnnotatedRelated()){
                        System.out.println("\t\tAnnotated : " + anr.getName());
                    }
                    for(MethodEntity cr:me.getCallRelated()){
                        System.out.println("\t\tCall : " + cr.getFQN());
                        System.out.println("\t\tCallClass : " + cr.getInClassRelated().getFQN());
                    }
                }
            }
            for(PackageEntity pess:pes.getPackageRelated()){
                System.out.println("\n\tPACKAGE"
                    + "\n\tName : " + pess.getName()
                );
                for(ClassEntity ces : pess.getClassRelated()){
                System.out.println("\t\tCLASS"
                    + "\n\t\tName : " + ces.getName()                        
                );
                for(ClassEntity ex:ces.getExtendsRelated())
                    System.out.println("\t\t\tEXTEND : " + ex.getName());
                for(ClassEntity im: ces.getImplementsRelated())
                    System.out.println("\t\t\tIMPLEMENTS : " + im.getName());
                for(ClassEntity imp: ces.getImportRelated())
                    System.out.println("\t\t\tIMPORT : " + imp.getFQN());
                for(AnnotatedEntity an:ces.getAnnotatedRelated()){
                    System.out.println("\t\t\tAnnotated : " + an.getName());
                    for(AnnParaEntity ap: an.getAnnParaRelated())
                        System.out.println("\t\t\t\tAnnParam : " + ap.getType());
                }
                for(MethodEntity me:ces.getMethodRelated()){
                    System.out.println(
                            "\t\t\tMETHOD : " + me.getDescription()
                    );
                    for(AnnotatedEntity anr:me.getAnnotatedRelated()){
                        System.out.println("\t\t\t\tAnnotated : " + anr.getName());
                    }
                    for(MethodEntity cr:me.getCallRelated()){
                        System.out.println("\t\t\t\tCall : " + cr.getFQN());
                    }
                }
                }
                
                for(PackageEntity pesss:pess.getPackageRelated()){
                System.out.println("\n\t\tPACKAGE"
                    + "\n\t\tName : " + pesss.getName()
                );
                for(ClassEntity ces : pesss.getClassRelated()){
                System.out.println("\t\t\tCLASS"
                    + "\n\t\t\tName : " + ces.getName()
                );
                for(ClassEntity ex:ces.getExtendsRelated())
                    System.out.println("\t\t\t\tEXTEND : " + ex.getName());
                for(ClassEntity im: ces.getImplementsRelated())
                    System.out.println("\t\t\t\tIMPLEMENTS : " + im.getName());
                for(ClassEntity imp: ces.getImportRelated())
                    System.out.println("\t\t\t\tIMPORT : " + imp.getFQN());
                for(AnnotatedEntity an:ces.getAnnotatedRelated()){
                    System.out.println("\t\t\t\tAnnotated : " + an.getName());
                    for(AnnParaEntity ap: an.getAnnParaRelated())
                        System.out.println("\t\t\t\tAnnParam : " + ap.getType());
                }
                for(MethodEntity me:ces.getMethodRelated()){
                    System.out.println(
                            "\t\t\t\tMETHOD : " + me.getDescription()
                    );
                    for(AnnotatedEntity anr:me.getAnnotatedRelated()){
                        System.out.println("\t\t\t\t\tAnnotated : " + anr.getName());
                    }
                    for(MethodEntity cr:me.getCallRelated()){
                        System.out.println("\t\t\t\t\tCall : " + cr.getFQN());
                    }
                }
                }
                }
            }
        }
    }

    private void setAnnotation(CustomAnnotation CA, AnnotatedEntity AE) {                    
            if(log)
            System.out.println(
                    "@"
                    + "\nDescription : " + CA.getAnnotationType().getDescription()
                    + "\nBriefDescription : " + CA.getAnnotationType().getBriefDescription()
                    + "\nName : " + CA.getAnnotationType().getName()
                    + "\nPackage : " + CA.getAnnotationType().getPackageName()
                    + "\nFullName : " + CA.getAnnotationType().getFullName()
            );
            AE.setName(CA.getAnnotationType().getName());
            AE.setFQN(CA.getAnnotationType().getFullName());
            AE.setType("annotated");
            AE.setDescription(CA.getAnnotationType().getDescription());
            
            //import
            setImport(AE.getFQN());
            
            for (AnnotationParameter ap : CA.getParameters()) {
                if(log)
                System.out.println(
                        "@P"
                        + "\nMember : " + ap.getMember());
                AnnParaEntity ape = AE.addAnnParaRelated();
                ape.setName(ap.getMember());
                ape.setType(ap.getValue().getElementType().name());
                
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
                for(CustomAnnotation ca:m.getAnnotations())
                    setAnnotation(ca,ME.addAnnotatedRelated());
            }
            
            //parametrs
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
                    for(CustomAnnotation ca:pd.getAnnotations())
                        setAnnotation(ca, mpe.addAnnotatedRelated());
                }
                count++;
            }
            ME.setCountPara(count);
            
            //Body
            if(log)
            System.out.println("\nMB-CODE");
            if(m.getBody()!= null)
                //m.getBody().getVariables().listIterator().next().getDeclaringType()
            for (Instruction ins :m.getBody().getInstructions()) {
                if(log)
                System.out.println(                        
                        "\nString : " + ins.toString()
                        + "\nLable : " + (ins.hasLabel() ? ins.getLabel().getIndex() : "false")
                        + "\nOffset : " + ins.hasOffset()
                        + "\nOperand : " + ins.hasOperand()
                        + "\nCode : " + ins.hashCode()
                        + "\nGetOpCode : " + ins.getOpCode()                        
                );
                if(log)
                for(int i = 0; i < ins.getOperandCount(); i++)
                {
                    System.out.println("Operand : " + ins.getOperand(i));
                }
                if(ins.toString().contains("INVOKE"))
                {
                    if(ins.toString().contains("STATIC")) //INVOKESPECIAL
                    {
                        setCall(ins.toString(), ME, true);
                    }                    
                    else if(ins.toString().contains("INTERFACE"))
                    {
                        setCall(ins.toString(), ME, false);                    
                    }
                    else if(ins.toString().contains("VIRTUAL"))
                    {
                        setCall(ins.toString(), ME, false);                    
                    }
                    else if(ins.toString().contains("DYNAMIC"))
                    {
                        setCall(ins.toString(), ME, false);                    
                    }
                    else if(ins.toString().contains("SPECIAL"))
                    {
                        //setCall(ins.toString(), ME, false);                    
                    }
                }
                    
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
                        
        APE.setFQN(annotationAnnotationElement.getAnnotation().getAnnotationType().getFullName());
        APE.setDescription(annotationAnnotationElement.getAnnotation().getAnnotationType().getDescription());
        APE.setName(annotationAnnotationElement.getAnnotation().getAnnotationType().getName());
        
        //import
        setImport(annotationAnnotationElement.getAnnotation().getAnnotationType().getFullName());
        
        for(AnnotationParameter ap : annotationAnnotationElement.getAnnotation().getParameters()){
            if(log)
            System.out.println(
                        "@@P"
                        + "\nMember : " + ap.getMember());
            AnnParaEntity ape = APE.addAnnParaRelated();
            ape.setName(ap.getMember());
            ape.setType(ap.getValue().getElementType().name());
            
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
        int i=0;
        for(AnnotationElement ae : arrayAnnotationElement.getElements()){
            AnnParaEntity ape = APE.addAnnParaRelated();
            ape.setType(ae.getElementType().name());
            ape.setIndex(i);
            i++;
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
        if(log)
        System.out.println(
                "ConstantAnnotationElement"
                + "\nValue : " + constantAnnotationElement.getConstantValue()                
        );
        
            APE.setValue((String) constantAnnotationElement.getConstantValue());
    }

    private void setClassAnnotationElement(ClassAnnotationElement classAnnotationElement,AnnParaEntity APE) {        
        if(log)
        System.out.println(
                "ClassAnnotationElement"
                + "" + classAnnotationElement.getClassType().getName()
                + "" + classAnnotationElement.getClassType().getFullName()
        );
        
        APE.setValue(classAnnotationElement.getClassType().getName());
    }

    private void setEnumAnnotationElementType(EnumAnnotationElement enumAnnotationElement,AnnParaEntity APE) {
        APE.setValue(enumAnnotationElement.getEnumConstantName());
        APE.setType("enum");
        APE.setFQN(enumAnnotationElement.getEnumType().getFullName());
        APE.setDescription(enumAnnotationElement.getEnumType().getFullName() + "." + enumAnnotationElement.getEnumType().getFullName());
        setImport(enumAnnotationElement.getEnumType().getFullName());
        if(log)
        System.out.println(
            "\nEnumValue"
            + "\nEnumConstantName : " + enumAnnotationElement.getEnumConstantName()
            + "\nEnumTyp : " + enumAnnotationElement.getEnumType().getFullName()
        );
    }

    private void setCall(String INS, MethodEntity ME, boolean isStatic) {
        if(log)
        System.out.println("\nfull : " +INS.replaceAll(".*INVOKE[A-Z]* ","")                        
                + "\nClass : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll("\\..*", "")
                 + "\nMethod : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "")
                + "\nParametrs : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "")
                + "\nReturn : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\)", "")
                + "\nFQN : " + INS.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(":\\(.*", "")
                );
        String Full = INS.replaceAll(".*INVOKE[A-Z]+ ","");
        String Class = INS.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll("\\..*", "");
        String Method = INS.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "");
        String Param = INS.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "");
        String Return =INS.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*\\)", "").replaceAll("/", ".");
        String FQN = INS.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(":\\(.*", "");
                
        List<String> result = convertType(Param);        
        List<String> ret = convertType(Return);               
        
        String Brief = (ret.isEmpty() ? "void" : ret.get(ret.size()-1))
                + " " + Method + "(" + 
                (result.isEmpty()?"":result.toString()).replaceAll("(^\\[)|(\\]$)", "").replaceAll("/", ".")
                + ")" ;
        
        setImport(Class.replaceAll("/", "."));
        if(FQN.compareTo("java/lang/Object.<init>") == 0){
            return;
        }
        if(ME.getCallRelated(FQN) != null){
            return;
        }
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
                    while(s[++i] != ';'){    //Error
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
            paths= CE.getFQN().replaceFirst("\\.\\w*$", "").split("\\.");
            
        }        
//        for(String s:paths){
//                System.out.println(s);
//            }
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
        if(fullName == null)
            return;
        fullName = fullName.replaceAll("[\\[\\]]", "");
        if( fullName.compareTo("") == 0 || !fullName.contains(".")
                || fullName.compareTo("java.lang.String") == 0
                || fullName.compareTo("java.lang.Object") == 0
                || fullName.compareTo("java.lang.UnsupportedOperationException") == 0){
            return;
        }        
        if(_tmp.getFQN().replaceFirst("\\.\\w*$", "").compareTo(fullName.replaceFirst("\\.\\w*$", "")) == 0){
            return;
        }
        if(_tmp.getImportRelated(fullName) == null){
            _tmp.addImportRelated(getClass(fullName));
            
            //is Static Import
            //ImportRelated ie = _tmp.getImportEdge(fullName);            
            //ie.setStatic(true);                            
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
    
    
    
    /* 
    *   Èást volana queryExecute
    */
    
    public  List<ClassEntity> getClassInPackage(String text) {
        
        if(text.compareTo("*") == 0){ //vrat vsechny tridy v jar souboru
            List<ClassEntity> result = new ArrayList();
            for(PackageEntity pr:_jar.getPackageRelated()){
                result.addAll(getRecursion(pr));
            }
            return result;
        }
        
        String [] paths = text.replaceAll("'", "").split("\\.");
        PackageEntity pe = _jar.getPackageRelated(paths[0]);
        
        if(pe == null){   //Error balik neexistuje
            error = true;            
            return null;
        }
        
        for(int i = 1; i < paths.length; i++) {
            pe = pe.getPackageRelated(paths[i]);
            if(pe == null){  //Error balik neesixtuje
                return null; 
            }
        }      
        return Lists.newArrayList( pe.getClassRelated());
    }

    public  List<ClassEntity> getClassInPackageRecursion(String text) {
        String [] paths = text.replaceAll("'", "").split("\\.");
        PackageEntity pe = _jar.getPackageRelated(paths[0]);                
        if(pe == null){   //Error balik neexistuje            
            error = true;            
            return null;
        }
        
        for(int i = 1; i < paths.length; i++) {
            pe = pe.getPackageRelated(paths[i]);            
            if(pe == null){  //Error balik neesixtuje                
                return null; 
            }
        }        
        return getRecursion(pe);
    }
    
    private List<ClassEntity> getRecursion(PackageEntity PE){
        List<ClassEntity> result = Lists.newArrayList( PE.getClassRelated());
        for(PackageEntity pe:PE.getPackageRelated()){
            result.addAll(getRecursion(pe));
        }
        return result;
    }        
    
}
