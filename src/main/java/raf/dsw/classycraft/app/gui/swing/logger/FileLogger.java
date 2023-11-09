package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.Message;

import javax.swing.*;
import java.io.*;

public class FileLogger implements Logger  {



    @Override
    public void log(String greska) {
        try {
            FileOutputStream fos = new FileOutputStream("E:\\DSW\\src\\main\\resources\\log.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(greska);
            bw.newLine();
            bw.close();
            osw.close();
            fos.close();
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
