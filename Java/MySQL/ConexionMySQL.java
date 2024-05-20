package MySQL;
import java.sql.*;

import Librerias.Libreria;

public class ConexionMySQL {
    public static Libreria lib = new Libreria();
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/Prueba";
        String usuario="root";
        String contrasena="";
        Connection conexion=EstablecerConexion(url, usuario, contrasena);
        while (true) {
            if (conexion==null)
                break;
            lib.MostrarMensaje("Menu");
            break;
        }
        CerrarConexion(conexion);
    }

    public static Connection EstablecerConexion(String url,String usuario,String contrasena){
        Connection conexion = null;
        while (true) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url,usuario,contrasena);
                lib.MostrarMensaje("Conexion exitosa");
                return conexion;
            } catch (ClassNotFoundException e) {
                lib.MostrarMensaje("No se encontro el Driver");
                if (!(Reintentar())){
                    return null;
                }
            } catch (SQLException e) {
                lib.MostrarMensaje("No se pudo establecer la conexión con la base de datos");
                if (!(Reintentar())){
                    return null;
                }
            }
        }
    }

    public static void CerrarConexion(Connection conexion){
        if (conexion!=null){
            try {
                conexion.close();
            } catch (SQLException e) {
                lib.MostrarMensaje("No se pudo cerrar la conexion");
            }
        }
    }

    public static boolean Reintentar(){
        String opcion="";
        String[] bototnes = {"No","Si"};
        while (true) {
            opcion=lib.EntradaBotones("Reintentar?", bototnes);
            if (opcion.equals("No")){
                return false;
            }else if (opcion.equals("Si")){
                return true;
            }else{
                lib.MostrarMensaje("Ingrese valores validos");
            }
        }
    }
    
}