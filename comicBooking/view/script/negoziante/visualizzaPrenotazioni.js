function richiediTuttePrenotazioniNegoziante(){
    request(uriServer + "?operazione=visualizzaPrenotazioni", myGetElementById("tuttePrenotazioni"));
}

function printPrenotazioniNegoziante(callback, result){

    callback.innerHTML += ("Fumetto" + tab + "Acquirente" + tab + "completato" + "<br>")

    for (var i = 0; i < result.length; i++) {
        acquirente = result[i].acquirente.username;
        fumetto = result[i].copia.fumetto;
        completata = result[i].completata;

        callback.innerHTML += (fumetto + tab + acquirente + tab + completato + "<br>")

    }

}