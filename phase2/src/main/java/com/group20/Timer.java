package com.group20;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

// The timer class to keep track of how much time the player spends playing the game
public class Timer extends JLabel  implements Runnable{
    static int time=0;
    boolean running;
    boolean exit=false;

    // Starts the timer 
    Timer(){
        super("TIME ELAPSED:\n0 s");
        running=true;
        this.setForeground(Color.white);
        this.setOpaque(false);
        setFont(new Font("Monospaced", Font.BOLD, 24));
        
        Thread thread = new Thread(this);
        thread.start();
        
    }

    public void run(){
        while(!exit){

        if(running){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
            throw new IllegalStateException(e);
            }
            String text = "TIME ELAPSED:<br>"+Integer.toString(time)+" s";
            this.setText("<html><p>"+text+"</p></html>");
            time++;
       }
        
        }
    }

    public void pause(){
        running=false;
    }
    public void resume(){
        running=true;
    }

    public void exit(){
        exit=true;
    }
    eventManager event;
}
