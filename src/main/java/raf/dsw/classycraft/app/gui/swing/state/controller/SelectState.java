package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.MultiSelectionPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectState implements State {

    private PackageView packageView;
    private int x1,y1;
    private List<Painter> nova = new ArrayList<>();
    private MultiSelectionPainter msp = new MultiSelectionPainter();


    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {


    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {
        //diagramView = (DiagramView) packageView.getJTabbedPane().getSelectedComponent();

        if(!(diagramView.getClassSelectionModel().getSelected().isEmpty())){
            try {
                diagramView.getClassSelectionModel().clearList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        nova.clear();

        for(Painter p: diagramView.getPainters()){

            if(p.elementAt(x,y)){
                try {
                    diagramView.getClassSelectionModel().addElement(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                x1 = x;
                y1 = y;
                nova.add(msp);
            }
        }
        if(!nova.isEmpty()){
            for(Painter p : nova){
                diagramView.getPainters().add(p);
                diagramView.repaint();
            }
        }

    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView)  {

        if(!(diagramView.getClassSelectionModel().getSelected().isEmpty())) {
            try {
                diagramView.getClassSelectionModel().clearList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        msp.updatePoints(x1, y1, x, y);
        //diagramView.update(msp);
        diagramView.repaint();


        for(Painter p : diagramView.getPainters()){
            if(p instanceof MultiSelectionPainter)
                continue;

            if(msp.getShape() == null){
                diagramView.getPainters().remove(msp);
                return;
            }
            if(msp.getShape().intersects((( p.getShape().getBounds().getX())), p.getShape().getBounds().getY(), p.getShape().getBounds().getWidth(),  p.getShape().getBounds().getHeight())){
                try {
                    diagramView.getClassSelectionModel().addElement(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {

        for (Painter n : nova) {
            diagramView.getPainters().remove(n);
            msp = new MultiSelectionPainter();
        }
        try {
            diagramView.update(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
