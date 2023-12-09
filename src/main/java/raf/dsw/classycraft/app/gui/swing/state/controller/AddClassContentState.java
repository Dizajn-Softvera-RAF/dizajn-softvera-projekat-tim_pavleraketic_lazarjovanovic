package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;

public class AddClassContentState implements State {

    private String izabran;
    private String vidljivost;

    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

        if (izabran.equals("Attribute")) {
            for (Painter p : diagramView.getPainters()) {
                if (p.elementAt(x, y)) {
                    ClassContent atribut = new Atribut("");
                    atribut.setVidljivost(vidljivost());
                    atribut.setTip(tip());
                    atribut.setIme(ime());
                    ((Interclass) p.getDiagramElement()).getContent().add(atribut);
                }
            }
            diagramView.repaint();
        } else if(izabran.equals("Method")) {
        for (Painter p : diagramView.getPainters()) {
            if (p.elementAt(x, y)) {
                ClassContent metod = new Metod("");
                metod.setVidljivost(vidljivost());
                metod.setTip(tip());
                metod.setIme(ime());
                ((Interclass) p.getDiagramElement()).getContent().add(metod);
            }
        }
        diagramView.repaint();
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

    public void izaberiTip() {
        String[] s = {"Method", "Attribute"};
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
        } else if (s[choice].equals("Method")) {
            izabran = "Method";
        } else if (s[choice].equals("Attribute")) {
            izabran = "Attribute";
        }
    }

    public String vidljivost(){
        String[] choices = {"Private","Public","Default","Protected"};
        Object selectedChoice = JOptionPane.showInputDialog(null,
                "Choose an option:", "Visibility",
                JOptionPane.QUESTION_MESSAGE, null,
                choices,
                choices[0]);
        if (selectedChoice == null) {
            System.out.println("User canceled the input.");
        } else if( selectedChoice.equals("Private")){
            vidljivost = "-";
        }else if( selectedChoice.equals("Public")) {
            vidljivost = "+";
        }else if( selectedChoice.equals("Protected")) {
            vidljivost = "#";
        }else if( selectedChoice.equals("Default")) {
            vidljivost = "~";
        }
        return vidljivost;
    }
    public String ime(){
        String ime = JOptionPane.showInputDialog(null,"Set name","Name");
        if(ime == null) return null;
        return ime;
    }

    public String tip(){
        String tip = JOptionPane.showInputDialog(null,"Set type","Type");
        if(tip == null) return null;
        return tip;
    }



}
