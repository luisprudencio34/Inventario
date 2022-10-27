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

    /*public static String buscarNombre(){
    String busquedaNombre = null;
    Connection connection = null;
    try {
        connection = Conexion.getConnection();
        String queryBuscar = ("SELECT "+" FROM " +USUARIO+" WHERE ");
        preparedStatement = connection.prepareStatement(queryBuscar);
        resultSet = preparedStatement.executeQuery();
    }catch (Exception e){

    }
        return null;
    }*/

    /*public boolean buscarUsuarioInicioSesion(String usuario, String contrasena) {
        boolean iniciarSesion = false;
        Connection connection = null;
        try {

            connection = Conexion.getConnection();
            String consulta = "SELECT usuario_generado_automaticamente,contrasena FROM usuarios WHERE usuario_generado_automaticamente = ? AND contrasena = ?";
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                iniciarSesion = true;//El usuario puede iniciar Sesion por que esta registrado en la BD
            } else {
                iniciarSesion = false;//El usuario NO puede iniciar sesion por que no esta registrado en la BD
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("El valor de iniciarSesion en el metodo es: " + iniciarSesion);
        return iniciarSesion;
    }*/

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

        }

        return busquedaUsuario;
    }
}
