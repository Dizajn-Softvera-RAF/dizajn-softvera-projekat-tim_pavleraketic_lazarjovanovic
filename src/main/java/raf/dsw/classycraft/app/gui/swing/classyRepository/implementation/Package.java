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
    private String author;


    public Package(String name, ClassyNode parent) throws IOException {
        super(name, parent);
        setName(name + counter);
        counter++;
        if(parent instanceof Project){
            this.author = ((Project) parent).getAuthor();
        } else if (parent instanceof  Package) {
            this.author = ((Package) parent).getAuthor();
        }
    }

    public void setAuthor(String name) throws IOException {
        author = name;
        notifySubscribers("ime");
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null && child instanceof Diagram) {
            Diagram project = (Diagram) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
                try {
                    System.out.println(project);
                    notifySubscribers("child");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void removeChild(ClassyNode child) {
        Diagram diagram = (Diagram) child;
        if (this.getChildren().contains(diagram)) {
            this.getChildren().remove(diagram);
            try {
                notifySubscribers("child");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (child.getParent() instanceof Package) {
            try {
                child.notifySubscribers("clear");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }




    @Override
    public void setName(String name) throws IOException {
        super.setName(name);
        notifySubscribers("ime");
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
    public void notifySubscribers(Object notification) throws IOException {
        if (notification == null || subs.isEmpty()) return;
        for (Subscriber s : subs) {
            s.update(this);

        }
    }

}
