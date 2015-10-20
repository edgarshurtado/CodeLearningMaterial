/*

 Demanar edats fins que edat = 0
 
 Mostrar q menors de 18 i mitja
 Mostrar q entre 16 i 65 i mitja
 Mostrar q total i mitja

*/

#include <stdio.h>
#define DECIMALES 2

int main(){
    int c_menores=0, c_trabajar = 0, c_totales = 0;           //Contadores y acumuladores para las respuestas que se piden
    int sum_menores, sum_trabajar, sum_totales;               // Totales, menores de edad y con edad de trabajar
    int edad;
    
    printf("Introduce una edad: ");
    scanf("%i", &edad);
    
    while (edad != 0) {
        //TODAS LAS EDADES: Conteo y cálculo de todas las edades introducidas
        c_totales++;
        sum_totales += edad;
        
        if (edad < 18) {
            //MENORES DE EDAD: Conteo y cálculo de las edades de los menores de edad
            c_menores++;
            sum_menores += edad;
        }
        
        if (edad >= 16 && edad <= 65) {
            //EDAD DE TRABAJAR: Conteo y cálculo de las edades de los que tengan edad de trabajar
            c_trabajar++;
            sum_trabajar += edad;
        }
        
        //Introducción de una nueva edad
        printf("\nIntroduce una edad: ");
        scanf("%i", &edad);
    }
    
    //Impresión de los resultados
    if (c_totales > 0) {
        //Todas las edades
        printf("\nHay %i edades con una media de %.*f años\n", c_totales, DECIMALES, (float)sum_totales/c_totales);
    
        if (c_menores > 0) {
            //Para los menores de edad
            printf("Hay %i menores con una media de %.2f años\n", c_menores, (float)sum_menores/c_menores);
        }
        else{
            printf("Ningún menor de edad\n");
        }
        
        if (c_trabajar > 0) {
            //Para los que tienen edad para trabajar
            printf("Hay %i con edad para trabajar con una media de %.2f años\n", c_trabajar, (float)sum_trabajar/c_trabajar);
        }
        else{
            printf("No hay con edad para trabajar");
        }
    }
    else{
        //Si no se ha introducido ninguna edad
        printf("No has introducido ninguna edad válida\n");
    }

}