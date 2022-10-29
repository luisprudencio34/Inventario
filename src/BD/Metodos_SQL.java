package BD;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static BD.DataBase.*;

public class Metodos_SQL {
    public static Conexion conexion = new Conexion();
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static String sql;
    public static int restaldoNum = 0;


    public int guardarUsuario(String nombre, String apellido,String userName, String correo, String contraseña, String tipo){
        int resultado = 0;
        Connection connection = null;

        String queryGuardar = ("INSERT INTO " + USUARIO + " ("+ USUARIO_NOMBRE + ", "+USUARIO_APELLIDO+", "+USUARIO_USERNAME +", "
                +USUARIO_CORREO+", "+USUARIO_CONTRASEÑA+", " + USUARIO_TUSUARIO+")"+" VALUES (?,?,?,?,?,?)");
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(queryGuardar);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellido);
            preparedStatement.setString(3,userName);
            preparedStatement.setString(4,correo);
            preparedStatement.setString(5,contraseña);
            preparedStatement.setString(6,tipo);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    public int guardarProducto(String id, String nombre, String existencia,String precio, String descripcion){
        int resultado = 0;
        Connection connection = null;

        String queryGuardar = ("INSERT INTO " + PRODUCTO + " ("+PRODUCTO_ID+", "+ PRODUCTO_NOMBRE + ", "+PRODUCTO_EXISTENCIA+", "+PRODUCTO_PRECIO+", "
                +PRODUCTO_DESCRIPCION+ ")"+" VALUES (?,?,?,?,?)");
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(queryGuardar);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,nombre);
            preparedStatement.setString(3,existencia);
            preparedStatement.setString(4,precio);
            preparedStatement.setString(5,descripcion);


            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int consultarProducto (String id){
        int consulta =0;
        String label1, label2, label3;
        Connection connection = null;
        try{

            connection = Conexion.getConnection();
            String queryConsultarProducto =  ("SELECT "+PRODUCTO_NOMBRE+", "+PRODUCTO_PRECIO+", "
                    +PRODUCTO_DESCRIPCION+" FROM "+ PRODUCTO + " WHERE "+PRODUCTO_ID+" = ?");
            JOptionPane.showMessageDialog(null, queryConsultarProducto);
            preparedStatement = connection.prepareStatement(queryConsultarProducto);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();


            if(resultSet.next()==true)
            {
                String nombre = resultSet.getString(1);
                String precio = resultSet.getString(2);
                String descripcion = resultSet.getString(3);

                label1=(nombre);
                label2=(precio);
                label3=(descripcion);

            }
            else
            {
                label1=("");
                label2=("");
                label3=("");
                JOptionPane.showMessageDialog(null,"Invalid Employee No");

            }
            JOptionPane.showMessageDialog(null, label1+label2+label3);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return consulta;
    }



    public static String buscarUsuarioRegistrado (String usuario, String contraseña){
        String busquedaUsuario = null;
        Connection connection = null;

        try {
            connection = Conexion.getConnection();
            String queryBuscarUsuario = ("SELECT "+USUARIO_NOMBRE+","+USUARIO_CORREO+","+USUARIO_CONTRASEÑA
                    +" FROM "+USUARIO+" WHERE "+USUARIO_USERNAME+" = '"+usuario+"' && "+USUARIO_CONTRASEÑA+" = '"+contraseña+"'");
            preparedStatement = connection.prepareStatement(queryBuscarUsuario);
            resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                busquedaUsuario = "Usuario encontrado";
            }else{
                busquedaUsuario = "Usuario no encontrado";
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return busquedaUsuario;
    }


}
