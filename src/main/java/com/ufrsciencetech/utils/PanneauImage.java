package com.ufrsciencetech.utils;

import java.awt.*;
import javax.swing.*;

public class PanneauImage extends JPanel {

    private Image img;

    public PanneauImage() {
        super();
        this.img = null;
    }

    public void setImage(Image im) {
        this.img = im;
        repaint();
    }

    public Image getImage() {
        return this.img;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
