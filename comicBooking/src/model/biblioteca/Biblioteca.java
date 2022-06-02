package model.biblioteca;

import java.util.ArrayList;
import java.util.List ;

import model.fumetto.Fumetto;
import model.fumetto.Serie;
import model.user.Acquirente;

public class Biblioteca{

    private List<Fumetto>  fumetti;
    private Acquirente Acquirente;

    public Biblioteca(){
        this.fumetti = new ArrayList<Fumetto>();
    }


    public Acquirente getAcquirente() {
        return this.Acquirente;
    }

    public void setAcquirente(Acquirente Acquirente) {
        this.Acquirente = Acquirente;
    }


    public List<Fumetto> getFumetti() {
        return this.fumetti;
    }

    public boolean setFumetti(List<Fumetto> fumetti) {
        this.fumetti = fumetti;
        return true;
    }

    public boolean aggiungiFumetto(Fumetto f){
        return this.fumetti.add(f);
    }


    public boolean rimuoviFumetto(Fumetto f){
        return this.fumetti.remove(f);
    }

    public boolean aggiungiSerie(Serie s){
        boolean ok = true;
        for(Fumetto f : s.getFumettiDellaSerie()){
            if (this.fumetti.add(f) == false){
                ok = false;
            }
        }
        return ok;
    }

    public boolean rimuoviSerie(Serie s){
        boolean ok = true;
        for(Fumetto f : s.getFumettiDellaSerie()){
            if (this.fumetti.remove(f) == false){
                ok = false;
            }
        }
        return ok;
    }
    
    
}