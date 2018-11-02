package br.com.fatec.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.config.Config;


public class Conexao {
    static {
        conectar();
    }
    
    private static ILoginDTO loginDTO;

    public static ILoginDTO getLoginDTO() {
        return loginDTO;
    }

    public static void conectar(){
         try {
            //ip
            LocateRegistry.getRegistry(Config.REGISTRY);
            loginDTO = (ILoginDTO) Naming.lookup(Config.ENDPOINT_LOGIN);       
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }    
}
