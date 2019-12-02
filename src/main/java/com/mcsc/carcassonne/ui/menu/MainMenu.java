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

    private void label1MouseEntered(MouseEvent e) {
        label1.setIcon(new ImageIcon(getClass().getResource("/ui/ButtonFocus.png")));
    }

    private void label1MouseExited(MouseEvent e) {
        label1.setIcon(new ImageIcon(getClass().getResource("/ui/Button.png")));
    }

    private void label1MouseClicked(MouseEvent e) {
        MainFrame.getMainWindow().switchPanel("Players");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        StartMenuText = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        BackGround = new JLabel();

        //======== this ========
        setBorder(null);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
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
            "[]"));

        //---- StartMenuText ----
        StartMenuText.setBackground(new Color(255, 255, 255, 0));
        StartMenuText.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1 Light", Font.BOLD | Font.ITALIC, 48));
        StartMenuText.setText("      Carcassonne ");
        StartMenuText.setForeground(Color.black);
        StartMenuText.setEditable(false);
        StartMenuText.setFocusable(false);
        StartMenuText.setRequestFocusEnabled(false);
        add(StartMenuText, "cell 5 2 6 3");

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/ui/Button.png")));
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1MouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                label1MouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                label1MouseExited(e);
            }
        });
        add(label1, "cell 7 5 2 1");
        add(label2, "cell 7 6 2 1");

        //---- BackGround ----
        BackGround.setIcon(new ImageIcon(getClass().getResource("/ui/cover.png")));
        add(BackGround, "cell 0 0 16 9");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextArea StartMenuText;
    private JLabel label1;
    private JLabel label2;
    private JLabel BackGround;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
