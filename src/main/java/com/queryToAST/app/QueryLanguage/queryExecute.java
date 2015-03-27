/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.QueryLanguage;

import com.google.common.collect.Lists;
import com.queryToAST.app.Graph.GraphContext;
import com.queryToAST.app.Graph.Vertex.AnnParaEntity;
import com.queryToAST.app.Graph.Vertex.AnnotatedEntity;
import com.queryToAST.app.Graph.Vertex.ClassEntity;
import com.queryToAST.app.Graph.Vertex.MethParaEntity;
import com.queryToAST.app.Graph.Vertex.MethodEntity;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Niriel
 */
public class queryExecute extends queryBaseListener{
    private GraphContext _graphContext = null;
    private List<LangContext> _langContext = new ArrayList();    
    private int _depth = 0;        
    private List<AnnParaEntity> tmpAnnValue;
    public GraphContext getContext() {
        return _graphContext;
    }

    public void setContext(GraphContext context) {
        this._graphContext = context;
    }    
    
    public List<ClassEntity> getResult(){
        return _langContext.get(_depth).result;
    }
    
    @Override
    public void visitErrorNode(ErrorNode node) {
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

    
    
    @Override
    public void exitAnnotated(queryParser.AnnotatedContext ctx) {
        if(_langContext.get(_depth).error) return;
        tmpAnnValue = new ArrayList();
        
        List<ClassEntity> tmp = new ArrayList();
        queryParser.AnnotatedStatmentContext as = ctx.annotatedStatment();
        String name = as.annotatedName().NAME().getText();        
        
        for(ClassEntity ce:_langContext.get(_depth).result)
        {   
            boolean isAE = true;
            boolean isAnnotated = true;
            AnnParaEntity ann = null;
            AnnotatedEntity ar = ce.getAnnotatedRelated(name);
            if(ar != null)  //@NAME
            {
                for(int i = 0; i < as.annotatedParams().size(); i++)
                {
                    queryParser.AnnotatedParamsContext apc = as.annotatedParams().get(i);
                    if(apc.NAME() != null)
                    {
                        if(apc.index() != null) //@NAME.NAME INDEX
                        {   
                                if(isAE)
                                { 
                                    ann = ar.getAnnParaRelated(apc.NAME().getText());                                   
                                    if(ann != null)
                                    {
                                        ann = ann.getIndexRelated(Integer.parseInt(apc.index().INT().getText()));
                                        if(ann == null)
                                        {
                                            isAnnotated = false;
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        isAnnotated = false;
                                        break;
                                    }
                                    isAE = false;
                                }
                                else
                                {
                                    ann = ann.getAnnParaRelated(apc.NAME().getText());
                                    if(ann != null)
                                    {
                                        ann = ann.getIndexRelated(Integer.parseInt(apc.index().INT().getText()));
                                        if(ann == null)
                                        {
                                            isAnnotated = false;
                                            break;
                                        }                                        
                                    }
                                    else
                                    {
                                        isAnnotated = false;
                                        break;
                                    }
                                    
                                }
                                System.out.println("name index : " + ann.getName());
                        }
                        else    //@NAME.NAME
                        {
                            if(isAE)
                            {
                                ann = ar.getAnnParaRelated(apc.NAME().getText());
                                if(ann == null)
                                {
                                    isAnnotated = false;
                                    break;
                                }
                                isAE = false;
                            }
                            else
                            {
                                ann = ann.getAnnParaRelated(apc.NAME().getText());
                                if(ann == null)
                                {
                                    isAnnotated = false;
                                    break;
                                }
                            }
                            System.out.println("name : " + ann.getName() + ann.getValue());
                        }
                    }                    
                    else if(apc.annotatedName() != null)//@NAME.NAME.@NAME
                    {
                        if(apc.annotatedName().NAME().getText().compareTo(ann.getName()) == 0)
                        {
                            System.out.println("@name : " + ann.getName());
                        }
                        else
                        {
                            isAnnotated = false;
                            break;
                        }
                    }
                }
            }
            else
            {
                isAnnotated = false;
                break;
            }
            
            if(isAnnotated)
            {
                tmpAnnValue.add(ann);
                tmp.add(ce);
            }
        }
        _langContext.get(_depth).result = tmp;
    }
    
    @Override
    public void exitAssignment(queryParser.AssignmentContext ctx) {
        if(_langContext.get(_depth).error) return;
        
        if(ctx.NAME() != null)
        {
            _langContext.get(_depth).id.add(ctx.ID_DOLLAR().getText(), ctx.NAME().getText());
        }
        else if(ctx.ID_SLASH() != null)
        {
            _langContext.get(_depth).id.add(ctx.ID_DOLLAR().getText(), ctx.NAME().getText());
        }
        else if(ctx.annotated() != null)
        {
            for(AnnParaEntity tav:tmpAnnValue)
            {
                if(tav.getValue() != null)
                {
                    _langContext.get(_depth).id.add(ctx.ID_DOLLAR().getText(), tav.getValue());
                }
                else
                {
                    System.out.println("Error assigment annotace is null!!");
                }
            }
        }
    }
    
    @Override
    public void exitEqual(queryParser.EqualContext ctx) {
        if(_langContext.get(_depth).error) return;        
        List<ClassEntity> tmp = new ArrayList();
        if(ctx.NAME() != null)
        {
            if(ctx.STRING() != null) //name = STRING
            {
                for(ClassEntity ce :_langContext.get(_depth).result)
                {
                    if(ctx.NAME().getText().compareToIgnoreCase("name") == 0)
                    {
                        if(ce.getName().compareTo(ctx.STRING().getText().replaceAll("'", "")) == 0)
                        {
                            tmp.add(ce);                            
                        }
                    }
                    else if(ctx.NAME().getText().compareToIgnoreCase("fqn") == 0)
                    {
                        if(ce.getFQN().compareTo(ctx.STRING().getText().replaceAll("'", "")) == 0)
                        {
                            tmp.add(ce);
                        }
                    }
                }
            }
            else if(ctx.ID_SLASH() != null) //name = \1
            {
                for(ClassEntity ce : _langContext.get(_depth).result)
                {
                    if(ctx.NAME().getText().compareToIgnoreCase("name") == 0)
                    {
                        for( AnnParaEntity tav : tmpAnnValue)
                        {                        
                            if(tav.getValue().compareTo(ce.getName())==0)
                            {
                                tmp.add(ce);
                                break;
                            }
                        }
                    }
                    else if(ctx.NAME().getText().compareToIgnoreCase("fqn") == 0)
                    {
                        for( AnnParaEntity tav : tmpAnnValue)
                        {                        
                            if(tav.getValue().compareTo(ce.getFQN())==0)
                            {
                                tmp.add(ce);
                                break;
                            }
                        }
                    }
                }
            }
        }
        else if(ctx.annotated() != null)
        {
            if(ctx.STRING() != null)    //@annotation.value = STRING
            {
                for(int i =0; i < tmpAnnValue.size() ; i++)
                {
                    if(tmpAnnValue.get(i).getValue() != null && ctx.STRING()
                            .getText().replaceAll("'","").compareTo(tmpAnnValue.get(i).getValue()) == 0)
                    {                        
                        tmp.add(_langContext.get(_depth).result.get(i));
                    }
                }
            }
            else if(ctx.ID_SLASH() != null) //@annotation.value = \1
            {
                for(int i =0; i < tmpAnnValue.size() ; i++)
                {
                    if(tmpAnnValue.get(i).getValue()!= null)
                    {
                        for(String str:_langContext.get(_depth-1).id.get(ctx.ID_SLASH().getText()))
                        {
                            if(str.compareTo(tmpAnnValue.get(i).getValue()) == 0)
                            {
                                tmp.add(_langContext.get(_depth).result.get(i));
                                break;
                            }
                        }
                    }
                }
            }
            else
            {
                return;
            }
        }
        _langContext.get(_depth).result = tmp;
    }

    @Override
    public void exitCond(queryParser.CondContext ctx) {
        if(_langContext.get(_depth).error) return;
        if(ctx.NAME() == null) return;
        
        List<ClassEntity> tmp = new ArrayList();
        if(ctx.getChildCount()==1)
        {
            if(ctx.NAME() != null)
            {
                if(ctx.NAME().getText().compareToIgnoreCase("class") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.getType().compareToIgnoreCase("class") == 0)
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("interface") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.getType().compareToIgnoreCase("interface") == 0)
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("annotation") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.getType().compareToIgnoreCase("annotation") == 0)
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("enum") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.getType().compareToIgnoreCase("enum") == 0)
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("public") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.isPublic())
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("protected") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.isProtected())
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("private") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.isPrivate())
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("final") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.isFinal())
                      {
                          tmp.add(re);
                      }
                    }
                }
                else if(ctx.NAME().getText().compareToIgnoreCase("inner") == 0)
                {
                    for(ClassEntity re:_langContext.get(_depth).result)
                    {
                      if(re.isInner())
                      {
                          tmp.add(re);
                      }
                    }
                }
            }
            else if (ctx.innerSelect() != null)
            {
                
            }       
        }
        if(ctx.getChildCount()==3)
        {
            if(ctx.NAME() != null)
            {
                if(ctx.NAME().getText().compareToIgnoreCase("name") == 0)
                {
                    
                }                
            }
        }
        _langContext.get(_depth).result = tmp;
    }

    @Override
    public void exitPackageName(queryParser.PackageNameContext ctx) {
        if(_langContext.get(_depth).error) return;
        if(ctx.getChildCount()==2)
        {
            _langContext.get(_depth).result.addAll(_graphContext.getClassInPackage(ctx.STRING().getText()));
        }
        else
        {
            _langContext.get(_depth).result.addAll(_graphContext.getClassInPackageRecursion(ctx.STRING().getText()));
        }        
    }

    @Override
    public void exitPackages(queryParser.PackagesContext ctx) {
        if(_langContext.get(_depth).error) return;
        if(ctx.getChildCount()==1 && ctx.STAR() != null)
        {
            List<ClassEntity> tmp = _graphContext.getClassInPackage(ctx.STAR().getText());
            if(!_graphContext.isError())
            {
                if(tmp != null)
                {
                    _langContext.get(_depth).result.addAll(tmp);
                }
            }
            else
            {
                _langContext.get(_depth).error = true;
            }
        }
    }

    @Override
    public void exitParamName(queryParser.ParamNameContext ctx) {
        _langContext.get(_depth).selectList.add(ctx);
    }

    @Override
    public void exitSelectStatment(queryParser.SelectStatmentContext ctx) {
        if(_langContext.get(_depth).error) return;
        if(!_langContext.get(_depth)._FROM)
        {
             _langContext.get(_depth).result = _graphContext.getClassInPackage("*");
            _langContext.get(_depth)._FROM = true;
        }
        List<ClassEntity> tmp = new ArrayList();
        
        for(queryParser.ParamNameContext select:_langContext.get(_depth).selectList)
        {
            if(select.getChildCount() == 1)
            {
                if(select.NAME() != null)
                {                    
                    if(select.NAME().getText().compareToIgnoreCase("extend") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> extendsRelated = ce.getExtendsRelated();
                            if(extendsRelated !=null)
                            {
                                tmp.addAll(Lists.newArrayList(extendsRelated));
                            }
                        }
                    }
                    else if(select.NAME().getText().compareToIgnoreCase("import") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> Related = ce.getImportRelated();
                            if(Related !=null)
                            {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else if(select.NAME().getText().compareToIgnoreCase("implements") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> Related = ce.getImportRelated();
                            if(Related !=null)
                            {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                        
                }
                else if(select.STAR() != null)
                {
                    //bere vse takze nic nedela
                }                
            }
            else if(select.getChildCount() ==  2)
            {
                if(select.EXCLAMANTION() != null && select.NAME() != null)
                {
                    if(select.NAME().getText().compareToIgnoreCase("extend") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> Related = ce.getInExtendsRelated();
                            if(Related !=null)
                            {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else if(select.NAME().getText().compareToIgnoreCase("import") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> Related = ce.getInImportRelated();
                            if(Related !=null)
                            {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }
                    else if(select.NAME().getText().compareToIgnoreCase("implements") == 0)
                    {
                        for(ClassEntity ce:_langContext.get(_depth).result)
                        {
                            Iterable<ClassEntity> Related = ce.getInImplementsRelated();
                            if(Related !=null)
                            {
                                tmp.addAll(Lists.newArrayList(Related));
                            }
                        }
                    }                    
                }
            }
            else if(select.getChildCount() == 4)
            {
                if(select.NAME() != null && select.NAME().getText().compareToIgnoreCase("call") == 0)
                {                   
                    if(select.method() != null)
                    {   
                        if(select.method().getChildCount()!=1){
                            for(int i =0; i < select.method().getChildCount();i++){
                                //rozèíøení dotazy na casti methody !!!
                            }
                        }
                        else
                        {
                            String strTMP = select.method().STRING(0).getText().replaceAll("[\" ]", "");
                            String paramsTMP = strTMP.replaceFirst("^\\w*", "").replaceAll("[)(]", "");
                            String[] paramTMP = {};
                            if(paramsTMP.compareTo("") != 0)
                                paramTMP = paramsTMP.split(",");                            
                            String name = strTMP.replaceFirst("\\(.*", "");
                            
                            for(ClassEntity re:_langContext.get(_depth).result)
                            {                                
                                for(MethodEntity me:re.getMethodRelated(name))
                                {   
                                    if(me.getCountPara() != paramTMP.length)
                                    {
                                        continue;
                                    }
                                    
                                    boolean isTrueMethod=true;
                                    for(MethParaEntity mpr:me.getMethParaRelated())
                                    {
                                        if(mpr.getFQN().compareTo(paramTMP[mpr.getIndex()]) != 0)
                                        {                                                                                    
                                            isTrueMethod = false;
                                        }
                                    }
                                    if(isTrueMethod)
                                    {
                                        for(MethodEntity mic:me.getInCallRelated())
                                        {
                                            tmp.add(mic.getInClassRelated());                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }          
        }
        if(!_langContext.get(_depth).selectList.isEmpty())
        {            
            _langContext.get(_depth).result = tmp;
        }
    }

    @Override
    public void enterConditions(queryParser.ConditionsContext ctx) {
        _langContext.get(_depth)._WHERE=true;
        if(!_langContext.get(_depth)._FROM)
        {
            _langContext.get(_depth).result = _graphContext.getClassInPackage("*");
            _langContext.get(_depth)._FROM = true;
        }
    }        
    
    @Override
    public void enterPackages(queryParser.PackagesContext ctx) {
        _langContext.get(_depth)._FROM = true;
    }

    @Override
    public void enterParamSelect(queryParser.ParamSelectContext ctx) {
        _langContext.get(_depth)._SELECT = true;
    }

    @Override
    public void enterSelectStatment(queryParser.SelectStatmentContext ctx) {
        _langContext.add(new LangContext());
    }

    
    public class ErrorMessage {
        public String message;
        public int line;
        public int charPositionInLine;                
    }    
    
    public class LangContext
    {
        private List<ErrorMessage> errorMessage;
        private List<ClassEntity> result;
        private Identifier id;
        private boolean error;
        private List<queryParser.ParamNameContext> selectList;
        private boolean _SELECT;
        private boolean _FROM;
        private boolean _WHERE;
        
        LangContext()
        {
            errorMessage = new ArrayList();
            result = new ArrayList();
            id = new Identifier();
            error = false;
            selectList = new ArrayList();
            _SELECT = false;
            _FROM = false;
            _WHERE = false;
        }
    }
    
    public class Identifier
    {
        private List<Variable> variable;
        Identifier()
        {
            variable=new ArrayList();
        }
        public void add(String id, String value)
        {            
            boolean noFind = true;
            for(Variable v:variable)
            {
                if(v.id.compareTo(id) == 0)
                {
                    noFind = false;
                    v.value.add(value);
                }
            }
            if(noFind)
            {
                Variable v = new Variable();
                v.id = id;
                v.value.add(value);
                variable.add(v);
            }
        }
        public List<String> get(String id)
        {
            id = id.replaceFirst("\\\\", "$");
            for(Variable v:variable)
            {
                if(v.id.compareTo(id) == 0)
                {
                    return v.value;
                }
            }
            return null;
        }
    }
    
    public class Variable
    {
        private String id = null;
        private List<String> value = new ArrayList();
    }
}
