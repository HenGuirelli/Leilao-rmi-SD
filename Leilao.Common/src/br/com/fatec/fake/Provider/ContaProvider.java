package br.com.fatec.fake.Provider;

import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.interfaces.IContaProvider;
import br.com.fatec.model.Conta;

public class ContaProvider implements IContaProvider{

    @Override
    public void save(Conta conta) throws ContaExisteException{
        /* nada pra fazer aqui */
    }

    @Override
    public boolean signIn(Conta conta) {
        return true;
    }

    @Override
    public void update(Conta conta) {
        /* nada a fazer */
    }   
}
