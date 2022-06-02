package model.fumetto;

import java.util.Objects;

import model.interessi.Interesse;

public class Genere implements Interesse{

    private String tipo;

    public Genere(){

    }


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Genere)) {
            return false;
        }
        Genere genere = (Genere) o;
        return Objects.equals(tipo, genere.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tipo);
    }


}