package app;

import javax.swing.*;
import java.awt.*;
import BD.Metodos_SQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoProducto extends JFrame{
    private JPanel panelMain;
    private JTextPane nombreTextPane;
    private JTextPane existenciaTextPane;
    private JTextPane codigoTextPane;
    private JTextPane precioTextPane;
    private JButton guardarButton;
    private JTextPane descripcionTextPane;
    private JButton regresarButton;

    private JFrame frame;
    Metodos_SQL metodos = new Metodos_SQL();
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
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MenuPrincipal page = new MenuPrincipal();
            frame.dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodos.guardarProducto(nombreTextPane.getText(), existenciaTextPane.getText(), precioTextPane.getText(), descripcionTextPane.getText());
                MenuInicio page = new MenuInicio();
                frame.dispose();

            }
        });
    }
}
