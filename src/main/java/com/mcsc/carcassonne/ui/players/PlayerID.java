package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerID extends JTextField {
    public static final int MAX_LENGTH = 10;

    public PlayerID() {
        super(20);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String s = getText();
                if (s.length() >= MAX_LENGTH) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //do nothing
            }
        });

        setFont(new Font("微软雅黑", Font.PLAIN, 20));
    }
}
