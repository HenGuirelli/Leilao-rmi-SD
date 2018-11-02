package br.com.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private List<Item> itens = new ArrayList<>();
    private boolean aberto;

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
