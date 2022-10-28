package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BD.Metodos_SQL;

public class ConsultarProducto extends JFrame{

    private JPanel panelMain;
    private JTextField textField1;
    private JButton CerrarSesionButton;
    private JButton consultarButton;
    private JFrame frame;

    Metodos_SQL metodos = new Metodos_SQL();
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

        CerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal page = new MenuPrincipal();
                frame.dispose();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
