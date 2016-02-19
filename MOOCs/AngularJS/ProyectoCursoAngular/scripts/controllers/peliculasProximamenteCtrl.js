/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasProximamenteCtrl",
    ["$scope", "$filter", "Peliculas", "MovieDbApi", function($scope, $filter, Peliculas, MovieDbApi){


        $scope.peliculas = $filter("orderBy")(Peliculas.data.results, "release_date");

        $scope.rutaImagen = function(ruta) {
                return MovieDbApi.obtenerRutaImagen(45, ruta);
        }
}]);