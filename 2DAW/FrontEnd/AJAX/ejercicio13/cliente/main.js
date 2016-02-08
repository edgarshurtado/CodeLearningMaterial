var READY_STATE_COMPLETE=4;
var peticion_http = null;

function inicializa_xhr() {
    if(window.XMLHttpRequest) {
        return new XMLHttpRequest();
    }
    else if(window.ActiveXObject) {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function crea_query_string() {
    var login = document.getElementById("login");

    return "login" + encodeURIComponent(login.value) + "&nocache=" + Math.random();
}

function valida() {
    peticion_http = inicializa_xhr();
    if(peticion_http) {
        peticion_http.onreadystatechange = procesaRespuesta;
        peticion_http.open("POST", "http://localhost:63342/ejercicio13/servidor/compruebaDisponibilidad.php", true);

        peticion_http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        var query_string = crea_query_string();
        peticion_http.send(query_string);
    }
}

function procesaRespuesta() {
    if(peticion_http.readyState == READY_STATE_COMPLETE) {
        if(peticion_http.status == 200) {
            document.getElementById("disponibilidad").innerHTML = peticion_http.responseText;
        }
    }
}

var comprobarLink = document.getElementById("comprobar");

comprobarLink.addEventListener("click", function realizarComprobacion(){
    valida();
});
