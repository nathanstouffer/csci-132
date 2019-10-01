/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg4;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author natha
 */
public class OutLab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    /**
     * Method to run the program
     */
    public static void Start(){
        
        System.out.print("Enter a valid file name: ");
        Scanner scan = new Scanner(System.in);
        String file_name = scan.next();
        
        try{            
            Scanner fin = new Scanner(new File(file_name));
            String line = "";
            String output = "Program 4\n---------\n";;
            
            boolean run_loop = true;
            if (!fin.hasNextLine()){
                run_loop = false;
            }
            else{
                line = fin.nextLine().trim();
            }
            
            while (run_loop){ // Loop will run until it reaches the line with "0 0 0" as its input
                int[] input = new int[3]; // Array with data {N, k, m}
                String[] input_string_array = line.split(" ");
                for (int i = 0; i < 3; i++){
                    input[i] = Integer.parseInt(input_string_array[i]);
                }

                CircularLinkedList politicians = new CircularLinkedList(input);
                for (int i = 0; i < input[0]; i++){                
                    politicians.addNode(i + 1);
                }
                
                int i = 0, j = 0;
                int results [] = {0, 0, 1, politicians.getLength()}; // Array with form {k value, m value, next k, next m}
                while (politicians.getLength() > 0){
                    results = politicians.findCandidate(input[1] % (politicians.getLength() + 1), input[2] % (politicians.getLength() + 1), results);
                    if (results[1] == 0){
                        politicians.addCandidate(i, results[0]);
                        i++;
                    }
                    else{
                        politicians.addRemoved(j, results[0], results[1]);
                        j += 2;
                    }
                }
                
                output += politicians.toString();
                
                line = fin.nextLine().trim();
                if (line.equals("0 0 0")){
                    run_loop = false;
                    fin.close();
                }
            }
            
            output += "\nEnd of Program 4";
            PrintWriter fo = new PrintWriter("LinkedListProgram.txt");
            fo.print(output);
            fo.close();
            
            System.out.println("Written successfully to file");
        }
        catch (FileNotFoundException e){
            System.err.println("Opening file error");
        }
    }
    
}
