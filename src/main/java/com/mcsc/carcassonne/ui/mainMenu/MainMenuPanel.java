package com.mcsc.carcassonne.ui.mainMenu;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private static MainMenuPanel mainMenuPanel;

    private MainMenuPanel() {
        MigLayout layout = new MigLayout("wrap 16");
        setLayout(layout);

        addPlaceHolders();
        add(new StartMenuTextFiled(), "cell 5 2 6 3");
        add(new GameStartButton(), "cell 7 5 2 1 ");
        add(new OptionsButton(), "cell 7 6 2 1");
    }

    private void addPlaceHolders() {
        JPanel placeHolder1 = new JPanel();
        placeHolder1.setPreferredSize(new Dimension(400, 720));
        //placeHolder1.setBackground(Color.BLACK);
        add(placeHolder1, "span 5 9");

        JPanel placeHolder2 = new JPanel();
        placeHolder2.setPreferredSize(new Dimension(160, 320));
        //placeHolder2.setBackground(Color.BLACK);
        add(placeHolder2, "cell 5 5 2 4");

        JPanel placeHolder3 = new JPanel();
        placeHolder3.setPreferredSize(new Dimension(400, 160));
        //placeHolder3.setBackground(Color.BLACK);
        add(placeHolder3, "cell 5 0 10 2");

        JPanel placeHolder4 = new JPanel();
        placeHolder4.setPreferredSize(new Dimension(160, 160));
        //placeHolder4.setBackground(Color.BLACK);
        add(placeHolder4, "cell 7 7 2 2");
    }

    public static MainMenuPanel getPanel() {
        if (mainMenuPanel == null) {
            mainMenuPanel = new MainMenuPanel();
        }
        return mainMenuPanel;
    }

    private String getColumnSize() {
        StringBuilder columnSize = new StringBuilder();
        columnSize.append("[80]".repeat(16));
        return columnSize.toString();
    }

    private String getRowSize() {
        StringBuilder rowSize = new StringBuilder();
        rowSize.append("[80]".repeat(16));
        return rowSize.toString();
    }
}

