package BD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static BD.DataBase.*;

public class Conexion {

    public Conexion(){

    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(CLASE);
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (connection != null){

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally {return connection;
        }
        }
    }

