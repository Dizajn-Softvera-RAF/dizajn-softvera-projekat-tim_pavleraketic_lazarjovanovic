package raf.dsw.classycraft.app.gui.swing.state.painter.classContent;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;

public class AtributPainter extends ElementPainter {

    Atribut a;

    public AtributPainter(DiagramElement diagramElement, Atribut a) {
        super(diagramElement);
        this.a = a;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawString(a.getVidljivost() +" " + a.getIme() + ": " + a.getTip(), getInterclass().getX(), getInterclass().getY());
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
