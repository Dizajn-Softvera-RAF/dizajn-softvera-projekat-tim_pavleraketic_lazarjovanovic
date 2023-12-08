package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ClassPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

public class MoveState implements State {

    private int pocetnoX, pocetnoY;
    private int xDva, yDva;
    private PackageView packageView;

    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        diagramView = (DiagramView) packageView.getJTabbedPane().getSelectedComponent();
        pocetnoX = xDva = x;
        pocetnoY = yDva = y;
    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {

        for(Painter painter : diagramView.getSelected()){
            if(painter instanceof ClassPainter){
                Class movingTopic = (Class) painter.getDiagramElement();
                int newX = movingTopic.getX() + x - xDva;
                int newY = movingTopic.getY() + y - yDva;
                movingTopic.setX(newX);
                movingTopic.setY(newY);
            }
        }
        xDva = x;
        yDva = y;

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {

    }
}
