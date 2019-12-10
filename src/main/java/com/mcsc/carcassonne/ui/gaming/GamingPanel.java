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
    private ReturnButton returnButton;

    private GamingPanel() {
        setLayout(new MigLayout("wrap 16"));
        setBackground(Color.LIGHT_GRAY);
        gamingStatePanel = new GamingStatsPanel();
        boardPanel = new BoardPanel();
        returnButton = new ReturnButton();
    }

    /**
     * 每次新建游戏时调用，更新{@code GameStatePanel}，{@code BoardPanel}和{@code ReturnButton}
     */
    public GamingPanel initial() {
        remove(gamingStatePanel);
        remove(boardPanel);
        remove(returnButton);
        gamingStatePanel = new GamingStatsPanel();
        boardPanel = new BoardPanel();
        boardPanel.placeFirstTile();
        returnButton = new ReturnButton();
        add(gamingStatePanel, "cell 0 0 3 8");
        add(boardPanel, "cell 3 0 13 9");
        add(returnButton, "cell 0 8 3 1");
        return this;
    }

    public static GamingPanel getPanel() {
        return panel;
    }
}
