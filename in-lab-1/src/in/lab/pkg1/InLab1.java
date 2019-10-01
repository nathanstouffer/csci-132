/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg1;
import java.util.Random;

/**
 *
 * @author natha
 */
public class InLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random randInt = new Random();
                
        int[] rand_array = new int[10];
        for (int i = 0; i < 10; i++){
            rand_array[i] = randInt.nextInt(10) + 1; 
            /* The random number generator goes from 0 up to (but not including) the argument (10). Shifting the distribution by 1 does not
            *  the probabilities and is still random, but it does get the numbers in the right range (1-10)
            */
        }
        System.out.print("Randomly Generated Array: { ");
        for (int i = 0; i < 10; i++){
            System.out.print(rand_array[i] + " ");
        }
        System.out.println("}");
        
        Reverse_Array(rand_array); // Part two
        Second_largest_element(rand_array); // Part three
        Average_value(rand_array); // Part four
        Histogram(rand_array); // Part six
        Frequency(rand_array); // Part seven
                
    }
    
    public static void Reverse_Array(int[] array){ // Part two
        System.out.print("Reversed Array: { ");
        for (int i = array.length - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println("}");
    }
    
    public static void Second_largest_element(int[] array){ // Part three
        int largest_element = array[0];
        for (int i = 1; i < array.length; i++){
            if (largest_element < array[i]){
                largest_element = array[i];
            }
        }
        
        int[] largest_element_indexes = new int[array.length];
        int ia = 0;
        for (int i = 0; i < array.length; i++){
            if (largest_element == array[i]){
                largest_element_indexes[ia] = i;
                ia++;
            }
        }
        
        ia = 0;
        int second_largest_element = array[0];
        for (int i = 1; i < array.length; i++){
            if (i == largest_element_indexes[ia]){
                ia++;
            }
            else if (second_largest_element < array[i]){
                second_largest_element = array[i];
            }
        }
        
        System.out.println("Second Largest Element: " + second_largest_element);
    }
    
    public static void Average_value(int[] array){ // Part four
        int average = 0;
        for (int i = 0; i < array.length; i++){
            average += array[i];
        }
        average /= array.length;
        
        System.out.println("Average value: " + average);
    }
    
    public static void Histogram(int[] array){ // Part six
        System.out.println("Histogram:");
        for (int i = 0; i < array.length; i++){
            for (int ia = 0; ia < array[i]; ia++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void Frequency(int[] array){ // Part seven
        int[] frequency_array = new int[array.length];
        for (int i = 0; i < array.length; i++){
            frequency_array[array[i] - 1] += 1;
        }
        
        for (int i = 0; i < frequency_array.length; i++){
            if (frequency_array[i] != 0){
                System.out.println("The number " + (i + 1) + " is in the array " + frequency_array[i] + " times.");
            }
        }
    }
}
