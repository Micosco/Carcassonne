package com.mcsc.carcassonne.ui.gaming;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 显示板块的面板
 *
 * @author WhiteWing
 */
public class GamingPanel extends JPanel {
    private static GamingPanel panel = new GamingPanel();
    private GamingStatsPanel gamingStatePanel;
    private BoardPanel boardPanel;

    private GamingPanel() {
        setLayout(new MigLayout("wrap 16"));
        setBackground(Color.LIGHT_GRAY);
        gamingStatePanel = new GamingStatsPanel();
        add(gamingStatePanel, "span 3 9");
        boardPanel = new BoardPanel();
        add(boardPanel, "span 13 9");
    }

    /**
     * 每次新建游戏时调用，更新{@code GameStatePanel}和{@code BoardPanel}
     */
    public void initial() {
        remove(gamingStatePanel);
        gamingStatePanel = new GamingStatsPanel();
        add(gamingStatePanel, "span 3 9");
        remove(boardPanel);
        boardPanel = new BoardPanel();
        add(boardPanel, "span 13 9");
    }

    public static GamingPanel getPanel() {
        return panel;
    }
}
