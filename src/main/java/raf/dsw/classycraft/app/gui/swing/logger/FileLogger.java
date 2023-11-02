package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements LoggerFactory {
    private MessageGenerator messageGenerator;

    public FileLogger(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
    }
    @Override
    public void log(String greska) {
        File file = new File("log.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(greska);
            fileWriter.close();
        } catch (FileNotFoundException e){
            System.out.println("Filenotfound");
        } catch (IOException e) {
            System.out.println("IOexception");
        }
    }

    @Override
    public void update(Object notification) {
        Message message = (Message) notification;
        Date date = new Date();
        String error = "("+date+") "+ ((Message) notification).toString();
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
