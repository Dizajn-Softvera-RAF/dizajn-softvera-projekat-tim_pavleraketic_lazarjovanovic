package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;
@Getter
@Setter
public class Kompozicija extends Connection {
    public Kompozicija(String name, ClassyNode parent, Interclass od, Interclass ka) {
        super(name, parent, od, ka);
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
