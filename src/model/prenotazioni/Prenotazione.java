package model.prenotazioni;

import java.time.LocalDateTime;

import model.fumetteria.NumeroCopie;
import model.user.Acquirente;

public class Prenotazione{

    private LocalDateTime dataPrenotazione;
    private boolean completata;
    private Acquirente acquirente;
    private NumeroCopie copia; 

    public Prenotazione(){}


    public LocalDateTime getDataPrenotazione() {
        return this.dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public boolean isCompletata() {
        return this.completata;
    }

    public boolean getCompletata() {
        return this.completata;
    }

    public void setCompletata(boolean completata) {
        this.completata = completata;
    }

    public Acquirente getAcquirente() {
        return this.acquirente;
    }

    public void setAcquirente(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    public NumeroCopie getCopia() {
        return this.copia;
    }

    public void setCopia(NumeroCopie copia) {
        this.copia = copia;
    }
    

}