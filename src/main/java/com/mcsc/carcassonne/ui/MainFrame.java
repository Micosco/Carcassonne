package com.mcsc.carcassonne.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static MainFrame mainWindow;
    private CardLayout contentPanelLayout;

    public MainFrame() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);    //
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        contentPanelLayout = new CardLayout();
        setContentPane(new JPanel());
        JPanel contentPanel = (JPanel) getContentPane();
        contentPanel.setLayout(contentPanelLayout);
        getContentPane().add("MainMenu", MainMenuPanel.getPanel());
        contentPanelLayout.show(getContentPane(), "MainMenu");

        mainWindow = this;
    }


}
