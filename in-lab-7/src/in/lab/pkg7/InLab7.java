/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg7;

/**
 *
 * @author natha
 */
public class InLab7 {
    
    /**Add the following items to your heap: 15, 5, 8, 4, 9, 22, 17, 6, 14
     * Print Heap (loop that prints the array, in the proper order)
     * Remove two items from the heap.
     * Print Heap
     * Add the following 18, 12
     * Print Heap
     * Remove three items from the heap.
     * Print Heap
     * /
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    public static void Start(){
        Heap heap = new Heap();
        
        int[] initial_values = new int[] { 15, 5, 8, 4, 9, 22, 17, 6, 14 };
        for (int i = 0; i < initial_values.length; i++){
            heap.addValue(initial_values[i]);
        }
        
        System.out.println(heap);
        System.out.println("----------------");
        
        for (int i = 0; i < 2; i++){
            heap.delete();
        }
        
        System.out.println(heap);
        System.out.println("----------------");
        
        int[] new_values = new int[] { 18, 12 };
        for (int i = 0; i < new_values.length; i++){
            heap.addValue(new_values[i]);
        }
        
        System.out.println(heap);
        System.out.println("----------------");
        
        for (int i = 0; i < 3; i++){
            heap.delete();
        }
        
        System.out.println(heap);
        System.out.println("----------------");
    }
    
}
