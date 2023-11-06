package raf.dsw.classycraft.app.gui.swing;

import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.message.EventType;
import raf.dsw.classycraft.app.gui.swing.message.Message;
import raf.dsw.classycraft.app.gui.swing.message.MessageGenerator;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class SwingGui implements Gui {

    private MainFrame mainFrame;
    private MessageGenerator msgGen;

    public SwingGui(MessageGenerator msgGen) {
        this.msgGen = msgGen;
    }

    @Override
    public void start() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        Message msg = (Message) notification;

        for (EventType eventType: EventType.values()){
            if (eventType.equals(msg.getEventType())){
                JOptionPane.showMessageDialog(mainFrame, msg.getText(), msg.getEventType().toString(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
