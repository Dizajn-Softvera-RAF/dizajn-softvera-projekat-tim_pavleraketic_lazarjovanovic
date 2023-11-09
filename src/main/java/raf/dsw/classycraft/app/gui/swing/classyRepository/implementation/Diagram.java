package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyLeaf;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;

@Getter
@Setter

public class Diagram extends ClassyLeaf {

    private static int counter =1;

    public Diagram(String name, ClassyNode parent) throws IOException {
        super(name, parent);
        setName(name + counter);
        counter++;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber))
            return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !subs.contains(subscriber))
            return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object obj) throws IOException {
        if (obj == null || subs.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subs)
            subscriber.update(obj);
    }

    @Override
    public String toString() {
        return "Diagram{}";
    }
}
