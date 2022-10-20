package model.notifiche;

import java.time.LocalDateTime;

import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.user.Acquirente;

public class Notifica{

    private LocalDateTime timestamp;
    private boolean visualizzato;
    private Fumetto fumetto;
    private Fumetteria fumetteria;
    private Acquirente Acquirente;

    public Notifica(){
        this.visualizzato = false;
    }

    public void  segnaComeLetto() {
        this.visualizzato = true;
    }

    public boolean isVisualizzato(){
        return this.visualizzato;
    }

    public  LocalDateTime getTimestamp(){
        return this.timestamp;
    }

    public  void setTimestamp(LocalDateTime t){
        this.timestamp = t;
    }


    public Fumetto getFumetto() {
        return this.fumetto;
    }

    public void setFumetto(Fumetto fumetto) {
        this.fumetto = fumetto;
    }

    public Fumetteria getFumetteria() {
        return this.fumetteria;
    }

    public void setFumetteria(Fumetteria fumetteria) {
        this.fumetteria = fumetteria;
    }

    public Acquirente getAcquirente() {
        return this.Acquirente;
    }

    public void setAcquirente(Acquirente Acquirente) {
        this.Acquirente = Acquirente;
    }


}