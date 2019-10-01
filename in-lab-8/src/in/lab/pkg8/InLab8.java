/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg8;
import java.util.Random;

/**
 *
 * @author natha
 */
public class InLab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(recur("Go Bobcats! ", 3));
        int[] array_lengths = new int[] { 20, 100, 500, 1000, 10000 };
        for (int i = 0; i < array_lengths.length; i++){
            int[] unsorted_array = new int[array_lengths[i]];
            Random rand_num_gen = new Random();
            for (int j = 0; j < array_lengths[i]; j++){
                unsorted_array[j] = rand_num_gen.nextInt(100);
            }
            
            long start_time = System.currentTimeMillis();
            int[] insertion_sorted_array = insertionSort(unsorted_array);
            long fin_time = System.currentTimeMillis();
            printArray(insertion_sorted_array);
            System.out.println("The time in milliseconds to sort " + Integer.toString(array_lengths[i]) + " items using insetion sort is " 
                    + Long.toString(fin_time - start_time) + ".");
            
            start_time = System.currentTimeMillis();
            int[] bubble_sorted_array = bubbleSort(unsorted_array);
            fin_time = System.currentTimeMillis();
            printArray(bubble_sorted_array);
            System.out.println("The time in milliseconds to sort " + Integer.toString(array_lengths[i]) + " items using bubble sort is " 
                    + Long.toString(fin_time - start_time) + ".\n");
        }
    }
    
    public static String recur(String phrase, int count){
        if (count == 1)
            return phrase;
        else
            return phrase + recur(phrase, count - 1);
    }
    
    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
    
    public static int[] bubbleSort(int[] array){
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 1; i < array.length; i++){
                if (array[i] < array[i - 1]){
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;
                }
            }
        }
        return array;
    }
    
    public static void printArray(int[] array){
        String output = "Array: { " + Integer.toString(array[0]);
        for (int i = 1; i < array.length; i++){
            output += ", " + Integer.toString(array[i]);
        }
        output += " }";
        System.out.println(output);
    }
}
