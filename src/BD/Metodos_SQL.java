package BD;

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
    public int guardarProducto(String nombre, String existencia,String precio, String descripcion){
        int resultado = 0;
        Connection connection = null;

        String queryGuardar = ("INSERT INTO " + PRODUCTO + " ("+ PRODUCTO_NOMBRE + ", "+PRODUCTO_EXISTENCIA+", "+PRODUCTO_PRECIO+", "
                +PRODUCTO_DESCRIPCION+ ")"+" VALUES (?,?,?,?)");
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(queryGuardar);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,existencia);
            preparedStatement.setString(3,precio);
            preparedStatement.setString(4,descripcion);


            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
