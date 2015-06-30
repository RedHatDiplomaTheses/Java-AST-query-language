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


    // Separate from the Stack into StackRunner - only have the data in the stack.
    public List<ClassEntity> run() {
        Interpret interpret = new Interpret();
        interpret.setContext(ctx);
        for(Command com:Stack) {
            switch(com.getComand()) {
                case enterCond:
                    interpret.enterCond((CondContext) com.getCtx());
                    break;
                case enterConditions:
                    interpret.enterConditions((ConditionsContext) com.getCtx());
                    break;
                case enterEqual:
                    interpret.enterEqual((EqualContext) com.getCtx());
                    break;
                case enterInnerSelect:
                    interpret.enterInnerSelect((InnerSelectContext) com.getCtx());
                    break;
                case enterPackageLink:
                    interpret.enterPackageLink((PackageLinkContext) com.getCtx());
                    break;
                case enterPackageName:
                    interpret.enterPackageName((PackageNameContext) com.getCtx());
                    break;
                case enterPackages:
                    interpret.enterPackages((PackagesContext) com.getCtx());
                    break;
                case enterParamName:
                    interpret.enterParamName((ParamNameContext) com.getCtx());
                    break;
                case enterParamSelect:
                    interpret.enterParamSelect((ParamSelectContext) com.getCtx());
                    break;
                case enterRightStatment:
                    interpret.enterRightStatment((RightStatmentContext) com.getCtx());
                    break;
                case enterSelectStatment:
                    interpret.enterSelectStatment((SelectStatmentContext) com.getCtx());
                    break;
                //----
                //exit
                //----
                case exitAlias:
                    interpret.exitAlias((AliasContext) com.getCtx());
                    break;
                case exitAnnotated:
                    interpret.exitAnnotated((AnnotatedContext) com.getCtx());
                    break;
                case exitAs:
                    interpret.exitAs((AsContext) com.getCtx());
                    break;
                case exitCond:
                    interpret.exitCond((CondContext) com.getCtx());
                    break;
                case exitEqual:
                    interpret.exitEqual((EqualContext) com.getCtx());
                    break;
                case exitIndex:
                    interpret.exitIndex((IndexContext) com.getCtx());
                    break;
                case exitInnerSelect:
                    interpret.exitInnerSelect((InnerSelectContext) com.getCtx());
                    break;
                case exitPackageLink:
                    interpret.exitPackageLink((PackageLinkContext) com.getCtx());
                    break;
                case exitPackageName:
                    interpret.exitPackageName((PackageNameContext) com.getCtx());
                    break;
                case exitPackages:
                    interpret.exitPackages((PackagesContext) com.getCtx());
                    break;
                case exitParamName:
                    interpret.exitParamName((ParamNameContext) com.getCtx());
                    break;
                case exitSelectStatment:
                    interpret.exitSelectStatment((SelectStatmentContext) com.getCtx());
                    break;
                default:
                    System.out.println("Error: Neznámý prikaz vnitøní chyba aplikace -> 'Stack.class'");
                    break;
            }
        }
        if(interpret.isError()){
            interpret.printErr();
            return null;
        }
        return interpret.getResult();
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
