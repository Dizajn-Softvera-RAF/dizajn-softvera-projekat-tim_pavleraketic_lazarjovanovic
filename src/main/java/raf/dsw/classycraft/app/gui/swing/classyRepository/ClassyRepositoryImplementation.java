package raf.dsw.classycraft.app.gui.swing.classyRepository;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.message.EventType;

public class ClassyRepositoryImplementation implements ClassyRepository {


    private ProjectExplorer projectExplorer;

    public ClassyRepositoryImplementation() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(ClassyNodeComposite parent, ClassyNode child) {

            if (child == null || parent.getChildren().contains(child)) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_ALREADY_EXISTS);
                return;
            }
            parent.getChildren().add(child);
        }


    }

