package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JFrame frame;
    private JPanel panelMain;
    private JButton ConsultarProductobutton;
    private JButton ingresarProducto_button;
    private JButton regresarButton;

    public MenuPrincipal(){
        setContentPane(panelMain);
        frame=new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ingresarProducto_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresoProducto page = new IngresoProducto();
                frame.dispose();
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioSesion page = new InicioSesion();
                frame.dispose();
            }
        });
    }
}
