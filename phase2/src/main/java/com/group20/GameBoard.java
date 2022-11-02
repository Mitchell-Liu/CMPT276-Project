package com.group20;

import java.awt.*;  
import javax.swing.*;

public class GameBoard {
    JFrame game;

    GameBoard(){
        game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLayout(null);

        Map map = new Map();
        PlayArea gameArea = new PlayArea(map);
        gameArea.setBoard();
        eventManager keylistener = new eventManager(gameArea.getMap().getDiver(), map, gameArea, game);
        JPanel scoreboard = new JPanel();
        JTextPane score = new JTextPane();
        JTextPane time = new JTextPane();
        game.setSize(615,660);
        scoreboard.setBackground(Color.YELLOW);
        scoreboard.setBounds(0,0,500,50);
        score.setText("SCORE TEST");
        time.setText("TEST TIME");
        scoreboard.setLayout(new BorderLayout(100,0));
        scoreboard.add(score,BorderLayout.WEST);
        scoreboard.add(time, BorderLayout.EAST);
        gameArea.setBounds(0,0,600,600); 
        game.addKeyListener(keylistener);   
        game.add(gameArea);
        //game.add(scoreboard, BorderLayout.NORTH);
        game.setVisible(true);
    }
}
