package controller.datastore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import controller.interfacce.iPercistance.IDataStore;
import model.fumetto.Fumetto;
import model.user.Acquirente;
import model.user.Negoziante;

public class JsonDataStoreController implements IDataStore {

    private Acquirente a;
    private Negoziante n;
   private List<Fumetto> fumetti;

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
             
            e.printStackTrace();
        }

        buffer="";
        jsonData="";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("resources/dbcomicxfumetti.json")))) {
          
            while((buffer=reader.readLine())!=null)jsonData+=buffer;
            fumetti=(List<Fumetto>) g.fromJson(jsonData, List.class);
            
        } catch (IOException e) {
             
            e.printStackTrace();
        }



    }

    @Override
    public List<Negoziante> getNegozianti() {
        
        List<Negoziante> result=new ArrayList<>();
        result.add(n);
        return result;
    }

    @Override
    public List<Fumetto> getFumetti() {
       
        return fumetti;
    }

  

    
}
