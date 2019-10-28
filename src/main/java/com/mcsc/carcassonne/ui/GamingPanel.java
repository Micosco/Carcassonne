package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 显示板块的面板
 */
public class GamingPanel extends AbstractGamePanel {
    private static GamingPanel gameBoard;

    private GamingPanel() {
        layout = new GridBagLayout();
        setLayout(layout);
    }

    public static GamingPanel getNewPanel() {
        if (gameBoard == null) {
            gameBoard = new GamingPanel();
        } else {

        }
        return gameBoard;
    }
}
