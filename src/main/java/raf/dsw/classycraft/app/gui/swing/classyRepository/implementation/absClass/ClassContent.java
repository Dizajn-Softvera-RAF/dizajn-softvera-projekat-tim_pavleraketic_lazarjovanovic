package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public abstract class ClassContent {
    private String ime;
    //private Font font;
    private String tip;
    private String vidljivost;

    public ClassContent(String ime) {
        this.ime = ime;

    }

}
