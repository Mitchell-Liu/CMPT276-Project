package com.group20;

import java.awt.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


public class Board extends JPanel{




    private Map map;
    BufferedImage[] allImages;
    JLabel[] labels;
    JLabel[][] board;
    ImageIcon[] icons;
    
    Board(Map gameMap){

        map = gameMap;

        board = new JLabel[20][20];

        File path = new File("project/phase2/src/main/java/com/group20/Assets");

        File[] allFiles = path.listFiles();

        allImages = new BufferedImage[allFiles.length];

        this.setLayout(null);
        this.setBackground(Color.BLUE);

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


    }

    public Map getMap(){
        return map;
    }

    
    public void updateBoard(){
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Position currPosition = new Position(i, j);
                switch (map.getEntityNameAt(currPosition)){
                    case "com.group20.Diver":
                        board[i][j].setIcon(icons[1]);
                        break;
                    case "com.group20.Shark":
                        board[i][j].setIcon(icons[3]);
                        break;
                    case "com.group20.Wall":
                        board[i][j].setIcon(icons[5]);
                        break; 
                    default:
                        board[i][j].setIcon(null);    

                }
            }
            System.out.print("\n");
        }
    }
}
