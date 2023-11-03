package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {
    private MessageGenerator messageGenerator;

    @Override
    public void log(String greska) {
        File file = new File("/resources/log.txt");
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
        String error = message.toString();
        log(error);

    }

}
