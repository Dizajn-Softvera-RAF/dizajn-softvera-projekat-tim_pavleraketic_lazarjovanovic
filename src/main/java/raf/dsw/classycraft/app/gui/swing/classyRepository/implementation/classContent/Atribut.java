package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;

import java.awt.*;

@Getter
@Setter

public class Atribut extends ClassContent {

    private String vidljivost;
    private String tip;
    public Atribut(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return " " +  getVidljivost() + " " + getIme() + " : " + getTip() ;
    }
}
