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

import java.util.ConcurrentModificationException;

public class DuplicateState implements State {




    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        try {
            for (Painter p : diagramView.getPainters()) {
                if (p.elementAt(x, y)) {
                    if (p.getDiagramElement() instanceof Interclass) {
                        Interclass k1 = (Interclass) p.getDiagramElement();
                        if(p.getDiagramElement() instanceof Class){
                            try {

                                Interclass cloned = (Interclass) k1.clone();
                                ClassPainter classPainter = new ClassPainter(cloned);
                                diagramView.getPainters().add(classPainter);
                                diagramView.getDiagram().addChild(cloned);
                                diagramView.repaint();

                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (p.getDiagramElement() instanceof Enum) {
                            try {

                                Enum cloned =(Enum) k1.clone();
                                EnumPainter enumPainter = new EnumPainter(cloned);
                                diagramView.getPainters().add(enumPainter);
                                diagramView.getDiagram().addChild(cloned);
                                diagramView.repaint();

                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (p.getDiagramElement() instanceof Interface) {
                            try {

                                Interface cloned = (Interface) k1.clone();
                                InterfacePainter interfacePainter = new InterfacePainter(cloned);
                                diagramView.getPainters().add(interfacePainter);
                                diagramView.getDiagram().addChild(cloned);
                                diagramView.repaint();

                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                diagramView.repaint();
            }
        } catch (ConcurrentModificationException e){

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
