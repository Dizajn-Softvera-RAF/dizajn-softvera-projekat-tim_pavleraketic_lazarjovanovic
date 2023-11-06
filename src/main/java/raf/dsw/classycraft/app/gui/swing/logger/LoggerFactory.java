package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;

public class LoggerFactory  {
    private MessageGenerator messageGenerator;

    public LoggerFactory(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;

    }

    public void createLogger(String logger){
        if(logger.equals("file")){
            FileLogger fileLogger = new FileLogger();
            messageGenerator.addSubscriber(fileLogger);
        }
        else if(logger.equals("console")) {
            ConsoleLogger consoleLogger = new ConsoleLogger();
            messageGenerator.addSubscriber(consoleLogger);
        }
    }


}
