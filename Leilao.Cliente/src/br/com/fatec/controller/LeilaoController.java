package br.com.fatec.controller;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.model.Item;
import java.rmi.RemoteException;
import java.util.List;

public class LeilaoController {
    public void cadastrar(Item item) throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.cadastrar(item);
    }
    
    public void remover(Item item) throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.cadastrar(item);
    }
    
    public void encerrar() throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.encerrar();
    }
    
    public void inciciar() throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.inciciar();
    }
    
    public List<Item> listar() throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        return dto.listar();
    }
}
