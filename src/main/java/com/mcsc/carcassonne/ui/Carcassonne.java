package com.mcsc.carcassonne.ui;


import javax.swing.*;

public class Carcassonne {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame window = new MainFrame();
        window.setVisible(true);
    }
}
