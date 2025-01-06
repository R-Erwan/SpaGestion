package com.ufrsciencetech.utils;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel() {
        super();
        this.img = null;
    }

    public Image getImage() {
        return this.img;
    }

    public void setImage(Image im) {
        this.img = im;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
