package raf.dsw.classycraft.app.gui.swing.classyRepository.factory;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class DiagramFactory extends NodeFactory {


    public DiagramFactory(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public ClassyNode createNode(ClassyNode node) throws IOException {
        String s = JOptionPane.showInputDialog(MainFrame.getInstance(), "Paket ili Dijagram?\n", "Option", JOptionPane.QUESTION_MESSAGE);
        if (s.toLowerCase().equals("paket")) {
            return new Package("Paket", node);
        }
        return new Diagram("Diagram" , node);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }
}
