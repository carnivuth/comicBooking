import java.util.ArrayList;
import java.util.List;


import model.biblioteca.Biblioteca;
import model.fumetteria.Catalogo;
import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.fumetto.Serie;
import model.user.Acquirente;
import model.user.Negoziante;

public class JsonMaker {
    public static void main(String args[]){
        Acquirente u1=new Acquirente();
        Biblioteca b1 =new Biblioteca();
        List<Fumetto> fumettiA=new ArrayList<Fumetto>();
        
        Serie s=new Serie();
        s.setAutore("provaAutore");
        s.setTitolo("provaTitolo");
        
        Fumetto f =new Fumetto();
        f.setSerie(s);
        f.setNumero(1);
        f.setDescrizione("descrizione 1");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);

        //creazione fumetti acquirente
         f =new Fumetto();
        f.setSerie(s);
        f.setNumero(2);
        f.setDescrizione("descrizione 2");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);

        
         f =new Fumetto();
        f.setSerie(s);
        f.setNumero(3);
        f.setDescrizione("descrizione 3");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);

        f =new Fumetto();
        f.setSerie(s);
        f.setNumero(4);
        f.setDescrizione("descrizione 4");
        f.setCasaEditrice("provacasaEditrice");
        fumettiA.add(f);
       
        b1.setFumetti(fumettiA);
        u1.setBiblioteca(b1);
        u1.setUsername("pippo");

        

        Negoziante n1=new Negoziante();
        n1.setUsername("pluto");
        Fumetteria f1=new Fumetteria();
        f1.setCitta("bologna");
        f1.setIndirizzo("indirizzo");
        f1.setNome("nome");
        Catalogo c1=new Catalogo();
        List<Fumetto> fumettiN=new ArrayList<Fumetto>();

        //creazione fumetti negoziante
        f =new Fumetto();
        f.setSerie(s);
        f.setNumero(5);
        f.setDescrizione("descrizione 5");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);

        
         f =new Fumetto();
        f.setSerie(s);
        f.setNumero(5);
        f.setDescrizione("descrizione 5");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);

        f =new Fumetto();
        f.setSerie(s);
        f.setNumero(5);
        f.setDescrizione("descrizione 5");
        f.setCasaEditrice("provacasaEditrice");
        fumettiN.add(f);

        c1.setFumetti(fumettiN);
        


    }
}
