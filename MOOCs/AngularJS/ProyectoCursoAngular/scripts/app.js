/**
 * Created by Rumil on 08/02/16.
 */

angular.module("MisPelisSeriesApp", ["ngRoute", "route-segment", "view-segment"]);

angular.module("MisPelisSeriesApp").config(["$routeSegmentProvider", "$routeProvider",
    function ($routeSegmentProvider, $routeProvider) {



   $routeSegmentProvider.when("/peliculas", "peliculas");
   $routeSegmentProvider.segment("peliculas", {
      controller: "peliculasCtrl",
      templateUrl: "views/peliculas.html",
   });

   $routeSegmentProvider.when("/peliculas/proximamente", "peliculas.proximamente");
   $routeSegmentProvider.within("peliculas").segment("proximamente", {
      controller: "peliculasProximamenteCtrl",
      templateUrl: "views/peliculasProximamente.html",
      resolve: {
           Peliculas: ["MovieDbApi", function(MovieDbApi){
               return MovieDbApi.consultaBD("movie/upcoming");
           }]
      }
   });

    $routeSegmentProvider.when("/peliculas/cartelera", "peliculas.cartelera");
    $routeSegmentProvider.within("peliculas").segment("cartelera", {
        controller: "peliculasCarteleraCtrl",
        templateUrl: "views/peliculasCartelera.html"
    });

   $routeSegmentProvider.when("/series", "series");
   $routeSegmentProvider.segment("series", {
      controller: "seriesCtrl",
      templateUrl: "views/series.html"
   });

   // Vista por defecto
    $routeProvider.otherwise({
        redirectTo: "/peliculas/proximamente"
    })


    }]);