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
public class Node {
    
    private String name;
    private Node next = null;
    
    Node(String value){
        name = value;
    }
    
    public void setNext(Node temp){ next = temp; }
    
    public Node getNext(){ return next; }
    public String getName(){ return name; }
    public String toString(){ return name; }
}
