/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasCarteleraCtrl", ["$scope", "MovieDbApi", function($scope, MovieDbApi){

    MovieDbApi
        .consultaBD("movie/now_playing")
        .then(
            function(resultado) {
                $scope.peliculas = resultado.data.results;
            },
            function(){
                alert("Algo no ha ido bien");
            });
}]);