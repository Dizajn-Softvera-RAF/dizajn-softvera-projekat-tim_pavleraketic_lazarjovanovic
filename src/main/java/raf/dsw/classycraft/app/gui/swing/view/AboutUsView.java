package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AboutUsView extends JFrame {

    public AboutUsView() throws HeadlessException {
        initGui();
    }

    private void initGui() {
        Toolkit kit =Toolkit.getDefaultToolkit();
        setSize(650,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("AboutUs");
        JPanel jPanel = new JPanel(new GridLayout(2,2,10,10));

        JLabel jLabelPavle = new JLabel("Pavle Raketic");
        JLabel jLabelLazar = new JLabel("Lazar Jovanovic");


        ImageIcon jImage1 = new ImageIcon(loadImage("/images/pavle.jpg"));
        Image image1 = jImage1.getImage();
        Image modPavleImage = image1.getScaledInstance(300,320,Image.SCALE_SMOOTH);
        jImage1= new ImageIcon(modPavleImage);
        JLabel jLabelImage1 = new JLabel(jImage1);


        ImageIcon jImage2 = new ImageIcon(loadImage("/images/lazar.jpg"));
        Image image2 = jImage2.getImage();
        Image modLazarImage = image2.getScaledInstance(300,300,Image.SCALE_SMOOTH);
        jImage2= new ImageIcon(modLazarImage);
        JLabel jLabelImage2 = new JLabel(jImage2);

        jPanel.add(jLabelPavle);
        jPanel.add(jLabelImage1);
        jPanel.add(jLabelLazar);
        jPanel.add(jLabelImage2);

        jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //jPanel.setBackground(Color.GRAY);
        add(jPanel);

        }


        private Image loadImage(String fileName){

            URL imageURL = getClass().getResource(fileName);
            Image image = null;

            if(imageURL != null){
                image = new ImageIcon(imageURL).getImage();
            }
            else {
                System.err.println("Resource not found: " + fileName);
            }
        return image;
        }
}
