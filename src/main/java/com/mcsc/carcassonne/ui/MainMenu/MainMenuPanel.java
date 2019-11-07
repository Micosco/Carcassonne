package com.mcsc.carcassonne.ui.MainMenu;

import com.mcsc.carcassonne.ui.AbstractGamePanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends AbstractGamePanel {
    private static MainMenuPanel mainMenuPanel;

    private MainMenuPanel() {
        setLayout(new MigLayout("wrap 16"));
        GameStartButton startButton = new GameStartButton();

        addPlaceHolders();
        add(new StartMenuTextFiled(), "cell 5 2 6 3");
        add(new GameStartButton(), "cell 7 6 2 1 ");
    }

    private void addPlaceHolders() {
        JPanel placeHolder1 = new JPanel();
        placeHolder1.setPreferredSize(new Dimension(400 , 720));
        add(placeHolder1, "span 5 9");



        JPanel placeHolder2 = new JPanel();
        placeHolder2.setPreferredSize(new Dimension(160 , 320));
        add(placeHolder2, "cell 5 5 2 4");

        JPanel placeHolder3 = new JPanel();
        placeHolder3.setPreferredSize(new Dimension(400, 160));
        add(placeHolder3, "cell 5 0 6 2");
    }

    public static MainMenuPanel getPanel() {
        if (mainMenuPanel == null) {
            mainMenuPanel = new MainMenuPanel();
        }
        return mainMenuPanel;
    }

    private String getColumnSize() {
        StringBuilder columnSize = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            columnSize.append("[80]");
        }
        return columnSize.toString();
    }

    private String getRowSize() {
        StringBuilder rowSize = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            rowSize.append("[80]");
        }
        return rowSize.toString();
    }
}

