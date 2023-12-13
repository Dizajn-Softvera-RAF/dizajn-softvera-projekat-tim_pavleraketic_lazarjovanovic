package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;

public interface ClassyRepository {

     ProjectExplorer getProjectExplorer();

     void addChild(ClassyNodeComposite parent, ClassyNode child);

     void deleteChild(ClassyNodeComposite parent, ClassyNode child);


}
