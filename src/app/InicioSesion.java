package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame{
    private JButton butto_msg;
    private JPanel panelMain;
    private JPasswordField inputContraseña;
    private JTextPane inputUsuario;
    private JButton regresar_button;
    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem salir;


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

        /*menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");
        setJMenuBar(menuBar);*/

        butto_msg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String userValue = inputUsuario.getText();        //get user entered username from the textField1
                String passValue = inputContraseña.getText();        //get user entered pasword from the textField2

                //check whether the credentials are authentic or not
                if (userValue.equals("Usuario") && passValue.equals("1234")) {  //if authentic, navigate user to a new page

                    //create instance of the NewPage
                    MenuPrincipal page = new MenuPrincipal();

                    //make page visible to the user


                    frame.dispose();
                    //create a welcome label and set it to the new page
                    /*JLabel wel_label = new JLabel("Welcome: "+userValue);
                    page.getContentPane().add(wel_label);*/

                }
                else{
                    //show error message
                    JOptionPane.showMessageDialog(null,"Please enter valid username and password");
                }
            }


        });
        regresar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicio page = new MenuInicio();
                frame.dispose();
            }
        });
    }


}
