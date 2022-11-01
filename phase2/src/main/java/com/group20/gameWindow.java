package com.group20;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class gameWindow extends JFrame{
    

    gameWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		//this.setLayout(null);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(Color.black);

        ImageIcon backGround = new ImageIcon();
        try {
            backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("backGround.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(new JLabel(backGround));


       
    }
    
}
