/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg7;

/**
 *
 * @author natha
 */
public class Heap {
    
    private int[] tree;
    private int first_null;
    
    Heap(){
        tree = new int[25];
        first_null = 0;
    }
    
    /**
     * Method to add value to tree
     * @param number 
     */
    public void addValue(int number){
        if (first_null == 0){
            tree[0] = number;
            first_null++;
        }
        else{
            int child = first_null;
            int parent = (child - 1)/2;
            first_null++;

            tree[child] = number;

            while (tree[child] < tree[parent] && parent >= 0){
                int temp = tree[parent];
                tree[parent] = tree[child];
                tree[child] = temp;

                child = parent;
                parent = (child - 1)/2;
            }
        }
    }
    
    /**
     * Method to delete value from root of tree
     * @return 
     */
    public int delete(){
        if (tree.length > 0){
            int value = tree[0];
            
            tree[0] = tree[first_null - 1];
            tree[first_null - 1] = 0;
            first_null--;
            int parent = 0;
            boolean run_loop = true;
            while (run_loop){
                int l_child = (parent + 1)*2 - 1;
                int r_child = (parent + 1)*2;
                if (tree[l_child] == 0 || tree[r_child] == 0){
                    run_loop = false;
                }
                else if (tree[parent] > tree[l_child] && tree[l_child] < tree[r_child]){
                    int temp = tree[parent];
                    tree[parent] = tree[l_child];
                    tree[l_child] = temp;
                    parent = l_child;
                }
                else if (tree[parent] > tree[r_child]){
                    int temp = tree[parent];
                    tree[parent] = tree[r_child];
                    tree[r_child] = temp;
                    parent = r_child;
                }
                else{
                    run_loop = false;
                }
            }
            
            return value;
        }
        else{
            return 0;
        }
    }
    
    /**
     * Method to return correctly ordered output of tree
     * @return 
     */
    @Override
    public String toString(){
        String output = "";
        
        int row_count = 0;
        int length = first_null;
        while (length > 0){
            length /= 2;
            row_count++;
        }
        
        int index = first_null - 1;
        int power = row_count - 1;
        while (index >= 0){
            int first_value = (int)Math.pow(2, power);
            power--;
            for (int i = index; i >= first_value - 1 && index >= 0; i--){
                output = Integer.toString(tree[i]) + " " + output;
            }
            output = "\n" + output;
            index = first_value - 2;
        }
        
        return output;
    }
    
}
