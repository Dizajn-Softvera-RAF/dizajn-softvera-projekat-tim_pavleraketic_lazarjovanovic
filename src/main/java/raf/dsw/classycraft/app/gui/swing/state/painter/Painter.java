package raf.dsw.classycraft.app.gui.swing.state.painter;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;

import java.awt.*;
@Getter
@Setter

public abstract class Painter {

    private Shape shape;
    private DiagramElement diagramElement;

    protected Painter(DiagramElement diagramElement){
        this.diagramElement = diagramElement;
    }

    public Painter() {
    }

    public abstract void draw (Graphics2D g);

    public abstract boolean elementAt (int x, int y);



}
