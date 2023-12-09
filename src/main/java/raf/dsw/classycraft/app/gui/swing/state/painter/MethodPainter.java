package raf.dsw.classycraft.app.gui.swing.state.painter;


import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;

import java.awt.*;

public class MethodPainter extends ElementPainter {

    private Metod m;

    public MethodPainter(DiagramElement diagramElement, Metod m) {
        super(diagramElement);
        this.m = m;
    }

    @Override
    public void draw(Graphics2D g) {


    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
