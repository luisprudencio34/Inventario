package app;

import javax.swing.*;
import java.awt.*;

public class IngresoProducto extends JFrame{
    private JPanel panelMain;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JButton button1;
    private JTextPane textPane5;

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
    }
}
