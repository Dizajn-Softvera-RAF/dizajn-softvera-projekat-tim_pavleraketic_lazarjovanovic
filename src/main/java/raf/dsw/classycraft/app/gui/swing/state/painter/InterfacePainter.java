package raf.dsw.classycraft.app.gui.swing.state.painter;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.EnumElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class InterfacePainter extends ElementPainter{

    private Interface i;
    private int brojac = 15;
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

        g.drawString(i.getName(), i.getX(), i.getY() - 10);
        Font f = new Font("Sheriff", Font.PLAIN,12);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);

        if (!i.getContent().isEmpty()) {
            for (ClassContent cc : i.getContent())
                if (cc instanceof Metod) {
                    Metod m = (Metod) cc;
                    int currWidth = fm.stringWidth(m.toString());
                    if(i.getMaxWidth()<currWidth)
                        i.setMaxWidth(currWidth + 10);
                    g.drawString(m.toString(), i.getX(), i.getY() + brojac);
                    i.setWidth(i.getMaxWidth() + 5);
                    i.setHeight(brojac + 5);
                    brojac += 15;

                } else if (cc instanceof Atribut) {
                    //MainFrame.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                    continue;
                } else if(cc instanceof EnumElement){
                    //MainFrame.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                    continue;
                }

        }
        brojac = 15;
        i.setMaxWidth(0);


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

    }

    @Override
    public boolean elementAt(int x, int y) {
        return i.getPainter().getShape().contains(x,y);
    }
}
