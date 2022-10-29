package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BD.Conexion;
import BD.Metodos_SQL;

import static BD.DataBase.*;
import static BD.DataBase.PRODUCTO_ID;

public class ConsultarProducto extends JFrame{
    Connection connection;
    PreparedStatement pst;
    private JPanel panelMain;
    private JTextField consultaTextField;
    private JButton CerrarSesionButton;
    private JButton consultarButton;
    private JLabel idlabel;
    private JLabel nombrelabel;
    private JLabel existencialabel;
    private JLabel preciolabel;
    private JButton LIMPIARButton;
    private JLabel descripcionLabel;

    public static PreparedStatement preparedStatement;

    private JFrame frame;

    Metodos_SQL metodos = new Metodos_SQL();


    public ConsultarProducto(){

        setContentPane(panelMain);
        frame=new JFrame("Consulta de productos");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1030,640));
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
                Connection connection = null;
                try{

                    connection = Conexion.getConnection();
                    String queryConsultarProducto =  ("SELECT "+PRODUCTO_ID+", "+PRODUCTO_NOMBRE+", "+PRODUCTO_PRECIO+", "
                            +PRODUCTO_EXISTENCIA+", "+PRODUCTO_DESCRIPCION+" FROM "+ PRODUCTO + " WHERE "+PRODUCTO_ID+" = ? OR "+PRODUCTO_NOMBRE+" = ?");
                    preparedStatement = connection.prepareStatement(queryConsultarProducto);
                    preparedStatement.setString(1, consultaTextField.getText());
                    preparedStatement.setString(2, consultaTextField.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();


                    if(resultSet.next()==true)
                    {
                        String id = resultSet.getString(1);
                        String nombre = resultSet.getString(2);
                        String precio = resultSet.getString(3);
                        String existencia = resultSet.getString(4);
                        String descripcion = resultSet.getString(5);

                        idlabel.setText(id);
                        nombrelabel.setText(nombre);
                        preciolabel.setText("$ "+precio);
                        existencialabel.setText(existencia);
                        descripcionLabel.setText(descripcion);

                    }
                    else
                    {
                        idlabel.setText("");
                        nombrelabel.setText("");
                        preciolabel.setText("");
                        existencialabel.setText("");
                        descripcionLabel.setText("");
                        JOptionPane.showMessageDialog(null,"ID o Nombre invalidos");

                    }

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaTextField.setText("");
                idlabel.setText("");
                nombrelabel.setText("");
                preciolabel.setText("");
                existencialabel.setText("");
                descripcionLabel.setText("");
            }
        });
    }


    }

