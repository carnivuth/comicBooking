function printNotifiche(callback, result){
    
    callback.innerHTML = "Fumetto"+ tab + "Fumetteria" + tab + "SegnaComeLetto<br>";

    for (var i=0; i<result.length; i++) {
        f = result[i].fumetto;
        fumetteria = result[i].fumetteria;
        checkbox = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" onclick=\"segnaComeLetto(this)\">";
        checkboxSi = "<input type=\"checkbox\" id=\"segnaComeLetto\" name=\"segnaComeLetto\" checked >";
        
        callback.innerHTML += (f.titolo + " " + f.numero + tab + fumetteria.nome + tab);
        
        if (result[i].visualizzato){
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