package model.fumetteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.interessi.Interesse;
import model.recensioni.Recensibile;
import model.recensioni.Recensione;
import model.user.Negoziante;

public class Fumetteria implements Recensibile, Interesse{

    private String indirizzo;
    private String nome;
    private String citta;
    private Catalogo catalogo;
    private Negoziante negoziante;

    List<Recensione> recensioni;

    public Fumetteria(){
        this.recensioni = new ArrayList<>();
    }


    public List<Recensione> getTutteRecensioni() {
        return this.recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }



    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return this.citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Catalogo getCatalogo() {
        return this.catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Negoziante getNegoziante() {
        return this.negoziante;
    }

    public void setNegoziante(Negoziante negoziante) {
        this.negoziante = negoziante;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fumetteria)) {
            return false;
        }
        Fumetteria fumetteria = (Fumetteria) o;
        return Objects.equals(indirizzo, fumetteria.indirizzo) && Objects.equals(nome, fumetteria.nome) && Objects.equals(citta, fumetteria.citta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indirizzo, nome, citta, catalogo,negoziante);
    }
    

}