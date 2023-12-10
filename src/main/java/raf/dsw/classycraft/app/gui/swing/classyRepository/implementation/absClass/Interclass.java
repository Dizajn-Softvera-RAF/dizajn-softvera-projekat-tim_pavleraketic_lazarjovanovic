package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.state.painter.*;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.ClassPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.InterfacePainter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public abstract class Interclass extends DiagramElement {


    private int strokeW;
    private Painter painter;
    private Color color;
    private Color defaultColor = Color.BLACK;
    private List<ClassContent> content;
    private int maxWidth = 0;
    private List<Point> points;

    private int x;
    private int y;
    private int width;
    private int height;




    public Interclass(String name, ClassyNode parent, Painter painter, Color color, int x, int y) {
        super(name, parent);

        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 130;
        this.color = defaultColor;
        this.strokeW = 3;
        content = new ArrayList<>();
        this.maxWidth = 0;
        points = new ArrayList<>();

        System.out.println(name);
        if(name.equals("Class")){
           this.painter = new ClassPainter(this);
           //napraviTacke();
        } else if (name.equals("Enum")) {
            this.painter = new EnumPainter(this);
            //napraviTacke();
        }else if(name.equals("Interface")){
            this.painter = new InterfacePainter(this);
            //napraviTacke();
        }

    }

    @Override
    public void notifySubscribers(Object notification) throws IOException {

    }

    public void napraviTacke(){
        Point topMiddle = new Point(getX() + width/2,getY());
        Point bottomMiddle = new Point(getX() + width/2,getY() + height);
        Point leftMiddle = new Point(getX(), getY() + height/2);
        Point rightMiddle = new Point(getX() + width, getY() + height/2);

        getPoints().add(topMiddle);
        getPoints().add(bottomMiddle);
        getPoints().add(leftMiddle);
        getPoints().add(rightMiddle);

    }


}
