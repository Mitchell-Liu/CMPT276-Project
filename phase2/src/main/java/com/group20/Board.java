package com.group20;

import java.awt.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


public class Board extends JPanel{




    private Map map;
    BufferedImage[] allImages;
    JLabel[] labels;
    JLabel[][] board;
    ImageIcon[] icons;
    JLabel playerScore;
    
    Board(Map gameMap){

        map = gameMap;

        board = new JLabel[20][20];

        
        File path = new File("./phase2/src/main/java/com/group20/Assets");

        File[] allFiles = path.listFiles();

        allImages = new BufferedImage[allFiles.length];

        this.setLayout(null);
        //this.setBackground(Color.BLUE);
        this.setOpaque (false);

        labels = new JLabel[allFiles.length];
        icons = new ImageIcon[allFiles.length];

        for(int i=0; i<allFiles.length; i++){
            try{
                allImages[i] = ImageIO.read(allFiles[i]);
                labels[i] = new JLabel();
                ImageIcon icon = new ImageIcon(allImages[i]);
                Image image = icon.getImage();
                Image scaled = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
                labels[i].setIcon(icon);
                labels[i].setSize(30, 30);
                icons[i] = icon;
            }
            catch(IOException e){

            }
        }

        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                board[i][j] = new JLabel();
                board[i][j].setBounds(i*30, j*30, 30, 30);
                //board[i][j].setIcon(icons[6]);
                this.add(board[i][j]);
            }
        }

        playerScore = new JLabel("YOUR SCORE:\n"+map.getPlayerScore());
        playerScore.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        playerScore.setForeground(Color.white);
        playerScore.setHorizontalAlignment(JLabel.CENTER);
        playerScore.setVerticalAlignment(JLabel.CENTER);
        playerScore.setPreferredSize(new Dimension(200, 300));


    }

    public Map getMap(){
        return map;
    }

    public JLabel getPlayerScoreLabel(){
        return playerScore;
    }

    
    public void updateBoard(){
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Position currPosition = new Position(i, j);
                switch (map.getEntityNameAt(currPosition)){
                    case "Diver":
                        board[i][j].setIcon(icons[1]);
                        break;
                    case "Shark":
                        board[i][j].setIcon(icons[3]);
                        break;
                    case "Wall":
                        board[i][j].setIcon(icons[5]);
                        break; 
                    case "Coin":
                        board[i][j].setIcon(icons[0]);
                        break;
                    case "TreasureChest":
                        board[i][j].setIcon(icons[4]);
                        break;
                    case "Seaweed":
                        board[i][j].setIcon(icons[2]);
                        break;
                    case "Exit":
                        board[i][j].setIcon(null);
                        board[i][j].setText("EXIT");                
                    default:
                        board[i][j].setIcon(null);    

                }
            }
        }
        playerScore.setText("YOUR SCORE:\n"+map.getPlayerScore());
    }
}
