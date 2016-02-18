/**
 * Created by Rumil on 18/02/16.
 */

// Los filtros necesariamente deben de tener el nombre en lowerCamelCase
angular.module("MisPelisSeriesApp").filter("fechaEstrenoFilter", function(){
    return function (datoEntrada) {
        return "Se estrena en: " + datoEntrada;
    }
})
