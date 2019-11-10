package com.mcsc.carcassonne.ui.gaming;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 显示板块的面板
 */
public class GamingPanel extends JPanel {
    private static GamingPanel gamingPanel = new GamingPanel();

    private GamingPanel() {
        setLayout(new MigLayout("wrap 16"));
        setBackground(Color.LIGHT_GRAY);

        add(new GamingStatsPanel(), "span 3 9");
        add(new BoardPanel(), "span 13 9");
    }

    public static GamingPanel getNewPanel() {
        if (gamingPanel == null) {
            gamingPanel = new GamingPanel();
        } else {

        }
        return gamingPanel;
    }
}
