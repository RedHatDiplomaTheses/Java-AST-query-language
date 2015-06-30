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
import com.strobel.assembler.ir.OpCode;
import com.strobel.decompiler.ITextOutput;
import com.strobel.decompiler.PlainTextOutput;

/**
 *
 * @author Niriel
 */
public class GraphContext
{

    private boolean error = false;
    private final Graph graph;
    private final FramedGraph<Graph> framed;

    // TODO: Separate from graphcontext.
    // TODO: Get the "root vertex dynamically".
    private JarEntity _jar;

    // TODO: Change all logging to Java Util Logging.
    private final boolean log = false;


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
        FramedGraphFactory factory = new FramedGraphFactory(new GremlinGroovyModule());
        framed = factory.create(graph);
    }




    private ClassEntity currentClassVertex = null;


    /**
     * Takes Procyon metadata and creates the vertex of the class.
     * @param metadata
     *
     * TODO: Separate to ClassProcessing class!
     */
    public void createClassMetadata(TypeDefinition metadata) {
        if(log)
            printClassMetadata(metadata);

        ClassEntity classEntity = findClass(metadata.getFullName());
        currentClassVertex = classEntity;
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
        if(!(metadata.getBaseType().getFullName().equals("java.lang.Object") ||
                metadata.getBaseType().getFullName().equals("java.lang.Enum")))
        {
                classEntity.addExtendsRelated(findClass(metadata.getBaseType().getFullName()));
                addImport(metadata.getBaseType().getFullName());
        }

        //umisteni v baliku
        processPackage(classEntity);

        //implementace
        for(TypeReference ei:metadata.getExplicitInterfaces()){
            if(ei.getFullName().equals("java.lang.annotation.Annotation"))
                break;
            addImport(ei.getFullName());
            if(metadata.isInterface()) {
                classEntity.addExtendsRelated(findClass(ei.getFullName()));
            }
            else {
                classEntity.addImplementsdRelated(findClass(ei.getFullName()));
            }
        }

        if(metadata.hasAnnotations()){
            for(CustomAnnotation ca:metadata.getAnnotations()){
                processAnnotation(ca,classEntity.addAnnotatedRelated());
            }
        }

        //propperty
        for(FieldDefinition df:metadata.getDeclaredFields()){
            if(log)
            System.out.println("FILED"
                    + "\nName : " + df.getName()
                    + "\nType : " + df.getFieldType().getFullName()
            );
                addImport(df.getFieldType().getFullName());
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
                            processMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                processMethod(m,classEntity.addMethodRelated());
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
                            processMethod(m, meqt);
                        }
                    }
                }
                if(cmp)
                processMethod(m,classEntity.addMethodRelated());
            }
        }else if(metadata.isEnum()){
            classEntity.setType("enum");
        }
    }


    private void printClassMetadata(TypeDefinition metadata)
    {
        System.out.println(
                "Class"
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

    public void printEdge(){
        for(Edge e :graph.getEdges()){
            System.out.println(
                    "\nEDGE"
                    + "\nLabel: " + e.getLabel()
                    + "\n" + e.getVertex(Direction.OUT).getProperty("fqn")
                    + "<-->" + e.getVertex(Direction.IN).getProperty("fqn")
            );
        }
    }

    public void printGraph(){
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
                    for(AnnotationAttributeEntity ap: an.getAnnParaRelated()){
                        System.out.println("\t\t\tAnnParam : " + ap.getName() + " type : " + ap.getType());
                        for(AnnotationAttributeEntity ps : ap.getAnnParaRelated()){
                            System.out.println("\t\t\tAnnParam : " + ps.getFQN() + " type : " + ps.getType() + " value : " + ps.getValue());
                            for( AnnotationAttributeEntity abs:ps.getAnnParaRelated()){
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
                    for(AnnotationAttributeEntity ap: an.getAnnParaRelated())
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
                    for(AnnotationAttributeEntity ap: an.getAnnParaRelated())
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

    private void processAnnotation(CustomAnnotation CA, AnnotatedEntity AE) {
        if(log)
            printCustomAnnotation(CA);
        AE.setName(CA.getAnnotationType().getName());
        AE.setFQN(CA.getAnnotationType().getFullName());
        AE.setType("annotated");
        AE.setDescription(CA.getAnnotationType().getDescription());

        //import
        addImport(AE.getFQN());

        for (AnnotationParameter ap : CA.getParameters()) {
            if(log)
                System.out.println(
                    "@P"
                    + "\nMember : " + ap.getMember());
            AnnotationAttributeEntity ape = AE.addAnnParaRelated();
            ape.setName(ap.getMember());
            ape.setType(ap.getValue().getElementType().name());

            switch(ap.getValue().getElementType()){
                case Annotation:
                    processAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue(), ape);
                    break;
                case Array:
                    processArrayAnnotationElement((ArrayAnnotationElement)ap.getValue(), ape);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue(), ape);
                    break;
                case Class:
                    processClassAnnotationElement((ClassAnnotationElement)ap.getValue(), ape);
                    break;
                case Enum:
                    processEnumAnnotationElement((EnumAnnotationElement)ap.getValue(), ape);
                    break;
            }
        }
    }


    private void printCustomAnnotation(CustomAnnotation CA)
    {
        System.out.println(
            "@"
                + "\nDescription : " + CA.getAnnotationType().getDescription()
                + "\nBriefDescription : " + CA.getAnnotationType().getBriefDescription()
                + "\nName : " + CA.getAnnotationType().getName()
                + "\nPackage : " + CA.getAnnotationType().getPackageName()
                + "\nFullName : " + CA.getAnnotationType().getFullName()
        );
    }

    private void processMethod(MethodDefinition methodDef,MethodEntity methodEntity) {
            if(log)
            System.out.println(
                    "M"
                    + "\nName : " + methodDef.getName()
                    + "\nBriefDescription : " + methodDef.getBriefDescription()
                    + "\nDescription : " + methodDef.getDescription()
                    + "\nErasedDescription : " + methodDef.getErasedDescription()
                    + "\nErasedSignature : " + methodDef.getErasedSignature()
                    + "\nFullName : " + methodDef.getFullName()
                    + "\nSignature : " + methodDef.getSignature()
                    + "\nSimpleDescription : " + methodDef.getSimpleDescription()
                    + "\nReturnType : " + methodDef.getReturnType().getFullName()
            );
            methodEntity.setBriefDescription(methodDef.getBriefDescription());
            methodEntity.setName(methodDef.getName());
            methodEntity.setType("method");
            methodEntity.setFQN(methodDef.getFullName());
            methodEntity.setDescription(methodDef.getDescription());
            methodEntity.setNotDecompile(false);
            methodEntity.setPrivate(methodDef.isPrivate());
            methodEntity.setPublic(methodDef.isPublic());
            methodEntity.setProtected(methodDef.isProtected());
            methodEntity.setFinal(methodDef.isFinal());
            methodEntity.setStatic(methodDef.isStatic());
            //Import
            // TODO: Use getReturnType().isPrimitive(), isArray, getUnderlyingType()
            // TODO: get rid of getType()
            addImport(getType(methodDef.getReturnType().getFullName().replaceAll("\\[|\\]", "")));

            if(methodDef.hasAnnotations()){
                for(CustomAnnotation ca:methodDef.getAnnotations())
                    processAnnotation(ca,methodEntity.addAnnotatedRelated());
            }

            //parametrs
            int count = 0;
            for(ParameterDefinition pd:methodDef.getParameters()){
                if(log)
                System.out.println(
                        "MP"
                        + "\nname : " + pd.getName()
                        + "\ntype : " + pd.getParameterType().getName()
                        + "\nfullName : " + pd.getParameterType().getFullName()
                        + "\ndeclarName :" + pd.getDeclaringType().getName()
                        + "\ndeclarFullName :" + pd.getDeclaringType().getFullName()
                );

                MethParaEntity mpe = methodEntity.addMethParaRelated();
                mpe.setType("parametr");
                mpe.setName(pd.getName());
                mpe.setFQN(pd.getParameterType().getFullName());
                mpe.setIndex(count);

                //import
                addImport(pd.getParameterType().getFullName());

                if(pd.hasAnnotations()){
                    for(CustomAnnotation ca:pd.getAnnotations())
                        processAnnotation(ca, mpe.addAnnotatedRelated());
                }
                count++;
            }
            methodEntity.setParamCount(count);

            //Body
            if(log)
                System.out.println("\nMB-CODE");

            if(methodDef.getBody() == null)
                return;

            for (Instruction instruction: methodDef.getBody().getInstructions()) {
                if(log)
                    System.out.println(
                        "\nString : " + instruction.toString()
                        + "\nLable : " + (instruction.hasLabel() ? instruction.getLabel().getIndex() : "false")
                        + "\nOffset : " + instruction.hasOffset()
                        + "\nOperand : " + instruction.hasOperand()
                        + "\nCode : " + instruction.hashCode()
                        + "\nGetOpCode : " + instruction.getOpCode()
                );
                if(log)
                for(int i = 0; i < instruction.getOperandCount(); i++)
                {
                    System.out.println("Operand : " + instruction.getOperand(i));
                }

                // TODO: Replace this parsing with calls to the instruction data.
                // OpCode x = instruction.getOpCode();
                // switch( x ) { case INVOKESTATIC: ... break; ... }
                if(instruction.toString().contains("INVOKE"))
                {
                    if(instruction.toString().contains("STATIC"))
                    {
                        processMethodCall(instruction.toString(), methodEntity, true);
                    }
                    else if(instruction.toString().contains("INTERFACE"))
                    {
                        processMethodCall(instruction.toString(), methodEntity, false);
                    }
                    else if(instruction.toString().contains("VIRTUAL"))
                    {
                        processMethodCall(instruction.toString(), methodEntity, false);
                    }
                    else if(instruction.toString().contains("DYNAMIC"))
                    {
                        processMethodCall(instruction.toString(), methodEntity, false);
                    }
                    else if(instruction.toString().contains("SPECIAL"))
                    {
                        processMethodCall(instruction.toString(), methodEntity, false);     //TODO mozna zakomentovat
                    }
                }

            }
    }

    private void processAnnotationAnnotationElement(AnnotationAnnotationElement annotationAnnotationElement, AnnotationAttributeEntity APE) {
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
        addImport(annotationAnnotationElement.getAnnotation().getAnnotationType().getFullName());

        for(AnnotationParameter ap : annotationAnnotationElement.getAnnotation().getParameters()){
            if(log)
            System.out.println(
                        "@@P"
                        + "\nMember : " + ap.getMember());
            AnnotationAttributeEntity ape = APE.addAnnParaRelated();
            ape.setName(ap.getMember());
            ape.setType(ap.getValue().getElementType().name());
            switch(ap.getValue().getElementType()){
                case Annotation:
                    processAnnotationAnnotationElement((AnnotationAnnotationElement)ap.getValue(), ape);
                    break;
                case Array:
                    processArrayAnnotationElement((ArrayAnnotationElement)ap.getValue(), ape);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ap.getValue(), ape);
                    break;
                case Class:
                    processClassAnnotationElement((ClassAnnotationElement)ap.getValue(),ape);
                    break;
                case Enum:
                    processEnumAnnotationElement((EnumAnnotationElement)ap.getValue(),ape);
                    break;
            }
        }
    }

    private void processArrayAnnotationElement(ArrayAnnotationElement arrayAnnotationElement, AnnotationAttributeEntity APE) {
        int i=0;
        for(AnnotationElement ae : arrayAnnotationElement.getElements()){
            AnnotationAttributeEntity ape = APE.addAnnParaRelated();
            ape.setType(ae.getElementType().name());
            ape.setIndex(i);
            i++;
            switch(ae.getElementType()){
                case Annotation:
                    processAnnotationAnnotationElement((AnnotationAnnotationElement)ae,ape);
                    break;
                case Array:
                    processArrayAnnotationElement((ArrayAnnotationElement)ae,ape);
                    break;
                case Constant:
                    setConstantAnnotationElement((ConstantAnnotationElement)ae,ape);
                    break;
                case Class:
                    processClassAnnotationElement((ClassAnnotationElement)ae,ape);
                    break;
                case Enum:
                    processEnumAnnotationElement((EnumAnnotationElement)ae,ape);
                    break;
            }
        }
    }

    private void setConstantAnnotationElement(ConstantAnnotationElement constantAnnotationElement, AnnotationAttributeEntity APE) {
        if(log)
        System.out.println(
                "ConstantAnnotationElement"
                + "\nValue : " + constantAnnotationElement.getConstantValue()
        );

            APE.setValue((String) constantAnnotationElement.getConstantValue());
    }

    private void processClassAnnotationElement(ClassAnnotationElement classAnnotationElement,AnnotationAttributeEntity APE) {
        if(log)
        System.out.println(
                "ClassAnnotationElement"
                + "" + classAnnotationElement.getClassType().getName()
                + "" + classAnnotationElement.getClassType().getFullName()
        );

        APE.setValue(classAnnotationElement.getClassType().getName());
    }

    private void processEnumAnnotationElement(EnumAnnotationElement enumAnnotationElement,AnnotationAttributeEntity APE) {

        APE.setValue(enumAnnotationElement.getEnumConstantName());
        APE.setDescription(enumAnnotationElement.getEnumType().getFullName());
        addImport(enumAnnotationElement.getEnumType().getFullName());
        if(log)
        System.out.println(
            "\nEnumValue"
            + "\nEnumConstantName : " + enumAnnotationElement.getEnumConstantName()
            + "\nEnumTyp : " + enumAnnotationElement.getEnumType().getFullName()
        );
    }

    // TODO: Replace string with some other data transfering.
    private void processMethodCall(String instruction, MethodEntity ME, boolean isStatic) {
        if(log)
        System.out.println("\nfull : " +instruction.replaceAll(".*INVOKE[A-Z]* ","")
                + "\nClass : " + instruction.replaceAll(".*INVOKE[A-Z]* ","").replaceAll("\\..*", "")
                 + "\nMethod : " + instruction.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "")
                + "\nParametrs : " + instruction.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "")
                + "\nReturn : " + instruction.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(".*\\)", "")
                + "\nFQN : " + instruction.replaceAll(".*INVOKE[A-Z]* ","").replaceAll(":\\(.*", "")
                );
        String full = instruction.replaceAll(".*INVOKE[A-Z]+ ","");
        String clazz = instruction.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll("\\..*", "");
        String method = instruction.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*\\.", "").replaceAll(":\\(.*", "");
        String param = instruction.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*:\\(", "").replaceAll("\\).*", "");
        String return_ =instruction.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(".*\\)", "").replaceAll("/", ".");
        String fqName = instruction.replaceAll(".*INVOKE[A-Z]+ ","").replaceAll(":\\(.*", "");

        List<String> result = convertType(param);
        List<String> ret = convertType(return_);

        String Brief = (ret.isEmpty() ? "void" : ret.get(ret.size()-1))
                + " " + method + "(" +
                (result.isEmpty()?"":result.toString()).replaceAll("(^\\[)|(\\]$)", "").replaceAll("/", ".")
                + ")" ;

        addImport(clazz.replaceAll("/", "."));
        if(fqName.compareTo("java/lang/Object.<init>") == 0){
            return;
        }
        if(ME.getCallRelated(fqName) != null){
            return;
        }
        for(Vertex v :graph.getVertices()){
            if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(fqName) == 0){
                MethodEntity meqt = framed.frame(v, MethodEntity.class);
                if(meqt.getBriefDescription().compareTo(Brief) == 0){
                    ME.addCallRelated(meqt);
                    return;
                }
            }
        }
        MethodEntity me =  (MethodEntity) framed.frame(graph.addVertex(null), MethodEntity.class);
        me.setName(method);
        me.setType("method");
        me.setBriefDescription(Brief);
        me.setFQN(fqName);
        me.setNotDecompile(true);
        ME.addCallRelated(me);

    }


    // TODO: Use API, get rid of this parsing method.
    //       Get the list of strings from the API.
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

    private ClassEntity findClass(String fullName) { //predelat k urychleni
        for(Vertex v : graph.getVertices()){
            if(v.getProperty("fqn") != null && v.getProperty("fqn").toString().compareTo(fullName) == 0){
            return framed.frame(v, ClassEntity.class);
            }
        }
        ClassEntity ce = framed.frame(graph.addVertex(null), ClassEntity.class);
        ce.setName("Unknown");
        ce.setFQN(fullName);
        ce.setNotDecompile(true);
        return ce;
    }

    private void processPackage(ClassEntity CE) {
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

    private void addImport(String fullName) {
        if(fullName == null)
            return;
        fullName = fullName.replaceAll("[\\[\\]]", "");
        if( fullName.compareTo("") == 0 || !fullName.contains(".")
                || fullName.compareTo("java.lang.String") == 0
                || fullName.compareTo("java.lang.Object") == 0
                || fullName.compareTo("java.lang.UnsupportedOperationException") == 0){
            return;
        }
        if(currentClassVertex.getFQN().replaceFirst("\\.\\w*$", "").compareTo(fullName.replaceFirst("\\.\\w*$", "")) == 0){
            return;
        }
        if(currentClassVertex.getImportRelated(fullName) == null){
            currentClassVertex.addImportRelated(findClass(fullName));

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
    *   Θαst volana queryExecute
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
