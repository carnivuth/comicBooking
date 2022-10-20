package model.user;

import java.time.LocalDateTime;
import java.util.Objects;

public class Utente{

    private String username;
    private boolean bloccato;
    private LocalDateTime timestampBlocco;
    private int numeroTentativi;

    public Utente(){

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBloccato() {
        return this.bloccato;
    }

    public boolean getBloccato() {
        return this.bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public LocalDateTime getTimestampBlocco() {
        return this.timestampBlocco;
    }

    public void setTimestampBlocco(LocalDateTime timestampBlocco) {
        this.timestampBlocco = timestampBlocco;
    }

    public int getNumeroTentativi() {
        return this.numeroTentativi;
    }

    public void setNumeroTentativi(int numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Utente)) {
            return false;
        }
        Utente utente = (Utente) o;
        return Objects.equals(username, utente.username) && bloccato == utente.bloccato && Objects.equals(timestampBlocco, utente.timestampBlocco) && numeroTentativi == utente.numeroTentativi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, bloccato, timestampBlocco, numeroTentativi);
    }

    

}