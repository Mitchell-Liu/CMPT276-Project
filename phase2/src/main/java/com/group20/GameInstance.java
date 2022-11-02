package com.group20;

import java.awt.*;  
import javax.swing.*;

public class GameInstance {
    JFrame frame;

    GameInstance(GameFactory factory){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Map map = factory.makeMap();
        Board board = factory.makeBoard(map);
        eventManager keylistener = new eventManager(map, board);
        JPanel scoreboard = new JPanel();
        JTextPane score = new JTextPane();
        JTextPane time = new JTextPane();
        frame.setSize(615,660);
        scoreboard.setBackground(Color.YELLOW);
        scoreboard.setBounds(0,0,500,50);
        score.setText("SCORE TEST");
        time.setText("TEST TIME");
        scoreboard.setLayout(new BorderLayout(100,0));
        scoreboard.add(score,BorderLayout.WEST);
        scoreboard.add(time, BorderLayout.EAST);
        board.setBounds(0,0,600,600); 
        frame.addKeyListener(keylistener); 

        frame.add(board);
        //frame.add(scoreboard, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
