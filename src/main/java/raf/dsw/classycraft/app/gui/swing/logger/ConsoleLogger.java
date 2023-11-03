package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;
import java.util.Date;

public class ConsoleLogger implements Logger {


    @Override
    public void log(String greska) {
        System.out.println(greska);
    }


    @Override
    public void update(Object notification) {
        Message message = (Message) notification;
        String greska = message.toString();
        this.log(greska);
    }

}
