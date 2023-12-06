package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.message.EventType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class EnumPainter extends ElementPainter{

    private Enum e;

    public EnumPainter(DiagramElement diagramElement) {

        super(diagramElement);
        this.e = (Enum) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {
        Color color = e.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(e.getStrokeW());
        g.setStroke(basicStroke);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(e.getX(), e.getY(), e.getWidth(), e.getHeight());
        setShape(rectangle);

        g.draw(getShape());
        if (e.getName()== null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
            try {
                e.setName("enum");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        g.drawString(e.getName(), e.getX(), e.getY()-10);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
