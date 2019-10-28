package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static MainFrame mainWindow;
    private CardLayout contentPanelLayout;

    public MainFrame() {
        Dimension halfScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        halfScreenSize.setSize(halfScreenSize.width / 2, halfScreenSize.height / 2);
        setSize(halfScreenSize);
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
