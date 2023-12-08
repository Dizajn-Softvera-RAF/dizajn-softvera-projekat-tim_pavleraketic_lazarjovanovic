package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddAttributeAction extends AbscractClassyAction {

    public AddAttributeAction(){
        putValue(SMALL_ICON, loadIcon("/images/attributes.png"));
        putValue(NAME, "Add Attribute State");
        putValue(SHORT_DESCRIPTION, "Add Attribute State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startAddAttributeState();
    }
}
