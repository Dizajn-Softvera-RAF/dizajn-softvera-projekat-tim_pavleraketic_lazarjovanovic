package raf.dsw.classycraft.app.gui.swing.message;

import raf.dsw.classycraft.app.gui.swing.observer.Publisher;

public interface MessageGenerator extends Publisher {
    void generateMessage(EventType eventType);
}
