package raf.dsw.classycraft.app.gui.swing.state.painter.interclass;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.EnumElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class EnumPainter extends ElementPainter {

    private Enum e;
    private int brojac = 50;
    private String enumm = "<<enum>>";


    public EnumPainter(DiagramElement diagramElement) {

        super(diagramElement);
        this.e = (Enum) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {
        e.getPoints().clear();
        Font f = new Font("Sheriff", Font.ITALIC, 12);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Color color = e.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(e.getStrokeW());
        g.setStroke(basicStroke);


        int nameWidth = fm.stringWidth(e.getName());
        int enumWidth = fm.stringWidth(enumm);


        if (!e.getContent().isEmpty()) {
            for (ClassContent cc : e.getContent()) {
                if (cc instanceof EnumElement) {
                    EnumElement enumElement = (EnumElement) cc;
                    int currWidth = fm.stringWidth(enumElement.toString());
                    if (e.getMaxWidth() < currWidth && currWidth > nameWidth) {
                        e.setMaxWidth(currWidth + 20);
                    } else if (nameWidth > e.getMaxWidth() && nameWidth > currWidth) {
                        e.setMaxWidth(nameWidth + 20);
                    }
                    g.drawString(enumElement.toString(), e.getX(), e.getY() + brojac);
                    e.setWidth(e.getMaxWidth() + 5);
                    e.setHeight(brojac + 5);
                    brojac += 15;

                }
            }
            }else {
                    if (enumWidth > nameWidth) {
                        e.setWidth(enumWidth + 25);
                    } else {
                        e.setWidth(nameWidth + 25);
                    }

                }
            brojac = 50;
            e.setMaxWidth(0);
            g.drawString(e.getName(), e.getX() + e.getWidth() / 2 - nameWidth / 2, e.getY() + 15);
            g.drawString(enumm, e.getX() + e.getWidth() / 2 - enumWidth / 2, e.getY() + 30);
            g.drawLine(e.getX(), e.getY() + 35, e.getX() + e.getWidth(), e.getY() + 35);


            Rectangle2D.Double rectangle = new Rectangle2D.Double();
            rectangle.setRect(e.getX(), e.getY(), e.getWidth(), e.getHeight());
            setShape(rectangle);

            g.draw(getShape());
            e.napraviTacke();
            if (e.getName() == null) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
                try {
                    e.setName("enum");


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            //g.drawString(e.getName(), e.getX(), e.getY()-10);
        }

    @Override
    public boolean elementAt(int x, int y) {
        return e.getPainter().getShape().contains(x,y);
    }
}
