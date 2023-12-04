package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveStateAction extends AbscractClassyAction {

    public MoveStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(NAME, "Move State");
        putValue(SHORT_DESCRIPTION, "Move State");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainFrame.getInstance().getPackageView().startAddState();
    }
}
