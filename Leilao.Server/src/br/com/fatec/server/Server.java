package br.com.fatec.server;

import br.com.fatec.DTO.ILeilaoDTO;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.config.Config;
import br.com.fatec.controller.LeilaoController;
import br.com.fatec.controller.LoginController;

public class Server {
    
    public static void main(String[] args){
        try {
            System.out.println("server ativo...");
            
            ILoginDTO login = new LoginController();
            ILeilaoDTO leilao = new LeilaoController();
            
            LocateRegistry.createRegistry(Config.PORT);
            
            Naming.rebind(Config.ENDPOINT_LOGIN, login);
            Naming.rebind(Config.ENDPOINT_LEILAO, leilao);
        }catch( Exception e ) { 
            System.out.println(" Erro: " + e );
        }
    }
}
