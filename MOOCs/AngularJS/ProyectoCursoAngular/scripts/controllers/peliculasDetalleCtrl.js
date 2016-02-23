/**
 * Created by Edgar S. Hurtado on 19/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasDetalleCtrl",
    ["$scope", "Pelicula", "MovieDbApi" ,function($scope, Pelicula, MovieDbApi){

        $scope.pelicula = Pelicula.data;

        $scope.rutaImagen = function(ruta) {
            return MovieDbApi.obtenerRutaImagen(150, ruta);
        };
}]);
