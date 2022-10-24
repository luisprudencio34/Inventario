package app;
import static app.DataBase.*;

public class Admin extends User {

    public Admin(String nombre, String apellido, String usuario, String contraseña){
        super(nombre, apellido, usuario, contraseña);
    }
}
