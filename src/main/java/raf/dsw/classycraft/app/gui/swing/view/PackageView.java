package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

import javax.swing.*;
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

    public PackageView(){

        //pravimo jTabbedPane i dodajemo ga na JPane
        jTabbedPane = new JTabbedPane();
        add(jTabbedPane);

        //dodajemo ime projekta i autora
        projectName = new JLabel();
        projectName.setVisible(true);

        author = new JLabel();
        author.setVisible(true);

        JPanel labelPanel = new JPanel();
        labelPanel.add(projectName);
        labelPanel.add(author);

        //inicijalizujemo listu
        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);
        add(labelPanel);

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

        //Package p = (Package) paket;
        //this.author.setText(p.getAuthor());
        this.projectName.setText(paket.getName());
        jTabbedPane.setVisible(true);

    }

    public DiagramView getDiagramView(){
        return (DiagramView) jTabbedPane.getSelectedComponent();
    }


    @Override
    public void update(Object notification) {

    }


}
