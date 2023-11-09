package raf.dsw.classycraft.app.gui.swing.classyRepository.factory;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;

import java.io.IOException;

public abstract class NodeFactory extends ClassyNode {


    public NodeFactory(String name, ClassyNode parent) {
        super(name, parent);
    }


    public ClassyNode getClassyNode(ClassyNode parent) throws IOException {
        ClassyNode n = createNode(parent);
        n.setParent(parent);
        return n;
    }

    public abstract ClassyNode createNode(ClassyNode node) throws IOException;

}
