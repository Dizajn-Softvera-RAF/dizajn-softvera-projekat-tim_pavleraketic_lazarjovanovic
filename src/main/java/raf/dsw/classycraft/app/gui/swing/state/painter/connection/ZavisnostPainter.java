package raf.dsw.classycraft.app.gui.swing.state.painter.connection;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;

import java.awt.*;
import java.awt.geom.Line2D;

public class ZavisnostPainter extends ConnectPainter {

    private Zavisnost zavisnost;

    public ZavisnostPainter(DiagramElement diagramElement, Point pos1, Point pos2) {
        super(diagramElement, pos1, pos2);
        this.zavisnost = (Zavisnost) diagramElement;
    }


    @Override
    public void draw(Graphics2D g) {
        Color color = zavisnost.getColor();
        g.setColor(color);
        g.setColor(color);
        setShape(new Line2D.Float(getPos1().x,getPos1().y,getPos2().x,getPos2().y));
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g.draw(getShape());
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
