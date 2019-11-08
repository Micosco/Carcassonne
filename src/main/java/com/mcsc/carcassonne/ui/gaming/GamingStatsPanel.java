package com.mcsc.carcassonne.ui.gaming;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏面板的子面板，用于显示玩家信息和游戏信息
 * <p>
 * 玩家信息：玩家昵称， 玩家得分， 剩余米宝， 标记进行回合的玩家
 * <p>
 * 游戏信息：显示要放置的板块
 */
public class GamingStatsPanel extends JPanel {
    public GamingStatsPanel() {
        setPreferredSize(new Dimension(240, 720));
    }
}
