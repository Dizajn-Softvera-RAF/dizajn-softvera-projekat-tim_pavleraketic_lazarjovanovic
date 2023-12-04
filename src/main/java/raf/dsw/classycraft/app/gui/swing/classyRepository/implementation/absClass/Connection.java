package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;

import java.io.IOException;

public abstract class Connection extends DiagramElement {

    private Interclass od;
    private Interclass ka;


    public Connection(String name, ClassyNode parent,Interclass od, Interclass ka){
        super(name, parent);
        this.od = od;
        this.ka = ka;
    }
}
