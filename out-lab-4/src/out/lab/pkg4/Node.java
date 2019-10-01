/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg4;

/**
 *
 * @author natha
 */
public class Node {
    
    private Node next;
    private Node previous;
    private int number; 
    
    Node(int value){
        number = value;
    }
    
    /**
     * Method to return politician number
     * @return 
     */
    public String toString(){ return Integer.toString(number) + " "; }
    
    /* 
     * Getters and setters
     */
    public void setNext(Node temp){ next = temp; }
    public void setPrevious(Node temp){ previous = temp; }   
    public Node getNext(){ return next; }
    public Node getPrevious(){ return previous; }
    public int getNumber(){ return number; }
}
