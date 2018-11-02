package br.com.fatec.fake.Provider;

import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import br.com.fatec.DTO.ILoginDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaProvider extends UnicastRemoteObject implements ILoginDTO{
    
    public ContaProvider() throws RemoteException {
        super();
    }
    
    @Override
    public void save(Conta conta) throws ContaExisteException{
        /* nada pra fazer aqui */
    }

    @Override
    public boolean signIn(Conta conta) {
        // TODO: mudar retorno pra TipoConta
        return true;
    }

    @Override
    public void update(Conta conta) {
        /* nada a fazer */
    }   
}
