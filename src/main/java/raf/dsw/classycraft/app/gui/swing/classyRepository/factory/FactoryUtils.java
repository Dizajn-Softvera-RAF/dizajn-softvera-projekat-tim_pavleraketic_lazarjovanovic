package raf.dsw.classycraft.app.gui.swing.classyRepository.factory;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.Random;

public class FactoryUtils {



    public static NodeFactory getFactory(ClassyNode parent){
    if (parent instanceof ProjectExplorer) {
        return  new ProjectFactory("Project" , parent);
    } else if (parent instanceof Project) {
        return  new PackageFactory("Package", parent);
    } else if (parent instanceof Package){
        Object[] options = {"Package", "Diagram"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose an option:",
                "Option Dialog",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choice == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without making a selection.");
        } else if (options[choice].equals("Package")){
            return new PackageFactory("Package", parent);
        }
        else return new DiagramFactory("Diagram" , parent);
        }
        return null;
    }
}
