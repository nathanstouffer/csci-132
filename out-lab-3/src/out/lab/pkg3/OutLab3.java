/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author natha
 */
public class OutLab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    
    /**
     * Driver method in the driver class
     */
    public static void Start(){
        
        LinkedList student_data = new LinkedList();
        String[] student;
        int menu_choice;
        do{
            printMenu();

            Scanner scan = new Scanner(System.in);
            menu_choice = scan.nextInt();

            switch(menu_choice){
                case 1:
                    student_data.delete();
                    try{
                        Scanner fin = new Scanner(new File("input.txt"));
                        while (fin.hasNextLine()){
                            String[] line = fin.nextLine().split(", ");
                            for (int i = 0; i < 3; i++){
                                line[i] = line[i].trim();
                            }
                            student_data.addInOrder(new Node(Integer.parseInt(line[0]), line[1].toLowerCase(), line[2].toLowerCase()));
                        }
                        fin.close();
                    }
                    catch (FileNotFoundException e){
                        System.err.println("Opening file error");
                    }
                    break;
                case 2:
                    student = userInputStudent();
                    student_data.addInOrder(new Node(Integer.parseInt(student[0]), student[1], student[2]));
                    System.out.println("Student added\n");
                    break;
                case 3:
                    System.out.println(student_data);
                    break;
                case 4:
                    System.out.println(student_data.printBackwards());
                    break;
                case 5:
                    student = userInputStudent();

                    if (student_data.removeItem(new Node(Integer.parseInt(student[0]), student[1], student[2]))){
                        System.out.println("Item successfully removed.\n");
                    }
                    else{
                        System.out.println("Item was not in list.\n");
                    }
                    break;
                case 6:
                    student_data.delete();
                    System.out.println("List deleted");
                    break;
            }
           
        } while (menu_choice != -1);
    }
    
    /**
     * Method to return an array of a student the user inputs
     * @return 
     */
    public static String[] userInputStudent(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a student ID: ");
        String id_number = scan.nextLine().trim();

        System.out.print("Enter a student's first name: ");
        String first_name = scan.nextLine().trim().toLowerCase();

        System.out.print("Enter a student's last name: ");
        String last_name = scan.nextLine().trim().toLowerCase();
        
        return new String[] { id_number, last_name, first_name };
    }
    
    /**
     * Method to print the menu for the user
     */
    public static void printMenu(){
        System.out.println("Press 1 to load list from file\n" 
                   + "Press 2 to load list with individual item from user input\n" 
                   + "Press 3 to print list inorder\n" 
                   + "Press 4 to print list backwards\n" 
                   + "Press 5 to remove item\n" 
                   + "Press 6 to delete entire list\n" 
                   + "Press -1 to exit");
    }
    
}
