package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;

import java.io.IOException;
@Getter
@Setter

public abstract class Connection extends DiagramElement {

    private Interclass od;
    private Interclass ka;
    private float xF, yF, xS, yS;


    public Connection(String name, ClassyNode parent,Interclass od, Interclass ka){
        super(name, parent);
        this.od = od;
        this.ka = ka;
    }

    public void setFirstTopic(Interclass od) {
        this.od = od;
        xF = od.getX();
        yF = od.getY();
    }

    public void setSecondTopic(Interclass ka) {
        this.ka = ka;
        xS = ka.getX();
        yS = ka.getY();
    }

    public void setNewCoordinates(){
        if(ka == null) return;
        xF = od.getX();
        yF = od.getY();
        xS = ka.getX();
        yS = ka.getY();
    }


}
