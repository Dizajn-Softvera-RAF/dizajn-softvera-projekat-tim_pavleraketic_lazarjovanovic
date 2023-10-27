package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.controller.ActionManager;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private ActionManager actionManager;


    private MainFrame(){

    }

    private void initialize(){
        actionManager=new ActionManager();
        initializeGUI();
    }

    private void initializeGUI(){
        Toolkit kit =Toolkit.getDefaultToolkit();
        Dimension screenSize =kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        MyMenyBar menu = new MyMenyBar();
        setJMenuBar(menu);

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);

        //dodavanje prozora i Linije za splitovanje ta dva dela
        JPanel desktop = new JPanel();
        desktop.setBackground(Color.WHITE);
        JPanel left = new JPanel();
        left.setBackground(Color.WHITE);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

}
