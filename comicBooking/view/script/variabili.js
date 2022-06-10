
uriServer = "http://localhost:8080/fumetto/";
uriRegistrazione = uriServer + registrazione.jsp;
uriHomeNegoziante = uriServer + HomeGestioneNegoziante.html;
uriHomeAcquirente = uriServer + HomeGestioneAcquirente.html;

tab = "\t"


function getUsername(){
    cookie = document.cookie.split("=")[1]; 
    return cookie;
}

function gotoHomeAcquirente(){
    window.location.href = uriHomeAcquirente;
}

function gotoHomeNegoziante(){
    window.location.href = uriHomeNegoziante;
}