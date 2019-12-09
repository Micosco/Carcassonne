/*
 * Created by JFormDesigner on Tue Dec 03 22:26:03 CST 2019
 */

package com.mcsc.carcassonne.ui.players;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.ui.MainFrame;
import com.mcsc.carcassonne.ui.gaming.GamingPanel;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class PlayerSettingPanel extends JPanel {
    private static PlayerSettingPanel panel;
    private ArrayList<PlayerInfo> players = new ArrayList<>();

    public static PlayerSettingPanel getPanel() {
        return panel;
    }

    public PlayerSettingPanel() {
        initComponents();
        initPlayerList();
        panel = this;
    }

    private void initPlayerList() {
        players.add(playerInfo1);
        players.add(playerInfo2);
        players.add(playerInfo3);
        players.add(playerInfo4);
        players.add(playerInfo5);
    }

    public ArrayList<PlayerInfo> getEnabledPlayersInfo() {
        ArrayList<PlayerInfo> enabledPlayers = new ArrayList<>();
        for (var player : players) {
            if (player.isEnable()) {
                enabledPlayers.add(player);
            }
        }
        return enabledPlayers;
    }

    private void StartGameButtonMouseEntered(MouseEvent e) {
        StartGameButton.setIcon(new ImageIcon(getClass().getResource("/ui/StartButtonFocus.png")));
    }

    private void StartGameButtonMouseExited(MouseEvent e) {
        StartGameButton.setIcon(new ImageIcon(getClass().getResource("/ui/StartButton.png")));
    }

    private void StartGameButtonMouseClicked(MouseEvent e) {
        if (getEnabledPlayersInfo().size() > 0) {
            GameState.initialNewGame();
            MainFrame.getMainWindow().switchPanel("Gaming");
            GamingPanel.getPanel().initial();
        } else {
            JOptionPane.showMessageDialog(null, "请添加至少一个玩家");
        }
    }

    private void StartGameButtonMousePressed(MouseEvent e) {
        StartGameButton.setIcon(new ImageIcon(getClass().getResource("/ui/StartButtonPressed.png")));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        playerInfo1 = new PlayerInfo();
        playerInfo2 = new PlayerInfo();
        playerInfo3 = new PlayerInfo();
        playerInfo4 = new PlayerInfo();
        playerInfo5 = new PlayerInfo();
        StartGameButton = new JLabel();
        background = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(1280, 720));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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
        add(playerInfo1, "cell 4 1 5 1");
        add(playerInfo2, "cell 4 2 5 1");
        add(playerInfo3, "cell 4 3 5 1");
        add(playerInfo4, "cell 4 4 5 1");
        add(playerInfo5, "cell 4 5 5 1");

        //---- StartGameButton ----
        StartGameButton.setIcon(new ImageIcon(getClass().getResource("/ui/StartButton.png")));
        StartGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StartGameButtonMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                StartGameButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                StartGameButtonMouseExited(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                StartGameButtonMousePressed(e);
            }
        });
        add(StartGameButton, "cell 6 6 2 1");

        //---- background ----
        background.setIcon(new ImageIcon(getClass().getResource("/ui/cover.png")));
        add(background, "cell 0 0 16 10");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private PlayerInfo playerInfo1;
    private PlayerInfo playerInfo2;
    private PlayerInfo playerInfo3;
    private PlayerInfo playerInfo4;
    private PlayerInfo playerInfo5;
    private JLabel StartGameButton;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
