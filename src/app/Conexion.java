package app;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import static app.DataBase.*;

public class Conexion {

    public Conexion(){

    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null){
            JOptionPane.showMessageDialog(null, "Se establecio la conexión :)");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally {return connection;
        }
        }
    }

