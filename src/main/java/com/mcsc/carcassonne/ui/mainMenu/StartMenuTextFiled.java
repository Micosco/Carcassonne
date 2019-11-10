package com.mcsc.carcassonne.ui.mainMenu;

import javax.swing.*;
import java.awt.*;

class StartMenuTextFiled extends JTextField {
    public StartMenuTextFiled() {
        setPreferredSize(new Dimension(480, 240));
        setBorder(null);
        setHorizontalAlignment(JTextField.CENTER);
        setText("Game Introduce");
        setEditable(false);
    }
}
