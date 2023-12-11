package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ConnectStateAction extends AbscractClassyAction {
    public ConnectStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/connect.png"));
        putValue(NAME, "Connect State");
        putValue(SHORT_DESCRIPTION, "Connect State");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startConnectState();
    }
}
