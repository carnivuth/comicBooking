function printNotifiche(callback, stringaJson){
    
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

    callback.innerHTML
	//nel div matrix stampo le text area
    var div=myGetElementById('matrix');
    //var str='<input type="text" id="'+i+j+'" value="1" onchange="calcola()">';
    div.innerHTML="";

    for(var i=0; i<x; i++){
        for(var j=0; j<y; j++){
            div.innerHTML+=('<input type="text" id="'+i+j+'" value="1" onchange="calcola()">');
        }
        div.innerHTML+='<br>';
    }
}

function segnaComeLetto(){

}