package br.com.fatec.controller;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import java.rmi.RemoteException;

public class LoginController {
    public LoginController(){
    }
    
    public boolean logar(Conta conta) throws RemoteException{
        ILoginDTO login = Conexao.getLoginDTO();
        return login.signIn(conta);
    }
    
    public void criarConta(Conta conta) throws ContaExisteException, RemoteException{
        ILoginDTO login = Conexao.getLoginDTO();
        login.save(conta);
    }    
}
