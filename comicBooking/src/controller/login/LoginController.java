package controller.login;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.interfacce.iPercistance.IUsersStore;
import controller.interfacce.iPercistance.IUsersStoreFactory;
import controller.interfacce.ilogin.ILogin;
import controller.usersstore.MemoryUsersStoreFactory;

public class LoginController extends HttpServlet implements ILogin{

    public static IUsersStore usersStore;

    @Override
    public void init(ServletConfig conf) throws ServletException {

        super.init(conf);
        IUsersStoreFactory factory = new MemoryUsersStoreFactory();
        usersStore = factory.createInstance();
    }

    @Override
    public String verificaCredenziali(String username, String password) {
        
        String ruolo = LoginController.usersStore.verificaCredenziali(username, password);

        return ruolo;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String u = req.getParameter("username");
		String p = req.getParameter("password");

        if (u!=null && p!=null){
            String ruolo = this.verificaCredenziali(u, p);

            if (ruolo.compareTo("false")!=0){

                Cookie cookie = new Cookie("username", u);
                resp.addCookie(cookie);

                if (ruolo.compareTo("acquirente")==0){
                    resp.sendRedirect(req.getContextPath()+"/HomeGestioneAcquirente.html");
                }
                if (ruolo.compareTo("negoziante")==0){
                    resp.sendRedirect(req.getContextPath()+"/HomeGestioneNegoziante.html");
                }

            }
            else{
                Gson g = new Gson();
                boolean res = false;
                resp.getWriter().println(g.toJson(res));
                //resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }
        }
    }

    
}