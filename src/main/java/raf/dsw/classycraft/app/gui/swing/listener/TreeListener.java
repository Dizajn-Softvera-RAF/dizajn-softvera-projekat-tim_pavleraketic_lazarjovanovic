package raf.dsw.classycraft.app.gui.swing.listener;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TreeListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (MainFrame.getInstance().getClassyTree().getSelectedNode().getClassyNode() instanceof Package) {
            if (e.getClickCount() == 2) {

                Package p = (Package) MainFrame.getInstance().getClassyTree().getSelectedNode().getClassyNode();
                MainFrame.getInstance().getPackageView().reloadTabs(p);

            }
        }
    }
}
