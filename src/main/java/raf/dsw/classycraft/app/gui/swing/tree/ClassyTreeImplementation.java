package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.core.ApplicationFramework;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.factory.FactoryUtils;
import raf.dsw.classycraft.app.gui.swing.classyRepository.factory.NodeFactory;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.*;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.message.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.util.Random;

public class ClassyTreeImplementation implements ClassyTree {

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
        if(child == null) return;
        parent.add(new ClassyTreeItem(child));
        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        //System.out.println(parent.getClassyNode()+" "+child);
        //ApplicationFramework.getInstance().getClassyRepository().addChild((ClassyNodeComposite) parent.getClassyNode(), child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteNode(ClassyTreeItem selectedNode) {
        ClassyNodeComposite p = (ClassyNodeComposite) selectedNode.getClassyNode().getParent();
        p.removeChild(selectedNode.getClassyNode());
        selectedNode.removeAllChildren();
        selectedNode.removeFromParent();
        treeView.expandPath(treeView.getSelectionPath());
       // ApplicationFramework.getInstance().getClassyRepository().deleteChild(p, selectedNode.getClassyNode());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void editNode(ClassyTreeItem classyTreeItem) {
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addDiagramChild(Diagram diagram, DiagramElement novi) {
        ClassyTreeItem cti = getTreeItem(diagram);
        ClassyTreeItem ctiChild = new ClassyTreeItem(novi);
        cti.add(ctiChild);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public void removeDiagramChild(Diagram diagram, DiagramElement childToRemove) {

        ClassyTreeItem parentTreeItem = getTreeItem(diagram);
        ClassyTreeItem childTreeItem = findChildTreeItem(parentTreeItem, childToRemove);
        if (childTreeItem != null) {
            parentTreeItem.remove(childTreeItem);
            SwingUtilities.updateComponentTreeUI(treeView);
        }
    }

    @Override
    public void updateTree() {
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private ClassyTreeItem findChildTreeItem(ClassyTreeItem parent, DiagramElement child) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            Object childObject = parent.getChildAt(i);
            if (childObject instanceof ClassyTreeItem) {
                ClassyTreeItem childTreeItem = (ClassyTreeItem) childObject;
                if (childTreeItem.getClassyNode().equals(child)) {
                    return childTreeItem;
                }
            }
        }
        return null;
    }


    private ClassyTreeItem getTreeItem(Diagram diagram) {
        if (diagram == null) return null;
        for (int i=0; i<treeView.getRowCount(); i++){
            ClassyTreeItem cti = (ClassyTreeItem) treeView.getPathForRow(i).getLastPathComponent();
            if (cti != null && cti.getClassyNode() == diagram){
                System.out.println(cti);
                return cti;
            }
        }
        return null;
    }


    private ClassyNode createChild(ClassyNode parent) throws IOException {

            NodeFactory nodeFactory = FactoryUtils.getFactory(parent);
            if(nodeFactory == null)return null;
            return nodeFactory.getClassyNode(parent);
    }




}
