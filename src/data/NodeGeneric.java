/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author FABIa
 */
public class NodeGeneric<T> {
    private T data;
    private NodeGeneric<T> next;
    
    public NodeGeneric(){
        this(null);
    
    }
    public NodeGeneric(T data){
        this.data=data;
        next=null;
    }

    public T getData() {
        return data;
    }

    public NodeGeneric<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }
    
    
    
}

