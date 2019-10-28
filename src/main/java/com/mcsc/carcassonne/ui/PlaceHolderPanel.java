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

    public static PlaceHolderPanel getStartPlaceHolderUp() {
        PlaceHolderPanel placeHolder = new PlaceHolderPanel();
        placeHolder.constraints.gridx = 0;
        placeHolder.constraints.gridy = 0;
        placeHolder.constraints.gridwidth = 16;
        placeHolder.constraints.gridheight = 5;
        placeHolder.constraints.weightx = 100;
        placeHolder.constraints.weighty = 100;
        return placeHolder;
    }

    public static PlaceHolderPanel getStartPlaceHolderDown() {
        PlaceHolderPanel placeHolder = new PlaceHolderPanel();
        placeHolder.constraints.gridx = 0;
        placeHolder.constraints.gridy = 6;
        placeHolder.constraints.gridwidth = 16;
        placeHolder.constraints.gridheight = 3;
        placeHolder.constraints.weightx = 100;
        placeHolder.constraints.weighty = 100;
        return placeHolder;
    }
}
