package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class DiagramView extends JPanel implements Subscriber {

    private JToolBar diagramToolBar;
    private Diagram diagram;




    public DiagramView(Diagram diagram) {

        this.setLayout(new BorderLayout());
        setDiagram(diagram);

    }

    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
        this.diagram.addSubscriber(this);

    }


    @Override
    public void update(Object notification) {

    }
}
