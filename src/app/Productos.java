package app;
import static app.DataBase.*;

public class Productos {
    int id;
    String nombre;
    Double precio;
    String descripción;
    Integer cantidad;

    public Productos(String nombre) {
        this.nombre = nombre;
    }

}


