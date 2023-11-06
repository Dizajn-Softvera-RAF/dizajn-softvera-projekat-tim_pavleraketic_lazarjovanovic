package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class MainFrame extends JFrame implements Subscriber {
    private static MainFrame instance;
    private JMenuBar menu;
    private JToolBar toolBar;
    private ActionManager actionManager;
    private MessageGenerator messageGenerator;
    private ClassyTree classyTree;
    private PackageView packageView;



    public MainFrame(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
        messageGenerator.addSubscriber(MainFrame.getInstance());
    }
    private MainFrame(){

    }

    private void initialize(){

        this.actionManager=new ActionManager();
        this.classyTree = new ClassyTreeImplementation();
        packageView = new PackageView();
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

        menu = new MyMenyBar();
        setJMenuBar(menu);

        toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);


        //dodavanje prozora i Linije za splitovanje ta dva dela
        JPanel desktop = new JPanel();
        desktop.setBackground(Color.WHITE);
        JPanel left = new JPanel();
        left.setBackground(Color.WHITE);


        JTree projectExplorer = classyTree.generateTree(ApplicationFramework.getInstance().getClassyRepository().getProjectExplorer());

        JScrollPane scroll=new JScrollPane(projectExplorer);
        JPanel rightPanel = packageView;
        scroll.setMinimumSize(new Dimension(200,150));

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,rightPanel);
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

    @Override
    public void update(Object notification) {
        Message msg = (Message) notification;

        for (EventType eventType: EventType.values()){
            if (eventType.equals(msg.getEventType())){
                JOptionPane.showMessageDialog(instance, msg.getText(), msg.getEventType().toString(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
