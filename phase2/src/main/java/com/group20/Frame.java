package com.group20;
import java.awt.Color;

import javax.swing.*;


public class Frame extends JFrame{

	
	JLabel label;
	ImageIcon icon;
	
	Frame(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		
		
		icon = new ImageIcon("shark.png");
		
		label = new JLabel();
		label.setBounds(0, 0, 100, 100);
		label.setIcon(icon);
		this.getContentPane().setBackground(Color.black);
		this.add(label);
		this.setVisible(true);
	}
	
	
	
	
}