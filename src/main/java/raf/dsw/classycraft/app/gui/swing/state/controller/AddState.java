package raf.dsw.classycraft.app.gui.swing.state.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Class;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Enum;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.klase.Interface;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class AddState implements State {

    public String izabran;


    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        System.out.println("clik");
        if(izabran.equals("Class")) {

            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!(p.getDiagramElement() instanceof Class)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Class)  p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Class) p.getDiagramElement()).getWidth(), y + ((Class) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Class) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Class c = new Class("Class", diagramView.getDiagram(), x, y);// :)
            c.getPainter().setDiagramElement(c);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram(), c);
            diagramView.getPainters().add(c.getPainter());
            diagramView.getDiagram().addChild(c);
            diagramView.repaint();
        } else if (izabran.equals("Enum")) {
            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!(p.getDiagramElement() instanceof Enum)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Enum) p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Enum) p.getDiagramElement()).getWidth(), y + ((Enum) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Enum) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Enum е = new Enum("Enum", diagramView.getDiagram(), x, y);// :)
            е.getPainter().setDiagramElement(е);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram(), c);
            diagramView.getPainters().add(е.getPainter());
            diagramView.getDiagram().addChild(е);
            diagramView.repaint();

        }else if (izabran.equals("Interface")) {
            for (Painter p : diagramView.getPainters()) {
                if (p instanceof ElementPainter) {
                    if (!( p.getDiagramElement() instanceof Interface)) continue;
                    if (p.elementAt(x, y) ||
                            p.elementAt(x + ((Interface) p.getDiagramElement()).getWidth(), y) ||
                            p.elementAt(x + ((Interface) p.getDiagramElement()).getWidth(), y + ((Interface) p.getDiagramElement()).getHeight()) ||
                            p.elementAt(x, y + ((Interface) p.getDiagramElement()).getHeight())) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.ERROR);
                        return;
                    }
                }
            }
            Interface i = new Interface("Interface", diagramView.getDiagram(), x, y);// :)
            i.getPainter().setDiagramElement(i);

            //ApplicationFramework.getInstance().getClassyRepository().addChild(diagramView.getDiagram(), c);
            diagramView.getPainters().add(i.getPainter());
            diagramView.getDiagram().addChild(i);
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

    public void izaberi() {
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
}
