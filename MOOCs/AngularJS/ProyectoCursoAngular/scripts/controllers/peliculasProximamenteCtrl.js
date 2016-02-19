/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasProximamenteCtrl",
    ["$scope", "$filter", "Peliculas", function($scope, $filter, Peliculas){

        $scope.peliculas = $filter("orderBy")(Peliculas.data.results, "release_date");
}]);