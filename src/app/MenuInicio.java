package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicio extends JFrame{
    private JButton iniciarSesionButton;
    private JButton crearUsuarioButton;
    private JPanel panelMain;
    private JFrame frame;
    public MenuInicio() {
        setContentPane(panelMain);
        frame=new JFrame("Menu");
        frame.setPreferredSize(new Dimension(350, 550));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        crearUsuarioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUsuario page = new CrearUsuario();
                frame.dispose();
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioSesion page = new InicioSesion();
                frame.dispose();
            }
        });
    }


}
