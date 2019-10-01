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
public class CircularLinkedList {
    
    private Node first;
    private Node last;
    private int length;
    private int[] candidates;
    private int[] removed;
    private int[] list_data;
    
    CircularLinkedList(int[] input){ // input[] is in form of {N, k, m}
        first = null;
        last = null;
        length = 0;
        candidates = new int[input[0] + 1];
        removed = new int[input[0] + 1];
        list_data = input;
    }
    
    /**
     * Method to add a node
     * Assumes nodes are added in ascending order
     * @param value 
     */
    public void addNode(int value){
        Node temp = new Node(value);
        
        if (length == 0){
            first = temp;
            first.setNext(temp);
            first.setPrevious(temp);
            length++;
        }
        else{
            temp.setNext(first);
            temp.setPrevious(first.getPrevious());

            first.getPrevious().setNext(temp);
            first.setPrevious(temp);
            
            last = temp;
            length++;
        }
    }
    
    /**
     * Method to find a candidate and delete nodes appropriately
     * @param k_step
     * @param m_step
     * @param initial_values Array with form {k value, m value, next k, next m}
     * @return 
     */
    public int[] findCandidate(int k_step, int m_step, int[] initial_values){
        //System.out.println(this);
        
        Node k_iterator = first;
        while (k_iterator.getNumber() != initial_values[2]){
            k_iterator = k_iterator.getNext();
        }
        
        Node m_iterator = last;
        while (m_iterator.getNumber() != initial_values[3]){
            m_iterator = m_iterator.getPrevious();
        }
        
        for (int i = 0; i < k_step - 1; i++){
            k_iterator = k_iterator.getNext();
        }
        for (int i = 0; i < m_step - 1; i++){
            m_iterator = m_iterator.getPrevious();
        }
        
        int[] results = new int[4];
        results[0] = k_iterator.getNumber();
        
        k_iterator.getNext().setPrevious(k_iterator.getPrevious());
        k_iterator.getPrevious().setNext(k_iterator.getNext());
        testEnds(k_iterator);
        length--;
        
        if (results[0] != m_iterator.getNumber()){
            results[1] = m_iterator.getNumber();
            
            m_iterator.getNext().setPrevious(m_iterator.getPrevious());
            m_iterator.getPrevious().setNext(m_iterator.getNext());
            testEnds(m_iterator);
            length--;
        }
        
        if (k_iterator.getNext() == m_iterator){
            results[2] = k_iterator.getNext().getNext().getNumber();
            results[3] = m_iterator.getPrevious().getPrevious().getNumber();
        }
        else{
            results[2] = k_iterator.getNext().getNumber();
            results[3] = m_iterator.getPrevious().getNumber();
        }
        
        return results;
    }
    
    /**
     * Method to change first/last value of the list
     * if temp is either first or last
     * @param temp 
     */
    private void testEnds(Node temp){
        if (temp == first){
            first = first.getNext();
        }
        else if (temp == last){
            last = last.getNext();
        }
    }
    
    /**
     * Method to add a candidate
     * @param index
     * @param value 
     */
    public void addCandidate(int index, int value){
        candidates[index] = value;
    }
    
    /**
     * Method to add a removed politician
     * @param index
     * @param k_value
     * @param m_value 
     */
    public void addRemoved(int index, int k_value, int m_value){
        removed[index] = k_value;
        removed[index + 1] = m_value;
    }
    
    /**
     * Method to return a shorter array, removing zero values from the array
     * @param array
     * @return 
     */
    private int[] chopTail(int[] array){
        int i = 0;
        while (array[i] > 0){
            i++;
        }
        
        int[] chopped_array = new int[i];
        for (int j = 0; j < i; j++){
            chopped_array[j] = array[j];
        }
        
        return chopped_array;
    }
    
    public String toString(){
        removed = chopTail(removed);
        candidates = chopTail(candidates);
        
        String output = "\nN = " + Integer.toString(list_data[0]) + ", k = " + Integer.toString(list_data[1]) + ", m = " + Integer.toString(list_data[2]) + "\n\n";
        output += "Output\n------\n";
        
        for (int i = 0; i < removed.length; i += 2){
            output += Integer.toString(removed[i]) + " " + Integer.toString(removed[i + 1]) + "\n";
        }
        for (int i = 0; i < candidates.length; i++){
            output += Integer.toString(candidates[i]) + "\n";
        }
        
        return output;
    }
    
    
    /**
     * Getters
     */
    public int getLength(){ return length; }
}
