package raf.dsw.classycraft.app.gui.swing.view.controller;

import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.*;

@Setter
public class MouseController implements MouseListener, MouseMotionListener{

    private DiagramView diagramView;
    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        int x = point.x;
        int y = point.y;
        MainFrame.getInstance().getPackageView().misKliknut(x, y, diagramView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        int x = point.x;
        int y = point.y;
        MainFrame.getInstance().getPackageView().misPritisnut(x, y, diagramView);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point point = e.getPoint();
        int x = point.x;
        int y = point.y;
        MainFrame.getInstance().getPackageView().misOtpusten(x, y, diagramView);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point point = e.getPoint();
        int x = point.x;
        int y = point.y;
        MainFrame.getInstance().getPackageView().misPovucen(x, y, diagramView);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
