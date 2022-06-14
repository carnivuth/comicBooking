package controller.implementazioni.NegozianteController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.datastore.MemoryDataStoreControllerFactory;
import controller.interfacce.iNegoziante.IGestioneCatalogo;
import controller.interfacce.iNegoziante.IGestioneNegoziante;
import controller.interfacce.iNegoziante.IPrenotazione;
import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;
import model.Wrapper;
import model.fumetteria.Catalogo;
import model.fumetto.Fumetto;

public class GestioneNegozianteController extends HttpServlet implements IGestioneNegoziante {

    public static  IDataStore dataStore;
    @Override
    public void init(ServletConfig conf) throws ServletException {

        super.init(conf);
        IDataStoreFactory factory = new MemoryDataStoreControllerFactory();
         dataStore= factory.createInstance();
        
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException, NumberFormatException {
        Gson g= new Gson();
        String operazione=req.getParameter("operazione");
        switch (operazione) {
            case "catalogo":
                IGestioneCatalogo c=new GestioneCatalogoController();
                String username=(String) req.getSession().getAttribute("username"); 
               
                c.getCatalogo (dataStore.getNegoziante(username));
                //send
                Wrapper w= new Wrapper();
                Catalogo cat = c.getCatalogo (dataStore.getNegoziante(username));
                Catalogo cat2 = new Catalogo();
                cat2.setNumeroCopie(cat.getNumeroCopie()); 
                //w.setResult(cat2);
                w.setResult(cat.getNumeroCopie());
                w.setOperazione("catalogo");
                           
                resp.getWriter().println(g.toJson(w));
                break;

            case "richiediListaFumetti":

                Wrapper w4= new Wrapper();
                w4.setResult(dataStore.getFumetti());
                w4.setOperazione("richiediListaFumetti");

                resp.getWriter().println(g.toJson(w4));
                break;  

            
         
            case "visualizzaPrenotazioni":
                IPrenotazione p=new PrenotazioneController();
                String userN=(String) req.getSession().getAttribute("username"); 

                Wrapper w5= new Wrapper();
                w5.setResult(p.getPrenotazioni(dataStore.getNegoziante(userN).getFumetteria()));
                w5.setOperazione("visualizzaPrenotazioni");

                resp.getWriter().println(g.toJson(w5));
                break;

            default:
                break;
        }
        
}

    @Override
    public String getUsername() {
        
        return null;
    }

    private Catalogo getCatalogo(String username){
        
        IGestioneCatalogo c=new GestioneCatalogoController();
        c.getCatalogo (dataStore.getNegoziante(username));
        //send
        Wrapper w= new Wrapper();
        Catalogo cat = c.getCatalogo (dataStore.getNegoziante(username));

        return cat;
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    Gson g= new Gson();
    String operazione=req.getParameter("operazione");
    switch (operazione) {
        
        case "changePrenotabile":
            IGestioneCatalogo c1=new GestioneCatalogoController();
            String neg=(String) req.getSession().getAttribute("username"); 
            String gFumetto=(String) req.getAttribute("fumettoDaCambiare"); 
            Fumetto f= g.fromJson(gFumetto, Fumetto.class);
            //int giorni=(Integer) req.getAttribute("giorni"); 
            String gg = req.getParameter("giorni");
            int giorni = Integer.parseInt(gg);
            c1.rendiVolumePrenotabile(f, giorni, dataStore.getNegoziante(neg));
            //send
            Wrapper w1= new Wrapper();
            w1.setResult(c1.getCatalogo (dataStore.getNegoziante(neg)).getNumeroCopie());
            //w1.setResult(this.getCatalogo(neg));
            w1.setOperazione("changePrenotabile");
                       
            resp.getWriter().println(g.toJson(w1));

            break;
        case "aggiungiFumettoCatalogo":
            IGestioneCatalogo c2=new GestioneCatalogoController();
            String negoz=(String) req.getSession().getAttribute("username"); 
            //String gFum=(String) req.getAttribute("fumettoDaInserire"); 
            String gFum = req.getParameter("fumettoDaInserire");
            Fumetto fum= g.fromJson(gFum, Fumetto.class);
            //int quantita=(int) req.getAttribute("quantita"); 
            String qua = req.getParameter("quantita");
            int quantita = Integer.parseInt(qua);

            List<Fumetto> fumetti = dataStore.getFumetti();
            Fumetto f2 = null;
            for (Fumetto fu : fumetti){
                if (fu.equals(fum)){
                    f2 = new Fumetto();
                    f2.setTitolo(fu.getTitolo());
                    f2.setCasaEditrice(fu.getCasaEditrice());
                    f2.setNumero(fu.getNumero());
                    f2.setDescrizione(fu.getDescrizione());
                    f2.setSerie(fu.getSerie());
                    f2.setTutteRecensioni(fu.getTutteRecensioni());
                }
            }

            if (f2 != null){
                c2.aggiungiFumetto(f2, quantita, dataStore.getNegoziante(negoz));

                Wrapper w2= new Wrapper();
                w2.setResult(c2.getCatalogo (dataStore.getNegoziante(negoz)).getNumeroCopie());
                w2.setOperazione("aggiungiFumettoCatalogo");

                resp.getWriter().println(g.toJson(w2));
            }
            else{
                Wrapper w2= new Wrapper();
                fumetti.add(fum);
                w2.setResult(fumetti);
                w2.setOperazione("aggiungiFumettoCatalogo");

                resp.getWriter().println(g.toJson(w2));
            }

            break;

        case "rimuoviFumettoCatalogo":

            IGestioneCatalogo c3=new GestioneCatalogoController();
            String n=(String) req.getSession().getAttribute("username"); 
            String nomefum=(String) req.getAttribute("fumettoDaRimuovere"); 
            Fumetto fumett= g.fromJson(nomefum, Fumetto.class);
            c3.rimuoviFumetto(fumett, dataStore.getNegoziante(n));

            Wrapper w3= new Wrapper();
            w3.setResult(c3.getCatalogo (dataStore.getNegoziante(n)).getNumeroCopie());
            w3.setOperazione("rimuoviFumettoCatalogo");

            resp.getWriter().println(g.toJson(w3));

            break;  

         

        
        case "scatenaEvento":
            IGestioneCatalogo c4=new GestioneCatalogoController();
            
            String user=(String) req.getSession().getAttribute("username"); 
            //String nomef=(String) req.getAttribute("fumettoNotifica"); 
            String nomef = req.getParameter("fumettoNotifica");
            Fumetto fumetto= g.fromJson(nomef, Fumetto.class);

            List<Fumetto> fumettii = dataStore.getFumetti();
            Fumetto f3 = null;
            for (Fumetto fu : fumettii){
                if (fu.equals(fumetto)){
                    f3 = new Fumetto();
                    f3.setTitolo(fu.getTitolo());
                    f3.setCasaEditrice(fu.getCasaEditrice());
                    f3.setNumero(fu.getNumero());
                    f3.setDescrizione(fu.getDescrizione());
                    f3.setSerie(fu.getSerie());
                    f3.setTutteRecensioni(fu.getTutteRecensioni());
                }
            }

            c4.scatenaEvento(true, f3, dataStore.getNegoziante(user).getFumetteria());
            break; 

        default:
            break;
    }
    
}
    
}
