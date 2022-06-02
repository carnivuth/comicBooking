package model.fumetteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.fumetto.Fumetto;
import model.prenotazioni.Prenotazione;

public class NumeroCopie{

    private int disponibilita;
    private boolean prenotabile;
    private Fumetto fumetto;
    private int tempoValidita;

    private List<Prenotazione> prenotazioni;


    public int getTempoValidita() {
        return this.tempoValidita;
    }

    public void setTempoValidita(int tempoValidita) {
        this.tempoValidita = tempoValidita;
    }

    

    public NumeroCopie(){
        this.prenotabile = false;
        this.disponibilita = 0;
        this.prenotazioni = new ArrayList<Prenotazione>();
    }


    public int getDisponibilita() {
        return this.disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public boolean isPrenotabile() {
        return this.prenotabile;
    }

    public boolean getPrenotabile() {
        return this.prenotabile;
    }

    public void setPrenotabile(boolean prenotabile) {
        this.prenotabile = prenotabile;
    }

    public Fumetto getFumetto() {
        return this.fumetto;
    }

    public void setFumetto(Fumetto fumetto) {
        this.fumetto = fumetto;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NumeroCopie)) {
            return false;
        }
        NumeroCopie numeroCopie = (NumeroCopie) o;
        return disponibilita == numeroCopie.disponibilita && prenotabile == numeroCopie.prenotabile && Objects.equals(fumetto, numeroCopie.fumetto) && tempoValidita == numeroCopie.tempoValidita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilita, prenotabile, fumetto, tempoValidita);
    }
    


    public List<Prenotazione> getPrenotazioni() {
        return this.prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }


}