package raf.dsw.classycraft.app.gui.swing.state.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Connection;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.absClass.Interclass;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Agregacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Generalizacija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Kompozicija;
import raf.dsw.classycraft.app.gui.swing.classyRepository.implementation.veze.Zavisnost;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
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
    List<ConnectPainter> connectPainterList = new ArrayList<>();


    @Override
    public void misKliknut(int x, int y, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(int x, int y, DiagramView diagramView) {
        i1 = null;
        i2 = null;
        boolean jeli = false;

        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                if(p.elementAt(x,y)){
                    jeli = true;


                    i1 = (Interclass) p.getDiagramElement();
                    if(izabran.equals("Agregacija")){

                        connection = new Agregacija("Agregacija",diagramView.getDiagram().getParent(),i1,null,Color.black);
                        connection.setOd(i1);
                        connectPainter = new AgregacijaPainter(connection,new Point(x,y),new Point(x,y));
                        connectPainterList.add(connectPainter);
                        dodajUListu(i1,connectPainter);
                        System.out.println(i1.getConnectPainters() + "      1");
                        diagramView.getConnectList().add(connectPainter);


                    } else if (izabran.equals("Generalizacija")) {

                        connection = new Generalizacija("Generalizacija",diagramView.getDiagram().getParent(),i1,null,Color.black);
                        connection.setOd(i1);
                        connectPainter = new GeneralizacijaPainter(connection,new Point(x,y),new Point(x,y));
                        connectPainterList.add(connectPainter);
                        dodajUListu(i1,connectPainter);
                        diagramView.getConnectList().add(connectPainter);


                    } else if (izabran.equals("Kompozicija")) {

                        connection = new Kompozicija("Kompozicija",diagramView.getDiagram().getParent(),i1,null,Color.black);
                        connection.setOd(i1);
                        connectPainter = new KompozicijaPainter(connection,new Point(x,y),new Point(x,y));
                        connectPainterList.add(connectPainter);
                        dodajUListu(i1,connectPainter);
                        diagramView.getConnectList().add(connectPainter);


                    } else if (izabran.equals("Zavisnost")) {

                        connection = new Zavisnost("Zavisnost", diagramView.getDiagram().getParent(), i1, null, Color.black);
                        connection.setOd(i1);
                        connectPainter = new ZavisnostPainter(connection, new Point(x, y), new Point(x, y));
                        connectPainterList.add(connectPainter);
                        dodajUListu(i1, connectPainter);
                        diagramView.getConnectList().add(connectPainter);
                    }


                }
            }
        }

        if(jeli == false){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.COMPONENT_NOT_SELECTED);
            //diagramView.getPainters().remove(connectPainter);
            connectPainterList.remove(connectPainter);
            diagramView.repaint();
            return;
        }

        for(ConnectPainter n: connectPainterList){
            if(!diagramView.getPainters().contains(n)) {
                System.out.println(n + "     2");
                diagramView.getPainters().add(n);
                diagramView.repaint();
            }
        }
        diagramView.repaint();
    }

    @Override
    public void misPovucen(int x, int y, DiagramView diagramView) {
        connectPainter.setPos2(new Point(x,y));
        diagramView.repaint();
    }

    @Override
    public void misOtpusten(int x, int y, DiagramView diagramView) {
        if(i1 == null || i2 == null){
        }

        connectPainter.setPos2(new Point(x,y));
        boolean jel = false;

        for(Painter p: diagramView.getPainters()){
            if(p.getDiagramElement() instanceof Interclass){
                if(p.elementAt(x,y)){
                    Interclass interclass = (Interclass) p.getDiagramElement();
                    double minPath = Double.MAX_VALUE;
                    for(Point point: connectPainter.getConnection().getOd().getPoints()){
                        for(Point point1: interclass.getPoints()){
                            double rastojanje = Math.sqrt((point1.y - point.y) * (point1.y - point.y) + (point1.x - point.x) * (point1.x - point.x));
                            if(rastojanje<minPath){
                                minPath = rastojanje;
                                connectPainter.setPos1(point);
                                connectPainter.setPos2(point1);
                            }
                        }
                    }
                    jel = true;
                    connection.setKa(interclass);
                    dodajUListu(interclass,connectPainter);
                }
            }
        }


        if(jel == false){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.COMPONENT_NOT_SELECTED);
            diagramView.getPainters().remove(connectPainter);
            connectPainterList.remove(connectPainter);
            diagramView.repaint();
            return;
        }

        for(ConnectPainter n: connectPainterList){
            System.out.println(n + "     22");
            if(!diagramView.getPainters().contains(n)){
                diagramView.getPainters().add(n);
                System.out.println(diagramView.getPainters().size() + "   size");
                diagramView.repaint();
            }

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
    public void dodajUListu(Interclass i, ConnectPainter connectPainter){
        if(!i.getConnectPainters().contains(connectPainter)){
            i.getConnectPainters().add(connectPainter);
        }
    }
}
