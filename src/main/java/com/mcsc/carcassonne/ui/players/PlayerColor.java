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
    private Color color;
    private final static Color[] colors = {
            Color.RED,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK,
            Color.PINK
    };

    public PlayerColor() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        color = colors[playerCount++];
        setBackground(Color.GRAY);
    }

    public void setEnable(boolean enable) {
        if (enable) {
            setBackground(color);
        } else {
            setBackground(Color.GRAY);
        }
    }

    public Color getColor() {
        return color;
    }

    public static int getMaxPlayerNum() {
        return colors.length;
    }
}
