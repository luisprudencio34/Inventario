package app;

public class DataBase {
    public  static final String URL = "jdbc:mysql://localhost:3306/inventario";
    public  static final String USERNAME = "inventario";
    public  static final String PASSWORD = "1234";

    public  static final String PRODUCTO = "productos";
    public  static final String PRODUCTO_ID = "ID_Producto";
    public  static final String PRODUCTO_NOMBRE = "NombreProducto";
    public  static final String PRODUCTO_EXISTENCIA = "ExistenciaProducto";
    public  static final String PRODUCTO_DESCRIPCION = "DescripcionProducto";

    public  static final String USUARIO = "usuarios";
    public  static final String USUARIO_ID = "ID_Usuario";
    public  static final String USUARIO_NOMBRE = "NombreUsuario";
    public  static final String USUARIO_APELLIDO = "ApellidoUsuario";
    public  static final String USUARIO_USERNAME = "Username";
    public  static final String USUARIO_CONTRASEÑA = "Contraseña";
    public  static final String USUARIO_TUSUARIO = "ID_TipoUsuario";



    public  static final String TIPOUSUARIO = "tipousuario";
    public  static final int[] TIPOUSUARIO_ID = {1,2};
    public  static final String TIPOUSUARIO_TIPO = "TipoUsuario";

}
