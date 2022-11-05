package com.group20;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameInstance {
    JFrame frame;

    GameInstance(GameFactory factory){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon backGround = new ImageIcon();
        try {
            backGround = new ImageIcon(ImageIO.read(this.getClass().getResource("Assets/zbackGround.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = backGround.getImage();
        Image scaled = image.getScaledInstance(815, 635, java.awt.Image.SCALE_SMOOTH);
        backGround = new ImageIcon(scaled);

        frame.setContentPane(new JLabel(backGround));
        frame.setLayout(new FlowLayout());


        //frame.setLayout(new BorderLayout());

        Map map = factory.makeMap();
        Board board = factory.makeBoard(map);
        eventManager keylistener = new eventManager(map, board);
        JPanel score = new JPanel();
        JLabel scoreText = new JLabel("SCORE");
        score.add(scoreText);
        Timer timer = new Timer();
        frame.setSize(815,635);
        board.setBounds(0,0,600,600); 
        frame.addKeyListener(keylistener); 
        //timer.setBounds(615,0,200,317);
        //score.setBounds(615, 318, 200, 317);
        board.setPreferredSize(new Dimension(600,600));
        timer.setPreferredSize(new Dimension(200, 600));
        frame.add(board, BorderLayout.CENTER);
        frame.add(timer, BorderLayout.EAST);
        //frame.add(score, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
}
