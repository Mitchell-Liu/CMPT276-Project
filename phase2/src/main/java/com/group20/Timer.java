package com.group20;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Timer extends JLabel  implements Runnable{
    int time=0;
    boolean running;
    boolean exit=false;
    Timer(){
        super("0 s");
       // this.event=event;
        running=true;
        this.setForeground(Color.red);
        this.setOpaque(false);
        setFont(new Font("Serif", Font.PLAIN, 30));
        
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
            this.setText(Integer.toString(time)+ " s");
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
