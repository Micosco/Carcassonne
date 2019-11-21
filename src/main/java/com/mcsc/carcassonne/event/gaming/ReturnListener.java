package com.mcsc.carcassonne.event.gaming;

import com.mcsc.carcassonne.ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnListener implements ActionListener {
    private static final String CONFIRM_MESSAGE = "确定要返回主菜单？";
    private static final String CONFIRM_TITLE = "返回主菜单";

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(MainFrame.getMainWindow(), CONFIRM_MESSAGE, CONFIRM_TITLE, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            MainFrame.getMainWindow().switchPanel("MainMenu");
        }
    }
}
