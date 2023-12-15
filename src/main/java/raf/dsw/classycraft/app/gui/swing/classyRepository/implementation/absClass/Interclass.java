package raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.state.painter.*;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.ClassPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.EnumPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.interclass.InterfacePainter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public abstract class Interclass extends DiagramElement implements Cloneable {


    private int strokeW;
    private Painter painter;
    private Color color;
    private Color defaultColor = Color.BLACK;
    private List<ClassContent> content;
    private int maxWidth = 0;
    private List<Point> points;
    private List<ConnectPainter> connectPainters;


    private int x;
    private int y;
    private int width;
    private int height;




    public Interclass(String name, ClassyNode parent, Painter painter, Color color, int x, int y) {
        super(name, parent);

        this.x = x;
        this.y = y;
        this.width = 150;
        this.height = 180;
        this.color = defaultColor;
        this.strokeW = 3;
        content = new ArrayList<>();
        this.maxWidth = 0;
        points = new ArrayList<>();
        connectPainters = new ArrayList<>();


        System.out.println(name);
        if(name.equals("Class")){
           this.painter = new ClassPainter(this);
        }else if (name.equals("Enum")) {
            this.painter = new EnumPainter(this);
        }else if(name.equals("Interface")){
            this.painter = new InterfacePainter(this);
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Interclass novi = (Interclass) super.clone();
        novi.painter = null;
        novi.points = new ArrayList<>(getPoints());
        novi.content = new ArrayList<>(getContent());
        novi.connectPainters = new ArrayList<>();
        novi.x = this.x + this.getWidth() + 10;
        novi.y = this.y;

        return novi;
    }
}
