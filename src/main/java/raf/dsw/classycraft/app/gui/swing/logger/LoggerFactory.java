package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import java.io.IOException;

public class LoggerFactory  {

    public void newLogger(String logger){
        if(logger.equals("file")){
            FileLogger fileLogger = new FileLogger();
        }
        else if(logger.equals("console")) {
            ConsoleLogger consoleLogger = new ConsoleLogger();
        }
        return;
    }


}
