/**
 *
 * Created by Rumil on 17/02/16.
 */

angular.module("MisPelisSeriesApp").service("MovieDbApi", ["$http", function($http){
    this.consultaBD = function(servicio){
        return $http.get("https://api.themoviedb.org/3/" + servicio + "?api_key=e08466e6994d3713b0a8b64245164762&language=es")
    }
}])
