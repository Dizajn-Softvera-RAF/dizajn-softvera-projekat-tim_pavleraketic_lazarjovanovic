package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import javax.swing.*;
import java.io.IOException;


public class ProjectExplorer extends ClassyNodeComposite {


    public ProjectExplorer(String name)  {
            super(name, null);
    }


    @Override
    public void addChild(ClassyNode child) {
        if(child != null && child instanceof Project)
        {
            Project project = (Project) child;
            if(!this.getChildren().contains(project))
            {
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void removeChild(ClassyNode child) {
        Project project = (Project) child;
        if(this.getChildren().contains(project))
        {
            this.getChildren().remove(project);
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber))
            return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !(subs.contains((subscriber)))) return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {
        if (notification == null || subs.isEmpty()) return;
        for (Subscriber s : subs) {
            s.update(this);

        }
    }
}
