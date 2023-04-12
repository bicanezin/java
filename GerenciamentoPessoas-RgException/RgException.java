import javax.swing.JOptionPane;

public class RgException extends Exception{

    public void exibeMsg(){
        JOptionPane.showMessageDialog(null, "O RG deve ser maior que 10 e menor que 50", "Erro!", JOptionPane.WARNING_MESSAGE);
    }

}