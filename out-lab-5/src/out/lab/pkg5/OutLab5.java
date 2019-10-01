/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg5;

/**
 *
 * @author natha
 */
public class OutLab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    /**
     * Method with hard-coded array and loop traversals to find start
     * Has the first call of the recursive method
    */
    public static void Start(){
        String[][] maze = { { "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#" },
                            { "#", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", "#" },
                            { ".", ".", "#", ".", "#", ".", "#", "#", "#", "#", ".", "#" },
                            { "#", "#", "#", ".", "#", ".", ".", ".", ".", "#", ".", "#" },
                            { "#", ".", ".", ".", ".", "#", "#", "#", ".", "#", ".", "#" },
                            { "#", "#", "#", "#", ".", "#", "F", "#", ".", "#", ".", "#" },
                            { "#", ".", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#" },
                            { "#", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#" },
                            { "#", ".", ".", ".", ".", ".", ".", ".", ".", "#", ".", "#" },
                            { "#", "#", "#", "#", "#", "#", ".", "#", "#", "#", ".", "#" },
                            { "#", ".", ".", ".", ".", ".", ".", "#", ".", ".", ".", "#" },
                            { "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#" } };
        
        boolean start_unknown = true;
        int[] start_coordinates = new int[4]; // Array of form xLoc, yLoc, xHandLoc, yHandLoc
        for (int i = 0; i < maze[0].length && start_unknown; i++){ // Loop to run through top row
            if (maze[0][i].equals(".")){
                start_coordinates = new int[] {i, 0, i - 1, 0};
                start_unknown = true;
            }
        }
        for (int i = 0; i < maze[maze.length - 1].length && start_unknown; i++){ // Loop to run through bottom row
            if (maze[maze.length - 1][i].equals(".")){
                start_coordinates = new int[] {i, maze[0].length - 1, i + 1, maze[0].length - 1};
                start_unknown = true;
            }
        }
        for (int i = 0; i < maze.length && start_unknown; i++){ // Loop to run through left column
            if (maze[i][0].equals(".")){
                start_coordinates = new int[] {0, i, 0, i + 1};
                start_unknown = true;
            }
        }
        for (int i = 0; i < maze.length && start_unknown; i++){ // Loop to run through right column
            if (maze[i][maze[0].length - 1].equals(".")){
                start_coordinates = new int[] {maze[0].length - 1, i, maze[0].length - 1, i - 1};
                start_unknown = true;
            }
        }
        
        solveMaze(maze, start_coordinates[0], start_coordinates[1], start_coordinates[2], start_coordinates[3]); // First recursive method call
    }
    
    /**
     * Recursive method to find a path through a 2D maze of any size
     * @param maze
     * @param xLoc
     * @param yLoc
     * @param xHandLoc
     * @param yHandLoc 
     */
    public static void solveMaze(String[][] maze, int xLoc, int yLoc, int xHandLoc, int yHandLoc){
        if (maze[yLoc][xLoc].equals("F")){ // Tests if current location is the finish
            maze[yLoc][xLoc] = "X";
            printMaze(maze);
            System.out.println("Maze solved!");
        }
        else{
            maze[yLoc][xLoc] = "X";
            printMaze(maze);
            maze[yLoc][xLoc] = "O";
            if (xHandLoc > xLoc){ // Tests if path is facing up
                if (maze[yHandLoc][xHandLoc].equals(".") || maze[yHandLoc][xHandLoc].equals("O")){
                    solveMaze(maze, xHandLoc, yHandLoc, xHandLoc, yHandLoc + 1);
                }
                else if (!maze[yLoc - 1][xLoc].equals("#")){
                    solveMaze(maze, xLoc, yLoc - 1, xHandLoc, yHandLoc - 1);
                }
                else{
                    solveMaze(maze, xLoc, yLoc, xHandLoc - 1, yHandLoc - 1);
                }
            }
            else if (yHandLoc > yLoc){ // Tests if path is facing right
                if (maze[yHandLoc][xHandLoc].equals(".") || maze[yHandLoc][xHandLoc].equals("O")){
                    solveMaze(maze, xHandLoc, yHandLoc, xHandLoc - 1, yHandLoc);
                }
                else if (!maze[yLoc][xLoc + 1].equals("#")){
                    solveMaze(maze, xLoc + 1, yLoc, xHandLoc + 1, yHandLoc);
                }
                else{
                    solveMaze(maze, xLoc, yLoc, xHandLoc + 1, yHandLoc - 1);
                }
            }
            else if (xHandLoc < xLoc){ // Tests if path is facing down
                if (maze[yHandLoc][xHandLoc].equals(".") || maze[yHandLoc][xHandLoc].equals("O")){
                    solveMaze(maze, xHandLoc, yHandLoc, xHandLoc, yHandLoc - 1);
                }
                else if (!maze[yLoc + 1][xLoc].equals("#")){
                    solveMaze(maze, xLoc, yLoc + 1, xHandLoc, yHandLoc + 1);
                }
                else{
                    solveMaze(maze, xLoc, yLoc, xHandLoc + 1, yHandLoc + 1);
                }
            }
            else if (yHandLoc < yLoc){ // Tests if path is facing left
                if (maze[yHandLoc][xHandLoc].equals(".") || maze[yHandLoc][xHandLoc].equals("O")){
                    solveMaze(maze, xHandLoc, yHandLoc, xHandLoc + 1, yHandLoc);
                }
                else if (!maze[yLoc][xLoc - 1].equals("#")){
                    solveMaze(maze, xLoc - 1, yLoc, xHandLoc - 1, yHandLoc);
                }
                else{
                    solveMaze(maze, xLoc, yLoc, xHandLoc - 1, yHandLoc + 1);
                }
            }
        }
    }
    
    /**
     * Method to print maze of varying size
     * @param maze 
     */
    public static void printMaze(String[][] maze){
        for (int i = 0; i < maze.length; i++){
            String line = "";
            for (int j = 0; j < maze[i].length; j++){
                line += maze[i][j] + " ";
            }
            System.out.println(line);
        }
        System.out.println("-----------------------\n");
    }
}
