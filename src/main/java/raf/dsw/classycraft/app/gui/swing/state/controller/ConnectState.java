package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Agregacija;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;

public class ConnectState implements State {

    private String izabran;

    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {
        if(izabran.equals("Agregacija")){
//            Agregacija agregacija = new Agregacija("agregacija",diagramView,);
//            AgregacijaPainter agregacijaPainter = new AgregacijaPainter(agregacija);
        } else if (izabran.equals("Generalizacija")) {

        } else if (izabran.equals("Kompozicija")) {

        } else if (izabran.equals("Zavisnost")) {

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


    public void izaberi(){
        String[] s = {"Agregacija", "Kompozicija", "Generalizacija","Zavisnost"};
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
        } else if (s[choice].equals("Agregacija")) {
            izabran = "Agregacija";
        }else if (s[choice].equals("Kompozicija")) {
            izabran = "Kompozicija";
        }else if (s[choice].equals("Generalizacija")) {
            izabran = "Generalizacija";
        } else if(s[choice].equals("Zavisnost")) {
            izabran = "zavisnost";
        }
    }
}
