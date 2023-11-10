package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;

import javax.swing.*;
import java.io.*;

public class FileLogger implements Logger  {



    @Override
    public void log(String greska) {

        File file = new File(getClass().getResource("/log/log.txt").getFile());
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(greska);
            fileWriter.write("\n");
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
        String greska = message.toString();
        log(greska);

    }

}
