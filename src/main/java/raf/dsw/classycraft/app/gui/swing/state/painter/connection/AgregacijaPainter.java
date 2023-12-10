package raf.dsw.classycraft.app.gui.swing.state.painter.connection;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Agregacija;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;

import java.awt.*;
import java.awt.geom.Line2D;

public class AgregacijaPainter extends ConnectPainter {

    private Agregacija agregacija;

    public AgregacijaPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics2D g) {
        Connection connection = (Connection)super.getDiagramElement();
        connection.setNewCoordinates();
        g.setColor(Color.GRAY);
        Line2D.Float line = new Line2D.Float(connection.getXF(), connection.getYF(), connection.getXS(), connection.getYS());
        setShape(line);
        g.draw(getShape());
    }

    @Override
    public boolean elementAt(int x, int y) {
        return getShape().contains(x,y);
    }
}
