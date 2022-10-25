package app;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JFrame frame;
    private JPanel panelMain;

    public MenuPrincipal(){
        setContentPane(panelMain);
        frame=new JFrame("Inicio de sesión");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
