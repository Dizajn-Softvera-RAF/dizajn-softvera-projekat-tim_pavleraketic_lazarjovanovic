package raf.dsw.classycraft.app.gui.swing.state.painter.interclass;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.EnumElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class ClassPainter extends ElementPainter {
    private Class c;
    private int brojac = 45;

    public ClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
        this.c = (Class) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {

        c.getPoints().clear();
        Font f = new Font("Sheriff", Font.PLAIN,12);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Color color = c.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(c.getStrokeW());
        g.setStroke(basicStroke);

        int nameWidth = fm.stringWidth(c.getName());



        if (!c.getContent().isEmpty()) {
            for (ClassContent cc : c.getContent())
                if (cc instanceof Metod) {
                    Metod m = (Metod) cc;
                    int currWidth = fm.stringWidth(m.toString());
                    if(c.getMaxWidth()<currWidth && currWidth>nameWidth){
                        c.setMaxWidth(currWidth + 20);
                    } else if (nameWidth > c.getMaxWidth() && nameWidth>currWidth) {
                        c.setMaxWidth(nameWidth + 20);
                    }

                    g.drawString(m.toString(), c.getX(), c.getY() + brojac);
                    c.setWidth(c.getMaxWidth() + 5);
                    c.setHeight(brojac + 5);
                    brojac += 15;

                } else if (cc instanceof Atribut) {
                    Atribut a = (Atribut) cc;
                    int currWidth = fm.stringWidth(a.toString());
                    if(c.getMaxWidth()<currWidth)
                        c.setMaxWidth(currWidth + 10);
                    g.drawString(a.toString(), c.getX(), c.getY() + brojac);
                    c.setWidth(c.getMaxWidth() + 5);
                    c.setHeight(brojac + 5);
                    brojac += 15;

                } else if(cc instanceof EnumElement){
                    //MainFrame.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                }
        } else {
            c.setWidth(nameWidth + 25);
        }
        brojac = 45;
        c.setMaxWidth(0);

        g.drawString(c.getName() , c.getX()+c.getWidth()/2 - nameWidth/2, c.getY() + 15);
        g.drawLine(c.getX(),c.getY()+25,c.getX()+c.getWidth(),c.getY()+25);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
        setShape(rectangle);

        g.draw(getShape());
        c.napraviTacke();

        if (c.getName() == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
        }


    }


    @Override
    public boolean elementAt(int x, int y) {
        return c.getPainter().getShape().contains(x,y);
    }


}
