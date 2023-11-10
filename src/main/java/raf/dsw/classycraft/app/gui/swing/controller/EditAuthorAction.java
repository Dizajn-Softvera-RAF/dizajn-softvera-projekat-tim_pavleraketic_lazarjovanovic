package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class EditAuthorAction extends AbscractClassyAction {

    public EditAuthorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selected = MainFrame.getInstance().getClassyTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }

        if (selected.getClassyNode() instanceof Project) {
            String newAuthor = JOptionPane.showInputDialog("Enter authors name:");
            try {
                ((Project) selected.getClassyNode()).setAuthor(newAuthor);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
