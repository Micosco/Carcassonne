package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.game.Player;
import com.mcsc.carcassonne.ui.players.PlayerID;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏时显示玩家颜色,ID,分数
 *
 * @author WhiteWing
 */
public class PlayerInfo extends JLabel {
    private Player player;

    public PlayerInfo(Player player) {
        super();
        this.player = player;
        setHorizontalAlignment(SwingConstants.LEFT);
        setText(player.getId() + " ".repeat(5));
        setFont(new Font("Consolas", Font.BOLD, 20));
        setForeground(player.getColor());
    }

    @Override
    protected void paintComponent(Graphics g) {
        setText(player.getId() + " ".repeat(5) + player.getScore());
        setBackground(player.getColor());
        super.paintComponent(g);
    }
}
