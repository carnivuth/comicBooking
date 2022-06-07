package controller.implementazioni.NegozianteController;

import java.util.ArrayList;
import java.util.List;

import controller.interfacce.iNegoziante.IPrenotazione;
import model.fumetteria.Fumetteria;
import model.fumetteria.NumeroCopie;
import model.prenotazioni.Prenotazione;

public class PrenotazioneController implements IPrenotazione{

    @Override
    public List<Prenotazione> getPrenotazioni(Fumetteria f) {
        List<Prenotazione> result=new ArrayList<Prenotazione>();

        for(NumeroCopie n:f.getCatalogo().getNumeroCopie()){
            for(Prenotazione p:n.getPrenotazioni()){
                result.add(p);

            }

        }
        return result;
    }
    
}
