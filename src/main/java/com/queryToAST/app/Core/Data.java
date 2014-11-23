/*
 * Dodelat pridavání Argumentu pøi volání funkcí TODO _arguments
 * 
 */
package com.queryToAST.app.Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class Data {

    private boolean _isFinal = false;
    private boolean _isStatic = false;
    private boolean _isSuper = false;
    private boolean _isabstract = false;    
    private boolean _isSynchronized = false;
    private boolean _isVolatile = false;
    private TypFile _typFile = null;
    private String _name = null;
    private String _retVal = null;
    private TypModifier _typMod = null;
    private List<Arg> _arguments = null;
    
    public Data(String name, TypFile typFile){
        _name = name;
        _typFile = typFile;
    }

    public Data(boolean isStatic, boolean isFinal, String retVal, String name) {        
        _isStatic = isStatic;
        _isFinal = isFinal;
        _retVal = retVal;
        _name = name;        
    }

    public String getRetVal() {
        return _retVal;
    }
    
    public String getName() {
        return _name;
    }
    
    /**
     * For Class file
     * @param _datatype
     * @param _name
     */
    public void addArg(String _datatype, String _name){
        Arg arg = new Arg();
        arg._datatyp =_datatype;
        arg._name = _name;
        
        if(_arguments == null)
            _arguments = new ArrayList<Arg>();
        
        _arguments.add(arg);
    }
    
    
    
    public Iterator<Arg> getArg(){
        return _arguments.iterator();
    }
    
    public TypModifier getTypMod() {
        return _typMod;
    }
    
    public boolean isIsFinal() {
        return _isFinal;
    }

    public void setIsFinal(boolean _isFinal) {
        this._isFinal = _isFinal;
    }

    public boolean isIsStatic() {
        return _isStatic;
    }

    public void setIsStatic(boolean _isStatic) {
        this._isStatic = _isStatic;
    }

    public boolean isIsabstract() {
        return _isabstract;
    }

    public void setIsabstract(boolean _isabstract) {
        this._isabstract = _isabstract;
    }

    public boolean isIsSynchronized() {
        return _isSynchronized;
    }

    public void setIsSynchronized(boolean _isSynchronized) {
        this._isSynchronized = _isSynchronized;
    }

    public boolean isIsVolatile() {
        return _isVolatile;
    }

    public void setIsVolatile(boolean _isVolatile) {
        this._isVolatile = _isVolatile;
    }
    
    public static class Arg {
        private String _datatyp;
        private String _name;
    }
    
    public void setTypMod(TypModifier _typMod) {
        this._typMod = _typMod;
    }

    public boolean isIsSuper() {
        return _isSuper;
    }

    public void setIsSuper(boolean _isSuper) {
        this._isSuper = _isSuper;
    }
    
    public TypFile getTypFile() {
        return _typFile;
    }

    @Override
    public String toString() {
        return "Data{" + "_isFinal=" + _isFinal + ", _isStatic=" + _isStatic + ", _isSuper=" + _isSuper + ", _isabstract=" + _isabstract + ", _isSynchronized=" + _isSynchronized + ", _isVolatile=" + _isVolatile + ", _typFile=" + _typFile + ", _name=" + _name + ", _typMod=" + _typMod + ", _arguments=" + _arguments + '}';
    }
    
}
