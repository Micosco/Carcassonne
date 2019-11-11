package com.mcsc.carcassonne.ui.menu;

import com.mcsc.carcassonne.event.menu.GameStartListener;

import javax.swing.*;
import java.awt.*;

public class GameStartButton extends JButton {

    public GameStartButton() {
        super("开始游戏");
        setSize(160, 80);
        setPreferredSize(new Dimension(160, 80));
        addActionListener(new GameStartListener());
    }
}
