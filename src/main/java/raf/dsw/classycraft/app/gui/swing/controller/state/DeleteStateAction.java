package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteStateAction extends AbscractClassyAction {

    public DeleteStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/erase.png"));
        putValue(NAME, "Erase State");
        putValue(SHORT_DESCRIPTION, "Erase State");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startDeleteState();
    }

}
