package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.gui.swing.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter

public class PackageView extends JPanel implements Subscriber {

    private JTabbedPane jTabbedPane;
    private List<DiagramView> tabs;
    private JLabel projectName;
    private JLabel author;
    private Package paket;
    private Map<Diagram,DiagramView> diagramMap;
    private StateManager stateManager;




    public PackageView(Package paket){
        this.paket = paket;
        this.stateManager = new StateManager();
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

    public void clearTabs(){
        jTabbedPane.removeAll();
        tabs.clear();
        projectName.setVisible(false);
        author.setVisible(false);
    }

    public void ucitavanje(){


        DiagramView remove = null;

        for(ClassyNode child: paket.getChildren()){
            if (!(child instanceof Diagram)) continue;
            if (diagramMap.containsKey(child)) continue;
            DiagramView d = new DiagramView((Diagram) child);
            d.setPackageView(this);
            tabs.add(d);
            jTabbedPane.add(d);
            diagramMap.put((Diagram) child, d);
        }

        for (DiagramView tab: tabs){
            if (paket.getChildren().contains(tab.getDiagram())) {
                continue;
            }
            else{
                jTabbedPane.remove(tab);
                diagramMap.remove(tab.getDiagram(), tab);
                remove = tab;
            }
        }
        tabs.remove(remove);
    }

    public void startAddState(){
        this.stateManager.setAddState();
    }
    public void startDeleteState(){
        this.stateManager.setDeleteState();
    }
    public void startMoveState(){this.stateManager.setMoveState();}
    public void startSelectState(){this.stateManager.setSelectState();}
    public void startAddAttributeState(){this.stateManager.setAddAttributeState();}

    public void startConnectState(){this.stateManager.setConnectState();}
    public void misKliknut(int x, int y, DiagramView m ){
        //System.out.println("kliknute su koordinate: ("+x+", "+y+")\t"+"na mapi "+m.getName());
        stateManager.getCurrent().misKliknut(x, y, m);
    }

    public void misPritisnut(int x, int y, DiagramView m){
        //System.out.println("kliknute su koordinate: ("+x+", "+y+")\t"+"na mapi "+m.getName());
        stateManager.getCurrent().misPritisnut(x, y, m);
    }

    public void misPovucen(int x, int y, DiagramView m){
        //System.out.println("kliknute su koordinate: ("+x+", "+y+")\t"+"na mapi "+m.getName());
        stateManager.getCurrent().misPovucen(x, y, m);
    }
    public void misOtpusten(int x, int y, DiagramView m){
        //System.out.println("kliknute su koordinate: ("+x+", "+y+")\t"+"na mapi "+m.getName());
        stateManager.getCurrent().misOtpusten(x,y,m);
}




    @Override
    public void update(Object notification) {
        if(notification instanceof Package) load((Package) notification);
        else if(notification instanceof String){
            if(notification.equals("child")) setDiagrams();
            //else if (notification.equals("child1")) ucitavanje();
            else if (notification.equals("ime")) setLabels();
            else if (notification.equals("clear")) clearTabs();
            }

    }
}







