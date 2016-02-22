/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasCarteleraCtrl",
    ["$scope", "$filter", "Peliculas", "$location", function($scope, $filter, Peliculas, $location){

        $scope.peliculas = $filter("orderBy")(Peliculas.data.results, "release_date");

        $scope.verDetalle = function(id) {
                $location.path("/peliculas/detalle").search({
                        idPelicula : id
                });
        }
}]);