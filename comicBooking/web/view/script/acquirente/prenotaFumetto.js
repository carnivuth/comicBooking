function richiediFumettiPerPrenotazione(){
    request(uriServerAcquirente + "?operazione=fumettiPerPrenotazione", myGetElementById("fumettiPerPrenotazione"));
}

fumetti
jsonFumetto

function stampaFumettiPerPrenotazione(callback, result){

    fumetti = result;

    callback.innerHTML += ("Titolo" + tab + "Numero" + tab + "Conferma" + "<br>")

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
    request(uriServerAcquirente + "?operazione=fumetteriePerPrenotazione&fumetto="+jsonFumetto, myGetElementById("fumettiPerPrenotazione"));
}

fumetterie
jsonFumetteria

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

    request(uriServerAcquirente + "?operazione=richiediPrenotazione&fumetto=" + jsonFumetto + "&fumetteria" + jsonFumetteria, myGetElementById("fumettiPerPrenotazione"));

}

function risultatoPrenotazione(callback, result){
    if (result == true) alert("Prenotazione effettuata");
    else alert("Operazione non andata a buon fine");
}