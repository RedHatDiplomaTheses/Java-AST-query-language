/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.SemanticExecute;

import com.queryToAST.app.Graph.GraphContext.GraphContext;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.QueryLanguage.WalkerContext.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class Stack {
    private List<Command> Stack;
    private int count;
    private GraphContext ctx;
    
    public Stack() {
        count = 0;
        this.Stack = new ArrayList();
    }
    
    
    public void setGraphContext(GraphContext _graphContext) {
        this.ctx = _graphContext;
    }
    
    public void add(KeyCommand name,IContext ctx) {
        Stack.add(new Command(count++, name, ctx));
    }
    
    public List<ClassEntity> run() {
        Interpret exe = new Interpret();
        exe.setContext(ctx);        
        for(Command com:Stack) {
            switch(com.getComand()) {                
                case enterCond:
                    exe.enterCond((CondContext) com.getCtx());
                    break;
                case enterConditions:
                    exe.enterConditions((ConditionsContext) com.getCtx());
                    break;
                case enterEqual:
                    exe.enterEqual((EqualContext) com.getCtx());
                    break;
                case enterInnerSelect:
                    exe.enterInnerSelect((InnerSelectContext) com.getCtx());
                    break;
                case enterPackageLink:
                    exe.enterPackageLink((PackageLinkContext) com.getCtx());
                    break;
                case enterPackageName:
                    exe.enterPackageName((PackageNameContext) com.getCtx());
                    break;
                case enterPackages:
                    exe.enterPackages((PackagesContext) com.getCtx());
                    break;
                case enterParamName:
                    exe.enterParamName((ParamNameContext) com.getCtx());
                    break;
                case enterParamSelect:
                    exe.enterParamSelect((ParamSelectContext) com.getCtx());
                    break;
                case enterRightStatment:
                    exe.enterRightStatment((RightStatmentContext) com.getCtx());
                    break;
                case enterSelectStatment:
                    exe.enterSelectStatment((SelectStatmentContext) com.getCtx());
                    break;
                //----
                //exit
                //----
                case exitAlias:
                    exe.exitAlias((AliasContext) com.getCtx());
                    break;
                case exitAnnotated:
                    exe.exitAnnotated((AnnotatedContext) com.getCtx());
                    break;
                case exitAs:
                    exe.exitAs((AsContext) com.getCtx());
                    break;
                case exitCond:
                    exe.exitCond((CondContext) com.getCtx());
                    break;
                case exitEqual:
                    exe.exitEqual((EqualContext) com.getCtx());
                    break;
                case exitIndex:
                    exe.exitIndex((IndexContext) com.getCtx());
                    break;
                case exitInnerSelect:
                    exe.exitInnerSelect((InnerSelectContext) com.getCtx());
                    break;
                case exitPackageLink:
                    exe.exitPackageLink((PackageLinkContext) com.getCtx());
                    break;
                case exitPackageName:
                    exe.exitPackageName((PackageNameContext) com.getCtx());
                    break;
                case exitPackages:
                    exe.exitPackages((PackagesContext) com.getCtx());
                    break;
                case exitParamName:
                    exe.exitParamName((ParamNameContext) com.getCtx());
                    break;
                case exitSelectStatment:
                    exe.exitSelectStatment((SelectStatmentContext) com.getCtx());
                    break;
                default:
                    System.out.println("Error: Neznámí prikaz vnitøní chyba aplikace -> 'Stack.class'");
                    break;
            }
        }
        if(exe.isError()){
            exe.printErr();
            return null;
        }
        return exe.getResult();
    }
}

// <editor-fold defaultstate="collapsed" desc=" KeyCommand ">
enum KeyCommand {

    enterSelectStatment, exitSelectStatment, enterParamSelect,
    enterParamName, exitParamName, enterPackages, exitPackages, exitPackageName,
    enterConditions, enterCond, exitCond, enterEqual, exitEqual, enterRightStatment,
    exitAlias, exitAs, exitIndex, exitAnnotated, enterInnerSelect, exitInnerSelect,
    exitPackageLink, enterPackageLink, enterPackageName
}

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Command ">
class Command {

    private int count;    
    private KeyCommand comand;
    private IContext ctx;
    
    public Command(int count, KeyCommand comand, IContext ctx) {
        this.count = count;
        this.comand = comand;
        this.ctx = ctx;
    }
    
    public int getCount() {
        return count;
    }
    
    public KeyCommand getComand() {
        return comand;
    }
    
    public IContext getCtx() {
        return ctx;
    }
    
}

// </editor-fold>
