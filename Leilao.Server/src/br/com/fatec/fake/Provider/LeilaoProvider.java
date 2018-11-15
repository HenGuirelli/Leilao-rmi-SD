package br.com.fatec.fake.Provider;

import br.com.fatec.model.Item;
import br.com.fatec.model.Leilao;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.util.List;

public class LeilaoProvider {
    private Leilao leilao = new Leilao();
    
    
    public void cadastrar(Item item) throws RemoteException {
        leilao.addItem(item);
    }

    public void remover(Item item) throws RemoteException {
        leilao.removeItem(item);
    }

    public void encerrar(Participante vencedor, Item item) throws RemoteException {
        //leilao.setAberto(false);
        System.out.println("encerrar");
        leilao.getItens().remove(item);
    }

    public void iniciar() throws RemoteException {
        leilao.setAberto(true);
    }

    public List<Item> listar() throws RemoteException {
        return leilao.getClone();
    }

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
