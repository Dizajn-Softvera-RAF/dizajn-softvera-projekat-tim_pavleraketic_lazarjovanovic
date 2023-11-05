package raf.dsw.classycraft.app.gui.swing;

import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame mainFrame;

    public SwingGui() {
    }

    @Override
    public void start() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

}
