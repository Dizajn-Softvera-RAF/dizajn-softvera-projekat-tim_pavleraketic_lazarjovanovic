package raf.dsw.classycraft.app.gui.swing.logger;

import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

public interface Logger extends Subscriber {
    void log(String error);
}

