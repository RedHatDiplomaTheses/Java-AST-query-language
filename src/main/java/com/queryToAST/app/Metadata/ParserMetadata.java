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
        return null;
    }
    
    /**
     * Metadat uspoøádá do stromové struktury
     */
    public void findHead() {        
        String pattern = "^((public |private |protected )?class .*)[^\n]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(_input);
        
        Data data = null;  //poradnou inicializaci a ochranu TODO
        
        
        if(m.find()){
            Matcher name = Pattern.compile("class (.*)").matcher(m.group(0));
            name.find();            
            data = new Data(name.group(1), TypFile.CLASS);
            
            Matcher fleg = Pattern.compile("^    Flags: (.*)",Pattern.MULTILINE).matcher(_input);
            fleg.find();
            fleg = Pattern.compile("(PUBLIC|PRIVATE|SUPER|FINAL|PROTECTED)").matcher(fleg.group(1));
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
                }            
            }
        } else {
            System.out.println("Nenalezeno");
        }
        
        _tree = new Tree<Data>(data);
        
        pattern = "^    (?:(public|protected|private) )?(static )?(final )?(\\S.*) (.*)\\((.*)\\)";
        r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        m = r.matcher(_input);
        while(m.find()){
            Data child = new Data(m.group(2) != null ? true : false,
                    m.group(3) != null ? true : false,
                    m.group(5), m.group(6));
            switch (m.group(1)) {
                    case "PUBLIC":
                        child.setTypMod(TypModifier.PUBLIC);
                        break;
                    case "PRIVATE":
                        child.setTypMod(TypModifier.PRIVATE);
                        break;
                    case "PROTECTED":
                        child.setTypMod(TypModifier.PROTECTED);
                        break;
                }
            _tree.addRootChild(child);
        }
    }
}
