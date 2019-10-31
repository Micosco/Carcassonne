package com.mcsc.carcassonne.ui;

import javax.swing.*;
import java.awt.*;

public class PlaceHolderPanel extends JPanel {
    private GridBagConstraints constraints;

    private PlaceHolderPanel() {
        this.constraints = new GridBagConstraints();
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }
}
