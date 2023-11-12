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

    public Project(String name, ClassyNode parent) throws IOException {
        super(name, parent);
        setName(name + counter);
        counter++;
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

        deleteAll(aPackage);
    }

    public void deleteAll(ClassyNodeComposite classyNodeComposite){
        if (classyNodeComposite.getChildren() == null || classyNodeComposite.getChildren().isEmpty()){
            try {
                classyNodeComposite.notifySubscribers("clear");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        for (ClassyNode child: classyNodeComposite.getChildren()){
            if (child instanceof Project) {
                deleteAll((Project) child);
                try {
                    child.notifySubscribers("clear");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    child.getParent().notifySubscribers("clear");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
        }
    }


    public void setAuthor(String name) throws IOException {
        author = name;
        for(ClassyNode child: this.getChildren()){
            if(child instanceof Package)((Package) child).setAuthor(this.author);
        }
    }
    public void setName(String name) throws IOException {
        super.setName(name);
        for(ClassyNode child: this.getChildren()){
            if(child instanceof Package)((Package) child).notifySubscribers("ime");
        }
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
    public void notifySubscribers(Object notification) throws IOException {
        if (notification == null || subs.isEmpty()) return;
        for (Subscriber s : subs) {
            s.update(this);

        }
    }

}
