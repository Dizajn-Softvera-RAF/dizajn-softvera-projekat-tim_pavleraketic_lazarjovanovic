package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;

import java.io.IOException;

public interface ClassyTree {

    ClassyTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(ClassyTreeItem parent) throws IOException;
    ClassyTreeItem getSelectedNode();

    void deleteNode(ClassyTreeItem selectedNode);
    void editNode (ClassyTreeItem classyTreeItem);


    void addDiagramChild(Diagram diagram, DiagramElement novi);
    void removeDiagramChild(Diagram diagram, DiagramElement childToRemove);
}
