package clienteServidor.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
    public static ServerSocket servidor;
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    public Servidor(Socket conexao) {
        this.conexao = conexao;
    }

    @Override
    public void run() {
        try {
            entrada= new DataInputStream(conexao.getInputStream());
            saida= new DataOutputStream(conexao.getOutputStream());

            String dados = entrada.readUTF();

            while (!dados.equals("fim")) {
                System.out.println("Envia na porta " + conexao.getPort()+" do cliente "+dados);

                saida.writeUTF(dados.toUpperCase());
                dados = entrada.readUTF();
                System.out.println(dados);
                System.out.println("");
            }

            System.out.println("Conexão finalizada pelo cliente");
            conexao.close();
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(4000);
            System.out.println("Servidor aberto na porta 4000");

            while (true) {
                conexao = servidor.accept();
                Servidor thread = new Servidor(conexao);
                System.out.println("Cliente conectado");
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Erro" + ex);
            System.out.println("");
        }
    }
}