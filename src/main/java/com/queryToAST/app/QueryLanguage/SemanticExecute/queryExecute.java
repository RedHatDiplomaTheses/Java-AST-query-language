/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.SemanticExecute;

import com.queryToAST.app.QueryLanguage.LexerParser.queryBaseListener;
import com.queryToAST.app.QueryLanguage.LexerParser.queryParser;
import com.google.common.collect.Lists;
import com.queryToAST.app.Graph.GraphContext.GraphContext;
import com.queryToAST.app.Graph.Vertex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Niriel
 */
public class queryExecute extends queryBaseListener{
    
    // <editor-fold defaultstate="collapsed" desc=" Property ">
    private GraphContext _graphContext = null;
    private List<LangContext> _langContext = new ArrayList();
    private int _depth = 0;
    private List<AnnParaEntity> _annotatedRight;
    private List<AnnParaEntity> _annotatedLeft;
    private int _index;
    private boolean _indexStar = false;
    private List<MethodEntity> _method = null;
    private List<ClassEntity> _result = new ArrayList();
    private List<ErrorMessage> _errMsg = new ArrayList();
    private List<ClassEntity> _packageLink = null;
    private boolean _error = false;
    private String _as = null;
    private String _alias = null;
    private boolean _isRight = false;    
// </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc=" Get-Set ">
    public void printErr() {
        for (ErrorMessage em : _errMsg) {
            System.out.println(em);
        }
    }
    
    public GraphContext getContext() {
        return _graphContext;
    }
    
    public void setContext(GraphContext context) {
        this._graphContext = context;
    }    
    
    public List<ClassEntity> getResult() {
        return _result;
    }

// </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc=" Every terminal ">

    @Override
    public void visitErrorNode(ErrorNode node) {
        _error =true;
        _errMsg.add(new ErrorMessage("Chyba v lexikální alalýze nebo v gramatice.", _error));
        super.visitErrorNode(node); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx); //To change body of generated methods, choose Tools | Templates.
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" InnerSelect ">
    @Override
    public void exitInnerSelect(queryParser.InnerSelectContext ctx) {        
        _depth--;
    }
    
    @Override
    public void enterInnerSelect(queryParser.InnerSelectContext ctx) {
        _depth++;
    }    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" AnnotatedParams ">
    @Override
    public void enterAnnotatedParams(queryParser.AnnotatedParamsContext ctx) {
        _indexStar = false;        
    }
// </editor-fold>                

    // <editor-fold defaultstate="collapsed" desc=" Annotated ">
    @Override
    public void exitAnnotated(queryParser.AnnotatedContext ctx) {
        if (_error) {
            return;
        }
                       
        queryParser.AnnotatedStatmentContext as = ctx.annotatedStatment();
        List<ClassEntity> tmp = new ArrayList();
        List<ClassEntity> alTmp = null;
        List<AnnParaEntity> anpTmp= new ArrayList();
        
        // <editor-fold defaultstate="collapsed" desc=" IF alias ">            
        if (_alias != null) {
            boolean isTrue = false;
            for (int i = _depth; i >= 0; i--) {
                if (_langContext.get(i).mapAS.containsKey(_alias)) {
                    alTmp = _langContext.get(i).mapAS.get(_alias);
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                _error = true;
                _errMsg.add(new ErrorMessage("Neexistující alias: " + _alias, isTrue));
                return;
            }
        } else {
            alTmp = _langContext.get(_index).result;
        }
        // </editor-fold>                                                
        
        String name = as.AT_NAME().getText().replaceFirst("@", "");
        String strTMP = null;
        String paramsTMP = null;
        String[] paramTMP = null;
        String method = null;
        
        if (ctx.METHOD() != null) {
            // <editor-fold defaultstate="collapsed" desc=" Dodelat ">
            strTMP = ctx.method().STRING(0).getText().replaceAll("[' ]", "");
            paramsTMP = strTMP.replaceFirst("^[\\w<>]*", "").replaceAll("[)(]", "");            
            
            if (paramsTMP.compareTo("") != 0) {
                paramTMP = paramsTMP.split(",");
            }
            method = strTMP.replaceFirst("\\(.*", "");

// </editor-fold>                        
        }
        else {
            // <editor-fold defaultstate="collapsed" desc=" Class Annotated ">
            for (ClassEntity ce : alTmp) {                
                boolean isAE = true;
                boolean isAnnotated = true;
                AnnParaEntity ann = null;
                AnnotatedEntity ar = null;
                
                ar = ce.getAnnotatedRelated(name);
                
                if (ar != null) {//@NAME
                    for (int i = 0; i < as.annotatedParams().size(); i++) {
                        queryParser.AnnotatedParamsContext apc = as.annotatedParams().get(i);                        
                        if (apc.DOT_NAME() != null) {
                            String ParaName = apc.DOT_NAME().getText().replace(".", "");
                            if (apc.index() != null) { //@NAME.NAME INDEX
                                if (isAE) {
                                    ann = ar.getAnnParaRelated(ParaName);                                    
                                    if (ann != null) {
                                        ann = ann.getIndexRelated(Integer.parseInt(apc.index().INT().getText()));
                                        if (ann == null) {
                                            isAnnotated = false;
                                            break;
                                        }
                                    }
                                    else {
                                        isAnnotated = false;
                                        break;
                                    }
                                    isAE = false;
                                }
                                else {
                                    ann = ann.getAnnParaRelated(ParaName);
                                    if (ann != null) {
                                        ann = ann.getIndexRelated(Integer.parseInt(apc.index().INT().getText()));
                                        if (ann == null) {
                                            isAnnotated = false;
                                            break;
                                        }                                        
                                    }
                                    else {
                                        isAnnotated = false;
                                        break;
                                    }
                                    
                                }                                
                            }
                            else { //@NAME.NAME
                                if (isAE) {
                                    ann = ar.getAnnParaRelated(ParaName);
                                    if (ann == null) {
                                        isAnnotated = false;
                                        break;
                                    }
                                    isAE = false;
                                }
                                else {
                                    ann = ann.getAnnParaRelated(ParaName);
                                    if (ann == null) {
                                        isAnnotated = false;
                                        break;
                                    }
                                }                                
                            }
                        }
                        else if (apc.AT_NAME() != null) {//@NAME.NAME.@NAME
                            String ATname = apc.AT_NAME().getText().replace("@", "");
                            if (ATname.compareTo(ann.getName()) == 0) {
                                
                            }
                            else {
                                isAnnotated = false;
                                break;
                            }
                        }
                    }
                }
                else {                    
                    continue;
                }
                
                if (isAnnotated) {                    
                    anpTmp.add(ann);
                    tmp.add(ce);
                }
            }

// </editor-fold>
        }        
        
        if(!_isRight) {            
            _annotatedLeft = anpTmp;
            alTmp.clear();
            alTmp.addAll(tmp);            
        }
        else {
            _annotatedRight = anpTmp;  
        }
    }
    
    @Override    
    public void enterAnnotated(queryParser.AnnotatedContext ctx) {
        _indexStar = false;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" as, INDEX and alias ">

    @Override
    public void exitIndex(queryParser.IndexContext ctx) {
        if(ctx.STAR() != null) {
            _indexStar = true;
        }
        _index = Integer.parseInt(ctx.INT().getText());
    }
    
    @Override
    public void exitAs(queryParser.AsContext ctx) {      
         _as = ctx.NAME().getText();
    }

    @Override
    public void exitAlias(queryParser.AliasContext ctx) {
        _alias = ctx.NAME_DOT().getText().replace(".", "");
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" RightStatment ">
    @Override
    public void enterRightStatment(queryParser.RightStatmentContext ctx) {
        _alias = null;
        _isRight = true;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Equal ">
    @Override
    public void exitEqual(queryParser.EqualContext ctx) {
        if (_error) return;
        
        if (ctx.OPERATORS() != null && ctx.OPERATORS().getText().compareToIgnoreCase("in") == 0)
        {
            _error=true;
            _errMsg.add(new ErrorMessage("Neplatný operátor: " + ctx.OPERATORS().getText(), _error));
            return;
        }
        
        List<ClassEntity> tmp = new ArrayList();
        List<ClassEntity> alTmp = null;

        // <editor-fold defaultstate="collapsed" desc=" IF alias ">
            alTmp = null;
            if (ctx.alias() != null) {
                String alias = ctx.alias().NAME_DOT().getText().replace(".", "");
                boolean isTrue = false;
                for (int i = _depth; i >= 0; i--) {
                    if (_langContext.get(i).mapAS.containsKey(alias)) {
                        alTmp = _langContext.get(i).mapAS.get(alias);
                        isTrue = true;
                        break;
                    }
                }
                if (!isTrue) {
                    _error = true;
                    _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, isTrue));
                    return;
                }
            } else {
                alTmp = _langContext.get(_index).result;
            }

            // </editor-fold>
        if(ctx.NAME() != null)  //alias? NAME OPERATORS rightStatment
        {   
            if (ctx.rightStatment().STRING() != null) { // (as.)? NAME = 'String' (M:1)            
                // <editor-fold defaultstate="collapsed" desc=" as? name = 'String' ">
                String str = ctx.rightStatment().STRING().getText().replaceAll("'", "");                
                switch (ctx.NAME().getText().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getName().compareTo(str) == 0) {
                                if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                            
                            if (ce.getName().contains(str)) {
                                if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                    tmp.add(ce);
                                }
                            }                            
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getFQN().compareTo(str) == 0) {
                                if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                    tmp.add(ce);
                                }
                            } else {
                                if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                            
                            if (ce.getFQN().contains(str)) {
                                if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                    tmp.add(ce);
                                }
                            }                            
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                        return;                    
                }

            // </editor-fold>
            }
            else if (ctx.rightStatment().PATTERN() != null) {
                // <editor-fold defaultstate="collapsed" desc=" as? name = 'Pattern' ">
                String pattern = ctx.rightStatment().PATTERN().getText().replaceFirst("r", "").replaceFirst("'", "").replaceFirst("'$", "");
                switch (ctx.NAME().getText().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getName().matches(pattern)) {
                                if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getFQN().matches(pattern)) {
                                if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                    tmp.add(ce);
                                }
                            }                            
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                        return;                    
                }

            // </editor-fold>
            }
            else if (ctx.rightStatment().NAME() != null) { // (as.)? NAME = (AS.)? NAME (M:N)
                // <editor-fold defaultstate="collapsed" desc=" as? NAME = as? NAME ">
                List<ClassEntity> ceTmp = null;
                if (ctx.alias() != null) {
                    String alias = ctx.alias().NAME_DOT().getText().replace(".", "");
                    boolean isTrue = false;
                    for (int i = _depth; i >= 0; i--) {
                        if (_langContext.get(i).mapAS.containsKey(alias)) {
                            ceTmp = _langContext.get(i).mapAS.get(alias);
                            isTrue = true;
                            break;
                        }
                    }
                    if (!isTrue) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, isTrue));
                        return;
                    }
                } else {
                    ceTmp = _langContext.get(_index).result;
                }
                
                String cmpNAME =ctx.rightStatment().NAME().getText().replaceAll("'", "");
                switch (ctx.NAME().getText().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            for (ClassEntity sec : ceTmp) {
                                String cmpValue;
                                switch (cmpNAME.toLowerCase()){
                                    case "name":
                                        cmpValue =sec.getName();
                                        break;
                                    case "fqn":
                                        cmpValue =sec.getFQN();
                                        break;
                                    default:
                                        _error = true;
                                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                                        return;
                                }
                                if (ce.getName().compareTo(cmpValue) == 0) {
                                    if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getName().contains(cmpValue)) {
                                    if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            for (ClassEntity sec : ceTmp) {
                                String cmpValue;
                                switch (cmpNAME.toLowerCase()){
                                    case "name":
                                        cmpValue =sec.getName();
                                        break;
                                    case "fqn":
                                        cmpValue =sec.getFQN();
                                        break;
                                    default:
                                        _error = true;
                                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                                        return;
                                }
                                if (ce.getFQN().compareTo(cmpValue) == 0) {
                                    if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getFQN().contains(cmpValue)) {
                                    if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                        return;                    
                }

            // </editor-fold>                
            }
            else if (ctx.rightStatment().annotated() != null){ // NAME = @Annotated (M:N)
                // <editor-fold defaultstate="collapsed" desc=" as? NAME = as? Annotated ">                
                switch (ctx.NAME().getText().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            for ( AnnParaEntity sec : _annotatedRight) {
                                if (ce.getName().compareTo(sec.getValue()) == 0) {
                                    if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getName().contains(sec.getValue())) {
                                    if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            for ( AnnParaEntity sec : _annotatedRight) {                                
                                if (ce.getFQN().compareTo(sec.getValue()) == 0) {
                                    if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getFQN().contains(sec.getValue())) {
                                    if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                        return;                    
                }

            // </editor-fold>                
            }                        
        }
        else if(ctx.OPERATORS() != null) //alias? annotated OPERATORS rightStatment
        {            
            if(ctx.rightStatment().STRING() != null) {             
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = STRING ">
                String cmp = ctx.rightStatment().STRING().getText().replaceAll("'", "");
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }                    
                    if (left.getValue().compareTo(cmp) == 0) {
                        if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                            tmp.add(ce);
                        }
                    } else {
                        if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                            tmp.add(ce);
                        }
                    }

                    if (left.getValue().contains(cmp)) {
                        if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                            tmp.add(ce);
                        }
                    }                    
                }
                // </editor-fold>
            }
            else if (ctx.rightStatment().PATTERN() != null) {
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = Pattern ">                
                String pattern = ctx.rightStatment().PATTERN().getText().replaceFirst("r", "").replaceFirst("'", "").replaceFirst("'$", "");
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }                    
                    if (left.getValue().matches(pattern)) {
                        if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                            tmp.add(ce);
                        }
                    } else {
                        if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                            tmp.add(ce);
                        }
                    }                                        
                }
                // </editor-fold>
            }
            else if(ctx.rightStatment().NAME() != null) {                
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = NAME ">
                List<ClassEntity> ceTmp = null;
                if (ctx.alias() != null) {
                    String alias = ctx.alias().NAME_DOT().getText().replace(".", "");
                    boolean isTrue = false;
                    for (int i = _depth; i >= 0; i--) {
                        if (_langContext.get(i).mapAS.containsKey(alias)) {
                            ceTmp = _langContext.get(i).mapAS.get(alias);
                            isTrue = true;
                            break;
                        }
                    }
                    if (!isTrue) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, isTrue));
                        return;
                    }
                } else {
                    ceTmp = _langContext.get(_index).result;
                }
                String cmpNAME =ctx.rightStatment().NAME().getText().replaceAll("'", "");
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);                    
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }
                    for (ClassEntity sec : ceTmp) {
                        String cmpValue;
                        switch (cmpNAME.toLowerCase()){
                            case "name":
                                cmpValue =sec.getName();
                                break;
                            case "fqn":
                                cmpValue =sec.getFQN();
                                break;
                            default:
                                _error = true;
                                _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.NAME().getText(), _error));
                                return;
                        }
                        if (left.getValue().compareTo(cmpValue) == 0) {
                            if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                tmp.add(ce);
                            }
                        } else {
                            if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                tmp.add(ce);
                            }
                        }
                        
                        if (left.getValue().contains(cmpValue)) {
                            if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                tmp.add(ce);
                            }
                        }
                    }
                }

// </editor-fold>
            }
            else if (ctx.rightStatment().annotated() != null) {
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = @Annotated ">
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }
                    for (AnnParaEntity sec : _annotatedRight) {
                        if (left.getValue().compareTo(sec.getValue()) == 0) {
                            if (ctx.OPERATORS().getText().compareTo("=") == 0) {
                                tmp.add(ce);
                            }
                        } else {
                            if (ctx.OPERATORS().getText().compareTo("!=") == 0) {
                                tmp.add(ce);
                            }
                        }
                        
                        if (left.getValue().contains(sec.getValue())) {
                            if (ctx.OPERATORS().getText().compareTo("~") == 0) {
                                tmp.add(ce);
                            }
                        }
                    }
                }

                // </editor-fold>
            }             
        }
        else if (ctx.annotated() != null) {    //alias? annotated
            return; //vyøízeno v exitAnnotated;
        }
        else if (ctx.method() != null) {
            //dodelat nebo vzit z annotated
        }
         alTmp.clear();
         alTmp.addAll(tmp);        
    }

    @Override
    public void enterEqual(queryParser.EqualContext ctx) {
        _alias = null;
        _isRight = false;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cond ">
    @Override
    public void exitCond(queryParser.CondContext ctx) {
        if (_error) return;        
        
        List<ClassEntity> tmp = new ArrayList();
        
        if (ctx.equal() != null) // zpracovat v exitEqual(): equal 
        {
            return;
        }
        else if (ctx.OPERATORS() != null)//:innerSelect OPERATORS alias? NAME
        {                       
            if(ctx.alias() == null)
            {
                // <editor-fold defaultstate="collapsed" desc=" Not Alias ">
                if (ctx.OPERATORS().getText().compareToIgnoreCase("in") == 0) {
                    for (ClassEntity ce : _langContext.get(_depth).result) {
                        boolean isTrue = true;
                        for (ClassEntity ce2 : _langContext.get(_depth + 1).result) {
                            switch (ctx.NAME().getText().toLowerCase()) {
                                case "import":
                                    if (ce.getImportRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "extend":
                                    if (ce.getExtendsRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "implements":
                                    if (ce.getImplementsRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "name":
                                    if (ce.getName().compareTo(ce2.getName()) != 0) //import extend implement name fqn
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "fqn":
                                    if (ce.getName().compareTo(ce2.getFQN()) != 0) //import extend implement name fqn
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                default:
                                    _error = true;
                                    _errMsg.add(new ErrorMessage("Oèekáváno klíèové slovo ne: " + ctx.NAME().getText(), _error));
                                    return;                                
                            }
                            
                        }
                        if (isTrue) {
                            tmp.add(ce);
                        }
                    }
                } else {
                    _error = true;
                    _errMsg.add(new ErrorMessage("Nepovolený operátor: " + ctx.OPERATORS().getText(), _error));
                    return;
                }

// </editor-fold>
            }
            else    // with alias
            {                    
                // <editor-fold defaultstate="collapsed" desc=" Alias ">
                String alias = ctx.alias().NAME_DOT().getText().replace(".", "");
                if (_langContext.get(_depth).mapAS.containsKey(alias)) {
                    if (ctx.OPERATORS().getText().compareToIgnoreCase("in") == 0) {
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    boolean isTrue = true;
                                    for (ClassEntity ce2 : _langContext.get(_depth + 1).result) {
                                        switch (ctx.NAME().getText().toLowerCase()) {
                                            case "import":
                                                if (ce.getImportRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            case "extend":
                                                if (ce.getExtendsRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            case "implements":
                                                if (ce.getImplementsRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            case "name":
                                                if (ce.getName().compareTo(ce2.getName()) != 0) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            case "fqn":
                                                if (ce.getName().compareTo(ce2.getFQN()) != 0) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            default:
                                                _error = true;
                                                _errMsg.add(new ErrorMessage("Oèekáváno klíèové slovo ne: " + ctx.NAME().getText(), _error));
                                                return;                                            
                                        }
                                    }
                                    if (isTrue) {
                                        tmp.add(ce);
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    } else {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Nepovolený operátor: " + ctx.OPERATORS().getText(), _error));
                        return;
                    }
                }

// </editor-fold>
            }
        }
        else if (ctx.innerSelect() != null)//:NAME innerSelect          NAME:(EXIST |NotExist)
        {
            // <editor-fold defaultstate="collapsed" desc=" (Not)?Exist InnerSelect">

            boolean isEmpty = _langContext.get(_depth + 1).result.isEmpty();            
            if (ctx.EXIST() != null){
                if (!isEmpty) {
                        tmp = _langContext.get(_depth).result;
                    }
                
            }
            else if (ctx.NOT_EXIST() != null) {                               
                    if (isEmpty) {
                        tmp = _langContext.get(_depth).result;
                    }
            }                            
            // </editor-fold>
        }       
        else //: (!)? alias? NAME
        {
            if(ctx.alias() == null)
            {
                // <editor-fold defaultstate="collapsed" desc=" NAME ">
                switch (ctx.NAME().getText().toLowerCase()) {
                    case "class":
                        for (ClassEntity re : _langContext.get(_depth).result) {                            
                            if (re.getType().compareToIgnoreCase("class") == 0) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "interface":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("interface") == 0) {
                               if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "annotation":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("annotation") == 0) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "enum":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("enum") == 0) {
                               if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "public":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isPublic()) {
                               if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "protected":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isProtected()) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "private":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isPrivate()) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "final":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isFinal()) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "inner":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isInner()) {
                                if(ctx.EXCLAMANTION() == null) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION() != null) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neoèekávyný vstup: " + ctx.NAME().getText(), _error));
                        return;
                }

// </editor-fold>
            }
            else
            {
                // <editor-fold defaultstate="collapsed" desc=" alias.NAME ">
                String alias = ctx.alias().NAME_DOT().getText().replace(".", "");
                boolean found = false;
                for (int i = _depth; i >= 0; i--) {
                    if (_langContext.get(i).mapAS.containsKey(alias)) {
                        List<ClassEntity> tmc = _langContext.get(i).mapAS.get(alias);
                        switch (ctx.NAME().getText().toLowerCase()) {
                            case "class":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("class") == 0) {
                                       if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "interface":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("interface") == 0) {
                                       if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "annotation":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("annotation") == 0) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "enum":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("enum") == 0) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "public":
                                for (ClassEntity re : tmc) {
                                    if (re.isPublic()) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "protected":
                                for (ClassEntity re : tmc) {
                                    if (re.isProtected()) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "private":
                                for (ClassEntity re : tmc) {
                                    if (re.isPrivate()) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "final":
                                for (ClassEntity re : tmc) {
                                    if (re.isFinal()) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "inner":
                                for (ClassEntity re : tmc) {
                                    if (re.isInner()) {
                                        if(ctx.EXCLAMANTION() == null) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION() != null) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            default:
                                _error = true;
                                _errMsg.add(new ErrorMessage("Neoèekávyný vstup: " + ctx.NAME().getText(), _error));
                                return;
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    _error = true;
                    _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                    return;
                }

// </editor-fold>
            }
        }
        _langContext.get(_depth).result = tmp;
    }

    @Override
    public void enterCond(queryParser.CondContext ctx) {
        _alias = null;
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Conditions ">

    @Override
    public void enterConditions(queryParser.ConditionsContext ctx) {
        _langContext.get(_depth)._WHERE = true;
        if (!_langContext.get(_depth)._FROM) {
            _langContext.get(_depth).result = _graphContext.getClassInPackage("*");
            _langContext.get(_depth)._FROM = true;
        }
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" PackageName ">
    @Override
    public void exitPackageName(queryParser.PackageNameContext ctx) {
        if (_error) {
            return;
        }
        
        if (ctx.innerSelect() != null) {            
            _packageLink.addAll(_langContext.get(_depth + 1).result);
        }
        else if (ctx.EXCLAMANTION() != null && ctx.STRING() != null) {            
            _packageLink.addAll(_graphContext.getClassInPackage(ctx.STRING().getText()));
        }
        else if(ctx.STRING() != null) {            
            _packageLink.addAll(_graphContext.getClassInPackageRecursion(ctx.STRING().getText()));
        }
    }
    
    @Override
    public void enterPackageName(queryParser.PackageNameContext ctx) {
        
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" PackageLink ">
    @Override
    public void exitPackageLink(queryParser.PackageLinkContext ctx) {
        if(ctx.STAR() != null) {
            _packageLink = _graphContext.getClassInPackage("*");            
        }
        
        if (ctx.as() == null) {
                _langContext.get(_depth).result.addAll(_packageLink);                
        }
        else {
            if (_langContext.get(_depth).mapAS.containsKey(_as)) //duplicitni alias
            {
                _errMsg.add(new ErrorMessage("Tento alias už existuje: " + _as, true));
                _error = true;
            }
            else {                                   
                _langContext.get(_depth).mapAS.put(_as, _packageLink);                
            }
        }        
    }

    @Override
    public void enterPackageLink(queryParser.PackageLinkContext ctx) {
        _as = null;
        this._packageLink = new ArrayList();
    }
    
    // </editor-fold>        
    
    // <editor-fold defaultstate="collapsed" desc=" Packages ">
    @Override
    public void exitPackages(queryParser.PackagesContext ctx) {
                        
    }    
    
    @Override
    public void enterPackages(queryParser.PackagesContext ctx) {
        _langContext.get(_depth)._FROM = true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ParamName ">
    @Override
    public void exitParamName(queryParser.ParamNameContext ctx) {
        if (ctx.innerSelect() != null) {
            _langContext.get(_depth).selectListInner.addAll(_langContext.get(_depth + 1).result);
        }
        _langContext.get(_depth).selectListCtx.add(ctx);        
    }

    @Override
    public void enterParamName(queryParser.ParamNameContext ctx) {
        _alias = null;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ParamSelect ">
    @Override
    public void enterParamSelect(queryParser.ParamSelectContext ctx) {        
        _langContext.get(_depth)._SELECT = true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" SelectStatment ">
    @Override
    public void exitSelectStatment(queryParser.SelectStatmentContext ctx) {
        if (_error) {
            return;
        }        
        
        if (!_langContext.get(_depth)._FROM) {
            _langContext.get(_depth).result = _graphContext.getClassInPackage("*");
            _langContext.get(_depth)._FROM = true;
        }
        
        List<ClassEntity> tmp = new ArrayList();
        
        if (_langContext.get(_depth).selectListCtx.isEmpty()) // select nebyl zadan
        {
            for (String str : _langContext.get(_depth).mapAS.keySet()) {                
                tmp.addAll(_langContext.get(_depth).mapAS.get(str));
            }            
            tmp.addAll(_langContext.get(_depth).result);
        }
        
        for (queryParser.ParamNameContext select : _langContext.get(_depth).selectListCtx) {            
            if (select.EXCLAMANTION() != null)// ! name | ! alias.name
            {                
                if (select.NAME().getText().compareToIgnoreCase("extends") == 0) //!name
                {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInExtendsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else { // !alias.name
                    
                        String alias = select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getInExtendsRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }
                else if (select.NAME().getText().compareToIgnoreCase("import") == 0) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInImportRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else {// !alias.name                    
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getInImportRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }                    
                }
                else if (select.NAME().getText().compareToIgnoreCase("implements") == 0) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInImplementsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else { // !alias.name                    
                        String alias = select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getInImplementsRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }                    
                }
            }
            else if (select.method() != null && select.NAME().getText().compareToIgnoreCase("call") == 0) { // alias.method[...]                
                if (select.method().getChildCount() != 1) {
                    for (int i = 0; i < select.method().getChildCount(); i++) {
                        //rozèíøení dotazy na casti methody !!!
                    }
                }
                else if (select.method().STAR() != null) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            for (MethodEntity me : ce.getMethodRelated()) {                                        
                                for (MethodEntity mic : me.getInCallRelated()) {
                                    tmp.add(mic.getInClassRelated());                                                
                                }
                            }
                        }
                    }
                    else {
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    for (MethodEntity me : ce.getMethodRelated()) {
                                        for (MethodEntity mic : me.getInCallRelated()) {
                                            tmp.add(mic.getInClassRelated());                                                        
                                        }
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }
                else {
                    String strTMP = select.method().STRING(0).getText().replaceAll("[' ]", "");
                    String paramsTMP = strTMP.replaceFirst("^[\\w<>]*", "").replaceAll("[)(]", "");
                    String[] paramTMP = {};

                    if (paramsTMP.compareTo("") != 0) {
                        paramTMP = paramsTMP.split(",");
                    }

                    String name = strTMP.replaceFirst("\\(.*", "");                            

                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            for (MethodEntity me : ce.getMethodRelated(name)) {                                        
                                if (me.getCountPara() != paramTMP.length) {
                                    continue;
                                }
                                boolean isTrueMethod = true;
                                for (MethParaEntity mpr : me.getMethParaRelated()) {
                                    if (mpr.getFQN().compareTo(paramTMP[mpr.getIndex()]) != 0) {                                                
                                        isTrueMethod = false;
                                    }
                                }
                                if (isTrueMethod) {
                                    for (MethodEntity mic : me.getInCallRelated()) {
                                        tmp.add(mic.getInClassRelated());                                                
                                    }
                                }
                            }
                        }
                    }
                    else {
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    for (MethodEntity me : ce.getMethodRelated(name)) {                                                
                                        if (me.getCountPara() != paramTMP.length) {
                                            continue;
                                        }
                                        boolean isTrueMethod = true;
                                        for (MethParaEntity mpr : me.getMethParaRelated()) {
                                            if (mpr.getFQN().compareTo(paramTMP[mpr.getIndex()]) != 0) {                                                        
                                                isTrueMethod = false;
                                            }
                                        }
                                        if (isTrueMethod) {
                                            for (MethodEntity mic : me.getInCallRelated()) {
                                                tmp.add(mic.getInClassRelated());                                                        
                                            }
                                        }
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }                
            }
            else if (select.innerSelect() != null) { // (inner select)            
                // zùstane prázdne vlození výsledku je na konci metody _langContext.get(_depth+1).seleceListInner
            }
            else if(select.NAME() != null) {// name | name as name                            
                if (select.NAME().getText().compareToIgnoreCase("extends") == 0) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getExtendsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else {
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {                            
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getExtendsRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }
                else if (select.NAME().getText().compareToIgnoreCase("import") == 0) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getImportRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else // alias.name
                    {
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getImportRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }
                else if (select.NAME().getText().compareToIgnoreCase("implements") == 0) {
                    if (select.alias() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getImplementsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else {
                        String alias =select.alias().NAME_DOT().getText().replace(".", "");
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    Iterable<ClassEntity> Related = ce.getImplementsRelated();
                                    if (Related != null) {
                                        tmp.addAll(Lists.newArrayList(Related));
                                    }
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    }
                }                
            }
            else if (select.STAR() != null) { // * | alias.*
                if (select.alias() == null) {
                    tmp.addAll(_langContext.get(_depth).result);                        
                }
                else {
                    String alias =select.alias().NAME_DOT().getText().replace(".", "");
                    boolean found = false;
                    for (int i = _depth; i >= 0; i--) {
                        if (_langContext.get(i).mapAS.containsKey(alias)) {
                            tmp.addAll(_langContext.get(i).mapAS.get(alias));                                
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                        return;
                    }
                }
            }
        }
        if (!_langContext.get(_depth).selectListInner.isEmpty()) {
            tmp.addAll(_langContext.get(_depth).selectListInner);
        }
        
        _langContext.get(_depth).result = tmp;
        
        if (_depth == 0) {
            _result = _langContext.get(_depth).result;
        }
    }
    
    @Override
    public void enterSelectStatment(queryParser.SelectStatmentContext ctx) {
        _langContext.add(new LangContext());
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" HelpClass ">
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
    
    public class LangContext {

        private List<ErrorMessage> errorMessage;
        private List<ClassEntity> result;        
        private List<queryParser.ParamNameContext> selectListCtx;
        private List<ClassEntity> selectListInner;
        private boolean _SELECT;
        private boolean _FROM;
        private boolean _WHERE;
        Map<String, List<ClassEntity>> mapAS;
        
        LangContext() {
            errorMessage = new ArrayList();
            result = new ArrayList();    
            selectListCtx = new ArrayList();
            selectListInner = new ArrayList();
            mapAS = new TreeMap<String, List<ClassEntity>>();
            _SELECT = false;
            _FROM = false;
            _WHERE = false;
        }
    }    

// </editor-fold>
}