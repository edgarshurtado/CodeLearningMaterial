//4. Escriu un programa que, donat un caràcter alfabètic, el passe de minúscula a majúscula i viceversa.
// Program that changes letter chars from lowercase to uppercase and from uppercase to lowercase

#include <stdio.h>

int main(){
    char caracter;
   
    printf("Escribe un caracter\n");
    scanf("%c", &caracter);
   
    if (caracter >= ‘A' && caracter <= ‘Z') {
        caracter = caracter + 32;
    }
    else if (caracter >=‘a' && caracter <= ‘z') {
        caracter= caracter - 32;
        }
    
    printf("%c \n", caracter);
}
