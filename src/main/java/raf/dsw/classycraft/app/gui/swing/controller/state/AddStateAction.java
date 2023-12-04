package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddStateAction  extends AbscractClassyAction {
    public AddStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/paint.png"));
        putValue(NAME, "Add State");
        putValue(SHORT_DESCRIPTION, "Add State");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainFrame.getInstance().getPackageView().startAddState();
}
}

