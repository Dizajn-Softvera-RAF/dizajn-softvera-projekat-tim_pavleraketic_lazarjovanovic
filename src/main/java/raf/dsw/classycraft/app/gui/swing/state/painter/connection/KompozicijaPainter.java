package raf.dsw.classycraft.app.gui.swing.state.painter.connection;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class KompozicijaPainter extends ConnectPainter {

    private Kompozicija kompozicija;

    public KompozicijaPainter(DiagramElement diagramElement, Point pos1, Point pos2) {
        super(diagramElement, pos1, pos2);
        setConnection((Connection) diagramElement);
        this.kompozicija = (Kompozicija) diagramElement;
    }


    @Override
    public void draw(Graphics2D g) {
        Color color = kompozicija.getColor();
        g.setColor(color);
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
        setShape(new Line2D.Float(getPos1().x,getPos1().y,getPos2().x,getPos2().y));
        g.setStroke(new BasicStroke(2));
        g.draw(getShape());

        double angle = Math.atan2(getPos2().y - getPos1().y, getPos2().x - getPos1().x);
        AffineTransform transform = AffineTransform.getTranslateInstance(getPos1().x, getPos1().y);
        transform.rotate(angle + Math.toRadians(45));


        int squareSize = 10;

        Rectangle2D square = new Rectangle2D.Double(-squareSize / 2.0, -squareSize / 2.0, squareSize, squareSize);

        Shape transformedSquare = transform.createTransformedShape(square);
        g.fill(transformedSquare);

        //drawArrowhead(g);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return super.elementAt(x, y);
    }

    private void drawArrowhead(Graphics2D g) {
        double arrowSize = 10; // Adjust arrowhead size as needed

        double angle = Math.atan2(getPos2().y - getPos1().y, getPos2().x - getPos1().x);

        double x3 = getPos2().x - arrowSize * Math.cos(angle - Math.PI / 6);
        double y3 = getPos2().y - arrowSize * Math.sin(angle - Math.PI / 6);
        double x4 = getPos2().x - arrowSize * Math.cos(angle + Math.PI / 6);
        double y4 = getPos2().y - arrowSize * Math.sin(angle + Math.PI / 6);

        int[] xPoints = {getPos2().x, (int) x3, (int) x4};
        int[] yPoints = {getPos2().y, (int) y3, (int) y4};

        g.fillPolygon(xPoints, yPoints, 3);
    }


}
