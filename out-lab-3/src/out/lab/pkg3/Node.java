/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg3;

/**
 *
 * @author natha
 */
public class Node {
    
    private Node next = null;
    private Node previous = null;
    private int id_number;
    private String first_name;
    private String last_name;
    
    /**
     * Constructor method
     * @param p_id_number
     * @param p_last_name
     * @param p_first_name 
     */
    Node(int p_id_number, String p_last_name, String p_first_name){
        id_number = p_id_number;
        first_name = p_first_name;
        last_name = p_last_name;
    }
    
    /* 
    * Getters, setters, and output methods
    */
    public void setNext(Node temp){ next = temp; }
    public void setPrevious(Node temp){ previous = temp; }
    public Node getNext(){ return next; }
    public Node getPrevious(){ return previous; }
    public int getStudentID(){ return id_number; }
    public String getLastName(){ return last_name; }
    public String toString(){ return "Sutdent ID: " + (id_number) 
            + " | Name: " + first_name.substring(0,1).toUpperCase() 
            + first_name.substring(1) + " " 
            + last_name.substring(0, 1).toUpperCase() 
            + last_name.substring(1) + "\n"; }
    
}
