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
public class CancelUnixSchedule extends Thread{
    @Override
    public void run(){
        try{ 
            Skeleton.StatusDisplay.setText("operation aborted!");
            Runtime.getRuntime().exec("killall shutdown");
            Runtime.getRuntime().exec("kill `cat /var/run/shutdown.pid`");
        }
        catch(Exception e){ }
    }
}
