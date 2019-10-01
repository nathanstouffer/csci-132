/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg1;

/**
 *
 * @author natha
 */
public class OutLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    public static void Start(){
        Nim game = new Nim();
        PlayGame(game);
    }
    
    public static void PlayGame(Nim game){
        if (game.GetPlayerOrder() == 0){ // Human goes first if player_order equals 0
            System.out.println("\nThere are " + game.GetMarbleCount() + " marbles.");
            game.ChangeMarbleCount(game.HumanChoice());
            //game.marble_count -= game.HumanChoice();
        }
        do{
            game.Output();
        } while (game.GetMarbleCount() != 0);
        System.out.println("\n" + game.GetWinner() + " wins!");
    }
    
}
