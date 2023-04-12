import javax.swing.JOptionPane;

public class NegaException extends Exception{
    public void impErro(){
        JOptionPane.showMessageDialog(null,"Numero negativo" , "Numero Pequeno", 0);
    }
}