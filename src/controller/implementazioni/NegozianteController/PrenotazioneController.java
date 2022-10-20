package controller.implementazioni.NegozianteController;

import java.util.ArrayList;
import java.util.List;

import controller.interfacce.iNegoziante.IPrenotazione;
import model.fumetteria.Fumetteria;
import model.fumetteria.NumeroCopie;
import model.prenotazioni.Prenotazione;
import model.user.Acquirente;

public class PrenotazioneController implements IPrenotazione{

    @Override
    public List<Prenotazione> getPrenotazioni(Fumetteria f) {
        List<Prenotazione> result=new ArrayList<Prenotazione>();

        for(NumeroCopie n:f.getCatalogo().getNumeroCopie()){

            NumeroCopie n2 = new NumeroCopie();
            n2.setFumetto(n.getFumetto());

            for(Prenotazione p:n.getPrenotazioni()){

                Acquirente a2 = new Acquirente();
                a2.setUsername(p.getAcquirente().getUsername());

                Prenotazione p2 = new Prenotazione();
                p2.setAcquirente(a2);
                p2.setCopia(n2);
                p2.setCompletata(p.getCompletata());
                
                result.add(p2);

            }

        }
        return result;
    }
    
}
