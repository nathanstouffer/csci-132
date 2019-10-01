/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg2;
import java.util.Random;

/**
 *
 * @author natha
 */
public class Frame {
    
    private int first_roll = 0;
    private int second_roll = 0;
    
    /**
     * Default constructor to create a frame with two rolls
     */
    Frame(){
        first_roll = roll();
        second_roll = roll(10 - first_roll);
    }
    
    /**
     * Constructor to create a final frame
     * @param one_roll
     */
    Frame(boolean one_roll){
        if (one_roll){
            first_roll = roll();
        }
        else{
            first_roll = roll();
            if (first_roll == 10){
                second_roll = roll();
            }
            else{
                second_roll = roll(10 - first_roll);
            }
        }
    }
    
    /**
     * Method to return the number of pins knocked over on the first roll
     * @return
     */
    private int roll(){
        int[] weighted_array = new int[] {0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10};    
        Random rand = new Random();
        
        return weighted_array[rand.nextInt(weighted_array.length)];
    }
    
    /**
     * Method to return the number of pins knocked over on the second roll
     * @param second_roll
     * @return 
     */
    private int roll(int pins){
        Random rand = new Random();
        
        return rand.nextInt(pins + 1);
    }
    
    /**
     * Method to return the value of the first roll
     * @return 
     */
    public int getFirst_roll() {
        return first_roll;
    }
    
    /**
     * Method to return the value of the second roll
     * @return 
     */
    public int getSecond_roll() {
        return second_roll;
    }
}
