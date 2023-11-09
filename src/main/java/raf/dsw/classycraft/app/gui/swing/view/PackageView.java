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
    private JLabel jLabelName;
    private JLabel author;

    private ClassyNodeComposite paket;


    public PackageView(){

        //dodajemo ime projekta i autora
        projectName = new JLabel();
        projectName.setVisible(true);
        projectName.setAlignmentX(CENTER_ALIGNMENT);
        add(projectName);

        jLabelName = new JLabel("Ime projekta: ");
        jLabelName.setVisible(true);
        jLabelName.setAlignmentX(CENTER_ALIGNMENT);

        //pravimo jTabbedPane i dodajemo ga na JPane
        jTabbedPane = new JTabbedPane();
        add(jTabbedPane);

        author = new JLabel();
        author.setVisible(true);
        add(author);

        //inicijalizujemo listu
        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);
    }

    public void reloadTabs(ClassyNodeComposite selected){

       tabs.clear();
       jTabbedPane.removeAll();



        this.paket = selected;
        paket.addSubscriber(this);


        for(ClassyNode child :  paket.getChildren()){
            if(child instanceof Diagram) {
                DiagramView diagramView = new DiagramView((Diagram) child);
                tabs.add(diagramView);
            }
        }

        for(DiagramView tab : tabs){
            jTabbedPane.add(tab.getDiagram().getName(),tab);
        }


        if(paket.getParent() instanceof Project){
            Project p =(Project) paket.getParent();
            this.author.setText(p.getAuthor());
            this.projectName.setText(paket.getParent().getName());
            //paket.getParent().addSubscriber(this);
        } else if (paket.getParent() instanceof Package) {
            Package pak1 = (Package) paket.getParent();
            Project p2 = (Project) pak1.getParent();
            this.author.setText(p2.getAuthor());
            this.projectName.setText(paket.getParent().getParent().getName());
            //paket.getParent().getParent().addSubscriber(this);
        }
        jTabbedPane.setVisible(true);

    }


    @Override
    public void update(Object notification) {
        reloadTabs((ClassyNodeComposite) notification);
    }




}
