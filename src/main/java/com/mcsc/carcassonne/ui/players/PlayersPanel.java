package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;

/**
 * 玩家管理界面
 * @author WhiteWing
 */
public class PlayersPanel extends JPanel {
    public static PlayersPanel panel = new PlayersPanel();

    private PlayersPanel() {
        setPreferredSize(new Dimension(1280, 720));
        add(new PlayerInfo());
    }

    public static PlayersPanel getPanel() {
        return panel;
    }
}
