//
//  11.c
//  Mi primer programa
//
//  Created by Edgar S. Hurtado on 05/11/14.
//  Copyright (c) 2014 Edgar Sánchez. All rights reserved.



#include <stdio.h>
#define DECIMALES 2

int main(){
    int i, num, max, min, sumatorio;
    float media;
    
    for (i=1; i<=10; i++) {
        printf("Escribe el nº %i: ", i);
        scanf("%i", &num);
        if (i==1) {
            max = num;
            min = num;
        }
        else{
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        sumatorio += num;
    }
    media = (float)sumatorio / 2;
    printf("\n \nEl nº máximo es: %i \n", max);
    printf("El nº mínimo es: %i \n", min);
    printf("La media de valores es: %.*f \n", DECIMALES, media);
    
}
