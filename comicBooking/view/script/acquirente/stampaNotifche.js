function printNotifiche(callback, result){
    
    callback.innerHTML = "Fumetto\tFumetteria\tSegnaComeLetto<br>";

    for (var i=0; i<result.length; i++) {
        f = lista[i].fumetto;
        fumetteria = lista[i].fumetteria;
        checkbox = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" onclick=\"segnaComeLetto(this)\">";
        checkboxSi = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" checked >";
        
        callback.innerHTML += (f.titolo + " " + f.numero + "\t" + fumetteria.nome + "\t");
        
        if (lista[i].visualizzato){
            callback.innerHTML += checkboxSi;
        }
        else{
            callback.innerHTML += checkbox;
        }
        callback.innerHTML += '<br>'
        
     }
}

function segnaComeLetto(){

}

function richiediNotifiche(){
    request(uriServer + "?operazione=notifiche", myGetElementById("notifiche"));
}