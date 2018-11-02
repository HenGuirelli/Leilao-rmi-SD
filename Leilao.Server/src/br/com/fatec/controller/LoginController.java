package br.com.fatec.controller;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import java.rmi.RemoteException;

public class LoginController {
    private ILoginDTO contaProvider;
    
    public LoginController() throws RemoteException{
        contaProvider = ProviderFactory.createContaProvider();
    }
    
    public boolean logar(Conta conta) throws RemoteException{
        return contaProvider.signIn(conta);
    }
    
    public void criarConta(Conta conta) throws ContaExisteException, RemoteException{
        contaProvider.save(conta);
    }
}
