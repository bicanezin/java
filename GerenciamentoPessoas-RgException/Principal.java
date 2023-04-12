import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javafx.collections.transformation.FilteredList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Principal implements ActionListener{
    private static JFrame jnl           = new JFrame("Cadastro de Pessoas"); 

    private static JLabel lbRg          = new JLabel("RG");
    private static JTextField cxRg      = new JTextField(15);
    private static JLabel lbNome        = new JLabel("NOME");
    private static JTextField cxNome    = new JTextField(30);
    private static JLabel lbRua         = new JLabel("RUA");
    private static JTextField cxRua     = new JTextField(30);
    private static JLabel lbNumero      = new JLabel("No");
    private static JTextField cxNumero  = new JTextField(5);

    private static JButton btInserir    = new JButton("Inserir");
    private static JButton btConsultar  = new JButton("Consultar");
    private static JButton btAlterar    = new JButton("Alterar");
    private static JButton btDeletar    = new JButton("Deletar");
    private static JButton btLimpar     = new JButton("Limpar");
    private static JButton btSair       = new JButton("Sair");
    
    private static JOptionPane jop      = new JOptionPane();

    private static Principal princ      = new Principal();

    private static BDpes BDConex        = new BDpes();
    private static Pessoa pessoa        = new Pessoa();

    public static void main(String[] args) {
        int TAM_VET = 5;
        jnl.setDefaultCloseOperation(jnl.EXIT_ON_CLOSE);

        jnl.setSize(600, 300);
        jnl.setLocation(500, 100);

        jnl.add(lbRg);
        jnl.add(cxRg);
        jnl.add(lbNome);
        jnl.add(cxNome);
        jnl.add(lbRua);
        jnl.add(cxRua);
        jnl.add(lbNumero);
        jnl.add(cxNumero);
        jnl.add(btInserir);
        jnl.add(btConsultar);
        jnl.add(btAlterar);
        jnl.add(btDeletar);
        jnl.add(btLimpar);
        jnl.add(btSair);

        jnl.setLayout(new FlowLayout());
        jnl.setVisible(true);

        btInserir.addActionListener(princ);
        btConsultar.addActionListener(princ);
        btAlterar.addActionListener(princ);
        btDeletar.addActionListener(princ);
        btLimpar.addActionListener(princ);
        btSair.addActionListener(princ);  
    }

    public void limpar(){
        cxRg.setText("");
        cxNome.setText("");
        cxRua.setText("");
        cxNumero.setText("");
        cxRg.requestFocus();
    }

    public Pessoa criarPessoa(){
        try{
            pessoa.setRg(Integer.parseInt(cxRg.getText()));
            pessoa.setNome(cxNome.getText());
            if(!cxNumero.getText().isEmpty()){
                pessoa.getEndereco().setNumero(Integer.parseInt(cxNumero.getText()));
            }
            pessoa.getEndereco().setRua(cxRua.getText());
            return pessoa;
        }
        catch(RgException rge){
            rge.exibeMsg();
            cxRg.requestFocus();
        }
        return null;
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btInserir)){
            Pessoa pessoa = criarPessoa();
            try{
                BDConex.insPes(pessoa);
                limpar();
            }
            catch(RgException rge){
                //nunca passara aqui
            }
        }

        else if(ae.getSource().equals(btConsultar)){
            Pessoa p = criarPessoa();
            Pessoa aux = BDConex.consPesRg(p);
            if(aux != null){
                JOptionPane.showMessageDialog(null,"Pessoa encontrada com sucesso");
                cxNome.setText(aux.getNome());
                cxNumero.setText(Integer.toString(aux.getEndereco().getNumero()));
                cxRua.setText(aux.getEndereco().getRua());
            }
            else{
                JOptionPane.showMessageDialog(null, "RG nao cadastrado!");
                limpar();
            }
        }

        else if(ae.getSource().equals(btAlterar)){
            Pessoa pessoa = criarPessoa();
            Pessoa aux = BDConex.altPesRg(pessoa);
            if(aux != null){
                cxNome.setText(aux.getNome());
                cxRua.setText(aux.getEndereco().getRua());
                cxNumero.setText(Integer.toString(aux.getEndereco().getNumero()));
                if (JOptionPane.showConfirmDialog(null, "Deseja alterar os dados?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cxRg.requestFocus();
                }           
                else{
                    limpar();
                }     
            }
            else{
                JOptionPane.showMessageDialog(null, "RG nao cadastrado!");
            }
        }

        else if(ae.getSource().equals(btDeletar)){
            Pessoa pessoa = criarPessoa();
            Pessoa aux = BDConex.consPesRg(pessoa);
            if(aux != null){
                cxNome.setText(aux.getNome());
                cxRua.setText(aux.getEndereco().getRua());
                cxNumero.setText(Integer.toString(aux.getEndereco().getNumero()));
                if (JOptionPane.showConfirmDialog(null, "Deseja deletar os dados?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    BDConex.delPes(pessoa);
                    JOptionPane.showMessageDialog(null,"Pessoa excluida com sucesso");
                    limpar();
                }           
                else{
                    limpar();
                }     
            }
        }

        else if(ae.getSource().equals(btLimpar)){
            limpar();
        }

        if(ae.getSource().equals(btSair)){
            int resp = jop.showConfirmDialog(null, "Deseja Sair?", "Saida", jop.YES_NO_CANCEL_OPTION);
            if(resp == 0)
                jnl.dispose();
        }
    }
}