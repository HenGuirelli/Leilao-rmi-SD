package br.com.fatec.controller;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.email.Email;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LeilaoController extends UnicastRemoteObject implements ILeilaoDTO {
    private ILeilaoDTO provider;
    
    public LeilaoController() throws RemoteException {
        super();
        provider = ProviderFactory.createLeilaoProvider();
    }
    
    @Override
    public void cadastrar(Item item) throws RemoteException {
        provider.cadastrar(item);
    }

    @Override
    public void remover(Item item) throws RemoteException {
        provider.remover(item);
    }

    @Override
    public void encerrar(Participante vencedor, Item item) throws RemoteException {
        //Email.enviar(vencedor, item);
        provider.remover(item);
    }

    @Override
    public void iniciar() throws RemoteException {
        provider.iniciar();
    }

    @Override
    public List<Item> listar() throws RemoteException {
        return provider.listar();
    }

    @Override
    public void darLance(Item item, Usuario usuario, float valor) throws RemoteException {
        provider.darLance(item, usuario, valor);
    }
}
