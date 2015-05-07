/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage.SemanticExecute;

import com.google.common.collect.Lists;
import com.queryToAST.app.Graph.GraphContext.GraphContext;
import com.queryToAST.app.Graph.Vertex.*;
import com.queryToAST.app.QueryLanguage.WalkerContext.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Niriel
 */
public class Interpret {
    
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
    
    public boolean isError() {
        return _error;
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
    
    // <editor-fold defaultstate="collapsed" desc=" InnerSelect ">    
    public void exitInnerSelect(InnerSelectContext ctx) {        
        _depth--;
    }
        
    public void enterInnerSelect(InnerSelectContext ctx) {
        _depth++;
    }    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" AnnotatedParams ">    
    public void enterAnnotatedParams(AnnotatedParamsContext ctx) {
        _indexStar = false;        
    }
// </editor-fold>                

    // <editor-fold defaultstate="collapsed" desc=" Annotated ">    
    public void exitAnnotated(AnnotatedContext ctx) {
        if (_error) {
            return;
        }
                       
        AnnotatedStatmentContext as = ctx.getAsctx();
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
                _errMsg.add(new ErrorMessage("Neexistující alias: " + _alias, _error));
                return;
            }
        } else {
            alTmp = _langContext.get(_index).result;
        }
        // </editor-fold>                                                
        
        String name = as.getAT_NAME();
        String strTMP = null;
        String paramsTMP = null;
        String[] paramTMP = null;
        String method = null;
        
        if (ctx.getMethod() != null) {
            //<editor-fold defaultstate="collapsed" desc=" Dodelat ">
//            strTMP = ctx.getMethod().Description();
//            paramsTMP = strTMP.replaceFirst("^[\\w<>]*", "").replaceAll("[)(]", "");            
//            
//            if (paramsTMP.compareTo("") != 0) {
//                paramTMP = paramsTMP.split(",");
//            }
//            method = strTMP.replaceFirst("\\(.*", "");
            _error = true;
            _errMsg.add(new ErrorMessage("Anotace metod ještì nejsou plnì implementovány.", _error));
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
                    for (int i = 0; i < as.getApctx().size(); i++) {
                        AnnotatedParamsContext apc = as.getApctx().get(i);
                        if (apc.getName() != null) {
                            String ParaName = apc.getName();
                            if (apc.getIndex() != null) { //@NAME.NAME INDEX
                                if (isAE) {
                                    ann = ar.getAnnParaRelated(ParaName);                                    
                                    if (ann != null) {
                                        ann = ann.getIndexRelated(apc.getIndex().getINDEX());
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
                                        ann = ann.getIndexRelated(apc.getIndex().getINDEX());
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
                        else if (apc.getAT_NAME() != null) {//@NAME.NAME.@NAME
                            String ATname = apc.getAT_NAME();
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

    public void enterAnnotated(AnnotatedContext ctx) {
        _indexStar = false;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" as, INDEX and alias ">
    public void exitIndex(IndexContext ctx) {
        if(ctx.isSTAR()) {
            _indexStar = true;
        }
        _index = ctx.getINDEX();
    }
        
    public void exitAs(AsContext ctx) {
         _as = ctx.getNAME();
    }
    
    public void exitAlias(AliasContext ctx) {
        _alias = ctx.getNAME();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" RightStatment ">    
    public void enterRightStatment(RightStatmentContext ctx) {
        _alias = null;
        _isRight = true;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Equal ">    
    public void exitEqual(EqualContext ctx) {
        if (_error) return;
        
        if (ctx.getOPERATORS() != null && ctx.getOPERATORS() == Operators.IN)
        {
            _error=true;
            _errMsg.add(new ErrorMessage("Neplatný operátor: " + ctx.getOPERATORS(), _error));
            return;
        }
        
        List<ClassEntity> tmp = new ArrayList();
        List<ClassEntity> alTmp = null;

        // <editor-fold defaultstate="collapsed" desc=" IF alias ">           
            if (ctx.getAlias() != null) {
                String alias = ctx.getAlias();
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
                    _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, _error));
                    return;
                }
            } else {
                alTmp = _langContext.get(_depth).result;
            }

            // </editor-fold>
            
        if(ctx.getNAME() != null)  //alias? NAME OPERATORS rightStatment
        {   
            if (ctx.getRsctx().getSTRING() != null) { // (as.)? NAME = 'String' (M:1)            
                // <editor-fold defaultstate="collapsed" desc=" as? name = 'String' ">
                String str = ctx.getRsctx().getSTRING();
                switch (ctx.getNAME().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getName().compareTo(str) == 0) {
                                if (ctx.getOPERATORS() == Operators.EQUAL) { // =
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.getOPERATORS() == Operators.NOT_EQUAL) { //!=
                                    tmp.add(ce);
                                }
                            }
                            
                            if (ce.getName().contains(str)) {
                                if (ctx.getOPERATORS() == Operators.SIMILAR) { // ~
                                    tmp.add(ce);
                                }
                            }                            
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getFQN().compareTo(str) == 0) {
                                if (ctx.getOPERATORS() == Operators.EQUAL) {  // =
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {  // !=
                                    tmp.add(ce);
                                }
                            }
                            
                            if (ce.getFQN().contains(str)) {
                                if (ctx.getOPERATORS() == Operators.SIMILAR) { // ~
                                    tmp.add(ce);
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                        return;                    
                }

            // </editor-fold>
            }
            else if (ctx.getRsctx().getPATTERN() != null) {
                // <editor-fold defaultstate="collapsed" desc=" as? name = 'Pattern' ">
                String pattern = ctx.getRsctx().getPATTERN();
                switch (ctx.getNAME().toLowerCase()) {
                    case "name" :
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getName().matches(pattern)) {
                                if (ctx.getOPERATORS() == Operators.EQUAL) {
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                    tmp.add(ce);
                                }
                            }
                        }
                        break;
                    case "fqn":
                        for (ClassEntity ce : alTmp) {                            
                            if (ce.getFQN().matches(pattern)) {
                                if (ctx.getOPERATORS() == Operators.EQUAL) {
                                    tmp.add(ce);
                                }
                            }
                            else {
                                if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                    tmp.add(ce);
                                }
                            }                            
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                        return;                    
                }

            // </editor-fold>
            }
            else if (ctx.getRsctx().getNAME() != null) { // (as.)? NAME = (AS.)? NAME (M:N)
                // <editor-fold defaultstate="collapsed" desc=" as? NAME = as? NAME ">
                List<ClassEntity> ceTmp = null;
                if (ctx.getAlias() != null) {
                    String alias = ctx.getAlias();
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
                        _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, _error));
                        return;
                    }
                } else {
                    ceTmp = _langContext.get(_depth).result;
                }
                
                String cmpNAME = ctx.getRsctx().getNAME();
                switch (ctx.getNAME().toLowerCase()) {
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
                                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                                        return;
                                }
                                if (ce.getName().compareTo(cmpValue) == 0) {
                                    if (ctx.getOPERATORS() == Operators.EQUAL) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getName().contains(cmpValue)) {
                                    if (ctx.getOPERATORS() == Operators.SIMILAR) {
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
                                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                                        return;
                                }
                                if (ce.getFQN().compareTo(cmpValue) == 0) {
                                    if (ctx.getOPERATORS() == Operators.EQUAL) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getFQN().contains(cmpValue)) {
                                    if (ctx.getOPERATORS() == Operators.SIMILAR) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                        return;                    
                }

            // </editor-fold>                
            }
            else if (ctx.getRsctx().isAnnotated()){ // NAME = @Annotated (M:N)
                // <editor-fold defaultstate="collapsed" desc=" as? NAME = as? Annotated ">                
                switch (ctx.getNAME().toLowerCase()) {
                    case "name":
                        for (ClassEntity ce : alTmp) {                            
                            for ( AnnParaEntity sec : _annotatedRight) {
                                if (ce.getName().compareTo(sec.getValue()) == 0) {
                                    if (ctx.getOPERATORS() == Operators.EQUAL) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getName().contains(sec.getValue())) {
                                    if (ctx.getOPERATORS() == Operators.SIMILAR) {
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
                                    if (ctx.getOPERATORS() == Operators.EQUAL) {
                                        tmp.add(ce);
                                    }
                                } else {
                                    if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                        tmp.add(ce);
                                    }
                                }
                                
                                if (ce.getFQN().contains(sec.getValue())) {
                                    if (ctx.getOPERATORS() == Operators.SIMILAR) {
                                        tmp.add(ce);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                        return;                    
                }

            // </editor-fold>                
            }                        
        }
        else if(ctx.getOPERATORS() != null) //alias? annotated OPERATORS rightStatment
        {            
            if(ctx.getRsctx().getSTRING() != null) {             
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = STRING ">
                String cmp = ctx.getRsctx().getSTRING();
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }                    
                    if (left.getValue().compareTo(cmp) == 0) {
                        if (ctx.getOPERATORS() == Operators.EQUAL) {
                            tmp.add(ce);
                        }
                    } else {
                        if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                            tmp.add(ce);
                        }
                    }

                    if (left.getValue().contains(cmp)) {
                        if (ctx.getOPERATORS() == Operators.SIMILAR) {
                            tmp.add(ce);
                        }
                    }                    
                }
                // </editor-fold>
            }
            else if (ctx.getRsctx().getPATTERN() != null) {
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = Pattern ">                
                String pattern = ctx.getRsctx().getPATTERN();
                for (int i = 0; i < _annotatedLeft.size(); i++) {
                    ClassEntity ce = alTmp.get(i);
                    AnnParaEntity left = _annotatedLeft.get(i);
                    if (left.getValue() == null) {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Anotace na levé strane má nevalidní tvar porovnávat se dají pouze hodnoty parametru :", _error));
                        return;                        
                    }                    
                    if (left.getValue().matches(pattern)) {
                        if (ctx.getOPERATORS() == Operators.EQUAL) {
                            tmp.add(ce);
                        }
                    } else {
                        if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                            tmp.add(ce);
                        }
                    }                                        
                }
                // </editor-fold>
            }
            else if(ctx.getRsctx().getNAME() != null) {                
                // <editor-fold defaultstate="collapsed" desc=" @Annotated = NAME ">
                List<ClassEntity> ceTmp = null;
                if (ctx.getAlias() != null) {
                    String alias = ctx.getAlias();
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
                        _errMsg.add(new ErrorMessage("Neexistující alias: " + alias, _error));
                        return;
                    }
                } else {
                    ceTmp = _langContext.get(_depth).result;
                }
                String cmpNAME =ctx.getRsctx().getNAME();
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
                                _errMsg.add(new ErrorMessage("Neplatné slovo :" + ctx.getNAME(), _error));
                                return;
                        }
                        if (left.getValue().compareTo(cmpValue) == 0) {
                            if (ctx.getOPERATORS() == Operators.EQUAL) {
                                tmp.add(ce);
                            }
                        } else {
                            if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                tmp.add(ce);
                            }
                        }
                        
                        if (left.getValue().contains(cmpValue)) {
                            if (ctx.getOPERATORS() == Operators.SIMILAR) {
                                tmp.add(ce);
                            }
                        }
                    }
                }

// </editor-fold>
            }
            else if (ctx.getRsctx().isAnnotated()) {
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
                            if (ctx.getOPERATORS() == Operators.EQUAL) {
                                tmp.add(ce);
                            }
                        } else {
                            if (ctx.getOPERATORS() == Operators.NOT_EQUAL) {
                                tmp.add(ce);
                            }
                        }
                        
                        if (left.getValue().contains(sec.getValue())) {
                            if (ctx.getOPERATORS() == Operators.SIMILAR) {
                                tmp.add(ce);
                            }
                        }
                    }
                }

                // </editor-fold>
            }             
        }
        else if (ctx.isANNOTATED()) {    //alias? annotated
            return; //vyøízeno v exitAnnotated;
        }
        else if (ctx.getMethod() != null) {
            //dodelat nebo vzit z annotated
        }
         alTmp.clear();
         alTmp.addAll(tmp);         
    }
    
    public void enterEqual(EqualContext ctx) {
        _alias = null;
        _isRight = false;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cond ">    
    public void exitCond(CondContext ctx) {
        if (_error) return;        
        
        List<ClassEntity> tmp = new ArrayList();
        
        if (ctx.Equal()) // zpracovat v exitEqual(): equal 
        {
            return;
        }
        else if (ctx.OPERATORS() != null)//:innerSelect OPERATORS alias? NAME
        {                       
            if(ctx.ALIAS() == null)
            {
                // <editor-fold defaultstate="collapsed" desc=" Not Alias ">
                if (ctx.OPERATORS() == Operators.IN) {
                    for (ClassEntity ce : _langContext.get(_depth).result) {
                        boolean isTrue = true;
                        if(_langContext.get(_depth + 1).result.isEmpty()) {
                            isTrue = false;
                        }
                        for (ClassEntity ce2 : _langContext.get(_depth + 1).result) {
                            switch (ctx.NAME().toLowerCase()) {
                                case "import":
                                    if (ce.getImportRelated(ce2.getFQN()) == null)
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "extends":
                                    if (ce.getExtendsRelated(ce2.getFQN()) == null)
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "implements":
                                    if (ce.getImplementsRelated(ce2.getFQN()) == null)
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "name":
                                    if (ce.getName().compareTo(ce2.getName()) != 0)
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                case "fqn":
                                    if (ce.getName().compareTo(ce2.getFQN()) != 0)
                                    {
                                        isTrue = false;
                                    }
                                    break;
                                default:
                                    _error = true;
                                    _errMsg.add(new ErrorMessage("Oèekáváno klíèové slovo ne: " + ctx.NAME(), _error));
                                    return;                                
                            }
                            
                        }
                        if (isTrue) {
                            tmp.add(ce);
                        }
                    }
                } else {
                    _error = true;
                    _errMsg.add(new ErrorMessage("Nepovolený operátor: " + ctx.OPERATORS(), _error));
                    return;
                }

// </editor-fold>
            }
            else    // with alias
            {                    
                // <editor-fold defaultstate="collapsed" desc=" Alias ">
                String alias = ctx.ALIAS();                
                    if (ctx.OPERATORS() == Operators.IN) {
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    boolean isTrue = true;
                                    if(_langContext.get(_depth + 1).result.isEmpty()) {
                                        isTrue = false;
                                    }
                                    for (ClassEntity ce2 : _langContext.get(_depth + 1).result) {
                                        switch (ctx.NAME().toLowerCase()) {
                                            case "import":
                                                if (ce.getImportRelated(ce2.getFQN()) == null) //import extend implement name fqn
                                                {
                                                    isTrue = false;
                                                }
                                                break;
                                            case "extends":
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
                                                _errMsg.add(new ErrorMessage("Oèekáváno klíèové slovo ne: " + ctx.NAME(), _error));
                                                return;                                            
                                        }
                                    }
                                    if (isTrue) {
                                        tmp.add(ce);
                                    }
                                }
                                _langContext.get(i).mapAS.get(alias).clear();
                                _langContext.get(i).mapAS.get(alias).addAll(tmp);
                                return;                                
                            }
                        }
                        if (!found) {
                            _error = true;
                            _errMsg.add(new ErrorMessage("Alias: " + alias + " nebyl nalezen", true));
                            return;
                        }
                    } else {
                        _error = true;
                        _errMsg.add(new ErrorMessage("Nepovolený operátor: " + ctx.OPERATORS(), _error));
                        return;
                    }
// </editor-fold>
            }
        }
        else if (ctx.InnerSelect())//:NAME innerSelect          NAME:(EXIST |NotExist)
        {
            // <editor-fold defaultstate="collapsed" desc=" (Not)?Exist InnerSelect">

            boolean isEmpty = _langContext.get(_depth + 1).result.isEmpty();            
            if (ctx.EXIST()){
                if (!isEmpty) {                    
                    tmp = _langContext.get(_depth).result;
                }
            }
            else if (ctx.NOT_EXIST()) {
                if (isEmpty) {
                    tmp = _langContext.get(_depth).result;
                }
            }
            // </editor-fold>
        }       
        else //: (!)? alias? NAME
        {
            if(ctx.ALIAS() == null)
            {
                // <editor-fold defaultstate="collapsed" desc=" NAME ">
                switch (ctx.NAME().toLowerCase()) {
                    case "class":
                        for (ClassEntity re : _langContext.get(_depth).result) {                            
                            if (re.getType().compareToIgnoreCase("class") == 0) {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "interface":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("interface") == 0) {
                               if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "annotation":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("annotation") == 0) {
                                if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "enum":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.getType().compareToIgnoreCase("enum") == 0) {
                               if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "public":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isPublic()) {
                               if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "protected":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isProtected()) {
                                if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "private":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isPrivate()) {
                                if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "final":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isFinal()) {
                                if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    case "inner":
                        for (ClassEntity re : _langContext.get(_depth).result) {
                            if (re.isInner()) {
                                if(!ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                            else
                            {
                                if(ctx.EXCLAMANTION()) {
                                    tmp.add(re);
                                }
                            }
                        }
                        break;
                    default:
                        _error = true;
                        _errMsg.add(new ErrorMessage("Neoèekávyný vstup: " + ctx.NAME(), _error));
                        return;
                }

// </editor-fold>
            }
            else
            {
                // <editor-fold defaultstate="collapsed" desc=" alias.NAME ">
                String alias = ctx.ALIAS();
                boolean found = false;
                for (int i = _depth; i >= 0; i--) {
                    if (_langContext.get(i).mapAS.containsKey(alias)) {
                        List<ClassEntity> tmc = _langContext.get(i).mapAS.get(alias);
                        switch (ctx.NAME().toLowerCase()) {
                            case "class":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("class") == 0) {
                                       if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "interface":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("interface") == 0) {
                                       if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "annotation":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("annotation") == 0) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "enum":
                                for (ClassEntity re : tmc) {
                                    if (re.getType().compareToIgnoreCase("enum") == 0) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "public":
                                for (ClassEntity re : tmc) {
                                    if (re.isPublic()) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "protected":
                                for (ClassEntity re : tmc) {
                                    if (re.isProtected()) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "private":
                                for (ClassEntity re : tmc) {
                                    if (re.isPrivate()) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "final":
                                for (ClassEntity re : tmc) {
                                    if (re.isFinal()) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            case "inner":
                                for (ClassEntity re : tmc) {
                                    if (re.isInner()) {
                                        if(!ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                    else
                                    {
                                        if(ctx.EXCLAMANTION()) {
                                            tmp.add(re);
                                        }
                                    }
                                }
                                break;
                            default:
                                _error = true;
                                _errMsg.add(new ErrorMessage("Neoèekávyný vstup: " + ctx.NAME(), _error));
                                break;
                        }
                       _langContext.get(i).mapAS.get(alias).clear();
                       _langContext.get(i).mapAS.get(alias).addAll(tmp);                       
                        return;
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
    
    public void enterCond(CondContext ctx) {
        _alias = null;
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Conditions ">
    
    public void enterConditions(ConditionsContext ctx) {
        _langContext.get(_depth)._WHERE = true;
        if (!_langContext.get(_depth)._FROM) {
            _langContext.get(_depth).result = _graphContext.getClassInPackage("*");
            _langContext.get(_depth)._FROM = true;
        }
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" PackageName ">    
    public void exitPackageName(PackageNameContext ctx) {
        if (_error) {
            return;
        }
        
        if (ctx.InnerClass()) {            
            _packageLink.addAll(_langContext.get(_depth + 1).result);
        }
        else if (ctx.EXCLAMANTION() && ctx.STRING() != null) {            
            _packageLink.addAll(_graphContext.getClassInPackage(ctx.STRING()));
        }
        else if(ctx.STRING() != null) {            
            _packageLink.addAll(_graphContext.getClassInPackageRecursion(ctx.STRING()));
        }
    }
        
    public void enterPackageName(PackageNameContext ctx) {
        
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" PackageLink ">    
    public void exitPackageLink(PackageLinkContext ctx) {
        if(ctx.isSTAR()) {
            _packageLink = _graphContext.getClassInPackage("*");
        }
        
        if (ctx.getAS() == null) {            
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
    
    public void enterPackageLink(PackageLinkContext ctx) {
        _as = null;
        this._packageLink = new ArrayList();
    }
    
    // </editor-fold>        
    
    // <editor-fold defaultstate="collapsed" desc=" Packages ">    
    public void exitPackages(PackagesContext ctx) {
                        
    }
        
    public void enterPackages(PackagesContext ctx) {
        _langContext.get(_depth)._FROM = true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ParamName ">    
    public void exitParamName(ParamNameContext ctx) {
        if (ctx.InnerSelect()) {
            _langContext.get(_depth).selectListInner.addAll(_langContext.get(_depth + 1).result);            
        }        
        _langContext.get(_depth).selectListCtx.add(ctx);        
    }
    
    public void enterParamName(ParamNameContext ctx) {
        _alias = null;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" ParamSelect ">    
    public void enterParamSelect(ParamSelectContext ctx) {        
        _langContext.get(_depth)._SELECT = true;        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" SelectStatment ">    
    public void exitSelectStatment(SelectStatmentContext ctx) {
        if (_error) {
            return;
        }        
        
        if (!_langContext.get(_depth)._FROM) {
            if(!_langContext.get(_depth)._SELECT && !_langContext.get(_depth)._WHERE) {
                _error = true;
                _errMsg.add(new ErrorMessage("Špatný vstup.", _error));
                return;
            }
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
        
        for (ParamNameContext select : _langContext.get(_depth).selectListCtx) {            
            if (select.EXCLAMANTION())// ! name | ! alias.name
            {                                
                if (select.NAME().compareToIgnoreCase("extends") == 0) //!name
                    // <editor-fold defaultstate="collapsed" desc=" extends ">
                {
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInExtendsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else { // !alias.name                    
                        String alias = select.ALIAS();
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
                // </editor-fold>
                else if (select.NAME().compareToIgnoreCase("import") == 0) {
                    // <editor-fold defaultstate="collapsed" desc=" Import ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInImportRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else {// !alias.name                    
                        String alias = select.ALIAS();
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
                } // </editor-fold>
                else if (select.NAME().compareToIgnoreCase("implements") == 0) {
                    // <editor-fold defaultstate="collapsed" desc=" Implements ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getInImplementsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else { // !alias.name                    
                        String alias = select.ALIAS();
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

// </editor-fold>
            }
            else if (select.Method() != null && select.NAME().compareToIgnoreCase("call") == 0) { // alias.method[...]                
                if (select.Method().getArg() != null) {                    
                    // <editor-fold defaultstate="collapsed" desc=" Arg ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            for (MethodEntity me : ce.getMethodRelated()) {
                                boolean isTrue = true;
                                for (String key : select.Method().getArg().keySet()) {                                    
                                    switch (key.toLowerCase()) {
                                        case "arg":
                                            String cmp = me.getBriefDescription().replaceFirst(".*\\(", "");
                                            cmp = cmp.replaceFirst("\\).*", "");
                                            if (select.Method().getArg().get(key).compareTo(cmp) != 0) {
                                                isTrue = false;
                                            }
                                            break;
                                        case "name":                                            
                                            if (select.Method().getArg().get(key).compareTo(me.getName()) != 0) {
                                                isTrue = false;
                                            }
                                            break;
                                        default:
                                            isTrue = false;
                                            break;
                                    }
                                }
                                if (!isTrue) {
                                    continue;
                                }
                                for (MethodEntity mic : me.getInCallRelated()) {
                                    tmp.add(mic.getInClassRelated());                                    
                                }
                                if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                    List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                    if (listTMP != null) {
                                        tmp.addAll(listTMP);                                        
                                    }                                    
                                }
                                if (ce.getInExtendsRelated() != null) {
                                    List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                    if (listTMP != null) {
                                        tmp.addAll(listTMP);
                                    }
                                }
                            }
                        }
                    } else {  // s Aliasem
                        String alias = select.ALIAS();
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    for (MethodEntity me : ce.getMethodRelated()) {
                                        boolean isTrue = true;
                                        for (String key : select.Method().getArg().keySet()) {                                            
                                            switch (key.toLowerCase()) {
                                                case "arg":
                                                    String cmp = me.getBriefDescription().replaceFirst(".*\\(", "");
                                                    cmp = cmp.replaceFirst("\\).*", "");
                                                    if (select.Method().getArg().get(key).compareTo(cmp) != 0) {
                                                        isTrue = false;
                                                    }
                                                    break;
                                                case "name":                                                    
                                                    if (select.Method().getArg().get(key).compareTo(me.getName()) != 0) {
                                                        isTrue = false;
                                                    }
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        if (!isTrue) {
                                            continue;
                                        }
                                        for (MethodEntity mic : me.getInCallRelated()) {
                                            tmp.add(mic.getInClassRelated());                                            
                                        }
                                        if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                            List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                            if (listTMP != null) {
                                                tmp.addAll(listTMP);                                                
                                            }                                            
                                        }
                                        if (ce.getInExtendsRelated() != null) {
                                            List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                            if (listTMP != null) {
                                                tmp.addAll(listTMP);
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
                } // </editor-fold>
                else if (select.Method().STAR()) {
                    // <editor-fold defaultstate="collapsed" desc=" STAR ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            for (MethodEntity me : ce.getMethodRelated()) {                                
                                for (MethodEntity mic : me.getInCallRelated()) {
                                    tmp.add(mic.getInClassRelated());                                    
                                }
                                if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                    List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                    if (listTMP != null) {
                                        tmp.addAll(listTMP);                                            
                                    }                                        
                                }
                                if(ce.getInExtendsRelated() != null) {
                                    List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                    if (listTMP != null) {
                                        tmp.addAll(listTMP);
                                    }
                                }
                            }
                        }
                    }
                    else {
                        String alias = select.ALIAS();
                        boolean found = false;
                        for (int i = _depth; i >= 0; i--) {
                            if (_langContext.get(i).mapAS.containsKey(alias)) {
                                for (ClassEntity ce : _langContext.get(i).mapAS.get(alias)) {
                                    for (MethodEntity me : ce.getMethodRelated()) {
                                        for (MethodEntity mic : me.getInCallRelated()) {
                                            tmp.add(mic.getInClassRelated());                                            
                                        }
                                        if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                            List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                            if (listTMP != null) {
                                                tmp.addAll(listTMP);                                            
                                            }                                        
                                        }
                                        if(ce.getInExtendsRelated() != null) {
                                            List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                            if (listTMP != null) {
                                                tmp.addAll(listTMP);
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
// </editor-fold>
                }
                else { //Description
                    // <editor-fold defaultstate="collapsed" desc=" Description ">
                    String strTMP = select.Method().Description().replaceAll("[' ]", "");
                    String paramsTMP = strTMP.replaceFirst("^[\\w<>]*", "").replaceAll("[)(]", "");
                    String[] paramTMP = {};
                    
                    if (paramsTMP.compareTo("") != 0) {
                        paramTMP = paramsTMP.split(",");
                    }
                    
                    String name = strTMP.replaceFirst("\\(.*", "");                    
                    
                    if (select.ALIAS() == null) {
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
                                    if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                        List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                        if (listTMP != null) {
                                            tmp.addAll(listTMP);                                            
                                        }                                        
                                    }
                                    if(ce.getInExtendsRelated() != null) {
                                        List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                        if (listTMP != null) {
                                            tmp.addAll(listTMP);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        String alias = select.ALIAS();
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
                                            if (ce.getType().compareToIgnoreCase("interface") == 0) {
                                                List<ClassEntity> listTMP = callInterface(ce.getInImplementsRelated(), me);
                                                if (listTMP != null) {
                                                    tmp.addAll(listTMP);                                            
                                                }                                        
                                            }
                                            if(ce.getInExtendsRelated() != null) {
                                                List<ClassEntity> listTMP = callInterface(ce.getInExtendsRelated(), me);
                                                if (listTMP != null) {
                                                    tmp.addAll(listTMP);
                                                }
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
                // </editor-fold>
            }
            else if (select.InnerSelect()) { // (inner select)            
                // zùstane prázdne vlození výsledku je na konci metody _langContext.get(_depth+1).seleceListInner
            }
            else if(select.NAME() != null) {// name | name as name                            
                if (select.NAME().compareToIgnoreCase("extends") == 0) {
                    // <editor-fold defaultstate="collapsed" desc=" Extends ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getExtendsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else {
                        String alias = select.ALIAS();
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
                // </editor-fold>
                else if (select.NAME().compareToIgnoreCase("import") == 0) {
                    // <editor-fold defaultstate="collapsed" desc=" Import ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getImportRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else // alias.name
                    {
                        String alias = select.ALIAS();
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
                } // </editor-fold>
                else if (select.NAME().compareToIgnoreCase("implements") == 0) {
                    // <editor-fold defaultstate="collapsed" desc=" Implements ">
                    if (select.ALIAS() == null) {
                        for (ClassEntity ce : _langContext.get(_depth).result) {
                            Iterable<ClassEntity> Related = ce.getImplementsRelated();
                            if (Related != null) {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    } else {
                        String alias = select.ALIAS();
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

// </editor-fold>                
            }
            else if (select.STAR()) { // * | alias.*
                // <editor-fold defaultstate="collapsed" desc=" STAR ">
                if (select.ALIAS() == null) {
                    tmp.addAll(_langContext.get(_depth).result);                    
                } else {
                    String alias = select.ALIAS();
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

// </editor-fold>
        }
        if (!_langContext.get(_depth).selectListInner.isEmpty()) {
            tmp.addAll(_langContext.get(_depth).selectListInner);
        }
        
        _langContext.get(_depth).result = tmp;
        
        if (_depth == 0) {
            _result = _langContext.get(_depth).result;
        }
    }
        
    public void enterSelectStatment(SelectStatmentContext ctx) {        
        if(_langContext.size() > 0 && _langContext.size() > _depth) {         
            _langContext.remove(_depth);
        }         
        _langContext.add(new LangContext());        
    }

    private List<ClassEntity> callInterface(Iterable<ClassEntity> inClassRelated, MethodEntity inMethodRelated) {
        List<ClassEntity> tmp= new ArrayList();
        for(ClassEntity ce: inClassRelated) {
            MethodEntity me = ce.getMethodRelatedBriefDescription(inMethodRelated.getBriefDescription());
            if (me != null) {
                Iterable<MethodEntity> metmp = me.getInCallRelated();
                if (metmp != null) {
                    for (MethodEntity cetmp:metmp) {
                        tmp.add(cetmp.getInClassRelated());
                    }
                }
            }
            if(ce.getInExtendsRelated() != null) {
                tmp.addAll(callInterface(ce.getInExtendsRelated(),inMethodRelated));
            }
            if(ce.getInImplementsRelated() != null) {
                tmp.addAll(callInterface(ce.getInImplementsRelated(),inMethodRelated));
            }
        }
        return tmp;
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

        private List<ClassEntity> result;        
        private List<ParamNameContext> selectListCtx;
        private List<ClassEntity> selectListInner;
        private boolean _SELECT;
        private boolean _FROM;
        private boolean _WHERE;
        Map<String, List<ClassEntity>> mapAS;
        
        LangContext() {
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
