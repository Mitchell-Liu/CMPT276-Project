package com.group20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickButton extends JLabel implements MouseListener{
    ActionListener myAL;
    public ClickButton(String str){
        super(str);
        this.setForeground(Color.blue);
        this.setOpaque(true);
        this.addMouseListener(this);
        setFont(new Font("Serif", Font.PLAIN, 60));
    }
    public void addActionListener(ActionListener al){
        myAL = al;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        myAL.actionPerformed(new ActionEvent(this,501,""));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setForeground(new Color(243, 105, 66));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setForeground(Color.blue);
    }
}
