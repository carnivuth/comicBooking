function printInteressi(callback, result){

    zzzzzz = result.interessi;
    callback.innerHTML = "Tipologia" + tab + "Nome" + "<br>";
    //callback.innerHTML += zzzzzz;
    

    for (var i=0; i<zzzzzz.length; i++) {
        f = zzzzzz[i];
        //classe = f.constructor.name;
        //alert(f.constructor);
        //alert(f.constructor.name);

        /*callback.innerHTML += classe;
        if (classe==="Serie"){
            callback.innerHTML += f.tipo;
        }
        if (classe==="Fumetteria"){
            callback.innerHTML += f.nome;
        }
        if (classe==="Serie"){
            callback.innerHTML += f.titolo;
        }*/

        text = "";
        var j = 0;
        for (const x in f) {
            if (j < 3){
                text += f[x];
            }
            if (j < 2){
                text += ",";
            }
            j += 1;
        }
 
        callback.innerHTML += text + "<br>";
     }
}

function richiediInteressi(){
    request(uriServerAcquirente + "?operazione=interessi", myGetElementById("interessi"), "get");
}