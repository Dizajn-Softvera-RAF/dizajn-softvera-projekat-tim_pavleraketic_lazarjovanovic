package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;

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
    private ClassyNodeComposite pckg;

    public PackageView(){

        jTabbedPane = new JTabbedPane();
        add(jTabbedPane);
        projectName = new JLabel();
        projectName.setVisible(true);
        add(projectName);
        author = new JLabel();
        author.setVisible(true);
        add(author);
        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);

    }

    public void reloadTabs(ClassyNodeComposite selected){
        tabs.clear();
        jTabbedPane.removeAll();
        this.pckg = selected;
        pckg.addSubscriber(this);
        for(ClassyNode child :  pckg.getChildren()){
            DiagramView diagramView = new DiagramView((Diagram) child);
            tabs.add(diagramView);
        }

        for(DiagramView tab : tabs){
            jTabbedPane.add(tab.getDiagram().getName(),tab);
        }

        Project p = (Project) pckg;
        this.author.setText(p.getAuthor());
        this.projectName.setText(pckg.getName());
        jTabbedPane.setVisible(true);

    }

    @Override
    public void update(Object notification) {

    }


}
