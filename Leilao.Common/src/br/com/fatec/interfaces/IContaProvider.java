package br.com.fatec.interfaces;

import br.com.fatec.fake.Provider.ContaProvider;

public interface IContaProvider {
   public void save(ContaProvider conta);
   public boolean signIn(ContaProvider conta);
   public void update(ContaProvider conta);
}
