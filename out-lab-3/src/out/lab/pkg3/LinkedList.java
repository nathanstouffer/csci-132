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
public class LinkedList {
    
    private Node first;
    private Node last;
    
    LinkedList(){
        first = null;
        last = null;
    }
    
    /**
     * Method to add a node to the linked list in numerical order (alphabetical in a tie)
     * @param temp 
     */
    public void addInOrder(Node temp){
        if (first == null){
            first = temp;
        }
        else if (last == null){
            if (compareNodes(temp, first)){
                temp.setNext(first);
                first.setPrevious(temp);
                last = first;
                first = temp;
            }
            else{
                first.setNext(temp);
                temp.setPrevious(first);
                last = temp;
            }
        }
        else{        
            if (compareNodes(temp, first)){
                temp.setNext(first);
                first.setPrevious(temp);
                first = temp;
            }
            else{            
                Node iterator = first.getNext();
                boolean run_loop = true;
                while (run_loop){
                    if (compareNodes(temp, iterator)){
                        temp.setNext(iterator);
                        temp.setPrevious(iterator.getPrevious());
                        iterator.getPrevious().setNext(temp);
                        iterator.setPrevious(temp);
                        run_loop = false;
                    }
                    else if (iterator.getNext() == null){
                        run_loop = false;
                        last.setNext(temp);
                        temp.setPrevious(last);
                        last = temp;
                    }
                    
                    iterator = iterator.getNext();
                }
            }          
        }
    }
    
    /**
     * Method to compare the relative order of two nodes
     * Returns true if the second should go in front of the first
     * @param first
     * @param second
     * @return 
     */
    public boolean compareNodes(Node first, Node second){
        if (second.getStudentID() > first.getStudentID()){
            return true;
        }
        else if (second.getStudentID() == first.getStudentID()){
            char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            int[] numbers = new int[26];
            for (int i = 0; i < 26; i++){
                numbers[i] = i + 1;
            }
            
            for (int i = 0; i < first.getLastName().length(); i++){
                char first_char = first.getLastName().toLowerCase().charAt(i);
                char second_char = second.getLastName().toLowerCase().charAt(i);
                
                int j = 0;
                int first_int = 0;
                int second_int = 0;
                boolean run_loop = true;
                while (run_loop && j < 26){
                    if (first_char == alphabet[j]){
                        first_int = numbers[j];
                    }
                    if (second_char == alphabet[j]){
                        second_int = numbers[j];
                    }
                    if (first_int != 0 && second_int != 0){
                        run_loop = false;
                    }
                    
                    j++;
                }
                
                if (second_int > first_int){
                    return true;
                }
                else if (second_int < first_int){
                    return false;
                }
            }
            
            return true; // Can just return true because there is a guaranteed return in the for-loop
        }
        
        return false;
    }
    
    /**
     * Method to remove an item in the linked list
     * @param temp
     * @return 
     */
    public boolean removeItem(Node temp){
        Node iterator = first;
        
        if (iterator.toString().equals(temp.toString())){
            first = first.getNext();
            first.setPrevious(null);
            return true;
        }
        else{
            iterator = iterator.getNext();
            while (iterator != null){               
                if (iterator.toString().equals(temp.toString())){
                    iterator.getPrevious().setNext(iterator.getNext());
                    iterator.getPrevious().setPrevious(iterator.getPrevious());
                    return true;
                }
                
                iterator = iterator.getNext();
            }
        }
        
        return false;
    }
    
    /**
     * Method to print the linked list forwards
     * @param backwards
     * @return 
     */    
    public String toString(){
        Node iterator = first;
        String output = "Stduent Data:\n";
        
        while (iterator != null){
            output += iterator.toString();
            iterator = iterator.getNext();
        }
        
        return output;
    }
    
    /**
     * Method to print the list backwards
     * @return 
     */
    public String printBackwards(){
        Node iterator = last;
        String output = "Stduent Data:\n";

            while (iterator != null){
                output += iterator.toString();
                iterator = iterator.getPrevious();
            }
            
        return output;
    }
    
    /**
     * Method to delete linked list
     */
    public void delete(){ first = null; last = null; }
    
}
