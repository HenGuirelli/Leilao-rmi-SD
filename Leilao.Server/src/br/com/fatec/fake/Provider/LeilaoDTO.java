package br.com.fatec.fake.Provider;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.model.Item;
import br.com.fatec.model.Leilao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LeilaoDTO extends UnicastRemoteObject implements ILeilaoDTO {
    private Leilao leilao = new Leilao();
    
    public LeilaoDTO() throws RemoteException {
        super();
    }
    
    @Override
    public void cadastrar(Item item) throws RemoteException {
        leilao.addItem(item);
    }

    @Override
    public void remover(Item item) throws RemoteException {
        leilao.removeItem(item);
    }

    @Override
    public void encerrar() throws RemoteException {
        leilao.setAberto(false);
    }

    @Override
    public void inciciar() throws RemoteException {
        leilao.setAberto(true);
    }

    @Override
    public List<Item> listar() throws RemoteException {
        return leilao.getItens();
    }
    
}
