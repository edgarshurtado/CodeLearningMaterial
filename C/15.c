/*
Programa que mostre les taules de multiplicar del 2 al 9. Nota: este exercici és més difícil, ja que suposa incloure un bucle dins d’altre.
*/

#include <stdio.h>

int main(){
    int tabla, i;
    
    for (tabla = 2; tabla <= 9; tabla ++) {
        printf("---------------\n La tabla del %i \n--------------- \n", tabla);
    
        for (i = 0; i <= 10; i++) {
            //itera sobre i para ir calculando el producto de la tabla indicada
            //desde 0 hasta 10 inclusive.
            printf("%i * %i = %i\n",tabla, i, tabla * i);
        }
    }
}