package br.com.fatec.controller;

import br.com.fatec.config.Config;
import br.com.fatec.interfaces.ILeilaoProvider;
import br.com.fatec.interfaces.ILoginProvider;
import java.rmi.RemoteException;

class ProviderFactory {
    static ILoginProvider createContaProvider() throws RemoteException{
        if (Config.USE_FAKE_PROVIDER)
            return new br.com.fatec.fake.Provider.ContaProvider();
        return new br.com.fatec.provider.ContaProvider();
    }
    
    static ILeilaoProvider createLeilaoProvider() throws RemoteException {
        if (Config.USE_FAKE_PROVIDER)
            return new br.com.fatec.fake.Provider.LeilaoProvider();
        return new br.com.fatec.provider.LeilaoProvider();
    }
}
