package raf.dsw.classycraft.app.gui.swing.state.painter;

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



    public void updatePoints(int x, int y, int x2, int y2){
        this.x = Math.min(x, x2);
        this.y = Math.min(y, y2);
        this.w = Math.abs(x2 - x);
        this.l = Math.abs(y2 - y);
    }
    public MultiSelectionPainter(){
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);

        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(getX(), getY(), getW(), getL());
        setShape(rectangle);
        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);

        g.setStroke(dashed);
        g.draw(rectangle);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }
}
