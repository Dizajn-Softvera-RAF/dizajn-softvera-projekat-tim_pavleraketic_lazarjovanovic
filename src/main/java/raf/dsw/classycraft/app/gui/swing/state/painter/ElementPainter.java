package raf.dsw.classycraft.app.gui.swing.state.painter;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter extends Painter {

    private Interclass interclass;

    protected ElementPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    public ElementPainter() {
    }
}
