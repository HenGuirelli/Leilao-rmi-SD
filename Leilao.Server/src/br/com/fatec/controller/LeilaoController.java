package br.com.fatec.controller;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.email.Email;
import br.com.fatec.interfaces.ILeilaoProvider;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class LeilaoController extends UnicastRemoteObject implements ILeilaoDTO {
    private ILeilaoProvider provider;
    
    public LeilaoController() throws RemoteException {
        super();
        provider = ProviderFactory.createLeilaoProvider();
    }
    
    @Override
    public void cadastrar(Item item) throws RemoteException, ClassNotFoundException, SQLException {
        provider.cadastrar(item);
    }

    @Override
    public void remover(Item item) throws RemoteException, ClassNotFoundException, SQLException {
        provider.remover(item);
    }

    @Override
    public void encerrar(Participante vencedor, Item item) throws RemoteException, ClassNotFoundException, SQLException {
        //Email.enviar(vencedor, item);
        provider.remover(item);
    }

    @Override
    public void iniciar() throws RemoteException, ClassNotFoundException, SQLException {
        provider.iniciar();
    }

    @Override
    public List<Item> listar() throws RemoteException, ClassNotFoundException, SQLException {
        return provider.listar();
    }

    @Override
    public void darLance(Item item, Usuario usuario, float valor) throws RemoteException, ClassNotFoundException, SQLException {
        System.out.println("lance dado");
        item.setVencedor((Participante) usuario);
        item.setValorAtual(valor);
        provider.atualizar(item);
    }
}
