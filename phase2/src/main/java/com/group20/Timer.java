package com.group20;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Timer extends JLabel  implements Runnable{
    static int time=0;
    boolean running;
    boolean exit=false;
    Timer(){
        super("TIME ELAPSED:\n0 s");
       // this.event=event;
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
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
            throw new IllegalStateException(e);
            }
            //System.out.println(time);
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
