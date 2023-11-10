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
    private Package paket;




    public PackageView(Package paket){
        this.paket = paket;
        initalize();
    }

    private void initalize() {

        projectName = new JLabel();
        author = new JLabel();
        jTabbedPane = new JTabbedPane();
        tabs = new ArrayList<>();

        add(projectName);
        add(jTabbedPane);
        add(author);

        projectName.setVisible(true);
        projectName.setAlignmentX(CENTER_ALIGNMENT);
        author.setVisible(true);
        jTabbedPane.setVisible(true);

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);

    }

    public void load(ClassyNodeComposite selected){

        if(selected==null || !(selected instanceof Package)){
            return;
        }
        setDiagrams();
        this.paket = (Package) selected;
        paket.addSubscriber(this);
        paket.getParent().addSubscriber(this);
        setLabels();
    }

    private void setLabels() {
        if(paket.getParent() instanceof Project){
        this.author.setText("Autor: "+(((Project)paket.getParent()).getAuthor()));
        this.projectName.setText("Ime projekta: " + ((Project)paket.getParent()).getName());
        }
        else if(paket.getParent() instanceof Package){
            while(!(paket.getParent() instanceof Project)){
                Package paket2 = (Package) paket.getParent();
               paket.setParent(paket2.getParent());
            }
            this.author.setText("Autor: "+(((Project)paket.getParent()).getAuthor()));
            this.projectName.setText("Ime projekta: " + ((Project)paket.getParent()).getName());}
        }


    public void setDiagrams() {
        tabs.clear();
        jTabbedPane.removeAll();
        for(ClassyNode child: paket.getChildren()){
            if (!(child instanceof Diagram)) continue;
            DiagramView d = new DiagramView((Diagram) child);
            d.setPackageView(this);
            tabs.add(d);
            for(DiagramView tab : tabs){
                jTabbedPane.add(tab.getDiagram().getName(),tab);
            }
        }
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Package) load((Package) notification);
        else if(notification instanceof String){
            if(notification.equals("child")) setDiagrams();
            else if (notification.equals("ime")) setLabels();}
        }
    }







