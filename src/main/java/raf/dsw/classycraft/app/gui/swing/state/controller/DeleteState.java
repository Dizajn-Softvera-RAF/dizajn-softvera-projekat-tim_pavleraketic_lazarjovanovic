package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;

public class DeleteState implements State {
    
    private String izabran;
    private ClassContent ime;
    
    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        for(Painter p: diagramView.getPainters()){
            if (p.elementAt(x, y)) {
                if(p.getDiagramElement() instanceof Interclass){
                   staSeBrise();
                   if(izabran.equals("Interclass")){
                       diagramView.getPainters().remove(p);
                       diagramView.repaint();
                   } else if (izabran.equals("ClassContent")) {
                        otvoriListu(p);
                        ((Interclass) p.getDiagramElement()).getContent().remove(ime);
                        diagramView.repaint();
                   }
                } else if (p.getDiagramElement() instanceof Connection) {
                    diagramView.getPainters().remove(p);
                    diagramView.repaint();
                }
            }
        }
    }
        

    

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {

    }
    
    public void staSeBrise() {
        String[] s = {"Interclass", "Class Content"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose an option:",
                "Option Dialog",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                s,
                s[0]);
        if (choice == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without making a selection.");
        } else if (s[choice].equals("Interclass")) {
            izabran = "Interclass";
        } else if (s[choice].equals("Class Content")) {
            izabran = "ClassContent";
        }
    }

    public ClassContent otvoriListu(Painter p){
        Interclass i = (Interclass) p.getDiagramElement();
        Object[] options = i.getContent().toArray();
        Object selectedOption = JOptionPane.showInputDialog(null,
                "Choose an item:", "Class Content",
                JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);

        if (selectedOption == null) {
            System.out.println("User canceled the input.");
        } else {
            ime = (ClassContent) selectedOption;
            System.out.println("You selected: " + selectedOption);
            return (ClassContent) ime;
        }
      return null;
    }
}
