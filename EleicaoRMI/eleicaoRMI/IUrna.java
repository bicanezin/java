package eleicaoRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

public interface IUrna extends Remote {
    HashSet<Candidato> getCandidatos() throws RemoteException;
    boolean votar(Integer numero) throws RemoteException;
}
