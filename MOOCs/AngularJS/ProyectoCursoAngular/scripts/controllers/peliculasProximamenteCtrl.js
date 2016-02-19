/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasProximamenteCtrl",
    ["$scope", "$filter", "Peliculas", "MovieDbApi", "$location", function($scope, $filter, Peliculas, MovieDbApi, $location){


        $scope.peliculas = $filter("orderBy")(Peliculas.data.results, "release_date");

        $scope.rutaImagen = function(ruta) {
                return MovieDbApi.obtenerRutaImagen(45, ruta);
        };

        $scope.verDetalle = function(id) {
           $location.path("/peliculas/detalle").search({
               idPelicula : id
           });
        }
}]);