package controller.interfacce.iPercistance;

import java.util.List;

import model.fumetto.Fumetto;
import model.user.Acquirente;
import model.user.Negoziante;

public interface IDataStore {

    public Acquirente getAcquirente(String username);
    public Negoziante getNegoziante(String username);
    public List<Negoziante> getNegozianti();
    public void setAcquirente(Acquirente a);
    public void setNegoziante(Negoziante n);
    public List<Fumetto> getFumetti();
    
}
