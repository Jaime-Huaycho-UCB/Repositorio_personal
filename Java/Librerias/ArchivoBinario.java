package Librerias;
import java.io.File;
import java.io.IOException;


public class ArchivoBinario {
    public Libreria lib = new Libreria();
    public File conexion;
    public String nombre;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getConexion() {
        return conexion;
    }
    public void setConexion(File conexion) {
        this.conexion = conexion;
    }

    public File ConectarArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo+".bin");
            if (!(archivo.exists())){
                archivo.createNewFile();
            }
            setNombre(nombreArchivo);
            setConexion(archivo);
            return archivo;
        } catch (IOException e) {
            lib.MostrarMensaje(e.getMessage());
            return null;
        }
    }


}
