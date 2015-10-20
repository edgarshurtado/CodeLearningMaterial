/*
* 10.Programa que calcule el màxim de 10 números introduïts per teclat.
*/


#include <stdio.h>

int main(){
    int i, num, max;
   
    for (i=1; i<=10; i++) {
        printf("Escribe el nº %i: ", i);
        scanf("%i", &num);
        if (i==1) {
            max = num;
        }
        else if(num > max){
            max = num;
        }
    }
    
    printf("\n\nEl nº máximo es: %i \n", max);

}