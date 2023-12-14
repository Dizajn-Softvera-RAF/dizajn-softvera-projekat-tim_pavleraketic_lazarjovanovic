package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomOutAction extends AbscractClassyAction {


    public ZoomOutAction() {
        putValue(SMALL_ICON, loadIcon("/images/zoomout.png"));
        putValue(NAME, "Zoom Out");
        putValue(SHORT_DESCRIPTION, "Zoom Out");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startZoomOutState();
    }
}
