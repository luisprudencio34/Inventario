package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JButton iniciarSesionButton;
    private JButton crearUsuarioButton;
    private JPanel panelMain;
    private JFrame frame;
    public Menu() {
        setContentPane(panelMain);
        frame=new JFrame("Menu");
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        crearUsuarioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Inicio page = new Inicio();
            page.setVisible(true);
            }
        });
    }


}
