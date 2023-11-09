package raf.dsw.classycraft.app.gui.swing.tree.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class ClassyTreeSelectionListener implements TreeSelectionListener {

    //private List<Package> selektovani = new ArrayList<>();

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        ClassyTreeItem treeItemSelected = (ClassyTreeItem)path.getLastPathComponent();
        System.out.println("Selektovan cvor:"+ treeItemSelected.getClassyNode().getName());
        System.out.println("getPath: "+e.getPath());

        if(treeItemSelected.getClassyNode() instanceof Package){
                Package p = (Package) treeItemSelected.getClassyNode();
                MainFrame.getInstance().getPackageView().reloadTabs(p);
           }

       }
//        else if (treeItemSelected.getClassyNode() instanceof Diagram){
//            Diagram d = (Diagram) treeItemSelected.getClassyNode();
//            MainFrame.getInstance().getPackageView().reloadTabs((ClassyNodeComposite) d.getParent());
//        }
    }

