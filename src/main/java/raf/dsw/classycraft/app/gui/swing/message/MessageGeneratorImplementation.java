package raf.dsw.classycraft.app.gui.swing.message;

import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import static raf.dsw.classycraft.app.gui.swing.message.EventType.*;

public class MessageGeneratorImplementation extends MessageGenerator{
    private Message message;

    @Override
    public void generateMessage(EventType eventType) {
        if (ERROR.equals(eventType)) {
            createMessage("Greška: ", eventType);
        } else if (CANNOT_DELETE_PROJECT_EXPLORER.equals(eventType)) {
            createMessage("Project Explorer ne moze bit obrisan!", eventType);
        } else if (CANNOT_ADD_CHILD.equals(eventType)) {
            createMessage("Ne može da se doda na ovu komponentu", eventType);
        } else if (MUST_INSERT_NAME.equals(eventType)) {
            createMessage("Ime projekta ne sme biti prazno", eventType);
        } else if (CANNOT_DELETE_FILE.equals(eventType)) {
            createMessage("Ovaj fajl ne može da se obriše", eventType);
        } else if (RESOURCE_NOT_FOUND.equals(eventType)){
            createMessage("Ne postoji putanja!", eventType);
        } else if (NODE_NOT_SELECTED.equals(eventType)) {
            createMessage("Nije selektovana nijedna komponenta!", eventType);
        } else if (NODE_ALREADY_EXISTS.equals(eventType)) {
            createMessage("Ova komponenta već postoji!", eventType);
        } else if (COMPONENT_NOT_SELECTED.equals(eventType)) {
            createMessage("Nije selektovana ni jedna komponenta!", eventType);
        }

    }


    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subscribers.contains(subscriber)) return;
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !(subscribers.contains(subscriber)) && subscribers.isEmpty()) return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || subscribers.isEmpty()) return;
        for (Subscriber s: subscribers){
            s.update(this.message);
        }
    }

    private void createMessage(String tekst, EventType eventType) {
        this.message = new Message(tekst, eventType);
        notifySubscribers(this);
    }
}
