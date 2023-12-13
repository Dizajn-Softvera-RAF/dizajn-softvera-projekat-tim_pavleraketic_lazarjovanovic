package raf.dsw.classycraft.app.gui.swing.state.painter.connection;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;

import java.awt.*;
import java.awt.geom.Line2D;

public class ZavisnostPainter extends ConnectPainter {

    private Zavisnost zavisnost;

    public ZavisnostPainter(DiagramElement diagramElement, Point pos1, Point pos2) {
        super(diagramElement, pos1, pos2);
        setConnection((Connection) diagramElement);
        this.zavisnost = (Zavisnost) diagramElement;
    }


    @Override
    public void draw(Graphics2D g) {
        Color color = zavisnost.getColor();
        g.setColor(color);
        setShape(new Line2D.Float(getPos1().x,getPos1().y,getPos2().x,getPos2().y));
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        if(getConnection().getKa() != null) {
            double minPath = Double.MAX_VALUE;
            for (Point point1 : getConnection().getOd().getPoints()) {
                for (Point point2 : getConnection().getKa().getPoints()) {
                    double path = Math.sqrt((point2.y - point1.y) * (point2.y - point1.y) + (point2.x - point1.x) * (point2.x - point1.x));

                    if (path < minPath) {
                        minPath = path;
                        setPos1(point1);
                        setPos2(point2);
                    }
                }
            }
        }
        g.draw(getShape());
        drawArrowhead(g);

    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }

    private void drawArrowhead(Graphics2D g) {
        double arrowSize = 10;

        double angle = Math.atan2(getPos2().y - getPos1().y, getPos2().x - getPos1().x);

        double x3 = getPos2().x - arrowSize * Math.cos(angle - Math.PI / 6);
        double y3 = getPos2().y - arrowSize * Math.sin(angle - Math.PI / 6);
        double x4 = getPos2().x - arrowSize * Math.cos(angle + Math.PI / 6);
        double y4 = getPos2().y - arrowSize * Math.sin(angle + Math.PI / 6);

        g.drawLine(getPos2().x, getPos2().y, (int) x3, (int) y3);
        g.drawLine(getPos2().x, getPos2().y, (int) x4, (int) y4);
    }



}
