/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg3;

/**
 *
 * @author natha
 */
public class Drone {
    
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int motors;
    private int size;
    private int weight;
    private int speed;
    Battery time;
            
    Drone(int battery, int motor_count, int input_size, int input_weight){
        time = new Battery(battery);
        motors = motor_count;
        size = input_size;
        weight = input_weight;
        
    }
    
    void TakePicture(){
        
    }
    
    void ChangeSpeed(int new_speed){
        
    }
    
    void Speed(){
        if (speed == 0){
            
        }
        else{
            
        }
    }
    
    void ChangePosition(int new_x, int new_y, int new_z){
        
    }
    
    void ChangeX(int new_x){
        
    }
    
    void ChangeY(int new_y){
        
    }
    
    void ChangeZ(int new_z){
    
    }
    
    int GetX(){
        return x;
    }
    
    int GetY(){
        return y;
    }
    
    int GetZ(){
        return z;
    }
    
    int GetTime(){
        return time.Time();
    }
}
