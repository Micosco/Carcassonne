/*
 * Created by JFormDesigner on Sun Dec 01 18:49:50 CST 2019
 */

package com.mcsc.carcassonne.ui.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mcsc.carcassonne.ui.MainFrame;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class MainMenu extends JPanel {
    public MainMenu() {
        initComponents();
    }

    private void startButtonMouseEntered(MouseEvent e) {
        startButton.setIcon(new ImageIcon(getClass().getResource("/ui/NewGameButtonFocus.png")));
    }

    private void startButtonMouseExited(MouseEvent e) {
        startButton.setIcon(new ImageIcon(getClass().getResource("/ui/NewGameButton.png")));
    }

    private void startButtonMouseClicked(MouseEvent e) {
        MainFrame.getMainWindow().switchPanel("Players");
    }

    private void startButtonMousePressed(MouseEvent e) {
        startButton.setIcon(new ImageIcon(getClass().getResource("/ui/NewGameButtonPressed.png")));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        startMenuText = new JTextArea();
        startButton = new JLabel();
        ExitButton = new JLabel();
        background = new JLabel();

        //======== this ========
        setBorder(null);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(new MigLayout(
            "fill,insets -5 -5 null null,hidemode 3",
            // columns
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]",
            // rows
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]" +
            "[80]"));

        //---- startMenuText ----
        startMenuText.setBackground(new Color(255, 255, 255, 0));
        startMenuText.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.BOLD | Font.ITALIC, 48));
        startMenuText.setText("      Carcassonne ");
        startMenuText.setForeground(Color.black);
        startMenuText.setEditable(false);
        startMenuText.setFocusable(false);
        startMenuText.setRequestFocusEnabled(false);
        add(startMenuText, "cell 5 2 6 3");

        //---- startButton ----
        startButton.setIcon(new ImageIcon(getClass().getResource("/ui/NewGameButton.png")));
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startButtonMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                startButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButtonMouseExited(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                startButtonMousePressed(e);
            }
        });
        add(startButton, "cell 7 5 2 1");
        add(ExitButton, "cell 7 6 2 1");

        //---- background ----
        background.setIcon(new ImageIcon(getClass().getResource("/ui/cover.png")));
        add(background, "cell 0 0 16 9");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextArea startMenuText;
    private JLabel startButton;
    private JLabel ExitButton;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
