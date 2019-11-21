package com.mcsc.carcassonne.ui.gaming;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    public BoardPanel() {
        setPreferredSize(new Dimension(1040, 720));
        setLayout(null);
        SampleComponent comp = new SampleComponent();
        add(comp);
        comp.setBounds(200,200, 443 ,295);

    }
}
