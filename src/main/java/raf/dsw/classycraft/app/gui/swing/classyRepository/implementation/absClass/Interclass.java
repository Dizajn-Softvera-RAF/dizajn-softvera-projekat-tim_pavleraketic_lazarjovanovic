package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;

import java.io.IOException;


public abstract class Interclass extends DiagramElement {


    private String vidljivost;
    private String naziv;
    private int position;
    private int size;


    public Interclass(String name, ClassyNode parent, String vidljivost, String naziv,int position,int size){
        super(name, parent);
        this.vidljivost = vidljivost;
        this.naziv = naziv;
        this.position = position;
        this.size = size;
    }

}
