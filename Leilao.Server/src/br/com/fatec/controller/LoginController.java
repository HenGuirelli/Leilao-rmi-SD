package br.com.fatec.controller;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginController extends UnicastRemoteObject implements ILoginDTO {
    private ILoginDTO contaProvider;
    
    public LoginController() throws RemoteException {
        contaProvider = ProviderFactory.createContaProvider();
    }

    @Override
    public void save(Conta conta) throws ContaExisteException, RemoteException {
        contaProvider.save(conta);
    }

    @Override
    public Usuario signIn(Conta conta) throws RemoteException {
        return contaProvider.signIn(conta);
    }

    @Override
    public void update(Conta conta) throws RemoteException {
        contaProvider.update(conta);
    }
}
