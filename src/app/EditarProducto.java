package app;

import BD.Metodos_SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class EditarProducto extends JFrame{
    private JPanel panelMain;
    private JTextPane nombreTextPane;
    private JTextPane existenciaTextPane;
    private JTextPane codigoTextPane;
    private JTextPane precioTextPane;
    private JButton editarButton;
    private JTextPane descripcionTextPane;
    private JButton regresarButton;
    public static PreparedStatement preparedStatement;

    private JFrame frame;

    Metodos_SQL metodos = new Metodos_SQL();


    public EditarProducto() {

        setContentPane(panelMain);
        frame = new JFrame("Consulta de productos");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1030, 640));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodos.editarProducto(codigoTextPane.getText(), nombreTextPane.getText(),existenciaTextPane.getText(),precioTextPane.getText(),descripcionTextPane.getText());
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal page = new MenuPrincipal();
                frame.dispose();
            }
        });
    }
}
