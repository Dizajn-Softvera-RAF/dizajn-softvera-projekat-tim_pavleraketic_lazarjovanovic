package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyLeaf;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.awt.*;
import java.io.IOException;

@Getter
@Setter

public class Diagram extends ClassyLeaf {

    private static int counter=1;
    private int stroke = 2;
    private Color color;
    //private Color realColor = Color.BLACK;


    public Diagram(String name, ClassyNode parent, Color color, int stroke){
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
        notifySubscribers(this);
    }

    public Diagram(String name, ClassyNode parent) throws IOException {
        super(name, parent);
        //setName(name + counter);
        //counter++;
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
    public void notifySubscribers(Object obj) {
        if (obj == null || subs.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subs)
            subscriber.update(obj);
    }

}
