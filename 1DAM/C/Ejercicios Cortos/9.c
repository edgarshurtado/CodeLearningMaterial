/*
 9.Programa que ens demane el radi d’una circumferència. Posteriorment ens mostrarà un menú amb 4 opcions:
 
                            1. Diàmetre 2. Perímetre 3. Superfície 4. Eixir
 
 L’usuari triarà una opció. El programa calcularà el corresponent valor i tornarà a fer el mateix (demanar el radi, etc) a no ser que s’haja triat l’opció d’eixir.
*/

#include <stdio.h>
#include <math.h>
#define DECIMALES 2  //número de decimales a mostrar en la respuesta

int main(void){
    int option;
    float radio, diametro;
    
    printf("Escribe el radio\n");
    scanf("%f",&radio);
    diametro = radio * 2;
    
    
    do{
        printf("Elige una opción: \n");
        printf("\n1.Diámetro: \n2.Perímetro: \n3.Superfície: \n4. Salir: \n\n");
        scanf("%i", &option);
        
        switch (option) {
            case 1: printf("El diámetro es: %.*f \n", DECIMALES, diametro); break;
            case 2: printf("El perímetro es: %.*f \n", DECIMALES, M_PI * diametro); break;
            case 3:printf("La superfície es: %.*f \n", DECIMALES, M_PI * radio*radio); break;
            case 4: break;
            default: printf("No has introducido una opción válida \n");
        }
    }
    while (option != 4);
    

}