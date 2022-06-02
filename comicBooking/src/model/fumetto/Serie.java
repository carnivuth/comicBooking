package model.fumetto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import model.interessi.Interesse;
import model.recensioni.Recensibile;
import model.recensioni.Recensione;

public class Serie implements Recensibile, Interesse{

    private String autore;
    private String titolo;
    private Set<Fumetto> fumetti;
    private Set<Genere> generi;

    List<Recensione> recensioni;

    public Serie(){
        this.fumetti = new HashSet<Fumetto>();
        this.generi = new HashSet<Genere>();
        this.recensioni = new ArrayList<Recensione>();
    }


    public Set<Fumetto> getFumetti() {
        return this.fumetti;
    }

    public void setFumetti(Set<Fumetto> fumetti) {
        this.fumetti = fumetti;
    }

    public List<Recensione> getRecensioni() {
        return this.recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }



    public Set<Genere> getGeneri() {
        return this.generi;
    }

    public void setGeneri(Set<Genere> generi) {
        this.generi = generi;
    }


    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }



    public Set<Fumetto> getFumettiDellaSerie() {
        return this.fumetti;
    }

    public void setFumettiDellaSerie(Set<Fumetto> fumetti) {
        this.fumetti = fumetti;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Serie)) {
            return false;
        }
        Serie serie = (Serie) o;
        return Objects.equals(autore, serie.autore) && Objects.equals(titolo, serie.titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autore, titolo);
    }


    @Override
    public List<Recensione> getTutteRecensioni() {
        return recensioni;
    }

    
    
}