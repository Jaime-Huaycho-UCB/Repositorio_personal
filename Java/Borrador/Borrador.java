package Borrador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Librerias.*;
public class Borrador {
    public static Libreria lib = new Libreria();
    public static void main(String[] args) {
        ArchivoBinario archivo = new ArchivoBinario();
        archivo.ConectarArchivo("Prueba1");
        Persona persona = new Persona("jaime", 19);
        Escribir(archivo.getConexion(),persona);
        Persona persona2 = (Persona) leerObjeto(archivo.getConexion());
        lib.MostrarMensaje(persona2.getNombre()+lib.t()+persona2.getEdad());

    }

    public static void Escribir(File archivo,Object persona){
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(persona);
            oss.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            // TODO: handle exception
        }
        

    }

    public static Object leerObjeto(File archivo) {
        try {
            FileInputStream fos = new FileInputStream(archivo) ;
            ObjectInputStream oss = new ObjectInputStream(fos);
            Object persona = oss.readObject();
            oss.close();
            return persona;
        } catch (FileNotFoundException e) {
            lib.MostrarMensaje(e.getMessage());
            return null;
        } catch (IOException e) {
            lib.MostrarMensaje(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            lib.MostrarMensaje(e.getMessage());
            return null;
            
        }
    }
}