/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg5;
import java.util.Scanner;

/**
 *
 * @author natha
 */
public class InLab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    public static void Start(){
        LinkedList names_list = new LinkedList();
        int answer = 0;
        do{
            printMenu();
            
            Scanner scan = new Scanner(System.in);
            answer = scan.nextInt(); // Only accepts integers
            while (scan.hasNextInt()){
                System.out.println("Error");
            }
            switch(answer){
                case 1:
                    System.out.print("Please enter a name: ");
                    scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    names_list.addItem(new Node(name));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("List: ");
                    names_list.printList();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the name you would like to delete: ");
                    scan = new Scanner(System.in);
                    name = scan.nextLine();
                    boolean deleted = names_list.deleteItem(name);
                    if (!deleted){
                        System.out.println("That name was not in the list.");
                    }
                    System.out.println();
                    break;
                case 4:
                    names_list.clearList();
                    System.out.println();
                    break;
                default:
                    System.out.println("That is not a valid anwer, please try again\n");
                    break;
            }
            
        } while (answer != -1);
    }
    
    public static void printMenu(){
        System.out.println("What would you like to do?\n"
                + "Press 1 to add an item to the back of the list\n"
                + "Press 2 to print the list\n"
                + "Press 3 to delete an item\n"
                + "Press 4 to clear the whole list\n"
                + "Press -1 to exit");
    }
    
}
