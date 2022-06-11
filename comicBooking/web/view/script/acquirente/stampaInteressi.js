function printInteressi(callback, result){

    zzzzzz = result.interessi;
    callback.innerHTML = "Tipologia" + tab + "Nome" + "<br>";
    callback.innerHTML += zzzzzz;


    /*for (var i=0; i<zzzzzz.size; i++) {
        f = zzzzzz[i];
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
     }*/
}

function richiediInteressi(){
    request(uriServerAcquirente + "?operazione=interessi", myGetElementById("interessi"));
}