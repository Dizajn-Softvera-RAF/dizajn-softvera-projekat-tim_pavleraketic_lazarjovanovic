package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.gui.swing.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.message.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

public class ApplicationFramework {

    private static ApplicationFramework instance;

    //buduca polja za model celog projekta

    private ApplicationFramework(){

    }

    public void initialize(){
        MainFrame.getInstance().setVisible(true);
        ClassyRepository classyRepository = new ClassyRepositoryImplementation();
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
