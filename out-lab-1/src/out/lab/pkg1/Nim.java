/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg1;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author natha
 */
public class Nim {
    
    Random numGen = new Random();
    private int marble_count;
    private final int player_order;
    private final int computer_intelligence;
    private String winner;
    
    Nim(){ // Class constructor ro set variables
        marble_count = numGen.nextInt(91) + 10;
        player_order = numGen.nextInt(2);
        computer_intelligence = numGen.nextInt(2);
        
        if (computer_intelligence == 0){
            System.out.println("Computer is playing easy.");
        }
        else{
            System.out.println("Computer is playing smart.");
        }
        if (player_order == 0){
            System.out.println("Human plays first.");
        }
        else{
            System.out.println("Computer plays first.");
        }
    }
    
    int SmartComputer(){
        int[] ideal_values = {1, 3, 7, 15, 31, 63};
        int target_value = 0;
        for (int i = 0; i < ideal_values.length && target_value == 0; i++){
            if (ideal_values[i] > ((marble_count / 2) + 1) || marble_count == 2){
                target_value = ideal_values[i];
            }
        }
        if (target_value != 0){
            int computer_choice = marble_count - target_value;
            marble_count -= computer_choice;
            return computer_choice;
        }
        return DumbComputer();
    }
    
    int DumbComputer(){
        int computer_choice;
        if (marble_count > 1){
            computer_choice = numGen.nextInt((int)(marble_count / 2)) + 1;
        }
        else{
            computer_choice = 1;
        }
        marble_count -= computer_choice;
        return computer_choice;
    }
    
    int HumanChoice(){
        boolean valid_answer = false;
        int input;
        do{
            System.out.print("Choose a valid number of marbles: ");
            Scanner reader = new Scanner(System.in);
            input = reader.nextInt();
            if (input > 0 && input < (marble_count / 2) + 1 || input == 1){
                valid_answer = true;
            }
        } while (valid_answer == false);
        return input;
    }
    
    void Output(){
        System.out.println("\nThere are " + marble_count + " marbles.");
        if (computer_intelligence == 1){ // Computer is smart if computer_intelligence is 1
            System.out.println("The computer chooses " + SmartComputer() + " marbles.");
        }
        else{
            System.out.println("The computer chooses " + DumbComputer() + " marbles.");
        }
        System.out.println("There are now " + marble_count + " marbles.");
        
        if (marble_count == 1){
            winner = "Computer";
        }
        
        if (marble_count > 0){
            int human_choice = HumanChoice();
            marble_count -= human_choice;
        }
        else{
            winner = "Human";
        }
    }
    
    void ChangeMarbleCount(int value){
        marble_count -= value;
    }
    
    int GetPlayerOrder(){
        return player_order;
    }
    
    int GetMarbleCount(){
        return marble_count;
    }
    
    String GetWinner(){
        return winner;
    }
}
