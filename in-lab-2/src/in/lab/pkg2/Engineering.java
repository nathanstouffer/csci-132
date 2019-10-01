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
public class Engineering {
    
    int length = 0;
    int width = 0;
    
    Engineering(int number1){
        length = number1;
    }
    
    Engineering(int number1, int number2){
        length = number1;
        width = number2;
    }
    
    public int CircleArea(){
        if (length > 0 && width == 0){
            return (int)(3.14 * length * length);
        }
        else{
            System.out.println("The dimensions of your shape do not fit this computation.");
            return 0;
        }
    }
    
    public int RectangleArea(){
        if (length > 0 && width > 0){
            return length * width;
        }
        else{
            System.out.println("The dimensions of your shape do not fit this computation.");
            return 0;
        }
    }
    
    public void ChangeLenth(int value){
        if (length + value > 0){
            length += value;
            System.out.print("The length is " + length);
        }
        if (width != 0){
            System.out.println(" and the width is " + width);
        }
        else{
            System.out.println();
        }
    }
    
}
