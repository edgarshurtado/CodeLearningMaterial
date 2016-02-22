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
        templateUrl: "views/peliculasCartelera.html",
        resolve: {
            Peliculas: ["MovieDbApi", function(MovieDbApi){
                return MovieDbApi.consultaBD("movie/now_playing");
            }]
        }
    });

   $routeSegmentProvider.when("/series", "series");
   $routeSegmentProvider.segment("series", {
      controller: "seriesCtrl",
      templateUrl: "views/series.html"
   });

   $routeSegmentProvider.when("/peliculas/detalle", "peliculas.detalle");
   $routeSegmentProvider.within("peliculas").segment("detalle", {
       controller : "peliculasDetalleCtrl",
       templateUrl : "views/peliculasDetalle.html",
       resolve : {
           Pelicula: ["MovieDbApi", "$routeParams", function(MovieDbApi, $routeParams){
               return MovieDbApi.consultaBD("movie/" + $routeParams.idPelicula)
           }]
       }
   })

   // Vista por defecto
    $routeProvider.otherwise({
        redirectTo: "/peliculas/proximamente"
    })


    }]);