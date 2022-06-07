package controller.implementazioni.AcquirenteController;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.datastore.*;
import controller.interfacce.iAcquirente.IGestioneAcquirente;
import controller.interfacce.iAcquirente.IPrenotaFumetto;
import controller.interfacce.iAcquirente.IVisualizzaNotifiche;
import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;
import model.Wrapper;
import model.fumetteria.Fumetteria;
import model.fumetto.Fumetto;
import model.user.Acquirente;

public class GestioneAcquirenteController extends HttpServlet implements IGestioneAcquirente {

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
                    case "biblioteca":
                        
                        break;

                    case "notifiche":
                        IVisualizzaNotifiche notifiche= new VisualizzaNotificheController();
                        if(req.getSession().getAttribute("username")!=null){

                            String username=(String) req.getSession().getAttribute("username"); 

                            Wrapper w= new Wrapper();
                            w.setResult(notifiche.getNotifiche(dataStore.getAcquirente(username)));
                            w.setOperazione("notifiche");
                           
                            resp.getWriter().println(g.toJson(w));
                        }
                       
                        break;
                    case "fumettiPerPrenotazione":
                        IPrenotaFumetto prenota= new PrenotaFumettoController();
                        Wrapper w= new Wrapper();
                        w.setResult(prenota.getFumetti());
                        w.setOperazione("fumettiPerPrenotazione");
                        resp.getWriter().println(g.toJson(w));
                        break;

                    case "fumetteriePerPrenotazione":
                        IPrenotaFumetto prenota2= new PrenotaFumettoController();
                        String gFumetto=(String) req.getSession().getAttribute("fumetto"); 
                        Fumetto f= g.fromJson(gFumetto, Fumetto.class);

                        Wrapper w1= new Wrapper();
                        w1.setResult(prenota2.getFumetterie(f));
                        w1.setOperazione("fumetteriePerPrenotazione");
                        resp.getWriter().println(g.toJson(w1));

                        break;  

                    case "richiediPrenotazione":

                        IPrenotaFumetto prenotaFinal= new PrenotaFumettoController();

                        String acquirente=(String) req.getSession().getAttribute("username"); 
                        Acquirente a= dataStore.getAcquirente(acquirente);

                        String gsonFumetto=(String) req.getSession().getAttribute("fumetto"); 
                        Fumetto fumetto= g.fromJson(gsonFumetto, Fumetto.class);
                        String gFumetteria=(String) req.getSession().getAttribute("fumetteria"); 
                        Fumetteria fumetteria= g.fromJson(gFumetteria, Fumetteria.class);
                        Wrapper w2= new Wrapper();

                        w2.setResult(prenotaFinal.prenotaFumetto(fumetto, fumetteria, a));
                        w2.setOperazione("richiediPrenotazione");
                        resp.getWriter().println(g.toJson(w2));
                        
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
