package raf.dsw.classycraft.app.gui.swing.logger;

public class LoggerFactory  {


    public void createLogger(String logger){
        if(logger.equals("file")){
            FileLogger fileLogger = new FileLogger();
        }
        else if(logger.equals("console")) {
            ConsoleLogger consoleLogger = new ConsoleLogger();
        }
    }


}
