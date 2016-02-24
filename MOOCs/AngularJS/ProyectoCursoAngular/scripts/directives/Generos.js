/**
 * Created by Edgar S. Hurtado on 23/02/16.
 */

angular.module("MisPelisSeriesApp").directive("generos", ["$compile", function($compile){
    return {
        restrict: "AE",
        replace: true,
        scope: {
            coleccion: "="
        },
        link: function(scope, elemento) {
            var vista = "<div class='caja-generos'>";

            for(var i=0; i < scope.coleccion.length; i++){
                vista += "<span class='label label-danger'>" + scope.coleccion[i].name + "</span>";
            }

            vista += "</div>";


            var nuevoElemento = angular.element(vista);
            var nuevoElementoCompilado = $compile(nuevoElemento)(scope);

            elemento.replaceWith(nuevoElementoCompilado);
        }
    }
}]);
