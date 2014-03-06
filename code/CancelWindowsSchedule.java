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
public class CancelWindowsSchedule extends Thread{
    @Override
    public void run(){
        try{ 
            Skeleton.StatusDisplay.setText("operation aborted!");
            Runtime.getRuntime().exec("shutdown /a");
        }
        catch(Exception e){ }
    }
}
