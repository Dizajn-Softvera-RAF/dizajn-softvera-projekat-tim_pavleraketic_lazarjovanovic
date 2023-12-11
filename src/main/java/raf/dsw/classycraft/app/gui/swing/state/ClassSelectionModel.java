package raf.dsw.classycraft.app.gui.swing.state;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.observer.Publisher;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter


public class ClassSelectionModel implements Publisher {

    private List<Painter> selected;
    protected List<Subscriber> subscribers;
    private Color customColor = new Color(150,219,219);
    private Color customColorEnum = new Color(255,107,215);
    private Color customColorInterface = new Color(93,217,119);

    public ClassSelectionModel() {
        this.selected = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addElement(Painter p) throws IOException {
        if (p != null) {


            this.getSelected().add(p);
            try {
                if(p.getDiagramElement()  instanceof Interclass ){
                    ((Interclass) p.getDiagramElement()).setColor(customColor);
                }else if(p.getDiagramElement() instanceof Connection ){
                    ((Connection) p.getDiagramElement()).setColor(customColor);
                }
            } catch (NullPointerException e){
                System.out.println("");
            }

            notifySubscribers(this);
        }
    }

    public void clearList() throws IOException {
        for(Painter p : this.getSelected()){
            try {
                if(p.getDiagramElement()  instanceof Interclass){
                    if(p.getDiagramElement() instanceof Class){
                        ((Interclass) p.getDiagramElement()).setColor(Color.BLACK);
                    } else if (p.getDiagramElement() instanceof Interface) {
                        ((Interclass) p.getDiagramElement()).setColor(customColorInterface);
                    }else if (p.getDiagramElement() instanceof Enum) {
                        ((Interclass) p.getDiagramElement()).setColor(customColorEnum);
                    }

                } else if(p.getDiagramElement() instanceof Connection){
                    ((Connection) p.getDiagramElement()).setColor(Color.BLACK);
                }
            } catch (NullPointerException e){
                System.out.println("");
            }

        }
        getSelected().clear();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber sub : subscribers){
            sub.update(notification);
        }
    }


}
