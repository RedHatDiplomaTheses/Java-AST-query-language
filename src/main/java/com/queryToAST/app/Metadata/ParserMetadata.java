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
        findHead();
        return _tree;
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
            
            data = new Data(m.group(2), typFile);
            
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
        r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        m = r.matcher(_input);
        while(m.find()){
            
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
