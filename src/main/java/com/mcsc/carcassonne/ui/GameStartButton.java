package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

public class GameStartButton extends JButton {
    private GridBagConstraints constraints;

    public GameStartButton() {
        super("开始游戏");
        setSize(160, 80);
        constraints = new GridBagConstraints();
        constraints.gridx = 7;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 100;
        constraints.weighty = 100;
        constraints.fill = GridBagConstraints.NONE;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }
}
