/**
 *
 * Created by Rumil on 17/02/16.
 */

angular.module("MisPelisSeriesApp").service("MovieDbApi", ["$http", "settings", function($http, settings){
    this.consultaBD = function(servicio){

        var requestUrl = "https://api.themoviedb.org/" + settings.apiVersion +  "/" + servicio
            + "?api_key=" + settings.apiKey + "&language=" + settings.language;

        return $http.get(requestUrl)
    }
}])
