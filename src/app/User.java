package app;

public class User {
    int id;
    String nombre;
    String apellido;
    private String usuario;
    private String contraseña;

    public User(String nombre, String apellido, String usuario, String contraseña){
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

