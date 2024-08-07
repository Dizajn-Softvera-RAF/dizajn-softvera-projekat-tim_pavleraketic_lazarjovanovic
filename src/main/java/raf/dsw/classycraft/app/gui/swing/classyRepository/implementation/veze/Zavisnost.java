package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.awt.*;
import java.io.IOException;
@Getter
@Setter
public class Zavisnost extends Connection {

    private String tip; //call instantiate
    public Zavisnost(String name, ClassyNode parent, Interclass od, Interclass ka, Color color) {
        super(name, parent, od, ka, color);
        this.setColor(Color.black);
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
    public boolean equals(Object obj) {
        if (obj instanceof Connection) {
            Connection otherObj = (Connection) obj;
            return ((this.getOd().equals(otherObj.getOd()) && this.getKa().equals(otherObj.getKa())) ||
                    (this.getOd().equals(otherObj.getKa()) && this.getKa().equals(otherObj.getOd())));
        }
        return false;
    }
}
