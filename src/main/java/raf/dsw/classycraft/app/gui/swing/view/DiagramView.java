package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ConcurrentModificationException;

@Getter
@Setter

public class DiagramView extends JPanel implements Subscriber {

    private JToolBar diagramToolBar;
    private Diagram diagram;
    private PackageView packageView;




    public DiagramView(Diagram diagram) {

        this.setLayout(new BorderLayout());
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
        packageView.setDiagrams();
        MainFrame.getInstance().reload(packageView);
    }
}
