package eleicaoRMI;

import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Servidor implements Runnable {
    private Urna urna;
    private ScheduledExecutorService executorService;

    @Override
    public void run() {
        try {
            urna = criaListaCandidatos();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi:///Urna", urna);

            System.out.println("Urna iniciada\n");
        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Erro: " + e);
        }
        apuraVotos();
    }

    private void listaCandidatos(Urna urna) throws RemoteException {
        String format =("|%1$-25s|%2$-16s|\n");

        System.out.format(format, "-------------------------", "-----------------");
        System.out.format(format, "          Nome           ", "      Número     ");
        System.out.format(format, "-------------------------", "-----------------");

        final Set<Candidato> candidatos = urna.getCandidatos();

        candidatos.stream().forEach((candidato) -> {
           float nomeCentro = 1;
           float numeroCentro = 1;

           if ( candidato.getNome().length() <=25)
               nomeCentro = ((25 - candidato.getNome().length())/2);

           if ( candidato.getNumero().toString().length() <= 17)
                numeroCentro = (17-candidato.getNumero().toString().length())/2;

            Object ex;

            if(candidato.getNome().length() % 2 == 0 && candidato.getNumero().toString().length() % 2 == 0){
                ex = new String[]{
                        String.format("%-" + nomeCentro + "s", " ") + candidato.getNome() + " " + String.format("%-" + nomeCentro + "s", ""),
                        String.format("%-" + numeroCentro + "s", " ") + candidato.getNumero() + " " + String.format("%-" + numeroCentro + "s", "")
                };
            } else if (candidato.getNome().length() % 2 == 0 && candidato.getNumero().toString().length() % 2 != 0) {
                ex = new String[]{
                        String.format("%-" + nomeCentro + "s", " ") + candidato.getNome() + " " + String.format("%-" + nomeCentro + "s", ""),
                        String.format("%-" + numeroCentro + "s", " ") + candidato.getNumero() + String.format("%-" + numeroCentro + "s", "")
                };
            }
                else if (candidato.getNome().length() % 2 != 0 && candidato.getNumero().toString().length() % 2 == 0) {
                ex = new String[]{
                        String.format("%-" + nomeCentro + "s", " ") + candidato.getNome() + String.format("%-" + nomeCentro + "s", ""),
                        String.format("%-" + numeroCentro + "s", " ") + candidato.getNumero() + " " + String.format("%-" + numeroCentro + "s", "")
                };
            }
            else {
                ex = new String[]{
                        String.format("%-" + nomeCentro + "s", " ") + candidato.getNome() + String.format("%-" + nomeCentro + "s", ""),
                        String.format("%-" + numeroCentro + "s", " ") + candidato.getNumero() + String.format("%-" + numeroCentro + "s", "")
                };
            }
           System.out.format(String.format(format, (Object[]) ex));
        });
        System.out.format(format, "-------------------------", "-----------------");
        System.out.printf("\n");
    }

    private Urna criaListaCandidatos() throws RemoteException {
        final Urna urnaLista = new Urna();
        final Scanner entrada = new Scanner(System.in);
        String valor = String.valueOf(entrada);
        boolean invalid = true;

        System.out.println("\nCrie a lista de candidatos conforme o exemplo e aperte ENTER para salvar");
        System.out.println("EXEMPLO: nomeCandidato-numeroCandidato, nomeCandidato-numeroCandidato, nomeCandidato-numeroCandidato...\n");

        while (invalid) {
            valor = entrada.nextLine();

            if (!valor.isEmpty()) {
                invalid = false;
            }
        }

        if (valor != null && !valor.isEmpty()) {
            final String[] arrayCandidatos = valor.split(",");

            for (String dadosCandidato : arrayCandidatos) {
                final String nome = dadosCandidato.split("-")[0];
                final String numero = dadosCandidato.split("-")[1];

                urnaLista.adicionaCandidato(new Candidato(nome.trim(), Integer.parseInt(numero)));
            }
        }

        listaCandidatos(urnaLista);
        return urnaLista;
    }

    private void apuraVotos() {
        executorService = Executors.newSingleThreadScheduledExecutor();

        //realiza a apuração a cada 5s
        executorService.scheduleAtFixedRate(() ->
        { urna.parcial(); }, 5, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Servidor());
    }
}
