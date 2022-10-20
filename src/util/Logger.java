package util;

import java.io.FileWriter;

public class Logger {

    private String file = "log.txt"/*"/home/luca/Desktop/log.txt"*/;
    

    public Logger(){
        
    }

    public void scrivi(String x){
        FileWriter log;

        try{
            log = new FileWriter(file);
            log.append(x);
            log.append(System.lineSeparator());
            log.flush();
            log.close();
        }catch(Exception e){}


    }

    

   

    


    
}
