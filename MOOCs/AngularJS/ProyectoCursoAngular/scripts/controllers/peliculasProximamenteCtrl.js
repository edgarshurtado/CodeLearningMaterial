/**
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("peliculasProximamenteCtrl",
    ["$scope", "MovieDbApi", "$filter", function($scope, MovieDbApi, $filter){

    MovieDbApi.consultaBD("movie/upcoming")
        .then(
            function(resultado) {
                $scope.peliculas = $filter("orderBy")(resultado.data.results, "release_date"); //Usando filtro desde controlador
            },
            function(){
                alert("Algo no ha ido bien");
            });
}]);