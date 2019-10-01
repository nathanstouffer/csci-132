/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg2;

/**
 *
 * @author natha
 */
public class Bowling {
    
    /**
     * Default constructor to simulate a game of bowling
     */
    Bowling(){
        Frame[] frames = new Frame[11]; //Array of frames. This is the game
        for (int i = 0; i < 10; i++){
            frames[i] = new Frame();
        }
        if (frames[9].getFirst_roll() == 10){
            frames[10] = new Frame(false);
        }
        else if (frames[9].getFirst_roll() + frames[9].getSecond_roll() == 10){
            frames[10] = new Frame(true);
        }
        
        int[] scores = calculateScores(frames); //Array with the total, updated score in each frame
        
        System.out.println(printGame(frames, scores));
    }
    
    /**
     * Method to return score totals
     * @param frames
     * @return 
     */
    private int[] calculateScores(Frame[] frames){
        int[] scores = new int[10];
        for (int i = 0; i < 10; i++){
            if (i > 0){
                scores[i] = scores[i - 1];
            }
            scores[i] += frames[i].getFirst_roll() + frames[i].getSecond_roll();
            
            if (frames[i].getFirst_roll() == 10){ //if-statements to ensure strikes/spares are scored accurately
                scores[i] += frames[i + 1].getFirst_roll() + frames[i + 1].getSecond_roll();
                if (frames[i + 1].getFirst_roll() == 10 && frames[i + 1].getSecond_roll() == 0 && i != 9){
                    scores[i] += frames[i + 2].getFirst_roll();
                }
            }
            else if (frames[i].getFirst_roll() + frames[i].getSecond_roll() == 10){
                scores[i] += frames[i + 1].getFirst_roll();
            }
        }
        
        return scores;
    }
    
    /**
     * Method to return a string of output for the simulated bowling game
     * @return 
     */
    private String printGame(Frame[] frames, int[] scores){
        String return_string = frameLine();
        for (int i = 0; i < 10; i++){
            return_string += "+   " + formatRoll(frames[i].getFirst_roll()) + "   |   " + formatRoll(frames[i].getFirst_roll(), frames[i].getSecond_roll()) + "   ";
        }
        
        if (frames[10] == null){
            return_string += "+               +\n";
        }
        else if (frames[9].getFirst_roll() == 10){
            return_string += finalFrame(frames[10].getFirst_roll(), frames[10].getSecond_roll()) + "+\n";
        }
        else{
            return_string += finalFrame(frames[10].getFirst_roll()) + "+\n";
        }
        
        return_string += spaceHolderLine();
        return_string += scoreLine(scores);
        return_string += spaceHolderLine();
        
        return return_string;
    }
    
    /**
     * A method to return the first line in the print statement as a string
     * @return 
     */
    private String frameLine(){
        String return_string = "";
        for (int i = 0; i < 10; i++){
            return_string += "+----Frame " + Integer.toString(i + 1);
            if (i < 9){
                return_string += "----";
            }
            else{
                return_string += "---";
            }
        }
        return return_string += "+---------------+\n";
    }
    
    /**
     * Method to return a dividing line as a string
     * @return 
     */
    private String spaceHolderLine(){
        String return_string = "";
        for (int i = 0; i < 11; i++){
            return_string += "+---------------";
        }
        
        return return_string + "+\n";
    }
    
    /**
     * Method to return the score line as a string
     * @param scores
     * @return 
     */
    private String scoreLine(int[] scores){
        String return_string = "";
        for (int i = 0; i < 10; i++){
            if (scores[i] < 10){
                return_string += "+       " + Integer.toString(scores[i]) + "       ";
            }
            else if (scores[i] < 100){
                return_string += "+       " + Integer.toString(scores[i]) + "      ";
            }
            else{
                return_string += "+      " + Integer.toString(scores[i]) + "      ";
            }
        }
        
        return return_string + "+               +\n";
    }
    
    /**
     * Method to return the correct output form of the first roll in a frame
     * @param first_roll
     * @return 
     */
    private String formatRoll(int first_roll){
        if (first_roll == 10){
            return "X";
        }
        else{
            return Integer.toString(first_roll);
        }
    }
    
    /**
     * Method to return the correct output form of the second roll in a frame
     * @param first_roll
     * @param second_roll
     * @return 
     */
    private String formatRoll(int first_roll, int second_roll){
        if (first_roll == 10){
            return " ";
        }
        else if (first_roll + second_roll == 10){
            return "S";
        }
        else{
            return Integer.toString(second_roll);
        }
    }
    
    /**
     * Method to return half a final frame as a string
     * @param first_roll
     * @return 
     */
    private String finalFrame(int first_roll){
        return "+   " + formatRoll(first_roll) + "   |       ";
    }
    
    /**
     * Method to return a full final frame as a string
     * @param first_roll
     * @param second_roll
     * @return 
     */
    private String finalFrame(int first_roll, int second_roll){
        String return_string = "+   ";
            
        if (first_roll != 10 && second_roll != 10){
            return_string += Integer.toString(first_roll) + "   |   " + Integer.toString(second_roll) + "   ";
        }
        else if (first_roll == 10 && second_roll == 10){
            
            return_string += "X   |   X   ";
        }
        else if (first_roll == 10 && second_roll != 10){
            return_string += "X   |   " + Integer.toString(second_roll) + "   ";
        }
        else if (first_roll != 10 && second_roll == 10){
            return_string += Integer.toString(first_roll) + "   |   X   ";
        }
        
        return return_string;
    }
    
}
