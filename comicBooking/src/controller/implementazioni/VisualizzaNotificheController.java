package controller.implementazioni;

import java.util.List;

import controller.interfacce.iAcquirente.IVisualizzaNotifiche;
import model.notifiche.Notifica;
import model.user.Acquirente;
public class VisualizzaNotificheController implements IVisualizzaNotifiche{

    @Override
    public List<Notifica> getNotifiche(Acquirente a) {
        // TODO Auto-generated method stub
        return a.getNotifiche();
        
    }

    @Override
    public void segnaComeGiaLetto(Notifica n) {
        // TODO Auto-generated method stub
        n.segnaComeLetto();
    }
    
}
