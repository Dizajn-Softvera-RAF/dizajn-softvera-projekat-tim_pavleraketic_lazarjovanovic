package raf.dsw.classycraft.app.gui.swing.view;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;

public class AboutUsView extends JFrame {

    public AboutUsView() throws HeadlessException {
        initGui();
    }

    private void initGui() {
        Toolkit kit =Toolkit.getDefaultToolkit();
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("AboutUs");






    }
}
