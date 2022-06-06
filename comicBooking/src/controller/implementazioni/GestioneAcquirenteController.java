package controller.implementazioni;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.datastore.*;
import controller.interfacce.iAcquirente.IGestioneAcquirente;
import controller.interfacce.iAcquirente.IVisualizzaNotifiche;
import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;
import model.Wrapper;

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
                        dataStore.getFumetti();
                        break;

                    case "interessi":
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
