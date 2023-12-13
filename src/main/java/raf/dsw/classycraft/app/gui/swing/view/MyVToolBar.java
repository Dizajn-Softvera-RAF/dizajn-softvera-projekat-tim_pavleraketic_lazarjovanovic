package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class MyVToolBar extends JToolBar {

    public MyVToolBar(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getAddAttributeAction());
        add(MainFrame.getInstance().getActionManager().getEditInterclassAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
        add(MainFrame.getInstance().getActionManager().getConnectStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomInAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        add(MainFrame.getInstance().getActionManager().getDuplicateAction());


    }

}
