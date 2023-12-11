package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;

import java.awt.*;
@Getter
@Setter

public class Metod extends ClassContent {

    private String tip;
    private String vidljivost;
    public Metod(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return " " + getVidljivost() + " " + getIme() + "() : " + getTip() ;
    }
}
