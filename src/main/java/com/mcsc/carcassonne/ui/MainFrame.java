package com.mcsc.carcassonne.ui;

import com.mcsc.carcassonne.ui.gaming.GamingPanel;
import com.mcsc.carcassonne.ui.menu.MainMenuPanel;
import com.mcsc.carcassonne.ui.players.PlayersPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 游戏主窗口, 使用CardLayout管理各子面板
 */
public class MainFrame extends JFrame {
    public static final int WINDOW_WIDTH = 1280;
    //窗口宽度+标题栏宽度
    public static final int WINDOW_HEIGHT = 720 + 32;
    private static MainFrame mainWindow = new MainFrame();
    private CardLayout contentPanelLayout;
    private Set<String> panels;

    private MainFrame() {
        panels = new HashSet<>();

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanelLayout = new CardLayout();
        setContentPane(new JPanel());
        JPanel contentPanel = (JPanel) getContentPane();
        contentPanel.setLayout(contentPanelLayout);

        getContentPane().add("MainMenu", MainMenuPanel.getPanel());
        panels.add("MainMenu");
        getContentPane().add("Gaming", GamingPanel.getPanel());
        panels.add("Gaming");
        getContentPane().add("Players", PlayersPanel.getPanel());
        panels.add("Players");
        contentPanelLayout.show(getContentPane(), "MainMenu");
    }

    public static MainFrame getMainWindow() {
        return mainWindow;
    }

    public void switchPanel(String panelName) {
        if (!panels.contains(panelName)) {
            System.out.println("Panel don't exist");
        }
        contentPanelLayout.show(getContentPane(), panelName);
    }
}
