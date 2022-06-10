nameProject = "Comic_Booking_App";
uriServer = "http://localhost:8080/" + nameProject + "/";
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
    window.location.href = uriServer + "view/html/loginRegistrazione/login.jsp";
}

function gotoRegistrazione() {
    window.location.href = uriServer + "registrazione";
}