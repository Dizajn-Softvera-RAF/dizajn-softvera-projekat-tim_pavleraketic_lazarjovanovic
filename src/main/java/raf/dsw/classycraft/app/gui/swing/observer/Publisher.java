package raf.dsw.classycraft.app.gui.swing.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public interface Publisher {


    void addSubscriber(Subscriber subscriber);

    void removeSubscriber (Subscriber subscriber);
    void notifySubscribers (Object notification) throws IOException;
}
