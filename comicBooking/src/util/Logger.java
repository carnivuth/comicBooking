package util;

import java.io.FileWriter;

public class Logger {

    private String file = "comicBooking/src/util/log.txt";
    

    public Logger(){
        
    }

    public void scrivi(String x){
        FileWriter log;

        try{
            log = new FileWriter(file);
            log.write(x);
            log.write(System.lineSeparator());
            log.flush();
            log.close();
        }catch(Exception e){}


    }

    

   

    


    
}
