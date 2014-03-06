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
public class WindowsHibernate extends Thread{
    /**
     * Properties
     */
    private int Time = 0;
    
    /**
     * Constructor
     */
    public WindowsHibernate(int Time){
        this.Time = Time;
    }
    
    @Override
    public void run(){
        try{
            Skeleton.StatusDisplay.setText("scheduled successfully! you can hide this window but do not close it");
            Thread.sleep(Time * 1000);
            Runtime.getRuntime().exec("shutdown /h");
        }
        catch(Exception e){ }
    }
}
