package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

public class GameStartButton extends JButton {
    private GridBagConstraints constraints;

    public GameStartButton() {
        super("开始游戏");
        setSize(160, 80);
        setPreferredSize(new Dimension(160, 80));
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }
}
