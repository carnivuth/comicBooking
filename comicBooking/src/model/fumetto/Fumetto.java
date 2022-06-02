package model.fumetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.recensioni.Recensibile;
import model.recensioni.Recensione;


public class Fumetto implements Recensibile{

    private String titolo;
    private int numero;
    private String descrizione;
    private String casaEditrice;
    private Serie serie;

    List<Recensione> recensioni;

    public Fumetto(){
       this.recensioni = new ArrayList<>();
    }

    public List<Recensione> getTutteRecensioni(){
        return this.recensioni;
    }

    public void setTutteRecensioni(List<Recensione> r){
        this.recensioni = r;
    }


    public Serie getSerie() {
        return this.serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }


    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCasaEditrice() {
        return this.casaEditrice;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fumetto)) {
            return false;
        }
        Fumetto fumetto = (Fumetto) o;
        return Objects.equals(titolo, fumetto.titolo) && numero == fumetto.numero && Objects.equals(descrizione, fumetto.descrizione) && Objects.equals(casaEditrice, fumetto.casaEditrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, numero, descrizione, casaEditrice);
    }

}