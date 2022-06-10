function printInteressi(callback, result){

    result = result.interessi;
    callback.innerHTML = "Tipologia" + tab + "Nome" + "<br>";


    for (var i=0; i<result.length; i++) {
        f = lista[i];
        classe = f.constructor.name;

        callback.innerHTML += classe;
        if (classe==="Serie"){
            callback.innerHTML += f.tipo;
        }
        if (classe==="Fumetteria"){
            callback.innerHTML += f.nome;
        }
        if (classe==="Serie"){
            callback.innerHTML += f.titolo;
        }
 
        callback.innerHTML += '<br>'
     }
}

function richiediInteressi(){
    request(uriServerAcquirente + "?operazione=interessi", myGetElementById("interessi"));
}