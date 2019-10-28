package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGamePanel extends JPanel {
    protected GridBagLayout layout;

    public AbstractGamePanel() {
        layout = new GridBagLayout();
    }
}
