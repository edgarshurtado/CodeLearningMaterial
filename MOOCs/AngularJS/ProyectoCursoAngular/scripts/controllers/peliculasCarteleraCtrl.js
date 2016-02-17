/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasCarteleraCtrl", ["$scope", "$http", function($scope, $http){
    $http
        .get("https://api.themoviedb.org/3/movie/now_playing?api_key=e08466e6994d3713b0a8b64245164762&language=es")
        .then(
            function(resultado) {
                $scope.peliculas = resultado.data.results;
            },
            function(){
                alert("Algo no ha ido bien");
            });
}]);