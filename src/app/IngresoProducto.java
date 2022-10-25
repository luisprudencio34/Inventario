package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoProducto extends JFrame{
    private JPanel panelMain;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JButton button1;
    private JTextPane textPane5;
    private JButton regresar_button;

    private JFrame frame;

    public IngresoProducto(){
        super("Inicio");

        frame=new JFrame("Ingreso de productos");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1300,700));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        regresar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MenuPrincipal page = new MenuPrincipal();
            frame.dispose();
            }
        });
    }
}
