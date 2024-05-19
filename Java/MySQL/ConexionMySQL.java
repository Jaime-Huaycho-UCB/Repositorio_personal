package MySQL;
import java.sql.*;

import javax.swing.JOptionPane;

public class ConexionMySQL {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/Prueba";
        String usuario="root";
        String contrasena="";
        Connection conexion=EstablecerConexion(url, usuario, contrasena);
        while (true) {
            if (conexion==null)
                break;
            MostrarMensaje("Menu");
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
                MostrarMensaje("Conexion exitosa");
                return conexion;
            } catch (ClassNotFoundException e) {
                MostrarMensaje("No se encontro el Driver");
                if (!(Reintentar())){
                    return null;
                }
            } catch (SQLException e) {
                MostrarMensaje("No se pudo establecer la conexión con la base de datos");
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
                MostrarMensaje("No se pudo cerrar la conexion");
            }
        }
    }

    public static boolean Reintentar(){
        String opcion="";
        String[] bototnes = {"No","Si"};
        while (true) {
            opcion=Botones("Reintentar?", bototnes);
            if (opcion.equals("No")){
                return false;
            }else if (opcion.equals("Si")){
                return true;
            }else{
                MostrarMensaje("Ingrese valores validos");
            }
        }
    }
    
    public static void MostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public static int EntradaEntero(String mensaje){
        int n=0;
        while (true) {
            try {
                n=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return n;
            } catch (Exception e) {
                MostrarMensaje("Ingresar unicamente valores enteros");
            }
        }
    }
    public static String Botones(String mensaje,String[] botones){
        int opcion=0;
        opcion=JOptionPane.showOptionDialog(null,mensaje,"Selecciones una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, botones,0);
        return botones[opcion];
    }
}