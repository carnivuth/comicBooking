package model.user;

import java.util.Objects;

import model.fumetteria.Fumetteria;

public class Negoziante extends Utente{

    private String partitaIVA;
    private Fumetteria fumetteria;

    public Negoziante(){

    }

    public String getPartitaIVA() {
        return this.partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }


    public Fumetteria getFumetteria() {
        return this.fumetteria;
    }

    public void setFumetteria(Fumetteria fumetteria) {
        this.fumetteria = fumetteria;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Negoziante)) {
            return false;
        }
        Negoziante negoziante = (Negoziante) o;
        return Objects.equals(partitaIVA, negoziante.partitaIVA) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partitaIVA, fumetteria);
    }


}