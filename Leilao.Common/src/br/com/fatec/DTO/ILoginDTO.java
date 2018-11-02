package br.com.fatec.DTO;

import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginDTO extends Remote{
   public void save(Conta conta)      throws ContaExisteException, RemoteException;
   public boolean signIn(Conta conta) throws RemoteException;
   public void update(Conta conta)    throws RemoteException;
}
