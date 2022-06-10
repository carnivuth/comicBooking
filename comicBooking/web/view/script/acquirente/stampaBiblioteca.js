function printBiblioteca(callback, result){
    
    result = result.fumetti;

    callback.innerHTML = "Titolo" + tab + "Numero" + tab + "Serie" + tab + "Descrizione" + tab + "Casa Editrice<br>";


    for (var i=0; i<result.length; i++) {
        f = result[i];
        
        callback.innerHTML += (f.titolo + tab + f.numero + tab + f.serie.titolo + tab + f.descrizione + tab + f.casaEditrice);
        
        callback.innerHTML += '<br>'
        
     }
}

function richiediBiblioteca(){
    request(uriServerAcquirente + "?operazione=biblioteca", myGetElementById("biblioteca"));
}