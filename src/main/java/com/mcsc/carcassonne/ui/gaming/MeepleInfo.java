package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.board.EdgeDirectionEnum;


import javax.swing.*;
import java.awt.*;

/**
 * 生成米宝必要信息的包装类
 */
public class MeepleInfo {
    private EdgeDirectionEnum position;
    private ImageIcon image;
    private boolean effective;

    public MeepleInfo(Color color, EdgeDirectionEnum position) {
        this.position = position;
        if (color == Color.RED) {
            image = new ImageIcon(getClass().getResource("/textures/meeple/follower_RED.png"));
        } else if (color == Color.BLUE) {
            image = new ImageIcon(getClass().getResource("/textures/meeple/follower_BLUE.png"));
        } else if (color == Color.YELLOW) {
            image = new ImageIcon(getClass().getResource("/textures/meeple/follower_YELLOW.png"));
        } else if (color == Color.BLACK) {
            image = new ImageIcon(getClass().getResource("/textures/meeple/follower_BLACK.png"));
        } else if (color == Color.PINK) {
            image = new ImageIcon(getClass().getResource("/textures/meeple/follower_PINK.png"));
        }
        effective = true;
    }

    /**
     * 当米宝不存在时防止nullPointer
     */
    public MeepleInfo() {
    }

    public EdgeDirectionEnum getPosition() {
        return position;
    }

    public ImageIcon getImage() {
        return image;
    }

    public boolean isEffective() {
        return effective;
    }
}
