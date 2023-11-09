package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class PackageView extends JPanel implements Subscriber {

    private JTabbedPane jTabbedPane;
    private List<DiagramView> tabs;
    private JLabel projectName;
    private JLabel author;
    private ClassyNodeComposite paket;

    public PackageView(){



        //dodajemo ime projekta i autora
        projectName = new JLabel();
        projectName.setVisible(true);
        projectName.setAlignmentX(CENTER_ALIGNMENT);

        author = new JLabel();
        author.setVisible(true);

        add(projectName);
        add(author);

        //pravimo jTabbedPane i dodajemo ga na JPane
        jTabbedPane = new JTabbedPane();
        add(jTabbedPane);



        //inicijalizujemo listu
        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);


    }

    public void reloadTabs(ClassyNodeComposite selected){

       tabs.clear();
       jTabbedPane.removeAll();
        this.paket = (Package) selected;
        paket.addSubscriber(this);
        for(ClassyNode child :  paket.getChildren()){
                DiagramView diagramView = new DiagramView((Diagram) child);
                tabs.add(diagramView);

        }

        for(DiagramView tab : tabs){
            jTabbedPane.add(tab.getDiagram().getName(),tab);
        }


        //Project p = (Project) paket;
        //this.author.setText(p.getAuthor());
        this.projectName.setText(paket.getParent().getName());
        jTabbedPane.setVisible(true);

    }


    @Override
    public void update(Object notification) {
        reloadTabs((ClassyNodeComposite) notification);
//        Diagram d = (Diagram) notification;
//        //tabs.add((DiagramView)notification);
//        jTabbedPane.add(d.getName(),new DiagramView(d));

    }


}
