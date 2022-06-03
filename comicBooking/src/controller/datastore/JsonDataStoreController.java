package controller.datastore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import controller.interfacce.iPercistance.IDataStore;
import model.user.Acquirente;
import model.user.Negoziante;

public class JsonDataStoreController implements IDataStore {

    private Acquirente a;
    private Negoziante n;

    public JsonDataStoreController(){
        init();
    }
    
    @Override
    public Acquirente getAcquirente(String username) {
        return a;
    }

    
    

    @Override
    public Negoziante getNegoziante(String username) {
        
        return n;
    }

    @Override
    public void setAcquirente(Acquirente a) {
        this.a=a;
        
    }

    @Override
    public void setNegoziante(Negoziante n) {
        this.n=n; 
    }

    private void init(){
        String buffer="";
        String jsonData="";
        Gson g=new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("resources/dbcomicxacquirente.json")))) {
          
            while((buffer=reader.readLine())!=null)jsonData+=buffer;
            a=g.fromJson(jsonData, Acquirente.class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer="";
        jsonData="";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("resources/dbcomicxnegoziante.json")))) {
          
            while((buffer=reader.readLine())!=null)jsonData+=buffer;
            n=g.fromJson(jsonData, Negoziante.class);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    
}
