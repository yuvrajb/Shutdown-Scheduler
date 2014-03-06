/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package design;

import code.CancelWindowsSchedule;
import code.DetectOS;
import code.UnixShutdown;
import code.WindowsHibernate;
import code.WindowsLogOff;
import code.WindowsRestart;
import code.WindowsShutdown;
import com.alee.laf.WebLookAndFeel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Yuvraj Singh Babrah
 */
public class Skeleton extends javax.swing.JWindow {
    // properties
    public static int OperatingSystem = 0; // default windows
    public static JLabel OperatingSystemName = null; // os name label
    public static JLabel StatusDisplay = null; // show status
    private static String Time = "00";
    
    /**
     * Creates new form Skeleton
     */
    public Skeleton() {
        initComponents();
        design();
        initiate();
        setSystemTray();
    }

    /**
     * 
    */
    public void initiate(){
        new DetectOS();
        if(OperatingSystem != 0){
            this.HibernateButton.setVisible(false);
        }
    }
    
    /**
     * 
     */
    public void setSystemTray(){
       if(!SystemTray.isSupported()){
           return;
       }
       try{
            SystemTray Tray = SystemTray.getSystemTray();
            
            PopupMenu Menu = new PopupMenu();
            MenuItem About = new MenuItem("a nice app by Yuvraj Singh Babrah");
            Menu.add(About);
            Menu.addSeparator();
            MenuItem Display = new MenuItem("Show Window");
            Display.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                }
            });
            Menu.add(Display);
            MenuItem Close = new MenuItem("Exit");
            Close.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.exit(0);
               }
            });
            Menu.add(Close);
            
            Image IconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon_tray.png"));
            TrayIcon Icon = new TrayIcon(IconImage, "hi human!! this is a scheduler", Menu);
            
            Tray.add(Icon);
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
    
    /**
     * design modifications
     */
    public void design(){
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.getContentPane().setBackground(new Color(64,212,126));
        this.OSName.setFont(new Font("Arial", Font.BOLD, 14));
        this.OSName.setForeground(new Color(255,255,255));
        
        this.OperatingSystemName = OSName;
        this.StatusDisplay = Status;
        this.TimeLabel.setText(Time);
        
        ButtonGroup Options = new ButtonGroup();
        Options.add(ShutdownButton);
        Options.add(RestartButton);
        Options.add(LogButton);
        Options.add(HibernateButton);
        
        ButtonGroup Units = new ButtonGroup();
        Units.add(HoursButton);
        Units.add(MinutesButton);
        Units.add(SecondsButton);
        
        this.getRootPane().setBorder(new MatteBorder(4, 4, 4, 4, new Color(231, 231, 231)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        CloseButton = new javax.swing.JLabel();
        MinimiseButton = new javax.swing.JLabel();
        OSName = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ShutdownButton = new javax.swing.JRadioButton();
        RestartButton = new javax.swing.JRadioButton();
        LogButton = new javax.swing.JRadioButton();
        HibernateButton = new javax.swing.JRadioButton();
        HoursButton = new javax.swing.JRadioButton();
        MinutesButton = new javax.swing.JRadioButton();
        SecondsButton = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        Status = new javax.swing.JLabel();

        CloseButton.setBackground(new java.awt.Color(255, 255, 255));
        CloseButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(255, 255, 255));
        CloseButton.setText("X");
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseButtonMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseWindow();
            }
        });

        MinimiseButton.setBackground(new java.awt.Color(255, 255, 255));
        MinimiseButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        MinimiseButton.setForeground(new java.awt.Color(255, 255, 255));
        MinimiseButton.setText("-");
        MinimiseButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        MinimiseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimiseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimiseButtonMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HideWindow();
            }
        });

        TimeLabel.setBackground(new java.awt.Color(255, 255, 255));
        TimeLabel.setFont(new java.awt.Font("MingLiU", 0, 102)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeLabel.setText("00");
        TimeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            }
        });

        jButton1.setText("Schedule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/up.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(73, 21));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/down.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        ShutdownButton.setSelected(true);
        ShutdownButton.setText("Shutdown");

        RestartButton.setText("Restart");

        LogButton.setText("Log Off");

        HibernateButton.setText("Hibernate");

        HoursButton.setSelected(true);
        HoursButton.setText("Hours ");
        HoursButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        MinutesButton.setText("Minutes ");
        MinutesButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        MinutesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinutesButtonActionPerformed(evt);
            }
        });

        SecondsButton.setText("Seconds ");
        SecondsButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jButton4.setText("Cancel Schedules");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Status.setForeground(new java.awt.Color(255, 255, 255));
        Status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Status.setText("      ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ShutdownButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(MinutesButton)
                                    .addComponent(SecondsButton)
                                    .addComponent(HoursButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RestartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LogButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HibernateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OSName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MinimiseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CloseButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(OSName))
                    .addComponent(CloseButton)
                    .addComponent(MinimiseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HoursButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MinutesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SecondsButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(Status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ShutdownButton)
                    .addComponent(RestartButton)
                    .addComponent(LogButton)
                    .addComponent(HibernateButton)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void CloseButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         

    }                                        

    private void CloseButtonMouseExited(java.awt.event.MouseEvent evt) {                                        

    }                                       

    private void MinimiseButtonMouseEntered(java.awt.event.MouseEvent evt) {                                            
        
    }                                           

    private void MinimiseButtonMouseExited(java.awt.event.MouseEvent evt) {                                           

    }                                                                                

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
    }                                   
    
    private void HideWindow(){
        // hide the window
        this.setVisible(false);
    }
    
    private void CloseWindow(){
        // close the window
        System.exit(0);
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        int Current = Integer.parseInt(Time);
        Current ++;
        if(Current < 10)
            Time = "0" + Current;
        else
            Time = "" + Current;
        this.TimeLabel.setText(Time);
    }                                     

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        int Current = Integer.parseInt(Time);
        Current --;
        if(Current < 0)
            return;
        if(Current < 10)
            Time = "0" + Current;
        else
            Time = "" + Current;
        this.TimeLabel.setText(Time);
    }                                     

    private void MinutesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // click on schedule button
        int FetchTime = Integer.parseInt(Time); // fetch time
        // unit
        if(HoursButton.isSelected())
            FetchTime *= 60*60;
        else if(MinutesButton.isSelected())
            FetchTime *= 60;
        else
            FetchTime = FetchTime;
        // option
        int Option = 0; // shutdown
        if(ShutdownButton.isSelected())
            Option = 0;
        else if(RestartButton.isSelected())
            Option = 1;
        else if(LogButton.isSelected())
            Option = 2;
        else
            Option = 3;
        // clear status
        Status.setText("");
        try{
            if(OperatingSystem == 0){ // windows
                if(Option == 0)
                    new WindowsShutdown(FetchTime).start(); // thread
                else if(Option == 1)
                    new WindowsRestart(FetchTime).start(); //thread
                else if(Option == 2)
                    new WindowsLogOff(FetchTime).start(); // thread
                else 
                    new WindowsHibernate(FetchTime).start(); // thread
            }
            else if(OperatingSystem == 2){ // unix based
                if(Option == 0)
                    new UnixShutdown(FetchTime).start(); // thread
            }
        }
        catch(Exception e){ }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // cancel schedules
        try{
            if(OperatingSystem == 0) // windows
                new CancelWindowsSchedule().start(); // thread
        }
        catch(Exception e){ }
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set WebLnF */
        try {
            WebLookAndFeel.install();
        } catch (Exception ex) {}

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Skeleton().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel CloseButton;
    private javax.swing.JRadioButton HibernateButton;
    private javax.swing.JRadioButton HoursButton;
    private javax.swing.JRadioButton LogButton;
    private javax.swing.JLabel MinimiseButton;
    private javax.swing.JRadioButton MinutesButton;
    private javax.swing.JLabel OSName;
    private javax.swing.JRadioButton RestartButton;
    private javax.swing.JRadioButton SecondsButton;
    private javax.swing.JRadioButton ShutdownButton;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration                   
}
