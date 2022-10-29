package app;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

    public static PreparedStatement preparedStatement;

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
                Connection connection = null;
                try{

                    connection = Conexion.getConnection();
                    String queryConsultarProducto =  ("SELECT "+PRODUCTO_NOMBRE+", "+PRODUCTO_PRECIO+", "
                            +PRODUCTO_DESCRIPCION+" FROM "+ PRODUCTO + " WHERE "+PRODUCTO_ID+" = ?");
                    preparedStatement = connection.prepareStatement(queryConsultarProducto);
                    preparedStatement.setString(1, consultaTextField.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();


                    if(resultSet.next()==true)
                    {
                        String nombre = resultSet.getString(1);
                        String precio = resultSet.getString(2);
                        String descripcion = resultSet.getString(3);

                        nombrelabel.setText(nombre);
                        preciolabel.setText("$ "+precio);
                        existencialabel.setText(descripcion);

                    }
                    else
                    {
                        nombrelabel.setText("");
                        preciolabel.setText("");
                        existencialabel.setText("");
                        JOptionPane.showMessageDialog(null,"ID o Nombre invalidos");

                    }

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }


    }

