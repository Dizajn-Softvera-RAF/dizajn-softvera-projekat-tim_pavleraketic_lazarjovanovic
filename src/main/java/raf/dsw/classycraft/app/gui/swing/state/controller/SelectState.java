package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.MultiSelectionPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectState implements State {

    private PackageView packageView;
    private int x1,y1;
    private List<ElementPainter> nova = new ArrayList<>();
    private MultiSelectionPainter msp = new MultiSelectionPainter();


    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        diagramView = (DiagramView) packageView.getJTabbedPane().getSelectedComponent();

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
                diagramView.getClassSelectionModel().getSelected().add((ElementPainter) p);
            }
            else{
                x1 = x;
                y1 = y;
                nova.add(msp);
            }
        }
        for(ElementPainter p : nova){
            diagramView.getPainters().add(p);
        }

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView)  {

        if((diagramView.getClassSelectionModel().getSelected().isEmpty())) {
            try {
                diagramView.getClassSelectionModel().clearList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        msp.updatePoints(x1, y1, x, y);
        try {
            diagramView.update(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Painter p : diagramView.getPainters()){
            if(p instanceof MultiSelectionPainter)
                continue;

            if(msp.getShape() == null){
                diagramView.getPainters().remove(msp);
                return;
            }
            if(msp.getShape().intersects(((((ElementPainter) p).getShape().getBounds().getX())), ((ElementPainter) p).getShape().getBounds().getY(), ((ElementPainter) p).getShape().getBounds().getWidth(), ((ElementPainter) p).getShape().getBounds().getHeight())){
                try {
                    diagramView.getClassSelectionModel().addElement((ElementPainter) p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {

        for (ElementPainter n : nova) {
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
