package raf.dsw.classycraft.app.gui.swing.controller.state;

import raf.dsw.classycraft.app.gui.swing.controller.AbscractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbscractClassyAction {

    public ZoomInAction(){
        putValue(SMALL_ICON, loadIcon("/images/zoomin.png"));
        putValue(NAME, "Zoom In");
        putValue(SHORT_DESCRIPTION, "Zoom In");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(MainFrame.getInstance().getPackageView().getJTabbedPane().getSelectedComponent());
        //((DiagramView) MainFrame.getInstance().getPackageView().getJTabbedPane().getSelectedComponent()).zoomIn();
    }

}
