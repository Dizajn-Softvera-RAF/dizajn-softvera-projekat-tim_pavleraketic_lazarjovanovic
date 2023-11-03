package raf.dsw.classycraft.app.gui.swing.classyRepository;

import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;

public class ClassyRepositoryImplementation implements ClassyRepository {


    private ProjectExplorer projectExplorer;

    public ClassyRepositoryImplementation() {
        projectExplorer = new ProjectExplorer(projectExplorer.getName());
    }

    @Override
    public ProjectExplorer getRoot() {
        projectExplorer = getRoot();
        return getRoot();
    }
}
