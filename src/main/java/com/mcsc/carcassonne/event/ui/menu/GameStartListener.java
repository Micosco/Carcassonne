package com.mcsc.carcassonne.event.ui.menu;

import com.mcsc.carcassonne.ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStartListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getMainWindow().switchPanel("Players");
    }
}