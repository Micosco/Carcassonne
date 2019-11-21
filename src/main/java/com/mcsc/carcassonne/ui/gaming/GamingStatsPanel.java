package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.game.GameState;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 游戏面板的子面板，用于显示玩家信息和游戏信息
 * <p>
 * 玩家信息：玩家昵称， 玩家得分， 剩余米宝， 标记进行回合的玩家
 * <p>
 * 游戏信息：显示要放置的板块
 */
public class GamingStatsPanel extends JPanel {
    public GamingStatsPanel() {
        setPreferredSize(new Dimension(240, 640));
        setLayout(new MigLayout("wrap 3"));
        for (var player : GameState.getCurrentGameState().getPlayersList()) {
            add(new PlayerInfo(player), "span 3 1");
        }
    }
}