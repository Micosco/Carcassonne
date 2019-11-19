package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author WhiteWing
 */
public class PlayerColor extends JPanel {
    public static final int SIZE = 40;
    private static int playerCount = 0;

    public PlayerColor() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBackground(Color.RED);
        playerCount++;
    }
}
