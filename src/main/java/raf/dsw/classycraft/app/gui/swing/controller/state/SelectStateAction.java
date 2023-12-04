package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectStateAction extends AbscractClassyAction {

    public SelectStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Select State");
        putValue(SHORT_DESCRIPTION, "Select State");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainFrame.getInstance().getPackageView().startAddState();
    }

}
