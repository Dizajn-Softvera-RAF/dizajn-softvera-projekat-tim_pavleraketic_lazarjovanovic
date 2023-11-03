package raf.dsw.classycraft.app.gui.swing.message;

import raf.dsw.classycraft.app.gui.swing.observer.Publisher;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageGenerator implements Publisher {

    List<Subscriber> subscribers = new ArrayList<>();
    public void generateMessage(EventType eventType) {

    }
}
