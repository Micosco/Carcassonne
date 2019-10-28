package com.mcsc.carcassonne.ui;

import java.awt.*;

public class MainMenuPanel extends AbstractGamePanel {
    private static MainMenuPanel mainMenuPanel;

    private MainMenuPanel() {
        setLayout(layout);
        GameStartButton startButton = new GameStartButton();
        add(startButton, startButton.getConstraints());
        PlaceHolderPanel placeHolderPanel =  PlaceHolderPanel.getStartPlaceHolderUp();
        add(placeHolderPanel, placeHolderPanel.getConstraints());
        placeHolderPanel.setBackground(Color.BLACK);
        PlaceHolderPanel placeHolderPanelDown = PlaceHolderPanel.getStartPlaceHolderDown();
        placeHolderPanelDown.setBackground(Color.BLACK);
        add(placeHolderPanelDown, placeHolderPanelDown.getConstraints());
    }

    public static MainMenuPanel getPanel() {
        if (mainMenuPanel == null) {
            mainMenuPanel = new MainMenuPanel();
        }
        return mainMenuPanel;
    }
}
