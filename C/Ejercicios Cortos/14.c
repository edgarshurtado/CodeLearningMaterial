/*
 Programa que mostre la taula de multiplicar del 9.
 */

#include <stdio.h>

int main(){
    int tabla, i;
    printf("¿Tabla de multiplicar?: ");
    scanf("%i", &tabla);
    
    for (i = 0; i <= 10; i++) {
        //itera sobre i para ir calculando el producto de la tabla indicada
        //desde 0 hasta 10 inclusive.
        printf("%i * %i = %i\n",tabla, i, tabla * i);
    }
    
}