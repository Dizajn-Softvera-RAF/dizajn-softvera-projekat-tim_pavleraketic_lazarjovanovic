package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class ConsoleLogger implements LoggerFactory {
    private MessageGenerator messageGenerator;
    private Message message;

    public ConsoleLogger(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
    }

    @Override
    public void log(String greska) {
        System.out.println(greska);
    }

    @Override
    public void update(Object notification) {
        Date date = new Date();
        String error ="["+ message.getEventType() + "] "  + "["+date+"] "+ ((Message) notification).toString();

        log(error);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }

}
