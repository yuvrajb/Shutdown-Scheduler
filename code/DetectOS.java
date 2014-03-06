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
public class DetectOS {
    /**
     * Constructor
     */
    public DetectOS(){
       String OS = System.getProperty("os.name");
       Skeleton.OperatingSystemName.setText(OS);
       OS = OS.toLowerCase();
       if(OS.contains("win")){
           Skeleton.OperatingSystem = 0;
       }
       else if(OS.contains("mac")){
           Skeleton.OperatingSystem = 1;
       }
       else if(OS.contains("nix") || OS.contains("nux") || OS.contains("aix")){
           Skeleton.OperatingSystem = 2;
       }
    }
}
