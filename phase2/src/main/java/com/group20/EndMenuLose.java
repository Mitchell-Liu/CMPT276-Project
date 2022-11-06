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
		
		
		ImageIcon logo = new ImageIcon();
        try {
            logo = new ImageIcon(ImageIO.read(this.getClass().getResource("resources/images/lose.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
		// logo=resize(logo,100,200);
		setLayout(new BorderLayout());
        getContentPane().add(new JLabel(logo),BorderLayout.NORTH);

		JPanel buttonsC = new JPanel();
        buttonsC.setBackground(Color.black);
        
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

        Timer timer=new Timer();
        

		buttonsC.add(startButton);
        buttonsC.add(exitButton);
        buttonsC.add(restartButton);

        buttonsC.add(timer);
        

		getContentPane().add(buttonsC);
		setVisible(true);
        
        
        

	}
	
	private static ImageIcon resize(ImageIcon image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }
	
	
}