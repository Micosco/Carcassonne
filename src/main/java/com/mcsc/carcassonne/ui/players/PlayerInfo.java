package com.mcsc.carcassonne.ui.players;

import com.mcsc.carcassonne.event.ui.players.PlayerEnableListener;

import javax.swing.*;
import java.awt.*;

/**
 * 玩家设置面板用于添加玩家，显示玩家颜色，设置玩家ID
 * @author WhiteWing
 */
public class PlayerInfo extends JPanel {
    private final PlayerColor color;
    private final PlayerID ID;
    private JCheckBox enableBox;

    public PlayerInfo() {
        setPreferredSize(new Dimension(600,80));
        setBackground(Color.WHITE);
        setOpaque(false);
        setLayout(new FlowLayout());
        enableBox = new JCheckBox();
        enableBox.setOpaque(false);
        enableBox.addChangeListener(new PlayerEnableListener());
        add(enableBox);
        color = new PlayerColor();
        add(color);
        ID = new PlayerID();
        add(ID);
    }

    public String getID() {
        return ID.getText();
    }

    public boolean isEnable() {
        return enableBox.isSelected();
    }

    public PlayerColor getColorState() {
        return color;
    }
}
