package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        add(fileMenu);

        JMenu aboutUs = new JMenu("About Us");
        aboutUs.add(MainFrame.getInstance().getActionManager().getAboutUsSection());
        add(aboutUs);

    }

}
