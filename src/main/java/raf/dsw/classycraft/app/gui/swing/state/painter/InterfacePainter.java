package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.message.EventType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class InterfacePainter extends ElementPainter{

    private Interface i;
    public InterfacePainter(DiagramElement diagramElement) {

        super(diagramElement);
        this.i = (Interface) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {
        Color color = i.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(i.getStrokeW());
        g.setStroke(basicStroke);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
        setShape(rectangle);

        g.draw(getShape());
        if (i.getName()== null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
            try {
                i.setName("Interface");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        g.drawString(i.getName(), i.getX(), i.getY()-10);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
