package app;

import BD.Metodos_SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuario extends JFrame {
    private JPanel panelMain;
    private JTextPane nombreTextPane;
    private JTextPane apellidoTextPane;
    private JTextPane correoTextPane;
    private JTextPane contraseñaTextPane;
    private JButton guardarButton;
    private JButton regresarButton;
    private JTextPane userNameTextPane;
    private JPasswordField contraseñaPasswordField;
    private final JFrame frame;

Metodos_SQL metodos = new Metodos_SQL();
    public CrearUsuario() {
        setContentPane(panelMain);
        frame=new JFrame("Crear Usuario");
        frame.setPreferredSize(new Dimension(625, 800));
        frame.setResizable(true);
        frame.add(panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicio page = new MenuInicio();
                frame.dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            metodos.guardarUsuario(nombreTextPane.getText(), apellidoTextPane.getText(), userNameTextPane.getText(), correoTextPane.getText(), contraseñaPasswordField.getText(), "2");
            MenuInicio page = new MenuInicio();
            frame.dispose();

            }
        });
    }
}