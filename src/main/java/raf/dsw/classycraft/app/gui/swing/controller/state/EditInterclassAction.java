package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EditInterclassAction extends AbscractClassyAction {

    public EditInterclassAction(){
        putValue(SMALL_ICON, loadIcon("/images/editattributes.png"));
        putValue(NAME, "Edit Interclass State");
        putValue(SHORT_DESCRIPTION, "Edit Interclass State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startEditClasscontentState();
    }
}
