package controller.interfacce.iAcquirente;

import java.util.List;

import model.notifiche.Notifica;
import model.user.Acquirente;

public interface IVisualizzaNotifiche {
    public List<Notifica> getNotifiche(Acquirente a);
    public void segnaComeGiaLetto(Notifica n);
    
    
}
