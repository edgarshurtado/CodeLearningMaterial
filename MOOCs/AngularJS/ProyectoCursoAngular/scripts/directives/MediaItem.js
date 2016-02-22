/**
 * Created by Edgar S. Hurtado on 22/02/16.
 */

angular.module("MisPelisSeriesApp").directive("mediaItem",
    ["MovieDbApi", function(MovieDbApi) {
        return {
            restrict: "AE",
            replace: true,
            templateUrl: "views/MediaItem.html",
            scope: {
                datos: "=",
                alSeleccionar: "&"
            },
            link: function(scope) {
                scope.rutaImagen = function(ruta) {
                    return MovieDbApi.obtenerRutaImagen(45, ruta);
                };

                scope.clickEnMedia = function (id) {
                    scope.alSeleccionar({ mediaId: id });
                }
            }
        }
}]);