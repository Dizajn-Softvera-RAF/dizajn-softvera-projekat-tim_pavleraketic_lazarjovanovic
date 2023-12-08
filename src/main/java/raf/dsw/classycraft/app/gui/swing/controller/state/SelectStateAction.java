package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectStateAction extends AbscractClassyAction {

    public SelectStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startSelectState();
    }

}
