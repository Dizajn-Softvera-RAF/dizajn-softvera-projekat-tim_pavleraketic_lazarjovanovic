package raf.dsw.classycraft.app.gui.swing.classyRepository.factory;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.util.Random;

public class FactoryUtils {



    public static NodeFactory getFactory(ClassyNode parent){
    if (parent instanceof ProjectExplorer) {
        return  new ProjectFactory("Project" , parent);
    } else if (parent instanceof Project) {
        return  new PackageFactory("Package", parent);
    } else if (parent instanceof Package){
        return new DiagramFactory("Diagram" , parent);
    }
        return null;
}

}
