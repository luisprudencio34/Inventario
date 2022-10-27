package app;

import javax.swing.*;
import java.awt.*;

public class ConsultarProducto extends JFrame{

    private JButton regresarButton;
    private JPanel panelMain;
    private JTable productosTable;
    private JFrame frame;

    public ConsultarProducto(){
        setContentPane(panelMain);
        frame=new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
