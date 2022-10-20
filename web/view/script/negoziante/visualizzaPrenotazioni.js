function richiediTuttePrenotazioniNegoziante(){
    request(uriServerNegoziante + "?operazione=visualizzaPrenotazioni", myGetElementById("tuttePrenotazioni"), "get");
}

function printPrenotazioniNegoziante(callback, result){

    callback.innerHTML += ("Fumetto" + tab + "Acquirente" + tab + "completato" + "<br>")

    
    for (var i = 0; i < result.length; i++) {
        acquirente = result[i].acquirente.username;
        fumetto = result[i].copia.fumetto.titolo;
        completata = result[i].completata;

        callback.innerHTML += (fumetto + tab + acquirente + tab + completata + "<br>")

    }

}