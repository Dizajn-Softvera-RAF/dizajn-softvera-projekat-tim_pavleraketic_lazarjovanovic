package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.ClassPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.InterfacePainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.util.ConcurrentModificationException;

public class DuplicateState implements State {




    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

        try {
            for (Painter p : diagramView.getPainters()) {
                if (p.elementAt(x, y)) {
                    if (p.getDiagramElement() instanceof Interclass) {
                        Interclass k1 = (Interclass) p.getDiagramElement();
                        Interclass cloned = (Interclass) k1.clone();
                        if(p.getDiagramElement() instanceof Class){

                            ClassPainter classPainter = new ClassPainter(cloned);
                            cloned.setPainter(classPainter);
                            diagramView.getPainters().add(classPainter);
                            diagramView.getDiagram().addChild(cloned);
                            MainFrame.getInstance().getClassyTree().addDiagramChild(diagramView.getDiagram(),cloned);
                            diagramView.repaint();

                        } else if (p.getDiagramElement() instanceof Enum) {

                            EnumPainter enumPainter = new EnumPainter(cloned);
                            cloned.setPainter(enumPainter);
                            diagramView.getPainters().add(enumPainter);
                            diagramView.getDiagram().addChild(cloned);
                            MainFrame.getInstance().getClassyTree().addDiagramChild(diagramView.getDiagram(),cloned);
                            diagramView.repaint();

                        } else if (p.getDiagramElement() instanceof Interface) {


                            InterfacePainter interfacePainter = new InterfacePainter(cloned);
                            cloned.setPainter(interfacePainter);
                            diagramView.getPainters().add(interfacePainter);
                            diagramView.getDiagram().addChild(cloned);
                            MainFrame.getInstance().getClassyTree().addDiagramChild(diagramView.getDiagram(),cloned);
                            diagramView.repaint();

                        }
                    }
                }
                diagramView.repaint();
            }
        } catch (ConcurrentModificationException e){

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {

    }
}
