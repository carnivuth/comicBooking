package controller.implementazioni.NegozianteController;

import java.time.LocalDateTime;
import java.util.List;

import controller.interfacce.iNegoziante.IGestioneCatalogo;
import model.fumetteria.Catalogo;
import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.interessi.Interesse;
import model.notifiche.Notifica;
import model.user.Acquirente;
import model.user.Negoziante;

public class GestioneCatalogoController implements IGestioneCatalogo{

    @Override
    public boolean rendiVolumePrenotabile(Fumetto f, Integer giorni, Negoziante n) {
        // TODO Auto-generated method stub
        return n.getFumetteria().getCatalogo().rendiVolumePrenotabile(f, giorni);
    }

    @Override
    public boolean rendiVolumeNonPrenotabile(Fumetto f, Negoziante n) {
        // TODO Auto-generated method stub
        return n.getFumetteria().getCatalogo().rendiVolumeNonPrenotabile(f);
    }

    @Override
    public boolean aggiungiFumetto(Fumetto f, int disponibilita, Negoziante n) {
        // TODO Auto-generated method stub
        return n.getFumetteria().getCatalogo().aggiungiFumetto(f, disponibilita);
    }

    @Override
    public boolean rimuoviFumetto(Fumetto f, Negoziante n) {
        // TODO Auto-generated method stub
        return n.getFumetteria().getCatalogo().rimuoviFumetto(f);
    }

    @Override
    public void scatenaEvento(boolean b, Fumetto f,Fumetteria fumetteria) {
        // TODO Auto-generated method stub
        List<Acquirente> acquirenti=GestioneNegozianteController.dataStore.getAcquirenti();
        for(Acquirente a : acquirenti){
            for(Interesse i:a.getInteressi().getInteressi()){
                if(i.equals(fumetteria)){

                    List<Notifica> notifiche=a.getNotifiche();
                    Notifica n=new Notifica();
                    n.setAcquirente(a);
                    n.setFumetteria(fumetteria);
                    n.setFumetto(f);
                    n.setTimestamp(LocalDateTime.now());
                    notifiche.add(n);
                }
            }
        }
    }

    @Override
    public Catalogo getCatalogo(Negoziante n) {
        // TODO Auto-generated method stub
        return n.getFumetteria().getCatalogo();
    }
    
}
