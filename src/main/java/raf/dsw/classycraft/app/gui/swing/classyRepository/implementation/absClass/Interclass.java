package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.state.painter.*;

import java.awt.*;
import java.io.IOException;


@Setter
@Getter
public abstract class Interclass extends DiagramElement {


    private int strokeW;
    private Painter painter;
    private Color color;
    private Color defaultColor = Color.BLACK;

    private int x;
    private int y;
    private int width;
    private int height;



    public Interclass(String name, ClassyNode parent, Painter painter, Color color, int x, int y) {
        super(name, parent);

        this.x = x;
        this.y = y;
        this.width = 90;
        this.height = 120;
        this.color = defaultColor;
        this.strokeW = 3;

        System.out.println(name);
        if(name.equals("Class")){
           this.painter = new ClassPainter(this);
        } else if (name.equals("Enum")) {
            this.painter = new EnumPainter(this);
        }else if(name.equals("Interface")){
            this.painter = new InterfacePainter(this);
        }

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }
}
