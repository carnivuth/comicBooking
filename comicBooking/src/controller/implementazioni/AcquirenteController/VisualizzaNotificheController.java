package controller.implementazioni.AcquirenteController;

import java.util.List;

import controller.interfacce.iAcquirente.IVisualizzaNotifiche;
import model.notifiche.Notifica;
import model.user.Acquirente;
public class VisualizzaNotificheController implements IVisualizzaNotifiche{

    @Override
    public List<Notifica> getNotifiche(Acquirente a) {
        
        return a.getNotifiche();
        
    }

    @Override
    public void segnaComeGiaLetto(Notifica n) {
       
        n.segnaComeLetto();
    }
    
}
