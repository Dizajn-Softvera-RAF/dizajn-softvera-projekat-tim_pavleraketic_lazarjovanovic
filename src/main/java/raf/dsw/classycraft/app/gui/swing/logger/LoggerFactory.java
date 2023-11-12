package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;

public class LoggerFactory  {
    //private MessageGenerator messageGenerator;

    public LoggerFactory() {
        //this.messageGenerator = messageGenerator;

    }

    public void createLogger(String logger){
        if(logger.equals("file")){
            FileLogger fileLogger = new FileLogger();
            ApplicationFramework.getInstance().getMessageGenerator().addSubscriber(fileLogger);
            //messageGenerator.addSubscriber(fileLogger);
        }
        else if(logger.equals("console")) {
            ConsoleLogger consoleLogger = new ConsoleLogger();
            ApplicationFramework.getInstance().getMessageGenerator().addSubscriber(consoleLogger);
            //messageGenerator.addSubscriber(consoleLogger);
        }
    }


}
