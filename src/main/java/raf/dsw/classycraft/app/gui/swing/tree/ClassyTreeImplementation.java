package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.util.Random;

public class ClassyTreeImplementation implements ClassyTree{

    private ClassyTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
        ClassyTreeItem root = new ClassyTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new ClassyTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(ClassyTreeItem parent) throws IOException {

        if (!(parent.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyNode child = createChild(parent.getClassyNode());
        parent.add(new ClassyTreeItem(child));
        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteNode(ClassyTreeItem selectedNode) {
        selectedNode.removeAllChildren();
        selectedNode.removeFromParent();
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void editNode(ClassyTreeItem selectedNode) {
        selectedNode.getClassyNode().getName();
        SwingUtilities.updateComponentTreeUI(treeView);

    }


    private ClassyNode createChild(ClassyNode parent) throws IOException {
        if (parent instanceof ProjectExplorer) {
                return  new Project("Project" +new Random().nextInt(100), parent);
        } else if (parent instanceof Project) {
            return  new Package("Package" + new Random().nextInt(100), parent);
        } else if (parent instanceof Package){
            return new Diagram("Diagram" + new Random().nextInt(100),parent);
            }
        return null;
    }

}
