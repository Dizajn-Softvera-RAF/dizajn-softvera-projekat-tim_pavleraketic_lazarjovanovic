package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.message.EventType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class ClassPainter extends ElementPainter{
    private Class c;
    private int brojac = 15;

    public ClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
        this.c = (Class) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawString(c.getName(), c.getX(), c.getY() - 10);
        Font f = new Font("Sheriff", Font.PLAIN,10);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);

        if (!c.getContent().isEmpty()) {
            for (ClassContent cc : c.getContent())
                if (cc instanceof Metod) {
                    Metod m = (Metod) cc;
                    int currWidth = fm.stringWidth(m.toString());
                    if(c.getMaxWidth()<currWidth)
                        c.setMaxWidth(currWidth + 10);
                    g.drawString(m.toString(), c.getX(), c.getY() + brojac);
                    c.setWidth(c.getMaxWidth() + 5);
                    c.setHeight(brojac + 5);
                    brojac += 15;
                } else if (cc instanceof Atribut) {
                    Atribut a = (Atribut) cc;
                    int currWidth = fm.stringWidth(a.toString());
                    if(c.getMaxWidth()<currWidth)
                        c.setMaxWidth(currWidth + 10);
                    g.drawString(a.toString(), c.getX() + 5, c.getY() + brojac);
                    c.setWidth(c.getMaxWidth() + 5);
                    c.setHeight(brojac + 5);
                    brojac += 15;
                }
        }
        brojac = 15;

        Color color = c.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(c.getStrokeW());
        g.setStroke(basicStroke);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
        setShape(rectangle);

        g.draw(getShape());
        if (c.getName() == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
        }


    }


    @Override
    public boolean elementAt(int x, int y) {
        return c.getPainter().getShape().contains(x,y);
    }


}
