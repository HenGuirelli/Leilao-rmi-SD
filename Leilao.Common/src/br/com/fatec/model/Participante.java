package br.com.fatec.model;

public class Participante extends Usuario implements java.io.Serializable {
   private int totalLances;
   private int totalItensGanhos;

    public int getTotalLances() {
        return totalLances;
    }

    public void setTotalLances(int totalLances) {
        this.totalLances = totalLances;
    }

    public int getTotalItensGanhos() {
        return totalItensGanhos;
    }

    public void setTotalItensGanhos(int totalItensGanhos) {
        this.totalItensGanhos = totalItensGanhos;
    }
}
