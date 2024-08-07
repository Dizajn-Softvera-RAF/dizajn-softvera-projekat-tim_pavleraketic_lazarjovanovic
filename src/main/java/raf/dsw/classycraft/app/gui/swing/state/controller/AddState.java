package raf.dsw.classycraft.app.gui.swing.state.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;


import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.text.AttributedString;

@Setter
@Getter
public class AddState implements State {

    public String izabran;
    public String abst;



    @Override
    public void misKliknut(int xx, int yy, DiagramView diagramView) {
        int x = diagramView.getOriginalCoordinates(new Point(xx,yy)).x;
        int y = diagramView.getOriginalCoordinates(new Point(xx,yy)).y;
        System.out.println("clik");
        DiagramElement novi = null;
        if(izabran.equals("Class")) {
            isAbstract();

            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!(p.getDiagramElement() instanceof Interclass)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Interclass)  p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Interclass) p.getDiagramElement()).getWidth(), y + ((Interclass) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Interclass) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Class c = new Class("Class", diagramView.getDiagram(), x, y);

            //c.napraviTacke();
            if(abst.equals("Abs")){
                try {
                    c.setName( izaberiIme() + " (A) ");
                    c.setAbst(true);
                    } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    c.setName(izaberiIme());
                    c.setAbst(false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            c.getPainter().setDiagramElement(c);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram(), c);
            diagramView.getPainters().add(c.getPainter());
            diagramView.getDiagram().addChild(c);
            diagramView.repaint();
            novi = c;
        } else if (izabran.equals("Enum")) {
            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!(p.getDiagramElement() instanceof Interclass)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Interclass) p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Interclass) p.getDiagramElement()).getWidth(), y + ((Interclass) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Interclass) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Enum en = new Enum("Enum", diagramView.getDiagram(), x, y);// :)
            //en.napraviTacke();
            try {
                    en.setName(izaberiIme());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            en.getPainter().setDiagramElement(en);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram());
            diagramView.getPainters().add(en.getPainter());
            diagramView.getDiagram().addChild(en);
            diagramView.repaint();
            novi = en;

        }else if (izabran.equals("Interface")) {
            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!( p.getDiagramElement() instanceof Interclass)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Interclass) p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Interclass) p.getDiagramElement()).getWidth(), y + ((Interclass) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Interclass) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Interface i = new Interface("Interface", diagramView.getDiagram(), x, y);// :)
            //i.napraviTacke();
            try {
                i.setName(izaberiIme());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            i.getPainter().setDiagramElement(i);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram(), c);
            diagramView.getPainters().add(i.getPainter());
            diagramView.getDiagram().addChild(i);
            diagramView.repaint();
            novi = i;
        }

        MainFrame.getInstance().getClassyTree().addDiagramChild(diagramView.getDiagram(), novi);

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
        String[] s = {"Class", "Enum", "Interface"};
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
        } else if (s[choice].equals("Class")) {
            izabran = "Class";
        }else if (s[choice].equals("Enum")) {
            izabran = "Enum";
        }else if (s[choice].equals("Interface")) {
            izabran = "Interface";
        }
    }

    public String izaberiIme(){
        String ime = JOptionPane.showInputDialog(null,"Set name","Name");
        if(ime == null) return null;
        return ime;
    }

    public void isAbstract(){
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
        }else if (s[choice].equals("Not Abs")) {
            abst = "NotAbs";
    }
}
}
