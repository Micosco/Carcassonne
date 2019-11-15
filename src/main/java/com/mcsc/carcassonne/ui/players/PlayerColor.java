package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author WhiteWing
 */
public class PlayerColor extends JPanel {
    public static final double SIZE = 80;

    public PlayerColor() {
        setPreferredSize(new Dimension(80, 80));
        setSize(getPreferredSize());

    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D graph = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(0, 0, SIZE, SIZE);
        graph.setPaint(Color.RED);
        graph.fill(rect);
        graph.drawString("color", 0, 0);
    }
}
