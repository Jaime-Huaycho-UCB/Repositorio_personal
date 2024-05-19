import javax.swing.JOptionPane;
public class HolaMundo{
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero"));
        JOptionPane.showMessageDialog(null,"tu numero es "+n);
    }
}