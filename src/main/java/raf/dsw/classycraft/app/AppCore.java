package raf.dsw.classycraft.app;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.SwingGui;
import raf.dsw.classycraft.app.gui.swing.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.gui.swing.logger.ConsoleLogger;
import raf.dsw.classycraft.app.gui.swing.logger.FileLogger;
import raf.dsw.classycraft.app.gui.swing.logger.LoggerFactory;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.message.MessageGeneratorImplementation;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();

        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        Gui gui = new SwingGui(messageGenerator);

        LoggerFactory loggerFactory = new LoggerFactory(messageGenerator);

        ClassyRepository classyRepository = new ClassyRepositoryImplementation();

        messageGenerator.addSubscriber(gui);


        appCore.initialize(gui, classyRepository,loggerFactory,messageGenerator);
        appCore.run();
    }
}