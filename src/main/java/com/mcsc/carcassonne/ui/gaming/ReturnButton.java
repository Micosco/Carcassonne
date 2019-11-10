package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.event.gaming.ReturnListener;

import javax.swing.*;
import java.awt.*;

public class ReturnButton extends JButton {
    public ReturnButton() {
        setPreferredSize(new Dimension(240, 80));
        addActionListener(new ReturnListener());
        setText("返回主菜单");
    }
}
