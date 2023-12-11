package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveState implements State {

    private Interclass interclass;
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
        Point point = new Point(x,y);
        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                Interclass i = (Interclass) p.getDiagramElement();
                if(diagramView.getClassSelectionModel().getSelected().contains(i.getPainter())){
                    if(p.elementAt((int) point.getX(), (int) point.getY())){
                        x1 = x;
                        y1 = y;
                        xPrim = x;
                        yPrim = y;
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
        if(flag == 1){
            for(Painter p: diagramView.getPainters()){
                if(p.getDiagramElement() instanceof Interclass){
                    Interclass i = (Interclass) p.getDiagramElement();
                    if(diagramView.getClassSelectionModel().getSelected().contains(i.getPainter())){
                        if(!painters.contains(p)){
                            painters.add(p);
                        }
                        i.setX(i.getX() - (xPrim - x));
                        i.setY(i.getY() - (yPrim - y));
                        for(ConnectPainter painter : diagramView.getConnectList()){
                            Connection con = (Connection) painter.getDiagramElement();
                            if(con.getOd().equals(i)){
                                Point pos1 = new Point(painter.getPos1().x - (xPrim - x), painter.getPos1().y - (yPrim - y));
                                painter.setPos1(pos1);
                            }else{
                                Point pos2 = new Point(painter.getPos2().x - (xPrim - x), painter.getPos2().y - (yPrim - y));
                                painter.setPos2(pos2);
                            }
                        }
                    }
                }
                }
                diagramView.repaint();
            }
            xPrim -= xPrim - x;
            yPrim -= yPrim - y;
            diagramView.repaint();
    }


    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {
        diagramView.repaint();
    }
}
