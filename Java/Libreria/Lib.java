package Libreria;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Lib {
    public String n(){
        return "\n";
    }
    public String t(){
        return "\t";
    }
    public String n(int numero){
        String nl="",n="\n";
        for (int i=0;i<numero;i++){
            nl+=n;
        }
        return nl;
    }
    public String t(int numero){
        String tab="",t="\t";
        for (int i=0;i<numero;i++){
            tab+=t;
        }
        return tab;
    }

    // Inicio - Salidas
    public void MostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void MostrarScroll(String mensaje) {
        JTextArea ob = new JTextArea(20,30);
        ob.setText(mensaje);
        JScrollPane ob1 = new JScrollPane(ob);
        JOptionPane.showMessageDialog(null, ob1);
    }
    // Fin - Salidas

    // Inicio - Entradas
    public int EntradaEntero(String mensaje){
        int numero=0;
        while (true) {
            try {
                numero=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return numero;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingresar unicamente valores enteros");
            }
        }
    }
    public double EntradaDecimal(String mensaje){
        double numero=0.00;
        while (true) {
            try {
                numero=Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                return numero;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingrese unicamente valores enteros");
            }
        }
    }
    public String EntradaCadena(String mensaje){
        String numero="";
        numero=JOptionPane.showInputDialog(null, mensaje);
        return numero;
    }
    public String EntradaBotones(String mensaje,String[] botones){
        int opcion=0;
        opcion=JOptionPane.showOptionDialog(null,mensaje,"Selecciones una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, botones,0);
        return botones[opcion];
    }
    // Fin - Entradas

    // Inicio - Funciones matematicas
    public int RandomEntero(int a,int b) {
        return (int)(Math.random() * (b - a + 1)) + a;
    }
    public static double LimitarDecimales(double numero, int decimales) {
        // Multiplicar el número por 10^n, donde n es la cantidad de decimales
        double factor = Math.pow(10, decimales);
        double numeroRedondeado = Math.round(numero * factor) / factor;
        return numeroRedondeado;
    }
    // Fin - Funciones matematicas

    // Inicio - Funciones tiempo
    public int Fecha(int opcion) {
        LocalDate fecha = LocalDate.now();
        switch (opcion) {
            case 1:
                return fecha.getDayOfMonth(); // Devuelve el día del mes actual
            case 2:
                return fecha.getMonthValue(); // Devuelve el número del mes actual
            case 3:
                return fecha.getYear(); // Devuelve el año actual
            default:
                return 0;
        }
    }
    public String Fecha(){
        String salidaFecha="";
        salidaFecha+=Fecha(1)+"/";
        salidaFecha+=Fecha(2)+"/";
        salidaFecha+=Fecha(3);
        return salidaFecha;
    }
    public int Tiempo(int opcion) {
        LocalTime tiempo = LocalTime.now();
        switch (opcion) {
            case 1:
                return tiempo.getHour(); // Devuelve la hora actual
            case 2:
                return tiempo.getMinute(); // Devuelve el minuto actual
            case 3:
                return tiempo.getSecond(); // Devuelve el segundo actual
            default:
                return 0;
        }
    }
    public String Tiempo(){
        String salidaTiempo="";
        salidaTiempo+=Tiempo(1)+":";
        salidaTiempo+=Tiempo(2)+":";
        salidaTiempo+=Tiempo(3);
        return salidaTiempo;
    }
    // Fin - Funciones tiempo
}