
uriServer = "http://localhost:8080/TW_Esame_StartingKit/";
uriServerNegoziante = uriServer + "negoziante";
uriServerAcquirente = uriServer + "acquirente";
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

function gotoLogin(){
    window.location.href = "http://localhost:8080/TW_Esame_StartingKit/view/html/loginRegistrazione/login.jsp";
}

function gotoRegistrazione() {
    window.location.href = uriServer + "registrazione";
}