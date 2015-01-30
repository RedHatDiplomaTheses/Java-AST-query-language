/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Metadata;

import com.queryToAST.app.Core.Data;
import com.queryToAST.app.Core.Tree;
import com.queryToAST.app.Core.TypFile;
import com.queryToAST.app.Core.TypModifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Niriel
 */
public class ParserMetadata {
    private Tree _tree;
    private String _input;
    
    
    
    ParserMetadata() {        
    }

    
    
    public Tree ParserMetadata(String input) {        
        _input = input;
        Parser();
        return _tree;
    }

    
    
    private void Parser() {
        Data data = null;
        String patLine = ".*\n";
        Pattern rLine = Pattern.compile(patLine, Pattern.MULTILINE);
        Matcher mLine = rLine.matcher(_input);
        
        //A (Class)
        mLine.find();
//        System.out.println("=====================");
//        System.out.println(mLine.group(0).replace("\n", ""));
//        System.out.println("=====================");
        String patClass = "^(class|@interface|enum|interface) ([^\n]*)";
        Pattern rClass = Pattern.compile(patClass);
        Matcher mClass = rClass.matcher(mLine.group(0));
        TypFile typFile;
        if(mClass.find()){           
            switch(mClass.group(1)) {                
                case "@interface":  //Annotation
                    typFile = TypFile.ANNOTATION;
                    break;
                case "enum":
                    typFile = TypFile.ENUMERATION;
                    break;
                case "interface":
                    typFile = TypFile.INTERFACE;
                    break;
                case "class":
                    typFile = TypFile.CLASS;
                    break;
                default:
                    typFile = TypFile.NONE;
                    break;
            }
        } else {
            return; //Interni Error
        }
        data = new Data(mClass.group(2).toString().replace('.', '/'), typFile);
        //System.out.println(mClass.group(0));        
        
        //B (Minor version)
        mLine.find();
        //System.out.println(mLine.group(0));
        
        //C (Major version)
        mLine.find();
        //System.out.println(mLine.group(0));
        
        //D (Flags)        
        mLine.find();
        Matcher fleg = Pattern.compile("^    Flags: (.*)").matcher(mLine.group(0));
        fleg.find();
        fleg = Pattern.compile("(PUBLIC|PRIVATE|SUPER|FINAL|PROTECTED|ABSTRACT|INTERFACE)").matcher(fleg.group(1));
        while(fleg.find()){
            switch (fleg.group(0)) {
                case "PUBLIC":
                    data.setTypMod(TypModifier.PUBLIC);
                    break;
                case "PRIVATE":
                    data.setTypMod(TypModifier.PRIVATE);
                    break;
                case "SUPER":
                    data.setIsSuper(true);
                    break;
                case "FINAL":
                    data.setIsFinal(true);
                    break;
                case "PROTECTED":
                    data.setTypMod(TypModifier.PROTECTED);
                    break;                    
                case "ABSTRACT":
                    data.setIsabstract(true);
                    break;
            }            
        }
        //System.out.println(mLine.group(0));
        
        //E2(Signature)
        mLine.find();
        String patSigna =".*Signature:.*";
        Pattern rSigna = Pattern.compile(patSigna);
        Matcher mSigna = rSigna.matcher(mLine.group(0));
        if(mSigna.find()) {
            //System.out.println(mSigna.group(0));
            mLine.find();
        }
        //E1 (SourceFile)
        //System.out.println(mLine.group(0));
        
        //F3 (EnclosingType)
        mLine.find();
        String patEncType =".*EnclosingType:.*";
        Pattern rEncType = Pattern.compile(patEncType);
        Matcher mEncType = rEncType.matcher(mLine.group(0));
        if(mEncType.find()) {
            //System.out.println(mEncType.group(0));
            
            //G3 (EnclosingMethod)
            mLine.find();
            //System.out.println(mLine.group(0));                        
            mLine.find();
        }
        
        //F2 (InnerClasses)
        String patInn =".*InnerClasses.*";
        Pattern rInn = Pattern.compile(patInn);
        Matcher mInn = rInn.matcher(mLine.group(0));
        if(mInn.find()) {
            //System.out.println(mLine.group(0));
            
            //G2 (InnerClasses: 1-?)
            while(mLine.find()){
                String patSigna2 =".*Signature.*";
                Pattern rSigna2 = Pattern.compile(patSigna2);
                Matcher mSigna2 = rSigna2.matcher(mLine.group(0));
                if(mSigna2.find()) {
                    break;
                }
                //System.out.println(mLine.group(0));
            }
            //H2 (Signature)
            //System.out.println(mLine.group(0));
            mLine.find();
        }
        
        //F1 (Constant Pool)
        //System.out.println(mLine.group(0));
        
        //G (Constant Pool 1-?)
        while(mLine.find()) {
            String patConPo ="^[ \t\n\\x0b\r\f]*$";
            Pattern rConPo = Pattern.compile(patConPo);
            Matcher mConPo = rConPo.matcher(mLine.group(0));
            if(mConPo.find()) {                
                break;
            }
            
            String pat = "//  " + data.getName() + "$";
            Pattern r = Pattern.compile(pat);
            Matcher m = r.matcher(mLine.group(0));
            
            if(m.find()){
                mLine.find();
                Matcher mExtImp = Pattern.compile("//  ([^><:\\(\\)\n]*)$").matcher(mLine.group(0));
                
                
                //Extend
                if(mExtImp.find() && mExtImp.group(1).toString().compareTo("java/lang/Object") != 0){
                    //System.out.println("Extend:" + mExtImp.group(1));
                    data.setExtends(mExtImp.group(1)); //extend
                }

                
                //Implement
                while(mLine.find()){
                    //System.out.println(mLine.group(0));
                    mExtImp = Pattern.compile("//  ([^><:\\(\\)\n]*)$").matcher(mLine.group(0));
                    if(mExtImp.find()){ //implement
                        //System.out.println("Implement:" + mExtImp.group(1));
                        data.setImplements(mExtImp.group(1));
                    }else{
                        break;
                    }
                }
            }
            
            //G2 Anotation
            Matcher mAnno = Pattern.compile("\"Runtime(Invisible|Visible)Annotations\"$").matcher(mLine.group(0));
            if(mAnno.find() && data.getTypFile() != TypFile.ANNOTATION){
                mLine.find();
                Matcher mAnn = Pattern.compile("\"L([\\w\\d-_/]+);\"$").matcher(mLine.group(0));

                if(mAnn.find()){
                    //Jmeno anotace
                    //System.out.println("Anotace: " + mAnn.group(1).replaceAll("[^/]*/", ""));
                    data.addAnnotated(mAnn.group(1).replaceAll("[^/]*/", ""), null,null);
                    while(mLine.find()){
                        Matcher mAn = Pattern.compile("\"(.+)\"$").matcher(mLine.group(0));
                        if(mAn.find()){
                            //Nazev Argumentu Anotace
                            String AName = mAn.group(1);
                            //System.out.println(mAn.group(1));
                            if(mAn.find()){
                                //Hodnota Anotace                                
                                data.addAnnotated(mAnn.group(1).replaceAll("[^/]*/", ""), AName, mAn.group(1));
                            }
                            else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
            
            //G3 Import            
            Matcher mImp = Pattern.compile("\"L([\\w\\d-_/]+);\"$").matcher(mLine.group(0));
            if(mImp.find()){
                if(data.getName().compareTo(mImp.group(1))!= 0){
                    data.addImport(mImp.group(1));
                    //System.out.println(mImp.group(1));
                }
            }
                    
            //System.out.println(mLine.group(0));
        }
        
        //H (\s\n)
        //System.out.println(mLine.group(0));
        
        //Zapis tøídy do stromu
        _tree = new Tree<Data>(data);
        
        while(mLine.find()) {
            Matcher mClass2 = rClass.matcher(mLine.group(0));
            if(mClass2.find()) {
                break;
            }
            //System.out.println(mLine.group(0));
            
            //I1 (Property)
            String patProp = "^    (?:(public|protected|private) )?(static )?(final )?([^ \\s\\{\\}\\[\\]]*) [^ $\\{\\}\\(\\);]*;";
            Pattern rProp = Pattern.compile(patProp);
            Matcher mProp = rProp.matcher(mLine.group(0));
            if(mProp.find()) {
                //System.out.println(mLine.group(0));
                
                //J1 (Flags)
                mLine.find();
                //System.out.println(mLine.group(0));
            }
            
            //I2 (Method)
            String patMeth = "^    (?:(public|protected|private) )?(static )?(final )?(?:abstract )?(\\S.*) ((?:[^<>]*)|(?:<init>))\\((.*)\\);$";
            Pattern rMeth = Pattern.compile(patMeth);
            Matcher mMeth = rMeth.matcher(mLine.group(0));
            if(mMeth.find()) {
                //System.out.println(mMeth.group(5));
                Data child = new Data(mMeth.group(2) != null ? true : false,
                            mMeth.group(3) != null ? true : false,
                            mMeth.group(4), mMeth.group(5));
                child.setTypFile(TypFile.METODA);
                if(mMeth.group(1) != null){
                    switch (mMeth.group(1)) {
                        case "public":
                            child.setTypMod(TypModifier.PUBLIC);
                            break;
                        case "private":
                            child.setTypMod(TypModifier.PRIVATE);
                            break;
                        case "protected":
                            child.setTypMod(TypModifier.PROTECTED);
                            break;
                    }
                }
                if(mMeth.group(6).toString().compareTo("") != 0){
                    //System.out.println("Parametry: " + mMeth.group(6));
                    Matcher mTMP= Pattern.compile("(, )?([^, ]*) ([^, ]*)").matcher(mMeth.group(6));
                    while(mTMP.find()){
                        //System.out.println("Typ: " + mTMP.group(2) + ", Name: " + mTMP.group(3));
                        data.addArg(mTMP.group(2), mTMP.group(3));
                    }
                }
                //System.out.println("Method: " + mLine.group(0));
                
                //J2 (Flags)
                mLine.find();
                //System.out.println(mLine.group(0));
                
                //K2 (Code)
                if(!mLine.find()) {
                    _tree.addRootChild(child);
                    break;
                }
                String patCode ="^[ \t\n\\x0b\r\f]*$";
                Pattern rCode = Pattern.compile(patCode);
                Matcher mCode = rCode.matcher(mLine.group(0));
                if(mCode.find()) {
                    _tree.addRootChild(child);
                    continue;
                }
                //System.out.println(mLine.group(0));
                
                //L2 (Stack, Local, Argument)
                mLine.find();
                //System.out.println(mLine.group(0));
                
                //M2 (LineNumber)
                mLine.find();
                String patNum =".*linenumber.*";
                Pattern rNum = Pattern.compile(patNum);
                Matcher mNum = rNum.matcher(mLine.group(0));                
                //System.out.println(mLine.group(0));

                //N2 (Statement)        
                while(mLine.find()){
                    Matcher mm = Pattern.compile(".*LocalVariableTable:.*").matcher(mLine.group(0));
                    if(mm.find()){
                        break;
                    }
                    Matcher mVirt = Pattern.compile("^\\s*\\d+: invokevirtual *([^\\[\\]\\s]*)$").matcher(mLine.group(0));
                    if(mVirt.find()) {
                        //System.out.println(mVirt.group(1));
                        boolean isExist = false;
                        if(child.getCallMethod() != null)
                            for(String tmp: child.getCallMethod()){
                                if(tmp.compareTo(mVirt.group(1)) == 0) {
                                    isExist = true;
                                }
                            }
                        if(!isExist){
                            child.setCallMethod(mVirt.group(1));
                            //System.out.println(mVirt.group(1));
                        }
                    }
                }                
                //System.out.println(mLine.group(0));
                
                //Zapis Method z tøidy do stromu
                _tree.addRootChild(child);
                
                //O2 (LocalVariableTable)
                //System.out.println(mLine.group(0));
                mLine.find(); //-----  ------  ----  ---- 
                
                //P2 (Start  Length  Slot  Name  Signature)
                mLine.find();
                //System.out.println(mLine.group(0));
                
                //Q2 (LocalVariableTable 1-?)
                while(mLine.find()) {                    
                    String patSLS ="^[ \t\n\\x0b\r\f]*$";
                    Pattern rSLS = Pattern.compile(patSLS);
                    Matcher mSLS = rSLS.matcher(mLine.group(0));
                    if(mSLS.find()) {
                        break;
                    }
                    //System.out.println(mLine.group(0));
                }
            }
        }
    }
    
    
      
    /**
     * Metadat uspoøádá do stromové struktury
     */
    public void findHead() {        
        String pattern = "^(class|@interface|enum|interface) ([^\n]*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(_input);
        
        Data data = null;  //poradnou inicializaci a ochranu TODO
                
        if(m.find()){
            TypFile typFile;
            switch(m.group(1)) {                
                case "@interface":  //Annotation
                    typFile = TypFile.ANNOTATION;
                    break;
                case "enum":
                    typFile = TypFile.ENUMERATION;
                    break;
                case "interface":
                    typFile = TypFile.INTERFACE;
                    break;
                case "class":
                    typFile = TypFile.CLASS;
                    break;
                default:
                    typFile = TypFile.NONE;
                    break;
            }
            
            data = new Data(m.group(2), typFile);//m.group(2).replaceAll("[^\\.]*\\.", "")
            
            Matcher fleg = Pattern.compile("^    Flags: (.*)",Pattern.MULTILINE).matcher(_input);
            fleg.find();
            fleg = Pattern.compile("(PUBLIC|PRIVATE|SUPER|FINAL|PROTECTED|ABSTRACT|INTERFACE)").matcher(fleg.group(1));
            while(fleg.find()){
                switch (fleg.group(0)) {
                    case "PUBLIC":
                        data.setTypMod(TypModifier.PUBLIC);
                        break;
                    case "PRIVATE":
                        data.setTypMod(TypModifier.PRIVATE);
                        break;
                    case "SUPER":
                        data.setIsSuper(true);
                        break;
                    case "FINAL":
                        data.setIsFinal(true);
                        break;
                    case "PROTECTED":
                        data.setTypMod(TypModifier.PROTECTED);
                        break;                    
                    case "ABSTRACT":
                        data.setIsabstract(true);
                        break;
                }            
            }
        } else {
            System.out.println("Nepodarilo se rozparsovat Parser Metadata");
        }
         
        pattern = "//  " + data.getName() + "\n[^\n]*//  ([^\n]*)\n((?:[^\n]*//  (?:[^\n]*)\n)*)";
        r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        m = r.matcher(_input);
        
        // find extends and implements
        if(m.find()){
            data.setExtends(m.group(1));
            if(m.group(2) != null){
                pattern = "//  ([^\n]*)";
                r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
                m = r.matcher(m.group(2));
                
                //implements
                while(m.find()){
                    data.setImplements(m.group(1));
                }                
            }
        }
        
        _tree = new Tree<Data>(data);                
        pattern = "^    (?:(public|protected|private) )?(static )?(final )?(\\S.*) (.*)\\((.*)\\)";
        //pattern = "^    (?:(public|protected|private) )?(static )?(final )?(\\S.*) (.*)\\((.*)\\);((.*\n)*).*LocalVariableTable:\n";
        r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        m = r.matcher(_input);
        while(m.find()){
           // System.out.println("\n -=====- \n" + m.group(7) + "\n -=============-");
            Data child = new Data(m.group(2) != null ? true : false,
                    m.group(3) != null ? true : false,
                    m.group(4), m.group(5));            
            child.setTypFile(TypFile.METODA);
            
            if(m.group(1) != null)
                switch (m.group(1)) {
                        case "public":
                            child.setTypMod(TypModifier.PUBLIC);
                            break;
                        case "private":
                            child.setTypMod(TypModifier.PRIVATE);
                            break;
                        case "protected":
                            child.setTypMod(TypModifier.PROTECTED);
                            break;
                    }
            _tree.addRootChild(child);
        }
    }
    
    
    
}
