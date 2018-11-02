package br.com.fatec.fake.Provider;

import br.com.fatec.interfaces.IContaProvider;

public class ContaProvider implements IContaProvider{

    @Override
    public void save(ContaProvider conta) {
        /* nada pra fazer aqui */
    }

    @Override
    public boolean signIn(ContaProvider conta) {
        return true;
    }

    @Override
    public void update(ContaProvider conta) {
        /* nada a fazer */
    }   
}
