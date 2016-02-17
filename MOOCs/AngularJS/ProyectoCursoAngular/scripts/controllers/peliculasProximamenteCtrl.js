/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasProximamenteCtrl", ["$scope", "MovieDbApi", function($scope, MovieDbApi){

    MovieDbApi.consultaBD("movie/upcoming")
        .then(
            function(resultado) {
                $scope.peliculas = resultado.data.results;
            },
            function(){
                alert("Algo no ha ido bien");
            });
}]);