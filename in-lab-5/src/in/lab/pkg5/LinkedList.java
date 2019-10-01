/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg5;

/**
 *
 * @author natha
 */
public class LinkedList {
    
    private Node first;
    private Node last;
    
    LinkedList(){
        first = null;
        last = null;
    }
    
    public void addItem(Node temp){
        if (first == null){
            first = temp;
            last = temp;
        }
        else{
            last.setNext(temp);
            last = temp;
        }
    }
    
    public boolean deleteItem(String name){
        Node iterator = first;
        Node lag_pointer = first;
        while (iterator != null){
            if (name.equals(iterator.getName())){
                if (iterator == first){
                    first = first.getNext();
                }
                else{
                    lag_pointer.setNext(iterator.getNext());
                }
                
                return true;
            }
            lag_pointer = iterator;
            iterator = iterator.getNext();
        }
        
        return false;
    }
    
    public void printList()
    {
        Node iterator = first;
        String output = "";

        while (iterator != null){
            output += iterator.toString();
            iterator = iterator.getNext();
            if (iterator != null){
                output += ", ";
            }
        }
        
        System.out.println(output);
    }
    
    public void clearList(){ first = null; }
    
}
