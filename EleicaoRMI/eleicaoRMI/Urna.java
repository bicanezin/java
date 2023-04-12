package eleicaoRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;

public class Urna extends UnicastRemoteObject implements IUrna {
    private HashMap<Candidato, Integer> votos;
    protected Urna() throws RemoteException { }

    @Override
    public HashSet<Candidato> getCandidatos() throws RemoteException {
        return new HashSet<>(votos.keySet());
    }

    @Override
    public boolean votar(Integer numero) throws RemoteException {
        votos.keySet().stream().filter((candidato) ->
                (candidato.getNumero().equals(numero))).forEach((candidato) -> {
            votos.put(candidato, votos.get(candidato) + 1);
        });

        return true;
    }

    public void adicionaCandidato(Candidato candidato) {
        if (votos == null) {
            votos = new HashMap<>();
        }

        votos.put(candidato, 0);
    }

    public void parcial() {
        System.out.println("\nParcial: ");

        votos.keySet().stream().forEach((candidato) -> {
            System.out.println(String.format("Candidato %s (%s) recebeu %s votos", candidato.getNome(), candidato.getNumero(), votos.get(candidato)));
        });
    }
}
