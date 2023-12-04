package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;

public class Klasa extends Interclass {


    public Klasa(String name, ClassyNode parent, String vidljivost, String naziv, int position, int size){
        super(name, parent, vidljivost, naziv, position, size);
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
