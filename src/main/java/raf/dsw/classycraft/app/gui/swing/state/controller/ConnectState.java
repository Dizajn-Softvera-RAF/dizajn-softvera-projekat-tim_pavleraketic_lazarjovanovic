package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Agregacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.state.State;
import raf.dsw.classycraft.app.gui.swing.state.painter.ConnectPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.Painter;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.AgregacijaPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.GeneralizacijaPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.KompozicijaPainter;
import raf.dsw.classycraft.app.gui.swing.state.painter.connection.ZavisnostPainter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectState implements State {

    private String izabran;
    private Interclass i1;
    private Interclass i2;
    private ConnectPainter connectPainter;
    private Connection connection;
    private Point pos1;
    private Point pos2;
    List<ConnectPainter> connectPainterList = new ArrayList<>();


    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {
        pos1 = new Point(x,y);
        pos2 = new Point(x,y);
        i1 = null;
        i2 = null;

        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                if(p.elementAt(x,y)){
                    i1 = (Interclass) p.getDiagramElement();
                    i2 = (Interclass) p.getDiagramElement();
                    if(izabran.equals("Agregacija")){
                        pos1.setLocation(i1.getX(),i1.getY());
                        connection = new Agregacija("Agregacija",diagramView.getDiagram().getParent(),i1,i2,Color.black);
                        connectPainter = new AgregacijaPainter(connection,pos1,pos2);
                        connectPainterList.add(connectPainter);
                        diagramView.getConnectList().add(connectPainter);
                    } else if (izabran.equals("Generalizacija")) {
                        pos1.setLocation(i1.getX(),i1.getY());
                        connection = new Generalizacija("Generalizacija",diagramView.getDiagram().getParent(),i1,i2,Color.black);
                        connectPainter = new GeneralizacijaPainter(connection,pos1,pos2);
                        connectPainterList.add(connectPainter);
                        diagramView.getConnectList().add(connectPainter);
                    } else if (izabran.equals("Kompozicija")) {
                        pos1.setLocation(i1.getX(),i1.getY());
                        connection = new Kompozicija("Kompozicija",diagramView.getDiagram().getParent(),i1,i2,Color.black);
                        connectPainter = new KompozicijaPainter(connection,pos1,pos2);
                        connectPainterList.add(connectPainter);
                        diagramView.getConnectList().add(connectPainter);
                    } else if (izabran.equals("Zavisnost")) {
                        pos1.setLocation(i1.getX(),i1.getY());
                        connection = new Zavisnost("Zavisnost",diagramView.getDiagram().getParent(),i1,i2,Color.black);
                        connectPainter = new ZavisnostPainter(connection,pos1,pos2);
                        connectPainterList.add(connectPainter);
                        diagramView.getConnectList().add(connectPainter);
                    }
                }
            }
        }
        for(ConnectPainter n: connectPainterList){
            diagramView.getPainters().add(n);
            diagramView.repaint();
        }
        diagramView.repaint();
    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {
        pos2.setLocation(x,y);
        diagramView.repaint();
    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {
        if(i1 == null || i2 == null){
        }
        pos2.setLocation(x,y);

        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                if(p.elementAt(x,y)){
                    Interclass interclass = (Interclass) p.getDiagramElement();
                    pos2 = new Point(interclass.getX(),interclass.getY());
                    connectPainter.setPos2(pos2);

                    i2 = (Interclass) p.getDiagramElement();
                    connection.setSecondSecond(i2);
                    pos2 = new Point(i2.getX(),i2.getY());
                    break;
                }
            }
        }

        for(ConnectPainter n: connectPainterList){
            diagramView.getPainters().add(n);
            diagramView.repaint();
        }
        connectPainterList.clear();
        diagramView.repaint();

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
            izabran = "Zavisnost";
        }
    }
}
