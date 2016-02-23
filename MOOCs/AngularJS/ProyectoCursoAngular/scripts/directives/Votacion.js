/**
 * Created by Edgar S. Hurtado on 23/02/16.
 */

angular.module("MisPelisSeriesApp").directive("votacion", ["$compile", function($compile){
    return {
        restrict: "AE",
        replace: true,
        scope : {
            media: "@"
        },
        link: function(scope, elemento) { // elemento en el que se quiere instaciar la directiva
            var mediaComoNumero = parseFloat(scope.media);
            var mediaRedondeada = Math.round(mediaComoNumero);

            // Creamos de forma dinámica la cantidad de estrellas que va a dibujar la directiva
            var vista = "<div>";

            for(var i=0; i < mediaRedondeada; i++){
                vista += "<span class='glyphicon glyphicon-star'></span>";
            }

            for (var f= 0, F = 10 - mediaRedondeada; f < F; f++){
                vista += "<span class='glyphicon glyphicon-star-empty'></span>";
            }

            vista += "</div>";

            // Enlazamos el scope con la vista. Esto es necesario cuando no tenemos una templateUrl o template
            // definidas
            // angular.element es un alias para $() de jQuery
            // necesitamos convertir la cadena en un elemento DOM antes de inyectar la funcionalidad en el elmento
            var nuevoElemento = angular.element(vista);
            var nuevoElementoCompilado = $compile(nuevoElemento)(scope);

            elemento.replaceWith(nuevoElementoCompilado);
        }
    }
}]);
