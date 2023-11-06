package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbscractClassyAction{


    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
        KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete Project");
        putValue(SHORT_DESCRIPTION, "Delete Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ClassyTreeItem selected = MainFrame.getInstance().getClassyTree().getSelectedNode();
        if (selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }

        if (selected.getClassyNode() instanceof ProjectExplorer) {

            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.CANNOT_DELETE_PROJECT_EXPLORER);
            return;
        }
        MainFrame.getInstance().getClassyTree().deleteNode(selected);
    }
}
