function richiediFumettiPerPrenotazione(){
    request(uriServer + "?operazione=fumettiPerPrenotazione", myGetElementById("fumettiPerPrenotazione"));
}

fumetti

function stampaFumettiPerPrenotazione(callback, result){

    fumetti = result;

    callback.innerHTML += ("Titolo" + tab + "Numero" + "tab" + Conferma + "<br>")

    for (var i=0; i<result.length; i++){
        f = result[i];
        
        callback.innerHTML += (f.titolo + tab + f.numero + tab);
        callback.innerHTML += "<button type=\"button\" value=\"" + i + "\" onclick=\"richiediFumetteriaPerPrenotazione(this.value)\">Seleziona</button> ";
        callback.innerHTML += "<br";
    }
}

function richiediFumetteriaPerPrenotazione(numeroFumetto){
    numeroFumetto = parseInt(numeroFumetto);
    f = fumetti[numeroFumetto];
    jsonFumetto = JSON.stringify(f);
    request(uriServer + "?operazione=fumetteriePerPrenotazione&fumetto="+jsonFumetto, myGetElementById("fumettiPerPrenotazione"));
}