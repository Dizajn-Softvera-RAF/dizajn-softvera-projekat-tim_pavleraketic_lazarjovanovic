package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

public class EditClassContentState implements State {
    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        for (Painter p : diagramView.getPainters()) {
            if (p.elementAt(x, y)) {
                if(p.getDiagramElement() instanceof Interclass){

                }
            }
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
