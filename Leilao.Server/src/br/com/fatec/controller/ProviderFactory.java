package br.com.fatec.controller;

import br.com.fatec.DTO.*;
import br.com.fatec.config.Config;
import java.rmi.RemoteException;

class ProviderFactory {
    static ILoginDTO createContaProvider() throws RemoteException{
        if (Config.USE_FAKE_PROVIDER)
            return new br.com.fatec.fake.Provider.ContaProvider();
        return null;
    }
    
    static ILeilaoDTO createLeilaoProvider() throws RemoteException {
        if (Config.USE_FAKE_PROVIDER)
            return new br.com.fatec.fake.Provider.LeilaoDTO();
        return null;
    }
}
