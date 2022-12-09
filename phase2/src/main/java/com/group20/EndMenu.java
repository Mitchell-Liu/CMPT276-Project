package com.group20;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.image.BufferedImage;
/**
 * Menu that appears upon losing the game.
 */
public class EndMenu extends JFrame{

	
	JLabel label;
	
	
	EndMenu(int plScore, boolean result){		
        // Setup the Window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(null);
		
        // Creates and fits a background for the window
		ImageIcon backGround = new ImageIcon();
        try{
            if(result == true){
                backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("/WinBac.png")));
            }
            else{
                backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("/LoseBac.png")));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Image image = backGround.getImage();
        Image scaledImage = image.getScaledInstance(1000,800 , java.awt.Image.SCALE_SMOOTH);
        backGround = new ImageIcon(scaledImage);
        this.setContentPane((new JLabel(backGround)));
    
        
		JPanel buttonsC = new JPanel();
        // Stacks the Buttons vertically
        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));

        // Create elements to be added to the JFrame
        ClickButton startButton = new ClickButton("Main Menu");
        ClickButton restartButton = new ClickButton("Restart");
        ClickButton exitButton = new ClickButton("Exit Game");

        JLabel score = new JLabel("SCORE: " + plScore);
        score.setFont((new Font("Serif", Font.PLAIN, 50)));
        score.setForeground(Color.black);
        
        JLabel time = new JLabel("TIME: " + Timer.time);
        time.setFont((new Font("Serif", Font.PLAIN, 50)));
        time.setForeground(Color.black);

        // Centers the Buttons
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        time.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Opens the appropriate windows when buttons are clicked
		startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				new StartMenu();
                dispose();
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
                new GameInstance(factory1);
                dispose();
            }
        });
        
        // Adds the buttons the the JFrame
        buttonsC.add(score);
        buttonsC.add(time);
		buttonsC.add(startButton);
        buttonsC.add(exitButton);
        buttonsC.add(restartButton);

        // Places the Frame in a specific position 
        Dimension size = buttonsC.getPreferredSize();
        buttonsC.setBounds(350,400,size.width, size.height);

        // Removes any decorations from the frame and adds the buttons
        setUndecorated(true);
		getContentPane().add((buttonsC));
        this.getContentPane().setLayout(null);

		setVisible(true);
	}

}