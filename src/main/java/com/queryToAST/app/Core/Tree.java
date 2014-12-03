/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queryToAST.app.Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Niriel
 */
public class Tree<T> {
    private Node<T> _root;
    
    public Tree(T rootData) {
        _root = new Node<T>();
        _root.data = rootData;
        _root.children = new ArrayList<Node<T>>();
    }
    
    public Node<T> getRoot(){
        return _root;
    }
    
    public Node<T> addRootChild(T data) {
        return _root.addChild(data);
    }
    
    private String getChildren(Node<T> parent, String tab){
        String out = parent.data.toString();
        for(Node<T> node: parent.children){
            out += "\n" + tab + getChildren(node,tab + "+---");
        }
        return out;
    }
    @Override
    public String toString() {
        String out;
        out = "Tree: ";
        out += getChildren(_root, "+-> ");
        return out;
    }
    
    
    public static class Node<T> {
        private T data;
        private Node<T> Parent;
        private List<Node<T>> children;
        
        public Node<T> addChild(T data){
            Node<T> node = new Node<T>();
            node.data = data;
            node.Parent = this;
            node.children = new ArrayList<Node<T>>();
            this.children.add(node);
            return node;
        }
        
        public List<Node<T>> getChildren(){
            return this.children;
        }
        
        public <T> T getdata(){
            return (T)this.data;
        }
        public Node<T> remove(){
            for(Node<T> node : this.Parent.children){
                if(this == node) {
                    Node<T> oldNode = node;
                    this.Parent.children.remove(node);
                    return oldNode;
                }
            }
            return null;
        }
    }
}
