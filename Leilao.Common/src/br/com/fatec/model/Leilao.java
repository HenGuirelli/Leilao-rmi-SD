package br.com.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class Leilao implements java.io.Serializable {
    private List<Item> itens = new ArrayList<>();
    private boolean aberto;

    public List<Item> getItens() {
        return itens;
    }

    public void addItem(Item item){
        itens.add(item);
    }
    
    public void removeItem(Item item){
        itens.remove(item);
    }
    
    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
}
