package raf.dsw.classycraft.app.gui.swing.tree.view;

import raf.dsw.classycraft.app.gui.swing.listener.TreeListener;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.tree.controller.ClassyTreeCellEditor;
import raf.dsw.classycraft.app.gui.swing.tree.controller.ClassyTreeSelectionListener;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;

public class ClassyTreeView extends JTree  {

    public ClassyTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        ClassyTreeCellRenderer ruTreeCellRenderer = new ClassyTreeCellRenderer();
        addTreeSelectionListener(new ClassyTreeSelectionListener());
        setCellEditor(new ClassyTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
        addMouseListener(new TreeListener());
    }

}
