/**
 *
 * Created by Rumil on 16/02/16.
 */

angular.module("MisPelisSeriesApp").controller("navegacionCtrl", ["$scope", "$routeSegment", function($scope, $routeSegment){
    $scope.rutaEsPeliculas = function () {
        return $routeSegment.startsWith("peliculas")
    };

    $scope.rutaEsSeries = function () {
        return $routeSegment.startsWith("series");
    };
}]);
