package eleicaoRMI;

import java.awt.*;
import java.rmi.Naming;
import java.util.Scanner;
import java.util.Set;

public class Cliente implements Runnable{
    private IUrna urna;

    @Override
    public void run() {
        try {
            urna = getUrnaService();
            System.out.println("Urna iniciada\n");

        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }

        votos();
    }

    public void votos() {
        boolean exit = false;

        try {
            final Scanner entrada = new Scanner(System.in);
            String voto;

            while (!exit) {
                System.out.println("\nCandidatos:");
                listarCandidatos();
                System.out.println("\n");

                System.out.print("Insira o número do seu candidato escolhido: ");
                voto = entrada.nextLine();

                try {
                    Integer numero = Integer.parseInt(voto);
                    urna.votar(numero);
                } catch (NumberFormatException e) {
                    System.err.println("Voto inválido");
                    System.err.println("Erro: " + e);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    private void listarCandidatos() throws Exception {
        final Set<Candidato> candidatos = urna.getCandidatos();

        candidatos.stream().forEach((candidato) -> {
            System.out.println(String.format("-> Nome: %s. Número: %s", candidato.getNome(), candidato.getNumero()));
        });
    }

    private IUrna getUrnaService() throws Exception {
        return (IUrna) Naming.lookup("rmi://localhost/Urna");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Cliente());
    }
}
