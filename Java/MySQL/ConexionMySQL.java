package MySQL;
import java.sql.*;

import Librerias.Libreria;

public class ConexionMySQL {
    public static Libreria lib = new Libreria();
    public static void main(String[] args) {
        String usuario="root";
        String contrasena="";
        String puerto="3306";
        String nombreBaseDatos="Prueba";
        Connection conexion=EstablecerConexion(puerto, nombreBaseDatos, usuario, contrasena);
        while (true) {
            if (conexion==null)
                break;
            lib.MostrarMensaje("Menu");
            break;
        }
        CerrarConexion(conexion);
    }

    public static Connection EstablecerConexion(String puerto,String nombreBaseDatos,String user, String password){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:"+puerto+"/"+nombreBaseDatos;
        String[] botones = {"Salir programa","Reintentar"};
        while (true) {
            try {
                Class.forName(driver);
                return DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                if (lib.EntradaBotones("El servidor non se pudo conectar: "+e,botones).equals("Salir programa")){
                    break;
                }
            }
        }
        return null;
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