package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;

@Getter
@Setter

public class Package extends ClassyNodeComposite {

    private static int counter = 1;
    //private boolean template;

    public Package(String name, Package parent) throws IOException {
        super(name, parent);
        setName(name + counter);
        counter++;
    }

    @Override
    public void add(ClassyNode child) {
        if (child != null && child instanceof Diagram) {
            Diagram project = (Diagram) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void remove(ClassyNode child) {
        Diagram diagram = (Diagram) child;
        if (this.getChildren().contains(diagram)) {
            this.getChildren().remove(diagram);
        }

    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber)) return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !(subs.contains((subscriber)))) return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || subs.isEmpty()) return;
        for (Subscriber s : subs) {
            s.update(this);

        }
    }

}
