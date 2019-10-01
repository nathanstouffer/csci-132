/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg6;
import java.util.Scanner;

/**
 *
 * @author natha
 */
public class InLab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        start();
    }
    
    public static int findLength(String word){
        if (word.equals("")){
            return 0;
        }
        else{
            return 1 + findLength(word.substring(1));
        }
    }
    
    public static void start(){
        System.out.println(findLength("ass"));
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word to test if it is palindromic: ");
        String input = scan.nextLine();
        
        boolean palindromic = palindrome(input);
        if (palindromic){
            System.out.println(input + " is a palindrome.\n");
        }
        else{
            System.out.println(input + " is not a palindrome.\n");
        }
        
        System.out.print("Enter two numbers (seperated by a space) to find their Greatest Common Divisor: ");
        input = scan.nextLine();
        scan.close();
        
        String[] numbers_string = input.split(" ");
        int[] numbers = new int[2];
        for (int i = 0; i < 2; i++){
            numbers[i] = Integer.parseInt(numbers_string[i]);
        }
        
        int gcd;
        if (numbers[0] > numbers[1]){
            gcd = gCD(numbers[0], numbers[1]);
        }
        else{
            gcd = gCD(numbers[1], numbers[0]);
        }
        
        System.out.println("The Greatest Common Divisor between " + numbers_string[0] + " and " + numbers_string[1] + " is: " + Integer.toString(gcd));
    }
    
    /**
     * Recursive method to find if a word is a palindrome
     * @param word
     * @return 
     */
    public static boolean palindrome(String word){
        if (word.length() == 0 || word.length() == 1){
            return true;
        }
        else{
            if (word.substring(0, 1).equals(word.substring(word.length() - 1, word.length()))){
                return true && palindrome(word.substring(1, word.length() - 1));
            }
            else{
                return false;
            }
        }
    }
    
    /**
     * Recursive method to find a GCD between two numbers
     * @param num_1 // Must be larger than num_2
     * @param num_2
     * @return 
     */
    public static int gCD(int num_1, int num_2){
        if (num_1 % num_2 == 0){
            return num_2;
        }
        else{
            return gCD(num_2, num_1 % num_2);
        }
    }
}
