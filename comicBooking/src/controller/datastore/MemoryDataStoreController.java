package controller.datastore;

import java.util.ArrayList;
import java.util.List;

import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;
import model.biblioteca.Biblioteca;
import model.fumetteria.Catalogo;
import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.fumetto.Serie;
import model.interessi.Interessi;
import model.notifiche.Notifica;
import model.user.Acquirente;
import model.user.Negoziante;

public class MemoryDataStoreController implements IDataStore {

    private List<Acquirente> acquirenti;
    private List<Negoziante> negozianti;
    private List<Fumetto> fumetti;

    private MemoryDataStoreController(){
        acquirenti=new ArrayList<Acquirente>();
        negozianti=new ArrayList<Negoziante>();
        init();
    }

   

    @Override
    public Acquirente getAcquirente(String username) {
        
        for(Acquirente a:this.acquirenti){
            if(a.getUsername().equals(username)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Negoziante getNegoziante(String username) {
        for(Negoziante n:this.negozianti){
            if(n.getUsername().equals(username))return n;
        }
        return null;
    }

    @Override
    public List<Negoziante> getNegozianti() {
       
        return negozianti;
    }

    @Override
    public List<Acquirente> getAcquirenti() {
       
        return acquirenti;
    }

    @Override
    public void setAcquirente(Acquirente a) {
       
        for(Acquirente a1:this.acquirenti){
            if(a1.getUsername().equals(a.getUsername())){
                a1=a;
                return;
            }
        }
        this.acquirenti.add(a);
        
    }

    @Override
    public void setNegoziante(Negoziante n) {
        
        for(Negoziante n1:this.negozianti){
            if(n1.getUsername().equals(n.getUsername())){
                n1=n;
                return;
            }
        }
        this.negozianti.add(n);
        
    }

    @Override
    public List<Fumetto> getFumetti() {
        
        return this.fumetti;
    }
    private void init(){
        Acquirente u1=new Acquirente();
        Biblioteca b1 =new Biblioteca();
        List<Fumetto> fumettiA=new ArrayList<Fumetto>();
        List<Fumetto> fumetti=new ArrayList<Fumetto>();
        
        Serie s=new Serie();
        s.setAutore("provaAutore");
        s.setTitolo("provaTitolo");
        
        Fumetto f =new Fumetto();
        f.setSerie(s);
        f.setTitolo("titolo1");
        f.setNumero(1);
        f.setDescrizione("descrizione 1");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);
        fumetti.add(f);

        //creazione fumetti acquirente
         f =new Fumetto();
         f.setTitolo("titolo2");
        f.setSerie(s);
        f.setNumero(2);
        f.setDescrizione("descrizione 2");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);
        fumetti.add(f);

        
         f =new Fumetto();
        f.setSerie(s);
        f.setTitolo("titolo3");
        f.setNumero(3);
        f.setDescrizione("descrizione 3");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);
        fumetti.add(f);

        f =new Fumetto();
        f.setTitolo("titolo4");
        f.setSerie(s);
        f.setNumero(4);
        f.setDescrizione("descrizione 4");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);
        fumetti.add(f);
       
        b1.setFumetti(fumettiA);
        u1.setBiblioteca(b1);
        u1.setUsername("pippo");
        u1.setNotifiche(new ArrayList<Notifica>());

        

        Negoziante n1=new Negoziante();
        n1.setUsername("pluto");
        Fumetteria f1=new Fumetteria();
        f1.setCitta("bologna");
        f1.setIndirizzo("indirizzo");
        f1.setNome("nome");
        Interessi inter = new Interessi();
        inter.aggiungiInteresse(f1);
        u1.setInteressi(inter);
        //u1.getInteressi().aggiungiInteresse(f1);
        Catalogo c1=new Catalogo();
        List<Fumetto> fumettiN=new ArrayList<Fumetto>();

        //creazione fumetti negoziante
        f =new Fumetto();
        f.setSerie(s);
        f.setNumero(5);
        f.setTitolo("titolo5");
        f.setDescrizione("descrizione 5");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);
        fumetti.add(f);

        
         f =new Fumetto();
        f.setSerie(s);
        f.setTitolo("titolo6");
        f.setNumero(6);
        f.setDescrizione("descrizione 6");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);
        fumetti.add(f);

        f =new Fumetto();
        f.setSerie(s);
        f.setNumero(7);
        f.setTitolo("titolo7");
        f.setDescrizione("descrizione 7");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);
        fumetti.add(f);
  
        c1.setFumetti(fumettiN);
        f1.setCatalogo(c1);
        n1.setFumetteria(f1);
        

        this.acquirenti.add(u1);
        this.negozianti.add(n1);
        this.fumetti=fumetti;

        

    }

    private static MemoryDataStoreController mdsc = null;

    public static IDataStore createInstance() {
        if (mdsc == null){
            MemoryDataStoreController.mdsc = new MemoryDataStoreController();
        }
        return MemoryDataStoreController.mdsc;
    }
}