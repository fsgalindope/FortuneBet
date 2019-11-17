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
public class QueueRefGeneric<T> {
    private NodeGeneric<T> front,rear;
    

    
    
    public QueueRefGeneric(){
        front =null;
        rear=null;
    }
     public boolean empty() {
        return front==null;
    }
     public T dequeue(){
         if (empty())
            throw new RuntimeException("esta vacio") ;
        T i = front.getData();
        front=front.getNext();
        
        if (front==null){
            rear=null;
            
        }
        return i; 
     }
     public void enqueue(T item){
         NodeGeneric<T> newp = new NodeGeneric<T> (item);
        if(rear!=null){
            rear.setNext(newp) ;
        }else{
            front = newp;}
        rear =newp;
        
     }
     
    
}
