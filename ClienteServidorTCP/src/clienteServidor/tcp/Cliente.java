package clienteServidor.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            // inicia conexão com o servidor
            conexao = new Socket("localhost", 4000);
            entrada = new DataInputStream(conexao.getInputStream());
            saida = new DataOutputStream(conexao.getOutputStream());

            // entrada do nome do cliente
            String dados = JOptionPane.showInputDialog("Digite um nome para o cliente");

            while (!dados.equals("fim")) {
                saida.writeUTF(dados);
                // saida com os dados recebidos do servidor
                System.out.println("Resposta do servidor: " + entrada.readUTF());
                dados = JOptionPane.showInputDialog("Escreva a mensagem:");
            }

            // fecha a conexão com o servidor
            conexao.close();
        } catch (IOException ex) {
            System.out.println("Erro na conexão com o servidor" + ex);
            System.out.println("");
        }
    }
}

