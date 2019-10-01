/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg3;
import java.util.Timer;

/**
 *
 * @author natha
 */
public class Battery {
    
    private static int battery_life;
    private static int flight_time;
    private static Timer timer;
    
    Battery(int battery){
        battery_life = battery;
        timer = new Timer();
    }
    
    static int Time(){
        flight_time = Integer.parseInt(timer.toString());
        return battery_life - flight_time;
    }
    
}
