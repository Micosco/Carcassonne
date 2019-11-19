package com.mcsc.carcassonne.event.gaming;

import com.mcsc.carcassonne.ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getMainWindow().switchPanel("MainMenu");
    }
}
