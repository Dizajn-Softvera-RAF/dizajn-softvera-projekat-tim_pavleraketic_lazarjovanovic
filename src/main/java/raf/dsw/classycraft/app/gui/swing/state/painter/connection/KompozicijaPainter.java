package raf.dsw.classycraft.app.gui.swing.state.painter.connection;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;

import java.awt.*;

public class KompozicijaPainter extends ConnectPainter {

    private Kompozicija kompozicija;

    public KompozicijaPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
