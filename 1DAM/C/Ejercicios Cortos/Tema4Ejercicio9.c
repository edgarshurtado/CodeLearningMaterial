/*
 9.Programa que ens demane el radi d’una circumferència. Posteriorment ens mostrarà un menú amb 4 opcions:
 
                            1. Diàmetre 2. Perímetre 3. Superfície 4. Eixir
 
 L’usuari triarà una opció. El programa calcularà el corresponent valor i tornarà a fer el mateix (demanar el radi, etc) a no ser que s’haja triat l’opció d’eixir.
*/

#include <stdio.h>
#include <math.h>

int main(void){
    int option;
    float radio;
    
    printf("Escribe el radio\n");
    scanf("%f",&radio);
    
    do{
        printf("Elige una opción: \n");
        printf("\n1.Diámetro: \n2.Perímetro: \n3.Superfície: \n4. Salir: \n\n");
        scanf("%i", &option);
        
        switch (option) {
            case 1: printf("El diámetro es: %.2f \n", radio * 2); break;
            case 2: printf("El perímetro es: %.2f \n", M_PI * 2 * radio); break;
            case 3:printf("La superfície es: %.2f \n", M_PI * radio*radio); break;
            default: printf("No has introducido una opción válida \n");
        }
    }
    while (option != 4);
    

}
