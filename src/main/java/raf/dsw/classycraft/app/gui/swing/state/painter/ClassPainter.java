package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.message.EventType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class ClassPainter extends ElementPainter{
    private Class c;
    public ClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
        this.c = (Class) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {
        Color color = c.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(c.getStrokeW());
        g.setStroke(basicStroke);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
        setShape(rectangle);

        g.draw(getShape());
        if (c.getName()== null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);

        }

        g.drawString(c.getName(), c.getX(), c.getY()-10);


    }


    @Override
    public boolean elementAt(int x, int y) {
        return c.getPainter().getShape().contains(x,y);
    }


}
