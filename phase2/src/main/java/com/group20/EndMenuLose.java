package com.group20;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class EndMenuLose extends JFrame{

	
	JLabel label;
	
	
	EndMenuLose(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(null);
		
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(null);

		ImageIcon backGround = new ImageIcon();
        try{
            backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("resources/images/LoseBac.png")));
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
        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));
        ClickButton startButton = new ClickButton("Main Menu");
        ClickButton restartButton = new ClickButton("Restart");
        ClickButton exitButton = new ClickButton("Exit Game");
        

		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				new StartMenu();
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
        restartButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
            
                            DefaultGameFactory factory1 = new DefaultGameFactory();
                            GameInstance test = new GameInstance(factory1);
                            dispose();
                        }
                    });

        //Timer timer=new Timer();
        

		buttonsC.add(startButton);
        buttonsC.add(exitButton);
        buttonsC.add(restartButton);

        //buttonsC.add(timer);
        Dimension size = buttonsC.getPreferredSize();
        buttonsC.setBounds(350,500,size.width, size.height);
        // buttonsC.setLocation(100,100);
        // buttonsC.add(timer);
        setUndecorated(true);
		getContentPane().add((buttonsC));
        this.getContentPane().setLayout(null);

		getContentPane().add(buttonsC);
		setVisible(true);
        
        
        

	}
	
	
	
	
}