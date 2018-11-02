package br.com.fatec.interfaces;

import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;

public interface IContaProvider {
   public void save(Conta conta) throws ContaExisteException;
   public boolean signIn(Conta conta);
   public void update(Conta conta);
}
