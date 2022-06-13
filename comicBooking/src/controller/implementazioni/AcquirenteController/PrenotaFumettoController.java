package controller.implementazioni.AcquirenteController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import controller.interfacce.iAcquirente.IPrenotaFumetto;
import model.fumetteria.Catalogo;
import model.fumetteria.Fumetteria;
import model.fumetteria.NumeroCopie;
import model.fumetto.Fumetto;
import model.prenotazioni.Prenotazione;
import model.user.Acquirente;
import model.user.Negoziante;

public class PrenotaFumettoController implements IPrenotaFumetto{

    @Override
    public boolean prenotaFumetto(Fumetto fu, Fumetteria f, Acquirente a) {
        
        Prenotazione prenotazione=new Prenotazione();
        prenotazione.setAcquirente(a);
        Catalogo catalogo = f.getCatalogo();
        List<NumeroCopie> listCopie = catalogo.getNumeroCopie();
        List<Prenotazione> prenotazioni=a.getPrenotazioni();

        for(NumeroCopie n:listCopie){
            if(n.getFumetto().equals(fu)){
               prenotazione.setCopia(n);
               prenotazione.setDataPrenotazione(LocalDateTime.now());
               prenotazione.setCompletata(false);
               n.getPrenotazioni().add(prenotazione);
               
               //aggiorni prenotazioni dell'utente
               prenotazioni.add(prenotazione);
            
               return true;
            }
        }
        
        return false;
    }

    @Override
    public List<Fumetteria> getFumetterie(Fumetto f) {
        
        List<Fumetteria>fumetterie=new ArrayList<Fumetteria>();
        List<Negoziante> list=GestioneAcquirenteController.dataStore.getNegozianti();
       
        for(Negoziante n:list){
            int count=0;
           for(NumeroCopie copie:n.getFumetteria().getCatalogo().getNumeroCopie()){
               
                if(copie.getFumetto().equals(f) && copie.getPrenotabile() &&copie.getDisponibilita()>0  ){
                    
                    //controllo prenotazioni pending 
                    count=0;
                    for(Prenotazione p:copie.getPrenotazioni()){
                    
                        LocalDateTime tempo2=p.getDataPrenotazione().plusDays(copie.getTempoValidita());
                        boolean expired=LocalDateTime.now().isAfter(tempo2);
                        
                        if(!p.isCompletata() && !expired){
                            count++;
                        }
                    
                      
                    
                    }
                    if(count>=copie.getDisponibilita()){

                        System.out.println("non prenotabile");
    
                    }else{
                        fumetterie.add(n.getFumetteria());
                    }
                
                } 
                
            }
        
        }
        return fumetterie;
    }

    @Override
    public List<Fumetto> getFumetti() {
        
        List<Fumetto>fumetti=new ArrayList<Fumetto>();
        fumetti=GestioneAcquirenteController.dataStore.getFumetti();

        return fumetti;
    }
    
}
