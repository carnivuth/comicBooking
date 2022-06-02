package model.user;

import java.util.ArrayList;
import java.util.List;

import model.interessi.Interessi;
import model.notifiche.Notifica;
import model.prenotazioni.Prenotazione;
import model.biblioteca.Biblioteca;

public class Acquirente extends Utente{

    public Biblioteca Biblioteca;
    public List<Notifica> notifiche;
    public List<Prenotazione> prenotazioni;
    public Interessi interessi;

    public Acquirente(){
        this.notifiche = new ArrayList<Notifica>();
        this.prenotazioni = new ArrayList<Prenotazione>();
    }


    public Biblioteca getBiblioteca() {
        return this.Biblioteca;
    }

    public void setBiblioteca(Biblioteca Biblioteca) {
        this.Biblioteca = Biblioteca;
    }


    public List<Notifica> getNotifiche() {
        return this.notifiche;
    }

    public void setNotifiche(List<Notifica> notifiche) {
        this.notifiche = notifiche;
    }


    public List<Prenotazione> getPrenotazioni() {
        return this.prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }


    public Interessi getInteressi() {
        return this.interessi;
    }

    public void setInteressi(Interessi interessi) {
        this.interessi = interessi;
    }



}