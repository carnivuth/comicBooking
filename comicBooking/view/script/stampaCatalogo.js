function printCatalogo(callback, stringaJson){
    
    lista = JSON.parse(theXhr.responseText);
    callback.innerHTML = "Fumetto\tFumetteria\tSegnaComeLetto";

    for (var i=0; i<lista.length; i++) {
        f = lista[i].getFumetto();
        fumetteria = lista[i].getFumetteria();
        checkbox = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" onclick=\"segnaComeLetto(this)\">";
        checkboxSi = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" checked >";
        
        callback.innerHTML += (f.getTitolo() + " " + f.getNumero() + "\t" + fumetteria.getNome() + "\t");
        
        if (lista[i].isVisualizzato()){
            callback.innerHTML += checkboxSi;
        }
        else{
            callback.innerHTML += checkbox;
        }
        innerHTML += '<br>'
        
     }
}

function segnaComeLetto(){
    
}