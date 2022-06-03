function printBiblioteca(callback, result){

    result = result.interessi;
    callback.innerHTML = "Tipologia" + tab + "Nome" + "<br>";


    for (var i=0; i<result.length; i++) {
        f = lista[i];

        callback.innerHTML += (f.titolo + tab + f.numero + tab + f.serie.titolo + tab + f.descrizione + tab + f.casaEditrice);
        
        callback.innerHTML += '<br>'
        
     }
}

function richiediInteressi(){
    request(uriServer + "?operazione=interessi", myGetElementById("interessi"));
}