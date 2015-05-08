/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.SemanticExecute;

import com.queryToAST.app.QueryLanguage.LexerParser.queryBaseListener;
import com.queryToAST.app.QueryLanguage.LexerParser.queryParser;
import com.queryToAST.app.QueryLanguage.WalkerContext.*;
import com.queryToAST.app.QueryLanguage.WalkerContext.CondContext;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.ErrorNode;

/**
 *
 * @author Niriel
 */
public class SemanticGenerator extends queryBaseListener{
    private Stack stack = new Stack();
    private boolean _error = false;
    private List<ErrorMessage> _errMsg = new ArrayList();
    
    public Stack getStack() {
        return this.stack;
    }
    
    public boolean isError() {
        return this._error;
    }
    
    public void PrintErr(){
        for (ErrorMessage em : _errMsg) {
            System.out.println(em);
        }
    }
    
    @Override
    public void visitErrorNode(ErrorNode node) {
        _error =true;
        _errMsg.add(new ErrorMessage("Chyba v lexikální alalýze nebo v gramatice.", _error));
    }        
    
    // <editor-fold defaultstate="collapsed" desc=" InnerSelect ">    
    @Override
    public void exitInnerSelect(queryParser.InnerSelectContext ctx) {        
        stack.add(KeyCommand.exitInnerSelect, new InnerSelectContext());
    }
        
    @Override
    public void enterInnerSelect(queryParser.InnerSelectContext ctx) {
       stack.add(KeyCommand.enterInnerSelect, new InnerSelectContext());
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Annotated ">    
    @Override
    public void exitAnnotated(queryParser.AnnotatedContext ctx) {
        AnnotatedContext actx = new AnnotatedContext();
        if (ctx.method() != null){
            MethodContext method = new MethodContext();
            if(ctx.method().getChildCount()==1) {
                method.STAR(ctx.method().STAR() != null);
                if(ctx.method().STAR() == null) {
                    method.Description(ctx.method().STRING() != null ? ctx.method().STRING().get(0).getText().replaceAll("[' ]", "") : null );
                }
            }
            else {
                for(int i =0; i < ctx.method().NAME().size() ; i++) {
                    method.Arg(
                            ctx.method().NAME(i).getText(),
                            ctx.method().STRING(i).getText().replace("'", "")
                    );
                }                
            }
            actx.setMethod(method);
        }
        if (ctx.index() != null) {
            IndexContext ictx = new IndexContext();
            if(ctx.index().STAR() != null) {
                ictx.setSTAR(true);
            }
            else {
                ictx.setINDEX(Integer.parseInt(ctx.index().INT().getText()));
            }
            actx.setIndex(ictx);
        }
        if (ctx.annotatedStatment() != null) {
            AnnotatedStatmentContext asctx = new AnnotatedStatmentContext();
            asctx.setAT_NAME(ctx.annotatedStatment().AT_NAME().getText().replace("@", ""));
            for (queryParser.AnnotatedParamsContext anp:ctx.annotatedStatment().annotatedParams()) {
                AnnotatedParamsContext apctx = new AnnotatedParamsContext();
                if (anp.AT_NAME() != null) {
                    apctx.setAT_NAME(anp.AT_NAME().getText().replace("@", ""));
                }
                else if (anp.DOT_NAME() != null) {
                    apctx.setName(anp.DOT_NAME().getText().replace(".", ""));
                    if (anp.index() != null ) {
                       IndexContext ictx = new IndexContext();
                        if(anp.index().STAR() != null) {
                            ictx.setSTAR(true);
                        }
                        else {
                            ictx.setINDEX(Integer.parseInt(anp.index().INT().getText()));
                        }
                        apctx.setIndex(ictx);
                        
                   }
                }
                asctx.setApctx(apctx);
            }
            actx.setAsctx(asctx);
        }        
        stack.add(KeyCommand.exitAnnotated, actx);
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" as, INDEX and alias ">
    @Override
    public void exitIndex(queryParser.IndexContext ctx) {
        IndexContext ictx = new IndexContext();
        if(ctx.STAR() != null) {
            ictx.setSTAR(true);
        }
        else {
            ictx.setINDEX(Integer.parseInt(ctx.INT().getText()));
        }
        stack.add(KeyCommand.exitIndex, ictx);
    }
    
    public void exitAs(queryParser.AsContext ctx) {
        AsContext actx = new AsContext();
        actx.setNAME(ctx.NAME().getText());
        stack.add(KeyCommand.exitAs, actx);        
    }

    public void exitAlias(queryParser.AliasContext ctx) {        
        AliasContext actx = new AliasContext();
        actx.setNAME(ctx.NAME_DOT().getText().replace(".", ""));
        stack.add(KeyCommand.exitAlias, actx);
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" RightStatment ">    
    @Override
    public void enterRightStatment(queryParser.RightStatmentContext ctx) {
        stack.add(KeyCommand.enterRightStatment, new RightStatmentContext());
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Equal ">    
    @Override
    public void exitEqual(queryParser.EqualContext ctx) {
        EqualContext ectx = new EqualContext();        
        
        if (ctx.alias() != null) {
            ectx.setAlias(ctx.alias().NAME_DOT().getText().replace(".", ""));
        }                
        if (ctx.NAME() != null) {
            ectx.setNAME(ctx.NAME().getText());
        }
        if (ctx.OPERATORS() != null) {
            switch(ctx.OPERATORS().getText()) {
                case "=" :
                    ectx.setOPERATORS(Operators.EQUAL);
                    break;
                case "!=" :
                    ectx.setOPERATORS(Operators.NOT_EQUAL);
                    break;
                case "~" :
                    ectx.setOPERATORS(Operators.SIMILAR);
                    break;
                case "in" :
                    _errMsg.add(new ErrorMessage("Tento operátor není povolen:" + ctx.OPERATORS().getText(), true));
                    _error = true;
                    ectx.setOPERATORS(Operators.IN);
                    break;
            }
        }
        if (ctx.rightStatment() != null) {
            RightStatmentContext rsctx = new RightStatmentContext();
            if (ctx.rightStatment().alias() != null) {
                rsctx.setAlias(ctx.rightStatment().alias().NAME_DOT().getText().replace(".", ""));
            }
            if (ctx.rightStatment().NAME() != null) {
                rsctx.setNAME(ctx.rightStatment().NAME().getText());
            }
            if (ctx.rightStatment().annotated() != null) {
                rsctx.setAnnotated(true);
            }
            if(ctx.rightStatment().STRING() != null) {
                rsctx.setSTRING(ctx.rightStatment().STRING().getText().replaceAll("'", ""));
            }
            if(ctx.rightStatment().PATTERN() != null) {
                rsctx.setPATTERN(ctx.rightStatment().PATTERN().getText().replaceFirst("r", "").replaceFirst("'", "").replaceFirst("'$", ""));
            }
            ectx.setRsctx(rsctx);
        }
        if(ctx.annotated() != null) {
            ectx.setANNOTATED(true);
        }
        if (ctx.method() != null) {
            MethodContext method = new MethodContext();
            if(ctx.method().getChildCount()==1) {
                method.STAR(ctx.method().STAR() != null);
                if(ctx.method().STAR()== null) {
                    method.Description(ctx.method().STRING() != null ? ctx.method().STRING().get(0).getText().replaceAll("[' ]", "") : null );
                }
            }
            else {
                if(ctx.method().NAME().size() > 2) {
                    _errMsg.add(new ErrorMessage("Maximální poèet argumentù je 2 ne:" + ctx.method().NAME().size(),true));
                    _error = true;
                }
                 boolean name=false;
                boolean arg=false;
                for(int i =0; i < ctx.method().NAME().size() ; i++) {
                    switch(ctx.method().NAME(i).getText().toLowerCase()){
                        case "name":
                            if(name) {
                                _errMsg.add(new ErrorMessage("Duplicitní parametr:" + ctx.method().NAME(i).getText(), true));
                                _error = true;
                            }
                            name = true;
                            break;
                        case "arg":
                            if(arg) {
                                _errMsg.add(new ErrorMessage("Duplicitní parametr:" + ctx.method().NAME(i).getText(), true));
                                _error = true;
                            }
                            arg = true;
                            break;
                        default:
                            _errMsg.add(new ErrorMessage("Neznámí parametr:" + ctx.method().NAME(i).getText(), true));
                            _error = true;
                            break;
                    }
                    method.Arg(
                            ctx.method().NAME(i).getText(),
                            ctx.method().STRING(i).getText().replace("'", "")
                    );
                }
            }
            ectx.setMethod(method);
        }
        stack.add(KeyCommand.exitEqual, ectx);
    }
    
    @Override
    public void enterEqual(queryParser.EqualContext ctx) {
        stack.add(KeyCommand.enterEqual, new EqualContext());
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cond ">    
    @Override
    public void exitCond(queryParser.CondContext ctx) {
        CondContext cctx = new CondContext();        
        if (ctx.equal() != null) {
            cctx.Equal(true);
        }
        if (ctx.OPERATORS() != null) {
            switch(ctx.OPERATORS().getText().toLowerCase()) {
                case "=" :
                    cctx.OPERATORS(Operators.EQUAL);
                    break;
                case "!=" :
                    cctx.OPERATORS(Operators.NOT_EQUAL);
                    break;
                case "~" :
                    cctx.OPERATORS(Operators.SIMILAR);
                    break;
                case "in" :
                    cctx.OPERATORS(Operators.IN);
                    break;
            }            
        }
        if (ctx.innerSelect() != null) {
            cctx.InnerSelect(true);
            if(ctx.OPERATORS() != null) {
                if(ctx.OPERATORS().getText().compareToIgnoreCase("in") != 0) {
                    _errMsg.add(new ErrorMessage("Tento operátor není povolen:" + ctx.OPERATORS().getText(),true));
                    _error = true;
                }
            }
        }
        else {
            if(ctx.OPERATORS() != null) {
                if(ctx.OPERATORS().getText().compareToIgnoreCase("in") == 0) {
                    _errMsg.add(new ErrorMessage("Tento operátor není povolen:" + ctx.OPERATORS().getText(),true));
                    _error = true;
                }
            }
        }
        
        if (ctx.NAME() != null) {
            switch(ctx.NAME().getText().toLowerCase()) {
                case "import":
                    break;
                case "interface":
                    break;
                case "class":
                    break;
                case "annotation":
                    break;
                case "enum":
                    break;
                case "public":
                    break;
                case "protected":
                    break;
                case "private":
                    break;
                case "final":
                    break;
                case "inner":
                    break;
                case "extends":
                    break;
                case "implements":
                    break;
                case "name":
                    break;
                case "fqn":
                    break;
                default :
                    _errMsg.add(new ErrorMessage("Neznáme klíèové slovo:" + ctx.NAME().getText(),true));
                    _error = true;
                    break;
            }
            cctx.NAME(ctx.NAME().getText());            
        }
        
        if(ctx.EXIST() != null) {
            cctx.EXIST(true);
        }
        if(ctx.NOT_EXIST() != null) {
            cctx.NOT_EXIST(true);
        }
        if(ctx.alias() != null) {
            cctx.ALIAS(ctx.alias().getText().replace(".", ""));
        }
        stack.add(KeyCommand.exitCond, cctx);
    }
    
    public void enterCond(queryParser.CondContext ctx) {
        stack.add(KeyCommand.enterCond, new CondContext());
    }    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Conditions ">    
    @Override
    public void enterConditions(queryParser.ConditionsContext ctx) {
        stack.add(KeyCommand.enterConditions, new ConditionsContext());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" PackageName ">    
    @Override
    public void exitPackageName(queryParser.PackageNameContext ctx) {      
        PackageNameContext PNctx = new PackageNameContext();
        if (ctx.innerSelect() != null) {
            PNctx.InnerClass(true);
        }
        if (ctx.EXCLAMANTION() != null) { //from  !package        
            PNctx.EXCLAMANTION(true);
        }
        if (ctx.STRING() != null) { //from package                    
            PNctx.STRING(ctx.STRING().getText().replace("'", ""));            
        }
        stack.add(KeyCommand.exitPackageName, PNctx);
    }
        
    @Override
    public void enterPackageName(queryParser.PackageNameContext ctx) {
        stack.add(KeyCommand.enterPackageName, new PackageNameContext());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" PackageLink ">
    @Override
    public void exitPackageLink(queryParser.PackageLinkContext ctx) {
        PackageLinkContext plctx = new PackageLinkContext();        
        plctx.setSTAR(ctx.STAR() != null);        
        plctx.setAS(ctx.as() != null ? ctx.as().NAME().getText() : null);
        stack.add(KeyCommand.exitPackageLink, plctx);
    }

    @Override
    public void enterPackageLink(queryParser.PackageLinkContext ctx) {
        stack.add(KeyCommand.enterPackageLink, new PackageLinkContext());
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Packages ">
    @Override
    public void exitPackages(queryParser.PackagesContext ctx) {
        stack.add(KeyCommand.exitPackages, new PackagesContext());
    }    
        
    public void enterPackages(queryParser.PackagesContext ctx) {
        stack.add(KeyCommand.enterPackages, new PackagesContext());
    }

// </editor-fold>        
    
    // <editor-fold defaultstate="collapsed" desc=" ParamName ">
    @Override
    public void exitParamName(queryParser.ParamNameContext ctx) {        
        ParamNameContext PNctx = new ParamNameContext();
        if(ctx.alias() != null) {
            PNctx.ALIAS(ctx.alias().getText().replace(".", ""));        
        }        
        PNctx.EXCLAMANTION(ctx.EXCLAMANTION() != null);        
        PNctx.InnerSelect(ctx.innerSelect() != null);
                
        if(ctx.NAME() != null) {
            switch(ctx.NAME().getText().toLowerCase()) {
                case "extends":
                    break;
                case "import":
                    break;
                case "implements":
                    break;
                case "call":
                    break;
                default:
                    _errMsg.add(new ErrorMessage("Neznámí parametr:" + ctx.NAME().getText(), true));
                    _error = true;
                    break;
            }
            PNctx.NAME(ctx.NAME().getText());
        }
        else {
            PNctx.NAME(null);
        }
        
        PNctx.STAR(ctx.STAR() != null);
        
        if(ctx.method() != null) {
            if(ctx.NAME().getText().compareToIgnoreCase("call") != 0) {
                _errMsg.add(new ErrorMessage("Chybný parametr:" + ctx.NAME().getText(), true));
            }
            MethodContext method = new MethodContext();
            if(ctx.method().getChildCount() == 1) {
                if (ctx.method().STAR() != null) {
                    method.STAR(true);
                }
                else {
                    method.Description(ctx.method().STRING() != null ? ctx.method().STRING(0).getText().replaceAll("[' ]", "") : null );
                }
            }
            else {
                if(ctx.method().NAME().size() > 2) {
                    _errMsg.add(new ErrorMessage("Maximální poèet argumentù je 2 ne:" + ctx.method().NAME().size(),true));
                    _error = true;
                }
                boolean name=false;
                boolean arg=false;
                for(int i =0; i < ctx.method().NAME().size() ; i++) {
                    switch(ctx.method().NAME(i).getText().toLowerCase()){
                        case "name":
                            if(name) {
                                _errMsg.add(new ErrorMessage("Duplicitní parametr:" + ctx.method().NAME(i).getText(), true));
                                _error = true;
                            }
                            name = true;
                            break;
                        case "arg":
                            if(arg) {
                                _errMsg.add(new ErrorMessage("Duplicitní parametr:" + ctx.method().NAME(i).getText(), true));
                                _error = true;
                            }
                            arg = true;
                            break;
                        default:
                            _errMsg.add(new ErrorMessage("Neznámí parametr:" + ctx.method().NAME(i).getText(), true));
                            _error = true;
                            break;
                    }
                    method.Arg(
                            ctx.method().NAME(i).getText(),
                            ctx.method().STRING(i).getText().replace("'", "")
                    );
                }
            }
            PNctx.Method(method);
        }
        stack.add(KeyCommand.exitParamName, PNctx);
    }
    
    @Override
    public void enterParamName(queryParser.ParamNameContext ctx) {
        stack.add(KeyCommand.enterParamName, new ParamNameContext());
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ParamSelect ">
    public void enterParamSelect(queryParser.ParamSelectContext ctx) {        
        stack.add(KeyCommand.enterParamSelect, new ParamSelectContext());
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" SelectStatment ">
    @Override
    public void exitSelectStatment(queryParser.SelectStatmentContext ctx) {
        SelectStatmentContext selectStatmentContext = new SelectStatmentContext();        
        selectStatmentContext.setUnique((ctx.UNIQUE() != null));        
       stack.add(KeyCommand.exitSelectStatment, selectStatmentContext);
    }
        
    @Override
    public void enterSelectStatment(queryParser.SelectStatmentContext ctx) {
        stack.add(KeyCommand.enterSelectStatment, new SelectStatmentContext());
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Help Class ">
    public class ErrorMessage {
        
        public String message;        
        public boolean isError;
        
        public ErrorMessage(String m, boolean e) {
            message = m;            
            isError = e;
        }
        
        @Override
        public String toString() {
            return (isError ? "Error: " : "Warning: ") + message;
        }
        
    }

// </editor-fold>
}
