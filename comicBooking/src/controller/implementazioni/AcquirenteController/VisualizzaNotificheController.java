package controller.implementazioni.AcquirenteController;

import java.util.ArrayList;
import java.util.List;

import controller.interfacce.iAcquirente.IVisualizzaNotifiche;
import model.notifiche.Notifica;
import model.user.Acquirente;
public class VisualizzaNotificheController implements IVisualizzaNotifiche{

    @Override
    public List<Notifica> getNotifiche(Acquirente a) {
        
        List<Notifica> notifiche2 = new ArrayList<>();
        
        for (Notifica n : a.getNotifiche()){
            Notifica tmp = new Notifica();
            tmp.setFumetteria(n.getFumetteria());
            tmp.setFumetto(n.getFumetto());
            notifiche2.add(tmp);
        }
        return notifiche2;
    }

    @Override
    public void segnaComeGiaLetto(Notifica n) {
       
        n.segnaComeLetto();
    }
    
}
