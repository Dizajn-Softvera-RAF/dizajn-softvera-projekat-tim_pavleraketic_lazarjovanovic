package raf.dsw.classycraft.app.gui.swing.state;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter


public class MultiSelectionPainter extends ElementPainter {


    private int x, y, w, l;
    private Painter painter;

    private MultiSelectionPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    public MultiSelectionPainter() {
    }

    public void updatePoints(int x, int y, int x2, int y2){
        this.x = Math.min(x, x2);
        this.y = Math.min(y, y2);
        this.w = Math.abs(x2 - x);
        this.l = Math.abs(y2 - y);
    }


    @Override
    public void draw(Graphics2D g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.GRAY);

        Rectangle2D.Float rectangle = new Rectangle2D.Float(x, y, w, l);
        painter.setShape(rectangle);
        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);

        g2d.setStroke(dashed);
        g2d.draw(painter.getShape());
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
