package br.com.fatec.controller;

import br.com.fatec.config.Config;
import br.com.fatec.interfaces.IContaProvider;

public class ProviderFactory {
    public IContaProvider createContaProvider(){
        if (Config.USE_FAKE_PROVIDER)
            return new br.com.fatec.fake.Provider.ContaProvider();
        return null;
    }
}
