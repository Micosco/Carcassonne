package com.mcsc.carcassonne.ui.menu;

import com.mcsc.carcassonne.event.ui.menu.NewGameListener;

import javax.swing.*;
import java.awt.*;

/**
 * @author WhiteWing
 */
public class NewGameButton extends JButton {

    public NewGameButton() {
        super("新建游戏");
        setSize(160, 80);
        setPreferredSize(new Dimension(160, 80));
        addActionListener(new NewGameListener());
    }
}
