package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;

/**
 * @author WhiteWing
 */
public class PlayerInfo extends JPanel {
    public PlayerInfo() {
        setPreferredSize(new Dimension(600,80));
        setLayout(new FlowLayout());
        add(new PlayerColor());
        add(new JTextField(20));
    }
}
