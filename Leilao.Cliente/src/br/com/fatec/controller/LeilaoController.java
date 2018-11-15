package br.com.fatec.controller;

import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.config.Config;
import br.com.fatec.model.ExecutionContext;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class LeilaoController {
    public void cadastrar(Item item) throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.cadastrar(item);
    }
    
    public void remover(Item item) throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.cadastrar(item);
    }
    
    public void encerrar(Participante vencedor, Item item) throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.encerrar(vencedor, item);
    }
    
    public void inciciar() throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        dto.iniciar();
    }
    
    public List<Item> listar() throws RemoteException{
        ILeilaoDTO dto = Conexao.getLeilaoDTO();
        return dto.listar();
    }
    
    public void darLance(Item item, float lance) throws RemoteException{
       ILeilaoDTO dto = Conexao.getLeilaoDTO();
       dto.darLance(item, ExecutionContext.getUsuario(), lance);
    }
    
    public void preencheTabelaAsync(javax.swing.JTable table){
        new Thread() {
            @Override
            public void run(){
                while (true){
                    List<Item> itens = null;
                    try {
                        itens = listar();
                    } catch (RemoteException ex) {
                        
                    }

                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int oldSelect = table.getSelectedRow();
                    model.setRowCount(0);
                    for(Item item : itens){
                        String [] row = new String[] {item.getDescricao(), item.getValoMinimo() + "", item.getValorAtual() + ""};
                        model.addRow(row);
                    }
                    try{
                        table.setRowSelectionInterval(oldSelect, oldSelect);
                    }catch(Exception e){}
                    
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LeilaoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }
    
}
