/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

import design.Skeleton;

/**
 *
 * @author Yuvraj Singh Babrah
 */
public class UnixRestart extends Thread{
    /**
     * Properties
     */
    private int Time = 0;
    
    /**
     * Constructor
     */
    public UnixRestart(int Time){
        this.Time = Time;
    }
    
    @Override
    public void run(){
        try{
            Skeleton.StatusDisplay.setText("scheduled successfully!");
            Time = Time / 60;
            Runtime.getRuntime().exec("shutdown -r " + Time);
        }
        catch(Exception e){ }
    }
}
