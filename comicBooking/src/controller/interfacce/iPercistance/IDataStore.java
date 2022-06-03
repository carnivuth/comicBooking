package controller.interfacce.iPercistance;

import model.user.Acquirente;
import model.user.Negoziante;

public interface IDataStore {

    public Acquirente getAcquirente(String username);
    public Negoziante getNegoziante(String username);
    public void setAcquirente(Acquirente a);
    public void setNegoziante(Negoziante n);
    
}
