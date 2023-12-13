package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enum extends Interclass {




    public Enum(String name, ClassyNode parent, Painter painter, Color color, int x, int y) {
        super(name, parent, painter, color, x, y);
        this.setColor(Color.MAGENTA);
    }

    public Enum(String anEnum, Diagram diagram, int x, int y) {
        super(anEnum,diagram,null,null,x,y);
        this.setColor(new Color(255,107,215));
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

    @Override
    public void napraviTacke() {
        super.napraviTacke();
    }

}
