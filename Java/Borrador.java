import Librerias.Libreria;
public class Borrador {
    public static void main(String[] args) {
        Libreria lib = new Libreria();
        int mes=lib.EntradaMes("sefsefs", 23, 324);
        lib.MostrarMensaje(lib.Mes(mes));
    }
}