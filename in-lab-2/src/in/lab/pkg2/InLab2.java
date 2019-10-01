/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg2;

/**
 *
 * @author natha
 */
public class InLab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    public static void Start(){
        Engineering circle = new Engineering(6);
        Engineering rectangle = new Engineering(5, 4);
        
        int circle_area = circle.CircleArea();
        int rectangle_area1 = rectangle.RectangleArea();
        rectangle.ChangeLenth(-10);
        int rectangle_area2 = rectangle.RectangleArea();
        
        System.out.println("Circle Area (Radius 6): " + circle_area + "\nRectangle Area: (Length 5, Width 4): " + rectangle_area1);
        System.out.println("Rectangle Area (Length 7, Width 4): " + rectangle_area2);
        
        int cirle_area_error = circle.RectangleArea();
    }
    
}
