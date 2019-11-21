package com.mcsc.carcassonne.ui.gaming;

import javax.swing.*;
import java.awt.*;

public class SampleComponent extends JComponent {
    private Image image;

    public SampleComponent() {
        this.image = new ImageIcon("src/main/resources/ui/sample.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
