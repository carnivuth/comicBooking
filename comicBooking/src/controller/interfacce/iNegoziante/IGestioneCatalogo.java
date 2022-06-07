package controller.interfacce.iNegoziante;



import model.fumetteria.Catalogo;
import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.user.Negoziante;

public interface IGestioneCatalogo {

    public boolean rendiVolumePrenotabile(Fumetto f, Integer giorni, Negoziante n);
    public boolean rendiVolumeNonPrenotabile(Fumetto f,  Negoziante n);
    public boolean aggiungiFumetto(Fumetto f,int disponibilita, Negoziante n);
    public boolean rimuoviFumetto(Fumetto f, Negoziante n);
    public void scatenaEvento(boolean b ,Fumetto f,Fumetteria fumetteria);
    public Catalogo getCatalogo(Negoziante n);
}

