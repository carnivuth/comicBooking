package controller.usersstore;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import controller.interfacce.iPercistance.IUsersStore;
import model.user.Acquirente;
import model.user.Negoziante;
import model.user.Utente;

public class MemoryUsersStoreController implements IUsersStore {
    private Map<Utente,String> usersPassword;

    public MemoryUsersStoreController(){
        usersPassword=new HashMap<Utente,String>();
        init();
    }

    private void init(){
        Utente u=new Acquirente();
        u.setUsername("pippo");
        u.setBloccato(false);
        u.setNumeroTentativi(0);
        usersPassword.put(u, "pippo");


        u=new Negoziante();
        u.setUsername("pluto");
        u.setBloccato(false);
        u.setNumeroTentativi(0);
        usersPassword.put(u, "pluto");
    }

    @Override
    public String verificaCredenziali(String Username, String Password) {
        for(Utente u:usersPassword.keySet()){
            if(u.getUsername().equals(Username)){
                if(!u.isBloccato()){
                    if(usersPassword.get(u).equals(Password)){
                        if(u instanceof Acquirente){
                            return "Acquirente";
                        }
                        if(u instanceof Negoziante){
                            return "Negoziante";
                        }
                    }
                if(u.getNumeroTentativi()>=3){
                    u.setBloccato(true);
                    u.setTimestampBlocco(LocalDateTime.now());
                }else{
                    u.setNumeroTentativi(u.getNumeroTentativi()+1);

                }
                
                }
                if(u.getTimestampBlocco()!=null && u.getTimestampBlocco().plusMinutes(1).isAfter(LocalDateTime.now())){
                    u.setBloccato(false);
                }
            }
        }
        return "false";
    }
    
}
