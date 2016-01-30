// Petición AJAX

var READY_STATE_UNINITIALIZED=0;
var READY_STATE_LOADING=1;
var READY_STATE_LOADED=2;
var READY_STATE_INTERACTIVE=3;
var READY_STATE_COMPLETE=4;

var peticion_http;

function cargaContenido(url, metodo, funcion) {
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
        peticion_http.send(null);
    }
}

function muestraContenidoXML() {
    if(peticion_http.readyState == READY_STATE_COMPLETE) {
        if(peticion_http.status == 200) {
            mostrarPaginaCubata(peticion_http.responseXML);
        }
    }
}

function parsearHTML(){
    var htmlPage = peticion_http.responseText;
    var contentHolder = document.getElementById("content");

    contentHolder.innerHTML = htmlPage;
}

function mostrarPaginaCubata(xml){
    console.log(peticion_http.responseXML);
    var root = xml.getElementsByTagName("gin-tonic")[0];
    var pageHTML = "";

    // Nombre ginebra
    var gin = root.getElementsByTagName("ginebra")[0].firstChild.textContent;
    pageHTML += "<h2>" + gin + "</h2>";

    // Descripción del gin tonic
    var descripcion = root.getElementsByTagName("descripcion")[0].firstChild.textContent;
    pageHTML += "<p>" + descripcion + "</p>";

    // Imagen
    var imagen = root.getElementsByTagName("imagen")[0].firstChild.textContent;
    pageHTML += "<img src=" + imagen + "/>";


    // Ingredientes
    var ingredientes = root.getElementsByTagName("ingredientes")[0]
        .getElementsByTagName("ingrediente");

    var nIngredientes = ingredientes.length;

    pageHTML += "<ul>";
    for(var i=0; i < nIngredientes; i++){
        var texto = ingredientes[i].firstChild.textContent;
        pageHTML += "<li>"+texto+"</li>";
    }
    pageHTML += "<ul>";

    //Elaboración
    var elaboracion = root.getElementsByTagName("elaboracion")[0]
        .getElementsByTagName("parrafo");
    var nPasos= elaboracion.length;
    for(var i=0; i < nPasos; i++){
        var paso = elaboracion[i].firstChild.textContent;
        pageHTML += "<p>" + paso + "</p>";
    }

    document.getElementById("content").innerHTML = pageHTML;
}

function siteUrl(url){
    //Change this to set the root directory for the page
    return "http://localhost:63342/CubatasXML/" + url;
}

// EVENTOS
document.getElementById("gin_right").addEventListener("click", function(){
    cargaContenido(siteUrl("pages/gin_right.xml"), "GET", muestraContenidoXML);
});

document.getElementById("pink_47").addEventListener("click", function(){
    cargaContenido(siteUrl("pages/pink_47.xml"), "GET", muestraContenidoXML);
});

document.getElementById("brockmans").addEventListener("click", function(){
    cargaContenido(siteUrl("pages/brockmans.xml"), "GET",  muestraContenidoXML);
});

document.getElementById("home").addEventListener("click", function(){
    cargaContenido(siteUrl("pages/home.html"), "GET", parsearHTML);
});

//DEFAULT PAGE

cargaContenido(siteUrl("pages/home.html"), "GET", parsearHTML);
