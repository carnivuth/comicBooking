function printBiblioteca(callback, result){
    
    result = result.fumetti;

    callback.innerHTML = "Titolo\tNumero\tSerie\tDescrizione\tCasa Editrice<br>";


    for (var i=0; i<result.length; i++) {
        f = lista[i];

        callback.innerHTML += (f.titolo + " " + f.numero + "\t" + f.serie.titolo + "\t" + f.descrizione + "\t" + f.casaEditrice);
        
        callback.innerHTML += '<br>'
        
     }
}

