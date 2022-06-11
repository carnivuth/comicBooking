nameProject = "Comic_Booking_App";
uriServer = "http://localhost:8080/" + nameProject + "/";
uriServerNegoziante = uriServer + "negoziante";
uriServerAcquirente = uriServer + "acquirente";
uriRegistrazione = uriServer + "registrazione.jsp";


uriHtmlNegoziante = uriServer + "view/html/" + "negoziante/";
uriHtmlAcquirente = uriServer + "view/html/" + "acquirente/";
uriHomeNegoziante = uriHtmlNegoziante + "HomeGestioneNegoziante.html";
uriHomeAcquirente = uriHtmlAcquirente + "HomeGestioneAcquirente.html";
tab = "\t";


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

function gotoGestioneBiblioteca(){
    window.location.href = uriHtmlAcquirente + "GestioneBiblioteca.html";
}
function gotoGestioneInteressi(){
    window.location.href = uriHtmlAcquirente + "GestioneInteressi.html";
}
function gotoPrenotaFumetto(){
    window.location.href = uriHtmlAcquirente + "PrenotaFumetto.html";
}
function gotoVisualizzaNotifiche(){
    window.location.href = uriHtmlAcquirente + "ViewVisualizzaNotifiche.html";
}

function gotoGestioneCatalogo() {
    window.location.href = uriHtmlNegoziante + "";
}