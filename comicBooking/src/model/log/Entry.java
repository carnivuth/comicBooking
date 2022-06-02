package model.log;

import java.time.LocalDateTime;

public class Entry{

    private LocalDateTime timestamp;
    private String descrizione;

    public Entry(){}


    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    

}