package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveState implements State {

    private int flag = 0;
    private int x1,y1;
    private int xPrim,yPrim;
    private List<Painter> painters = new ArrayList<>();

    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {
        painters.clear();
        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                Interclass i = (Interclass) p.getDiagramElement();
                if(diagramView.getClassSelectionModel().getSelected().contains(i.getPainter())){
                    if(p.elementAt(x, y)){
                        x1 = xPrim = x;
                        y1 = yPrim = y;
                        flag = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
            }
        }


    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {
        if (flag == 1) {
            for (Painter p : diagramView.getPainters()) {
                if (p.getDiagramElement() instanceof Interclass) {
                    Interclass i = (Interclass) p.getDiagramElement();
                    if (diagramView.getClassSelectionModel().getSelected().contains(i.getPainter())) {
                        if (!painters.contains(p)) {
                            painters.add(p);
                        }
                        i.setX(i.getX() - (xPrim - x));
                        i.setY(i.getY() - (yPrim - y));
                    }
                    diagramView.repaint();
                }
                diagramView.repaint();
            }
            xPrim -= xPrim - x;
            yPrim -= yPrim - y;
        }
    }





    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {
        diagramView.repaint();
    }
}




