package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DuplicateAction extends AbscractClassyAction {

    public DuplicateAction(){
        putValue(SMALL_ICON, loadIcon("/images/duplicate.png"));
        putValue(NAME, "Duplicate State");
        putValue(SHORT_DESCRIPTION, "Duplicate State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startDuplicateState();
    }
}
