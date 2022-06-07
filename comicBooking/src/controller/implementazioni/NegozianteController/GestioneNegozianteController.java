package controller.implementazioni.NegozianteController;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.datastore.DataStoreControllerFactory;
import controller.interfacce.iNegoziante.IGestioneCatalogo;
import controller.interfacce.iNegoziante.IGestioneNegoziante;
import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;
import model.Wrapper;
import model.fumetto.Fumetto;

public class GestioneNegozianteController extends HttpServlet implements IGestioneNegoziante {

    public static  IDataStore dataStore;
    @Override
    public void init(ServletConfig conf) throws ServletException {

        super.init(conf);
        IDataStoreFactory factory = new DataStoreControllerFactory();
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
                w.setResult(c.getCatalogo (dataStore.getNegoziante(username)));
                w.setOperazione("catalogo");
                           
                resp.getWriter().println(g.toJson(w));
                break;

            case "changePrenotabile":
                IGestioneCatalogo c1=new GestioneCatalogoController();
                String neg=(String) req.getSession().getAttribute("username"); 
                String gFumetto=(String) req.getAttribute("fumettoDaCambiare"); 
                Fumetto f= g.fromJson(gFumetto, Fumetto.class);
                int giorni=(int) req.getSession().getAttribute("giorni"); 
                c1.rendiVolumePrenotabile(f, giorni, dataStore.getNegoziante(neg));
                //send
                Wrapper w1= new Wrapper();
                w1.setResult(c1.getCatalogo (dataStore.getNegoziante(neg)));
                w1.setOperazione("changePrenotabile");
                           
                resp.getWriter().println(g.toJson(w1));

                break;
            case "aggiungiFumettoCatalogo":
                IGestioneCatalogo c2=new GestioneCatalogoController();
                String negoz=(String) req.getSession().getAttribute("username"); 
                String gFum=(String) req.getAttribute("fumettoDaInserire"); 
                Fumetto fum= g.fromJson(gFum, Fumetto.class);
                int quantita=(int) req.getAttribute("quantita"); 
                c2.aggiungiFumetto(fum, quantita, dataStore.getNegoziante(negoz));

                Wrapper w2= new Wrapper();
                w2.setResult(c2.getCatalogo (dataStore.getNegoziante(negoz)));
                w2.setOperazione("aggiungiFumettoCatalogo");
                break;

            case "rimuoviFumettoCatalogo":

                IGestioneCatalogo c3=new GestioneCatalogoController();
                String n=(String) req.getSession().getAttribute("username"); 
                String nomefum=(String) req.getAttribute("fumettoDaRimuovere"); 
                Fumetto fumett= g.fromJson(nomefum, Fumetto.class);
                c3.rimuoviFumetto(fumett, dataStore.getNegoziante(n));

                Wrapper w3= new Wrapper();
                w3.setResult(c3.getCatalogo (dataStore.getNegoziante(n)));
                w3.setOperazione("rimuoviFumettoCatalogo");

                break;  

            case "richiediListaFumetti":

               
                
                break;  

            default:
                break;
        }
        
}

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
