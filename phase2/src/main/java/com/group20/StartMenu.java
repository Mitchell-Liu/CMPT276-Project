package com.group20;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Dimension;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class StartMenu extends JFrame{

	
	JLabel label;
	private JButton button;
	
	StartMenu(){		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(null);

		ImageIcon backGround = new ImageIcon();
        try{
            backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("resources/images/StartMenuBac.png")));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Image image = backGround.getImage();
        Image scaled = image.getScaledInstance(1000,800 , java.awt.Image.SCALE_SMOOTH);
        backGround = new ImageIcon(scaled);
        this.setContentPane((new JLabel(backGround)));
    
        
		JPanel buttonsC = new JPanel();
        
        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));
        
        
        
        

        ClickButton startButton = new ClickButton("Start Game");
        ClickButton exitButton = new ClickButton("Exit Game");

		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
		startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				DefaultGameFactory factory1 = new DefaultGameFactory();
                GameInstance test = new GameInstance(factory1);
                dispose();
				//System.exit(0);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				
                dispose();
				System.exit(0);
            }
        });
        

        // Timer timer=new Timer();
        // startButton.setBounds(10,10,10,10);
		buttonsC.add((startButton));
        buttonsC.add((exitButton));
        // buttonsC.setOpaque(false);
        // buttonsC.setLayout(null);
        // buttonsC.setAlignmentX(B);
        Dimension size = buttonsC.getPreferredSize();
        buttonsC.setBounds(350,500,size.width, size.height);
        buttonsC.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        // buttonsC.setLocation(100,100);
        // buttonsC.add(timer);
        setUndecorated(true);
		getContentPane().add((buttonsC));
        this.getContentPane().setLayout(null);
        buttonsC.setOpaque(true);
        // buttonsC.setOpaque(true);
        
		setVisible(true);
        

	}
    
    
	// private static ImageIcon resize(ImageIcon image, int width, int height) {
    //     BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    //     Graphics2D g2d = (Graphics2D) bi.createGraphics();
    //     g2d.addRenderingHints(
    //             new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    //     g2d.drawImage(image.getImage(), 0, 0, width, height, null);
    //     g2d.dispose();
    //     return new ImageIcon(bi);
    // }
	
	
}