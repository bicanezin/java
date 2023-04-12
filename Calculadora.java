import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Calculadora implements ActionListener {
    private static JFrame janela = new JFrame("Calculadora");

    private static JLabel rotulo1 = new JLabel("Valor1");
    private static JLabel rotulo2 = new JLabel("Valor2");
    private static JLabel rotulo3 = new JLabel("Resultado");

    private static JTextField caixaTexto1 = new JTextField("");
    private static JTextField caixaTexto2 = new JTextField("");
    private static JTextField caixaTexto3 = new JTextField("");

    private static JButton botao1 = new JButton("+");
    private static JButton botao2 = new JButton("-");
    private static JButton botao3 = new JButton("Limpar");
    private static JButton botao4 = new JButton("Sair");

    private static JOptionPane jop = new JOptionPane();
    private static Prv2 p = new Prv2();

    public static void main(String arg[]) {
        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
        // janela.setDefaultCloseOperation(janela.DISPOSE_ON_CLOSE); // uso quando tenho
        // duas janelas, qaudno fecho uma vai para a outra a janela dentro do parenteses
        // diz em qual janela eu faço isso
        int larg = 300;
        int alt = 200;

        janela.setSize(larg, alt);

        caixaTexto1.setColumns(3);
        caixaTexto2.setColumns(3);
        caixaTexto3.setColumns(3);

        janela.add(rotulo1);
        janela.add(caixaTexto1);
        janela.add(rotulo2);
        janela.add(caixaTexto2);
        janela.add(rotulo3);
        janela.add(caixaTexto3);

        janela.add(botao1);
        janela.add(botao2);
        janela.add(botao3);
        janela.add(botao4);

        janela.setLayout(new FlowLayout());
        janela.setVisible(true);

        botao1.addActionListener(p);
        botao2.addActionListener(p);
        botao3.addActionListener(p);
        botao4.addActionListener(p);
    }

    public void actionPerformed(ActionEvent ae){ 
        try {

        if (ae.getSource().equals(botao1)) { 
            int v1 = Integer.parseInt(caixaTexto1.getText());
            int v2 = Integer.parseInt(caixaTexto2.getText());
            int result = v1 + v2;
            caixaTexto3.setText( Integer.toString(result));

            if(result > 10){
                throw new DezException();
                    
            }

        } else if (ae.getSource().equals(botao2)) {
            int v1 = Integer.parseInt(caixaTexto1.getText());
            int v2 = Integer.parseInt(caixaTexto2.getText());
            int result = v1 - v2;
            caixaTexto3.setText( Integer.toString(result));
            
            if(result < 0){
                throw new NegaException();
                
            }

        } else if (ae.getSource().equals(botao3)) {
            caixaTexto1.setText("");
            caixaTexto2.setText("");
            caixaTexto3.setText("");

            caixaTexto1.requestFocus();
        
            } else if (ae.getSource().equals(botao4)) {
                int resp = jop.showConfirmDialog(null, "Deseja sair?", "SAIR", jop.YES_NO_CANCEL_OPTION);
                if (resp == 0) {
                janela.dispose(); 
                }
            }

        }
        catch(DezException de){
            de.impErro();
        }
        catch(NegaException ne){
            ne.impErro();
        }
    }
}