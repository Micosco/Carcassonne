package com.mcsc.carcassonne.ui.players;


import com.mcsc.carcassonne.event.ui.players.GameStartListener;

import javax.swing.*;
import java.awt.*;


/**
 * @author WhiteWing
 */
public class GameStartButton extends JButton {
    public GameStartButton() {
        super("开始游戏");
        setSize(160, 80);
        setPreferredSize(new Dimension(160, 80));
        addActionListener(new GameStartListener());
    }
}
