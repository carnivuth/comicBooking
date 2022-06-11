package model.interessi;

import java.util.ArrayList;
import java.util.List;

public class Interessi{

    private List<Interesse> interessi;

    public Interessi(){
        this.interessi = new ArrayList<Interesse>();
    }


    public List<Interesse> getInteressi() {
        return this.interessi;
    }

    public void setInteressi(List<Interesse> interessi) {
        this.interessi = interessi;
    }

    public void aggiungiInteresse(Interesse i){
        this.interessi.add(i);
    }

    public void rimuoviInteresse(Interesse i){
        this.interessi.remove(i);
    }


    @Override
    public String toString() {
        String a = "";
        for(Interesse i : this.getInteressi()){
            a += (i.toString() + "   " + i.getClass());
            a+= System.lineSeparator();
        }
        return a;
    }

}