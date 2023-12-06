package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;

import java.awt.*;
import java.io.IOException;
@Getter
@Setter
public class Class extends Interclass {


    public Class(String name, ClassyNode parent, Painter painter, Color color, int x, int y) {
        super(name, parent, painter, color, x, y);
        this.setColor(Color.BLACK);

    }

    public Class(String aClass, Diagram diagram, int x, int y) {
        super(aClass,diagram,null,null,x,y);
        this.setColor(Color.BLACK);
        this.setStrokeW(2);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }
}
