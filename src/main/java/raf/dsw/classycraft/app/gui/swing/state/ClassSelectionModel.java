package raf.dsw.classycraft.app.gui.swing.state;

import lombok.Getter;
import lombok.Setter;
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

    private List<ElementPainter> selected;
    protected List<Subscriber> subscribers;
//    private Color oldColor;

    public ClassSelectionModel() {
        this.selected = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addElement(Painter p) throws IOException {
        if (p != null) {
            this.getSelected().add((ElementPainter) p);
            ((ElementPainter) p).getInterclass().setColor(Color.BLUE);
            notifySubscribers(this);
        }
    }

    public void clearList() throws IOException {
        for(ElementPainter p : this.getSelected()){
            p.getInterclass().setColor(p.getInterclass().getColor());
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
