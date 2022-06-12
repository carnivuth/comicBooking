function richiediFumettiPerPrenotazione(){
    request(uriServerAcquirente + "?operazione=fumettiPerPrenotazione", myGetElementById("fumettiPerPrenotazione"), "get");
}

fumetti = "";
jsonFumetto = "";

function stampaFumettiPerPrenotazione(callback, result){

    fumetti = result;

    callback.innerHTML += ("Titolo" + tab + "Numero" + tab + "Conferma" + "<br>")

    for (var i=0; i<result.length; i++){
        f = result[i];
        
        callback.innerHTML += (f.titolo + tab + f.numero + tab);
        callback.innerHTML += "<button type=\"button\" value=\"" + i + "\" onclick=\"richiediFumetteriaPerPrenotazione(this.value)\">Seleziona</button> ";
        callback.innerHTML += "<br>";
    }
}

function richiediFumetteriaPerPrenotazione(numeroFumetto){
    numeroFumetto = parseInt(numeroFumetto);
    f = fumetti[numeroFumetto];
    jsonFumetto = JSON.stringify(f);
    paramsName = [];
    paramsName[0] = "fumetto";
    params = [];
    params[0] = jsonFumetto;
    request(uriServerAcquirente + "?operazione=fumetteriePerPrenotazione", myGetElementById("fumettiPerPrenotazione"), "post", paramsName, params);
}

fumetterie = "";
jsonFumetteria = "";

function stampaFumetteriePerPrenotazione(callback, result){
    
    fumetterie = result;
    
    callback.innerHTML += ("Nome" + tab + "Citta" + tab + "Indirizzo" + "<br>");

    for (var i=0; i<result.length; i++){
        f = result[i];
        
        callback.innerHTML += (f.nome + tab + f.citta + tab + f.indirizzo + tab);
        callback.innerHTML += "<button type=\"button\" value=\"" + i + "\" onclick=\"richiediPrenotazione(this.value)\">Seleziona</button> ";
        callback.innerHTML += "<br";
    }
}

function richiediPrenotazione(numeroFumetteria){
    numeroFumetteria = parseInt(numeroFumetteria);
    f = fumetterie[numeroFumetteria];
    jsonFumetteria = JSON.stringify(f);

    paramsName = [];
    paramsName[0] = "fumetto";
    paramsName[1] = "fumetteria";
    params = [];
    params[0] = jsonFumetto;
    params[1] = jsonFumetteria;

    request(uriServerAcquirente + "?operazione=richiediPrenotazione", myGetElementById("fumettiPerPrenotazione"), "post", paramsName, params);

}

function risultatoPrenotazione(callback, result){
    if (result == true) alert("Prenotazione effettuata");
    else alert("Operazione non andata a buon fine");
}