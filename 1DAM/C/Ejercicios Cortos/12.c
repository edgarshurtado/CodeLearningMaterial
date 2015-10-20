/*
 12.Programa que calcule el factorial d’un número introduït per teclat ( n! ) tenint en compte que:
 
 0! = 1
 n! = n * (n-1) * (n-2) * ... * 2 * 1 (sent n > 1)
 
 Feu-ho amb els 3 tipus de bucles que hem vist, i fent els càlculs incrementant i
 decrementant el comptador (total: 6 solucions).
 */


#include <stdio.h>


int main(){
    //Definición de las variables
    int i, productoFactorial, factorial;
    productoFactorial = 1;
    
    //Introducción del numero del cual calcular el factorial
    printf("Escribe el nº del que calcular el factorial: ");
    scanf("%i", &factorial);
    
    
    //Bucle WHILE
    i = factorial;  //variable para iterar en el bucle sin modificar el valor de
                    //factorial
    
    if (factorial != 0) {
        while (i > 1) {
            //itera a través de la var i descendentemente para hacer el producto de los números del
            //factorial
            productoFactorial *= i--;
        }
    }
    else{   //para el caso especial de !0
        productoFactorial = 1;
    }
    //Mostrar los resultados del bucle WHILE
    printf("%i\n", productoFactorial);
    
    
    //BUCLE DO WHILE
    
    //reinicio de las variables para no arrastrar los resultados
    //del bucle WHILE
    productoFactorial=1;
    i=factorial;
    
    if (factorial != 0) {
        do {
        //itera a través de la var i descendentemente para hacer el producto de los números del
        //factorial
            productoFactorial *= i--;
        } while (i > 1);
    }
    else{   //para el caso especial de !0
        productoFactorial = 1;
    }
    //Mostrar los resultados del bucle WHILE
    printf("%i\n", productoFactorial);
    
    
    //BUCLE FOR
    
    //reinicio de las variables para no arrastrar los resultados
    //del bucle WHILE
    productoFactorial=1;

    if (factorial != 0) {
        for (i=factorial; i > 1; i--) {
            productoFactorial *= i;
        }
    }
    else{   //para el caso especial de !0
        productoFactorial = 1;
    }
    //Mostrar los resultados del bucle WHILE
    printf("%i\n", productoFactorial);
}