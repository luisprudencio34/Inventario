package app;

import BD.Metodos_SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame{
    private JButton ingresarButton;
    private JPanel panelMain;
    private JPasswordField inputContraseña;
    private JTextPane inputUsuario;
    private JButton regresarButton;
    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem salir;

    Metodos_SQL metodos = new Metodos_SQL();
    public InicioSesion(){
        setContentPane(panelMain);
        frame=new JFrame("Inicio de sesión");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));
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
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busquedaUsuario = metodos.buscarUsuarioRegistrado(inputUsuario.getText(), inputContraseña.getText());

                if(inputUsuario.getText().equals("root")&& inputContraseña.getText().equals("root")){
                    MenuPrincipal page = new MenuPrincipal();
                    frame.dispose();

                }else if (busquedaUsuario.equals("Usuario encontrado")){
                    MenuPrincipal page = new MenuPrincipal();
                    frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            }
        });
    }


}
