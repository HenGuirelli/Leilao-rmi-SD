package br.com.fatec.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.config.Config;
import br.com.fatec.fake.Provider.ContaProvider;

public class Server {
    
    public static void main(String[] args){
        try {
            System.out.println("server ativo...");
            ILoginDTO m = new ContaProvider();
            LocateRegistry.createRegistry(Config.PORT);
            Naming.rebind(Config.ENDPOINT_LOGIN, m);
        }catch( Exception e ) { 
            System.out.println(" Erro: " + e );
        }
    }
}
