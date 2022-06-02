package model.log;

import java.util.ArrayList;
import java.util.List;


public class Log{

    private List<Entry> logs;

    public Log(){
        this.logs = new ArrayList<Entry>();
    }

    public List<Entry> visualizzaLog(){
        return this.logs;
    }

    public void aggiungiLog(List<Entry> l) {
        this.logs=l;
    }

}