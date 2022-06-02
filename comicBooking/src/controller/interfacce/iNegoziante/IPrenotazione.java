package controller.interfacce.iNegoziante;

import java.util.List;

import model.fumetteria.Fumetteria;
import model.prenotazioni.Prenotazione;

public interface IPrenotazione {

    public List<Prenotazione> getPrenotazioni(Fumetteria f);
    
    
}
