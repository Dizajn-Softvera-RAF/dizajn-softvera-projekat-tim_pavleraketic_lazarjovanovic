package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;

import java.util.Locale;

public class EnumElement extends ClassContent {


    public EnumElement(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return " " + getIme().toUpperCase() + ",";
    }

}
