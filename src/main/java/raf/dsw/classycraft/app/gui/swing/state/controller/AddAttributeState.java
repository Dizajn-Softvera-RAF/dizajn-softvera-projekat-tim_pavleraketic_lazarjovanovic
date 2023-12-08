package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;
import java.lang.reflect.Method;

public class AddAttributeState implements State {

    private String izabran;

    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

        if(izabran.equals("Method")){

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

}
