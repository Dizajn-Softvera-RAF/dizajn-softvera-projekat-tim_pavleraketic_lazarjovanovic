package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;
@Getter
@Setter

public class Project extends ClassyNodeComposite {

    private static int counter=1;
    private String author;
    protected String filePath;
    //protected boolean changed = true;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if(child != null && child instanceof Package)
        {
            Package aPackage = (Package) child;
            if(!this.getChildren().contains(aPackage))
            {
                this.getChildren().add(aPackage);
            }
        }
    }

    @Override
    public void removeChild(ClassyNode child) {
        Package aPackage = (Package) child;
        if(this.getChildren().contains(aPackage))
        {
            this.getChildren().remove(aPackage);
        }

    }

    public void setAuthor(String name) {
        author = name;
        notifySubscribers(this);
    }


    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null ||  subs.contains(subscriber)) return;
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
