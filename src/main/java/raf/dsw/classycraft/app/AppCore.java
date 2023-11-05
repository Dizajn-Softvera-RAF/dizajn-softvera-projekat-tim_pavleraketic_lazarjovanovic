package raf.dsw.classycraft.app;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.SwingGui;
import raf.dsw.classycraft.app.gui.swing.classyRepository.ClassyRepositoryImplementation;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        ClassyRepository classyRepository = new ClassyRepositoryImplementation();
        appCore.initialize(gui, classyRepository);
        appCore.run();
    }
}