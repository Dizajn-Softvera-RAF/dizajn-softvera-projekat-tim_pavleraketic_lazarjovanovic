package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.ClassContent;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Atribut;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.EnumElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.classContent.Metod;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Agregacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class EditClassContentState implements State {

    private String izabran;
    private String ime;
    private String abst;
    private ClassContent classContent;
    private String vidljivost;
    private String kardinalitet;
    private String tipVeze;

    @Override
    public void misKliknut(int xx, int yy, DiagramView diagramView) {
        int x = diagramView.getOriginalCoordinates(new Point(xx,yy)).x;
        int y = diagramView.getOriginalCoordinates(new Point(xx,yy)).y;
        if(diagramView.getClassSelectionModel().getSelected().isEmpty()) {
            for (Painter p : diagramView.getPainters()) {
                if (p.elementAt(x, y)) {
                    if (p.getDiagramElement() instanceof Interclass) {
                        staSeMenja();
                        if (izabran.equals("Interclass")) {
                            Interclass i = (Interclass) p.getDiagramElement();
                            if (i instanceof Class) {
                                isAbstract();

                                if (abst.equals("Abs")) {
                                    try {
                                        izmenaImenaKlase(i);
                                        i.setName(ime + " (A)");
                                        ((Class) i).setAbst(true);
                                        MainFrame.getInstance().getClassyTree().updateTree();
                                        diagramView.repaint();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                } else {
                                    try {
                                        izmenaImenaKlase(i);
                                        i.setName(ime);
                                        ((Class) i).setAbst(false);
                                        MainFrame.getInstance().getClassyTree().updateTree();
                                        diagramView.repaint();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            } else {
                                izmenaImenaKlase(i);
                                try {
                                    i.setName(ime);
                                    MainFrame.getInstance().getClassyTree().updateTree();
                                    diagramView.repaint();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        } else if (izabran.equals("ClassContent")) {
                            if(!((Interclass) p.getDiagramElement()).getContent().isEmpty()) {
                                otvoriListu(((Interclass) p.getDiagramElement()).getPainter());
                                if (classContent instanceof EnumElement) {
                                    izmenaImenaClassContenta(classContent);
                                    classContent.setIme(ime);
                                    diagramView.repaint();
                                } else if (classContent instanceof Atribut) {
                                    classContent.setVidljivost(vidljivost());
                                    classContent.setTip(tip(classContent));
                                    izmenaImenaClassContenta(classContent);
                                    classContent.setIme(ime);
                                    diagramView.repaint();
                                } else if (classContent instanceof Metod) {
                                    classContent.setVidljivost(vidljivost());
                                    classContent.setTip(tip(classContent));
                                    izmenaImenaClassContenta(classContent);
                                    classContent.setIme(ime);
                                    diagramView.repaint();
                                }
                            }
                        }

                    } else if (p.getDiagramElement() instanceof Connection) {
                        Connection c = (Connection) p.getDiagramElement();
                        if (c instanceof Agregacija) {
                            promenaKardinalnosti(c);
                            Agregacija a = (Agregacija) c;
                            a.setKardinalitet(kardinalitet);
                            System.out.println("Novi kardinalitet " + kardinalitet);
                        } else if (c instanceof Kompozicija) {
                            promenaKardinalnosti(c);
                            Kompozicija k = (Kompozicija) c;
                            k.setKardinalitet(kardinalitet);
                            System.out.println("Novi kardinalitet " + kardinalitet);
                        } else if (c instanceof Zavisnost) {
                            promenaTipaVeze();
                            Zavisnost z = (Zavisnost) c;
                            z.setTip(tipVeze);
                            System.out.println("Novi tip: " + tipVeze);
                        }
                    }
                }
            }
        } else{
            for(Painter p: diagramView.getClassSelectionModel().getSelected()) {
                if(p.getDiagramElement() instanceof Interclass){
                    staSeMenja();
                    if (izabran.equals("Interclass")) {
                        Interclass i = (Interclass) p.getDiagramElement();
                        if (i instanceof Class) {
                            isAbstract();
                            if (abst.equals("Abs")) {
                                try {
                                    izmenaImenaKlase(i);
                                    i.setName(ime + " (A) ");
                                    MainFrame.getInstance().getClassyTree().updateTree();
                                    diagramView.repaint();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                try {
                                    izmenaImenaKlase(i);
                                    i.setName(ime);
                                    MainFrame.getInstance().getClassyTree().updateTree();
                                    diagramView.repaint();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        } else {
                            izmenaImenaKlase(i);
                            try {
                                i.setName(ime);
                                MainFrame.getInstance().getClassyTree().updateTree();
                                diagramView.repaint();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else if (izabran.equals("ClassContent")) {
                        if(!((Interclass) p.getDiagramElement()).getContent().isEmpty()) {
                            otvoriListu(((Interclass) p.getDiagramElement()).getPainter());
                            if (classContent instanceof EnumElement) {
                                izmenaImenaClassContenta(classContent);
                                classContent.setIme(ime);
                                diagramView.repaint();
                            } else if (classContent instanceof Atribut) {
                                classContent.setVidljivost(vidljivost());
                                classContent.setTip(tip(classContent));
                                izmenaImenaClassContenta(classContent);
                                classContent.setIme(ime);
                                diagramView.repaint();
                            } else if (classContent instanceof Metod) {
                                classContent.setVidljivost(vidljivost());
                                classContent.setTip(tip(classContent));
                                izmenaImenaClassContenta(classContent);
                                classContent.setIme(ime);
                                diagramView.repaint();
                            }
                        }
                    }
                } else if (p.getDiagramElement() instanceof Connection) {
                    Connection c = (Connection) p.getDiagramElement();
                    if (c instanceof Agregacija) {
                        promenaKardinalnosti(c);
                        Agregacija a = (Agregacija) c;
                        a.setKardinalitet(kardinalitet);
                        System.out.println("Novi kardinalitet " + kardinalitet);
                    } else if (c instanceof Kompozicija) {
                        promenaKardinalnosti(c);
                        Kompozicija k = (Kompozicija) c;
                        k.setKardinalitet(kardinalitet);
                        System.out.println("Novi kardinalitet " + kardinalitet);
                    } else if (c instanceof Zavisnost) {
                        promenaTipaVeze();
                        Zavisnost z = (Zavisnost) c;
                        z.setTip(tipVeze);
                        System.out.println("Novi tip: " + tipVeze);
                    }
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

    public void staSeMenja() {
        String[] s = {"Interclass", "Class Content"};
        int choice = JOptionPane.showOptionDialog(null,
                "What do you want to edit:",
                "Option Dialog",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                s,
                s[0]);
        if (choice == JOptionPane.CLOSED_OPTION) {
            return;
        } else if (s[choice].equals("Interclass")) {
            izabran = "Interclass";
        } else if (s[choice].equals("Class Content")) {
            izabran = "ClassContent";
        }
    }
    public void izmenaImenaKlase(Interclass i){
        ime = JOptionPane.showInputDialog(null,"Set new name","New name");
        if(ime == null) return;
        return;
    }


    public void izmenaImenaClassContenta(ClassContent classContent){
        ime = JOptionPane.showInputDialog(null,"Set new name",classContent.getIme());
        if(ime == null) return;
        return;
    }

    public void isAbstract() {
        String[] s = {"Abstract", "Not Abs"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose an option:",
                "Option Dialog",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                s,
                s[0]);
        if (choice == JOptionPane.CLOSED_OPTION) {
            //MainFrame.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
            System.out.println("Dialog closed without making a selection.");
        } else if (s[choice].equals("Abstract")) {
            abst = "Abs";
        } else if (s[choice].equals("Not Abs")) {
            abst = "NotAbs";
        }
    }

    public void otvoriListu(Painter p){
        Interclass i = (Interclass) p.getDiagramElement();
        Object[] options = i.getContent().toArray();
        Object selectedOption = JOptionPane.showInputDialog(null,
                "Choose an item:", "Class Content",
                JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);

        if (selectedOption == null) {
            MainFrame.getInstance().getMessageGenerator().generateMessage(EventType.COMPONENT_NOT_SELECTED);
        } else {
            classContent = (ClassContent) selectedOption;
            return;
        }
        return;
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

    public String tip(ClassContent classContent){
        String tip = JOptionPane.showInputDialog(null,"Set type",classContent.getTip());
        if(tip == null) return null;
        return tip;
    }

    public void promenaKardinalnosti(Connection c){
        String[] choices = {"0...1","0...*"};
        Object selectedChoice = JOptionPane.showInputDialog(null,
                "Choose an option:", "Kardnialnost",
                JOptionPane.QUESTION_MESSAGE, null,
                choices,
                choices[0]);
        if (selectedChoice == null) {
            System.out.println("User canceled the input.");
        } else if( selectedChoice.equals("0...1")){
            kardinalitet = "0...1";
        }else if( selectedChoice.equals("0...*")) {
            kardinalitet = "0...*";
        }
    }
    public void promenaTipaVeze(){
        String[] choices = {"Call","Instantiate"};
        Object selectedChoice = JOptionPane.showInputDialog(null,
                "Choose an option:", "Kardnialnost",
                JOptionPane.QUESTION_MESSAGE, null,
                choices,
                choices[0]);
        if (selectedChoice == null) {
            System.out.println("User canceled the input.");
        } else if( selectedChoice.equals("Call")){
            tipVeze = "Call";
        }else if( selectedChoice.equals("Instantiate")) {
            tipVeze = "Instantiate";
        }
    }

}
