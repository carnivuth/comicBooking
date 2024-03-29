/*
 * Funzione di callback
 */
function request_callback( theXhr, callback ) {

	// verifica dello stato
	if ( theXhr.readyState === 2 ) {
    	// non faccio niente
    	// theElement.innerHTML = "Richiesta inviata...";
	}// if 2
	else if ( theXhr.readyState === 3 ) {
    	// non faccio niente
		// theElement.innerHTML = "Ricezione della risposta...";
	}// if 3
	else if ( theXhr.readyState === 4 ) {

		// verifica della risposta da parte del server
	        if ( theXhr.status === 200 ) {

	        	// operazione avvenuta con successo
	
		        //if ( theXhr.responseText && theXhr.responseText !== "" ) {
					
					oggetto = JSON.parse(theXhr.responseText);
					operazione = oggetto.operazione;
					//alert("ciao");
					//alert(operazione);
					console.log(operazione);
					
					//acquirente
					if (operazione === "notifiche"){
				    	printNotifiche(callback, oggetto.result);
					}
					if (operazione === "biblioteca"){
				    	printBiblioteca(callback, oggetto.result);
					}
					if (operazione === "interessi"){
				    	printInteressi(callback, oggetto.result);
					}

					// prenotazione
					if (operazione === "fumettiPerPrenotazione"){
				    	stampaFumettiPerPrenotazione(callback, oggetto.result);
					}
					if (operazione === "fumetteriePerPrenotazione"){
				    	stampaFumetteriePerPrenotazione(callback, oggetto.result);
					}
					if (operazione === "richiediPrenotazione"){
				    	risultatoPrenotazione(callback, oggetto.result);
					}

					
					//negoziante
					if (operazione === "catalogo"){
				    	printCatalogo(callback, oggetto.result);
					}
					if (operazione === "changePrenotabile"){
				    	printCatalogo(callback, oggetto.result);
					}
					if (operazione === "aggiungiFumettoCatalogo"){
				    	printCatalogo(callback, oggetto.result);
						val = confirm("Scatenare evento?");
						if (val == true) {
							scatenaEvento();
						}
					}
					if (operazione === "rimuoviFumettoCatalogo"){
				    	printCatalogo(callback, oggetto.result);
					}
					if (operazione === "richiediListaFumetti"){
				    	stampaFumettiPerAggiunta(callback, oggetto.result);
					}


					if (operazione === "visualizzaPrenotazioni"){
				    	printPrenotazioniNegoziante(callback, oggetto.result);
					}


					
					//callback.innerHTML=JSON.parse(theXhr.responseText);
               // }
	
				/*else {
			    	// non faccio niente
				}*/

	        }

	        else {
	        	// errore di caricamento
	        	// non faccio niente nemmeno qui
	        }

	}// if 4

} // categoriaCallback();



/*
 * Imposta il contenuto testuale disponibile presso theUri
 * come src di un iframe all'interno dell'elemento theHolder del DOM
 * Non usa AJAX; per browser legacy
 */
function requestIframe(theUri,theHolder) {
	// qui faccio scaricare al browser direttamente il contenuto del feed come src dell'iframe.
	theHolder.innerHTML = '<iframe src="' + theUri + '" width="50%" height="50px">Il tuo browser non supporta gli iframe</iframe>';
	// non riesco tuttavia a intervenire per parsarlo! è il browser che renderizza l'src dell'iframe!
}// requestRandomIntGenerationIframe()



/*
 * Imposta il contenuto testuale disponibile presso theUri
 * all'interno dell'elemento theHolder del DOM
 * Usa tecniche AJAX attrverso la XmlHttpRequest fornita in theXhr
 */
function requestAJAX(theUri, theXhr, callback, method, paramsName, params) {
    
	// impostazione controllo e stato della richiesta
	theXhr.onreadystatechange = function() { request_callback(theXhr, callback); };
	if (method === "get"){
		// impostazione richiesta asincrona in GET
		// del file specificato
		try {
			theXhr.open("get", theUri, true);
			//theXhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		}
		catch(e) {
			// Exceptions are raised when trying to access cross-domain URIs 
			alert(e);
		}

		// invio richiesta
		theXhr.send(null);
	}
	if (method === "post"){
		theXhr.open("post", theUri, true);
		theXhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	

		text = "";

		if (params.length != paramsName.length) {
			alert("params and relative names have differnet length");
		}
		else{

			for (var i = 0; i < params.length; i++){
				text += paramsName[i] + "=" + params[i];
				if (i + 1 != params.length){
					text += "&";
				}
			}	
		}

		theXhr.send(text);
	}
} // requestRandomIntGenerationAJAX()



/*
 * Scarica un contenuto testuale dall'uri fornito
 * e lo aggiunge al contenuto dell'elemento e del dom
 * Gestisce sia AJAX che il mancato supporto ad AJAX 
 */
function request(uri,callback,method, paramsName,params) {

	// assegnazione oggetto XMLHttpRequest
	var xhr = myGetXmlHttpRequest();

	if ( xhr ) 
		requestAJAX(uri,xhr, callback, method, paramsName, params); 
	else 
		requestIframe(uri,callback); 

}// caricaFeed()


