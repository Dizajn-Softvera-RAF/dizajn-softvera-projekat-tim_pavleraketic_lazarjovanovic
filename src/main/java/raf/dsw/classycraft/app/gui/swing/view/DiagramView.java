package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.state.ClassSelectionModel;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.view.controller.MouseController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

@Getter
@Setter

public class DiagramView extends JPanel implements Subscriber {

    private JToolBar diagramToolBar;
    private Diagram diagram;
    private PackageView packageView;
    private List<Painter> painters;
    private List<Painter> selected;
    private ClassSelectionModel classSelectionModel;

    private MouseController mc;




    public DiagramView(Diagram diagram) {

        this.setLayout(new BorderLayout());
        setDiagram(diagram);

        this.mc = new MouseController();
        mc.setDiagramView(this);
        addMouseListener(mc);
        addMouseMotionListener(mc);

        classSelectionModel = new ClassSelectionModel();
        classSelectionModel.addSubscriber(this);

        painters = new ArrayList<>();
        selected = new ArrayList<>();

        for(ClassyNode classyNode: diagram.getChildren()){
            Class c = (Class) classyNode;
            System.out.println(classyNode+" "+c+" "+c.getPainter());
            painters.add(c.getPainter());
        }
        setDiagram(diagram);


    }



    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
        this.diagram.addSubscriber(this);

    }

    public void setPackageView(PackageView packageView){
        this.packageView = packageView;
    }



    @Override
    public void update(Object notification) throws IOException {
//        if (notification instanceof  String) repaint();
//        else {
//            packageView.setDiagrams();
//            MainFrame.getInstance().reload(packageView);
//        }
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(painters.isEmpty()) return;
        for(Painter p : painters){
            p.draw(g2d);
        }
    }
}
