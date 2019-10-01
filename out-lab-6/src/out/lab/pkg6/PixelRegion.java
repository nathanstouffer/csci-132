/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.lab.pkg6;

/**
 *
 * @author natha
 */
public class PixelRegion {
    
    private final PixelRegion previous;
    private final int x_coor;
    private final int y_coor;
    private int index;
    private final String[] position = { "-1 -1", "0 -1", "1 -1", "1 0", "1 1", "0 1", "-1 1", "-1 0" }; // array with position adjusters of form "x y" 
    
    PixelRegion(PixelRegion temp, int px_coor, int py_coor){
        previous = temp;
        x_coor = px_coor;
        y_coor = py_coor;
        index = 0;
    }
    
    /**
     * returns array with format {x, y}
     * @return 
     */
    public int[] getPixelAdjusters() {
        int[] adjusters = new int[2];
        String[] temp = position[index].split(" ");
        for (int i = 0; i < 2; i++){
            adjusters[i] = Integer.parseInt(temp[i]);
        }
        index++;
        return adjusters;
    }
    
    public PixelRegion getPrevious() { return previous; }
    public int getXCoor() { return x_coor; }
    public int getYCoor() { return y_coor; }
    public int getIndex() {return index; }

}
