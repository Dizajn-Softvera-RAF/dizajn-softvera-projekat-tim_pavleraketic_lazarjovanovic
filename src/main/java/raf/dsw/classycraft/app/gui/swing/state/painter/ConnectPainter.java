package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;

import java.awt.*;
import java.awt.geom.Line2D;

public abstract class ConnectPainter extends Painter {

    private Connection connection;

    public ConnectPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public abstract void draw(Graphics2D g) ;


    @Override
    public abstract boolean elementAt(int x, int y);
}
