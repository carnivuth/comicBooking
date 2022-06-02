package model.recensioni;

import java.time.LocalDateTime;

public class Recensione{

    private String testo;
    private LocalDateTime timestamp;

    public Recensione(){
        
    }


    public String getTesto() {
        return this.testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
    

    public  LocalDateTime getTimestamp(){
        return this.timestamp;
    }

    public  void setTimestamp(LocalDateTime t){
        this.timestamp = t;
    }

}