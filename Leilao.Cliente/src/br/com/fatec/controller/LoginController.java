package br.com.fatec.controller;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.ExecutionContext;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;

public class LoginController {
    
    public Usuario logar(Conta conta) throws RemoteException{
        ILoginDTO login = Conexao.getLoginDTO();
        Usuario u = login.signIn(conta);
        ExecutionContext.setUsuario(u);
        return u;
    }
    
    public void criarConta(Conta conta) throws ContaExisteException, RemoteException{
        ILoginDTO login = Conexao.getLoginDTO();
        login.save(conta);
    }
    
}
