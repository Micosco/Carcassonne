package com.mcsc.carcassonne.ui.players;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 玩家管理界面
 * @author WhiteWing
 */
public class PlayersPanel extends JPanel {
    public static PlayersPanel panel = new PlayersPanel();
    private ArrayList<PlayerInfo> players;
    private JLabel background = new JLabel();

    private PlayersPanel() {
        initialPanel();
    }

    private void initialPanel() {
        setPreferredSize(new Dimension(1280, 720));
        //使PlayerInfo竖直排列
        ((FlowLayout) getLayout()).setHgap(1000);

        //添加可用玩家
        players = new ArrayList<>();
        for (int i = 0; i < PlayerColor.getMaxPlayerNum(); i++) {
            players.add(new PlayerInfo());
        }

        for (var player : players) {
            add(player);
        }
        add(new GameStartButton());
    }

    public ArrayList<PlayerInfo> getPlayersInfo() {
        ArrayList<PlayerInfo> enabledPlayers = new ArrayList<>();
        for (var player : players) {
            if (player.isEnable()) {
                enabledPlayers.add(player);
            }
        }
        return enabledPlayers;
    }

    public static PlayersPanel getPanel() {
        return panel;
    }
}
