import javax.swing.JOptionPane;

public class DezException extends Exception{
    public void impErro(){
        JOptionPane.showMessageDialog(null, "Excedeu uma dezena!", "Numero Grande", 0);
    }
}