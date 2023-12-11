package raf.dsw.classycraft.app.gui.swing.state.painter;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;

import java.awt.*;
import java.awt.geom.Line2D;
@Getter
@Setter
public abstract class ConnectPainter extends Painter {

    private Connection connection;
    private Shape s;
    private Point pos1;
    private Point pos2;


    public ConnectPainter(DiagramElement diagramElement,Point pos1,Point pos2) {
        super(diagramElement);
        this.s = s;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }



    @Override
    public abstract void draw(Graphics2D g) ;


    @Override
    public abstract boolean elementAt(int x, int y);
}
