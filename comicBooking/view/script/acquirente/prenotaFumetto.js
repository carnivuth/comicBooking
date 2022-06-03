function richiediFumettiPerPrenotazione(){
    request(uriServer + "?operazione=fumettiPerPrenotazione", myGetElementById("fumettiPerPrenotazione"));
}

function stampaFumettiPerPrenotazione(callback, result){

    callback.innerHTML += ("Titolo" + tab + "Numero" + "tab" + Conferma + "<br>")

    for (var i=0; i<result.length; i++){
        f = result[i];
        
        callback.innerHTML += (f.titolo + tab + f.numero);
    }
    <button type="button" onclick="richiediFumetteriaPerPrenotazione(this)">Click Me!</button> 
}