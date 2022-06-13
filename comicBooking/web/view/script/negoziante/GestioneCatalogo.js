result = "";

function printCatalogo(callback, result) {

    result = result.fumetti;

    buttonPerRimuovere1 = "<button type=\"button\" value=\"";
    buttonPerRimuovere2 = "\" onclick=\"rimuoviFumettoCatalogo(this.value)\">X</button>";

    callback.innerHTML = "Titolo" + tab + "Numero" + tab + "NumeroCopie" + tab + "Prenotabile" + "<br>";

    buttonTrue1 = "<button type=\"button\" value=\"";
    buttonTrue2 = "\" onclick=\"changePrenotabile(this.value)\">Prenotabile</button>";

    buttonFalse1 = "<button type=\"button\" value=\"";
    buttonFalse2 = "\" onclick=\"changePrenotabile(this.value)\">Non prenotabile</button>";

    for (var i = 0; i < result.length; i++) {
        f = result[i];
        disp = f.disponibilita;
        pren = f.prenotanile;
        fumetto = f.fumetto

        butt = "";
        if (pren == true) {
            butt = buttonTrue1 + i + buttonTrue2;
        } else {
            butt = buttonFalse1 + i + buttonFalse2;
        }


        callback.innerHTML += (fumetto.titolo + tab + fumetto.numero + tab + disp + tab + butt);

        callback.innerHTML += '<br>'

    }
}

function richiediCatalogo() {
    request(uriServerNegoziante + "?operazione=catalogo", myGetElementById("catalogo"), "get");
}

function changePrenotabile(elementNumber) {
    fum = result[elementNumber];
    fumettoDaCambiare = JSON.stringify(fum);

    ok = false;
    giorni = 0;
    while (!ok){
        pr = prompt("Inserisci la quantità");
        giorni = parseInt(quantita);
        if (quantita > 0){
            ok = true;
        }
    }

    paramsName = [];
    paramsName[0] = "operazione";
    paramsName[1] = "fumettoDaCambiare";
    paramsName[2] = "giorni";
    params = [];
    params[0] = "changePrenotabile";
    params[1] = fumettoDaCambiare;
    params[2] = giorni;

    request(uriServerNegoziante, myGetElementById("catalogo"), "post", paramsName, params);
}

function richiediListaFumetti(){
    request(uriServerNegoziante + "?operazione=richiediListaFumetti", myGetElementById("fumettiAggiuntaCatalogo"), "get")
}

function aggiungiFumetto(elementNumber) {
    fum = result[elementNumber];
    fumettoDaInserire = JSON.stringify(fum);

    ok = false;
    quantita;
    while (!ok){
        pr = prompt("Inserisci la quantità");
        quantita = parseInt(quantita);
        if (quantita > 0){
            ok = true;
        }
    }

    paramsName = [];
    paramsName[0] = "operazione";
    paramsName[1] = "fumettoDaInserire";
    paramsName[2] = "quantita";
    params = [];
    params[0] = "aggiungiFumettoCatalogo";
    params[1] = fumettoDaInserire;
    params[2] = quantita;

    request(uriServerNegoziante, myGetElementById("catalogo"), "post",  paramsName, params);
}

elencoFumetti;
fumettoDaInserire;

function stampaFumettiPerAggiunta(callback, result) {

    fumetti = result;
    elencoFumetti = fumetti;

    callback.innerHTML += ("Titolo" + tab + "Numero" + "tab" + Conferma + "<br>")

    for (var i = 0; i < result.length; i++) {
        f = result[i];

        callback.innerHTML += (f.titolo + tab + f.numero + tab);
        callback.innerHTML += "<button type=\"button\" value=\"" + i + "\" onclick=\"aggiungiFumetto(this.value)\">Seleziona</button> ";
        callback.innerHTML += "<br";
    }
}

function rimuoviFumettoCatalogo(elementNumber){
    fum = result[elementNumber];
    fumettoDaRimuovere = JSON.stringify(fum);

    paramsName = [];
    paramsName[0] = "operazione";
    paramsName[1] = "fumettoDaRimuovere";
    
    params = [];
    params[0] = "rimuoviFumettoCatalogo";
    params[1] = fumettoDaRimuovere;

    request(uriServer + "?operazione=rimuoviFumettoCatalogo&fumettoDaRimuovere=" + fumettoDaRimuovere, myGetElementById("catalogo"), "post",  paramsName, params);
}

function scatenaEvento(){
    paramsName = [];
    paramsName[0] = "operazione";
    paramsName[1] = "fumettoNotifica";
    
    params = [];
    params[0] = "scatenaEvento";
    params[1] = fumettoDaInserire;
    request(uriServerNegoziante, myGetElementById("catalogo"), "post", paramsName, params); 
}