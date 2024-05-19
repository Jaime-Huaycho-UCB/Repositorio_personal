package Libreria;

import javax.swing.JOptionPane;

public class Lib {
    public void MostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public int EntradaEntero(String mensaje){
        int n=0;
        while (true) {
            try {
                n=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return n;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingresar unicamente valores enteros");
            }
        }
    }
    public String Botones(String mensaje,String[] botones){
        int opcion=0;
        opcion=JOptionPane.showOptionDialog(null,mensaje,"Selecciones una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, botones,0);
        return botones[opcion];
    }
}
