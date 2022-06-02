package controller.interfacce.iAcquirente;

import java.util.List;

import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;

public interface IPrenotaFumetto {
    public boolean prenotaFumetto(Fumetto fu, Fumetteria f, Aquirente a);
    public List<Fumetteria> getFumetterie(Fumetto f);
    public List<Fumetto> getFumetti();


    
}
