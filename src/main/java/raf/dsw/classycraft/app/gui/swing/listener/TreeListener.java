package raf.dsw.classycraft.app.gui.swing.listener;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TreeListener extends MouseAdapter {


    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        try {
            if (MainFrame.getInstance().getClassyTree().getSelectedNode().getClassyNode() instanceof Package) {
                if (e.getClickCount() == 2) {

                    Package p = (Package) MainFrame.getInstance().getClassyTree().getSelectedNode().getClassyNode();
                    PackageView pv = new PackageView(p);
                    p.addSubscriber(pv);
                    //p.getParent().addSubscriber(pv);
                    try {
                        p.notifySubscribers(p);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    MainFrame.getInstance().reload(pv);
                }
            }
        } catch (NullPointerException ex){}


}}
