package raf.dsw.classycraft.app.gui.swing.state.painter.interclass;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.EnumElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class InterfacePainter extends ElementPainter {

    private Interface i;
    private int brojac = 45;
    private String interface1 = "<<interface>>";

    public InterfacePainter(DiagramElement diagramElement) {

        super(diagramElement);
        this.i = (Interface) diagramElement;
    }

    @Override
    public void draw(Graphics2D g) {

        Font f = new Font("Sherif", Font.PLAIN, 12);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Color color = i.getColor();
        g.setColor(color);
        BasicStroke basicStroke = new BasicStroke(i.getStrokeW());
        g.setStroke(basicStroke);


        int nameWidth = fm.stringWidth(i.getName());
        int interfaceWidth = fm.stringWidth(interface1);


        if (!i.getContent().isEmpty()) {
            for (ClassContent cc : i.getContent())
                if (cc instanceof Metod) {
                    Metod m = (Metod) cc;
                    int currWidth = fm.stringWidth(m.toString());
                    if (i.getMaxWidth() < currWidth && currWidth > nameWidth) {
                        i.setMaxWidth(currWidth + 20);
                    } else if (nameWidth > i.getMaxWidth() && nameWidth > currWidth) {
                        i.setMaxWidth(nameWidth + 20);
                    }
                    g.drawString(m.toString(), i.getX(), i.getY() + brojac);
                    i.setWidth(i.getMaxWidth() + 5);
                    i.setHeight(brojac + 5);
                    brojac += 15;

                } else if (cc instanceof Atribut) {

                } else if (cc instanceof EnumElement) {
                }


        } else {
            if (interfaceWidth > nameWidth) {
                i.setWidth(interfaceWidth + 25);
            } else {
                i.setWidth(nameWidth + 25);
            }


            brojac = 45;
            i.setMaxWidth(0);


            g.drawString(i.getName() , i.getX()+i.getWidth()/2 - nameWidth/2, i.getY() + 15);
            g.drawString(interface1,i.getX()+i.getWidth()/2 - interfaceWidth/2,i.getY()+30);
            g.drawLine(i.getX(),i.getY()+35,i.getX()+i.getWidth(),i.getY()+35);

            Rectangle2D.Double rectangle = new Rectangle2D.Double();
            rectangle.setRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
            setShape(rectangle);

            g.draw(getShape());
            i.napraviTacke();
            if (i.getName() == null) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
                try {
                    i.setName("Interface");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public boolean elementAt(int x, int y) {
        return i.getPainter().getShape().contains(x,y);
    }
}
