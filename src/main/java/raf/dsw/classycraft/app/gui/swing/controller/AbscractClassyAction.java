package raf.dsw.classycraft.app.gui.swing.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public abstract class AbscractClassyAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            Image img = new ImageIcon(imageURL).getImage();
            Image newImg = img.getScaledInstance(30,30,Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
