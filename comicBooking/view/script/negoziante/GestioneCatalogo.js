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
    request(uriServer + "?operazione=catalogo", myGetElementById("catalogo"));
}

function changePrenotabile(elementNumber) {
    fum = result[elementNumber];
    fumettoDaCambiare = JSON.stringify(fum);
    request(uriServer + "?operazione=changePrenotabile&fumettoDaCambiare=" + fumettoDaCambiare);
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

    request(uriServer + "?operazione=aggiungiFumettoCatalogo&fumettoDaInserire=" + fumettoDaInserire + "&quantita=" + quantita);
}

elencoFumetti;

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
    request(uriServer + "?operazione=rimuoviFumettoCatalogo&fumettoDaRimuovere=" + fumettoDaRimuovere);
}