package app;

import javax.swing.*;
import java.awt.*;

public class CrearUsuario extends JFrame {
    private JPanel panelMain;
    private final JFrame frame;


    public CrearUsuario() {
        setContentPane(panelMain);
        frame=new JFrame("Menu");
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}