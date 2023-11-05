package raf.dsw.classycraft.app.core;

import lombok.Getter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.gui.swing.logger.ConsoleLogger;
import raf.dsw.classycraft.app.gui.swing.logger.FileLogger;
import raf.dsw.classycraft.app.gui.swing.logger.LoggerFactory;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

@Getter

public class ApplicationFramework {

    private static ApplicationFramework instance;
    protected Gui gui;
    protected ClassyRepository classyRepository;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;

    //buduca polja za model celog projekta

    private ApplicationFramework(){

    }

    public void run(){
        this.gui.start();
    }

    public void initialize(Gui gui, ClassyRepository classyRepository){
        MainFrame.getInstance().setVisible(true);

        this.gui = gui;
        this.classyRepository = classyRepository;

        LoggerFactory loggerFactory = new LoggerFactory();
        loggerFactory.createLogger("file");
        loggerFactory.createLogger("console");


    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
