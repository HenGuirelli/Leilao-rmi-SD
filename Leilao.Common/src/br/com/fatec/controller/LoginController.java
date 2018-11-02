package br.com.fatec.controller;

import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.interfaces.IContaProvider;
import br.com.fatec.model.Conta;

public class LoginController {
    IContaProvider contaProvider;
    
    public LoginController(){
        contaProvider = ProviderFactory.createContaProvider();
    }
    
    public boolean logar(Conta conta){
        return contaProvider.signIn(conta);
    }
    
    public void criarConta(Conta conta) throws ContaExisteException{
        contaProvider.save(conta);
    }
}
