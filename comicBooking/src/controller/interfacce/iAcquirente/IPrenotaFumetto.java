package controller.interfacce.iAcquirente;

import java.util.List;

import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.user.Acquirente;

public interface IPrenotaFumetto {
    public boolean prenotaFumetto(Fumetto fu, Fumetteria f, Acquirente a);
    public List<Fumetteria> getFumetterie(Fumetto f);
    public List<Fumetto> getFumetti();


    
}
