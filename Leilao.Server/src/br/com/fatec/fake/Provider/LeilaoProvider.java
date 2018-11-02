package br.com.fatec.fake.Provider;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.model.Item;
import br.com.fatec.model.Leilao;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LeilaoProvider extends UnicastRemoteObject implements ILeilaoDTO {
    private Leilao leilao = new Leilao();
    
    public LeilaoProvider() throws RemoteException {
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
    public void iniciar() throws RemoteException {
        leilao.setAberto(true);
    }

    @Override
    public List<Item> listar() throws RemoteException {
        return leilao.getClone();
    }

    @Override
    public void darLance(Item item, Usuario usuario, float valor) throws RemoteException {        
        int i = 0;
        for (Item _item : leilao.getItens()){
            if (_item.getId() == item.getId()){
                break;
            }
            i++;
        }
        leilao.getItens().remove(i);
                
        item.setValorAtual(valor);
        item.setVencedor((Participante)usuario);
        leilao.addItem(item);
    }    
}
