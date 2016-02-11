/**
 *
 * Created by Rumil on 11/02/16.
 */

/**
 * Created by Rumil on 04/02/16.
 */
var READY_STATE_UNINITIALIZED=0;
var READY_STATE_LOADING=1;
var READY_STATE_LOADED=2;
var READY_STATE_INTERACTIVE=3;
var READY_STATE_COMPLETE=4;
var lista = [];

var peticion_http;

function cargaContenido(url, metodo, funcion, sendVariables) {
    function inicializa_xhr() {
        if(window.XMLHttpRequest) {
            return new XMLHttpRequest();
        }
        else if(window.ActiveXObject) {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    peticion_http = inicializa_xhr();

    if(peticion_http) {
        peticion_http.onreadystatechange = funcion;
        peticion_http.open(metodo, url, true);
        peticion_http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        peticion_http.send(sendVariables);
    }
}

function muestraContenidoSelect() {
    if(peticion_http.readyState == READY_STATE_COMPLETE) {
        if(peticion_http.status == 200) {
            var respuesta = peticion_http.responseText;
            var mainDiv = document.getElementById("main");
            mainDiv.innerHTML= respuesta;

            cargaContenido("primeros_platos.xml", "GET", cargarPrimerosPlatos, null);

        }
    }
}


function cargarPrimerosPlatos() {
    if(peticion_http.readyState == READY_STATE_COMPLETE) {
        if(peticion_http.status == 200) {
            var respuesta = peticion_http.responseXML;
            var platosSelect = document.getElementById("primer_plato");

            respuesta = respuesta.getElementsByTagName("plato");

            platosSelect.innerHTML = "<option value='0'> ---- </option>";

            for(var i=0; i < respuesta.length; i++){
               var plato = respuesta[i].firstChild.textContent;

                platosSelect.innerHTML += "<option value='" + i + "'>" + plato + "</option>";
            }
            platosSelect.addEventListener("change", peticionSegundosPlatos);
        }
    }
}

function peticionSegundosPlatos(){
    cargaContenido("segundos_platos.json", "GET", cargarSegundosPlatos, null);
}

function cargarSegundosPlatos(){
    if(peticion_http.readyState == READY_STATE_COMPLETE) {
        if(peticion_http.status == 200) {
            var respuesta = peticion_http.responseText;

            var primerPlato = document.getElementById("primer_plato");
            primerPlato = primerPlato.value;

            var json_option = eval("(" + respuesta + ")");
            json_option = json_option[primerPlato];


            var segundoSelect = document.getElementById("segundo_plato")

            segundoSelect.innerHTML = "<option value='0'> ---- </option>";

            for(var index in json_option){
                segundoSelect.innerHTML += "<option value='" + index + "'>"+json_option[index]+"</option>";
            }
        }
    }
}

function meterOpcionLista(){
   var plato = this.options[this.selectedIndex].text;
   lista.push(plato);
}

cargaContenido("select.html", "GET", muestraContenidoSelect, null);
