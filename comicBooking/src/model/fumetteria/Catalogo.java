package model.fumetteria;

import java.util.ArrayList;
import java.util.List;

import model.fumetto.Fumetto;

public class Catalogo{

    private List<NumeroCopie> fumetti;
    private Fumetteria fumetteria;

    public Catalogo(){
        this.fumetti = new ArrayList<NumeroCopie>();
    }


    public Fumetteria getFumetteria() {
        return this.fumetteria;
    }

    public void setFumetteria(Fumetteria fumetteria) {
        this.fumetteria = fumetteria;
    }


    public List<Fumetto> getFumetti() {
        List<Fumetto> result = new ArrayList<Fumetto>();
        for(NumeroCopie n : this.fumetti){
            Fumetto copia = n.getFumetto();
            result.add(copia);
        }
        return result;
    }

    public boolean setFumetti(List<Fumetto> fumetti) {
        this.fumetti = new ArrayList<NumeroCopie>();
        boolean ok = true;

        for (Fumetto f : fumetti){
            NumeroCopie copia = new NumeroCopie();
            copia.setFumetto(f);
            copia.setDisponibilita(1);
            
            if (this.fumetti.add(copia) == false){
                ok = false;
            }
        }

        return ok;
    }

    public List<NumeroCopie> getNumeroCopie(){
        return this.fumetti;
    }

    public boolean setNumeroCopie(List<NumeroCopie> c){
        this.fumetti = c;
        return true;
    }

    public boolean aggiungiFumetto(Fumetto f, int quantita){
        NumeroCopie copia = new NumeroCopie();
        copia.setFumetto(f);
        copia.setDisponibilita(quantita);
        return this.fumetti.add(copia);
    }


    public boolean rimuoviFumetto(Fumetto f){

        int index = -1;
        for (int i=0; i<this.fumetti.size() && index == -1; i++){
            Fumetto copia = fumetti.get(i).getFumetto();
            if (copia.equals(f)){
                index = i;
            }
        }

        if (index == -1){
            return false;
        }

        NumeroCopie attuale = this.fumetti.get(index);
        int disponibilita = attuale.getDisponibilita();
        if (disponibilita <= 0){
            return false;
        }
        disponibilita--;
        attuale.setDisponibilita(disponibilita);
        return true;
    }

    public boolean rendiVolumePrenotabile(Fumetto f, int tempo){
        int index = -1;
        for (int i=0; i<this.fumetti.size() && index == -1; i++){
            Fumetto copia = fumetti.get(i).getFumetto();
            if (copia.equals(f)){
                index = i;
            }
        }

        if (index == -1){
            return false;
        }

        NumeroCopie attuale = this.fumetti.get(index);
        attuale.setPrenotabile(true);
        attuale.setTempoValidita(tempo);

        return true;

    }

    public boolean rendiVolumeNonPrenotabile(Fumetto f){
        int index = -1;
        for (int i=0; i<this.fumetti.size() && index == -1; i++){
            Fumetto copia = fumetti.get(i).getFumetto();
            if (copia.equals(f)){
                index = i;
            }
        }

        if (index == -1){
            return false;
        }

        NumeroCopie attuale = this.fumetti.get(index);
        attuale.setPrenotabile(false);
        attuale.setTempoValidita(0);
        
        return true;
    }


}