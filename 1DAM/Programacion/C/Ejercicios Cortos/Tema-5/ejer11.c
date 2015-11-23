#include <stdio.h> 
#include <string.h>

#define N_EXITS 4
int main(){
    char exitos[N_EXITS][10] = {"hola1","hola2","hola3", "hola4"};
    int votos[N_EXITS] = {0};
    strcpy(exitos[0], exitos[1]);
    for(int i = 0; i < N_EXITS; i++){
        printf("%s tiene %i votos \n", exitos[i], votos[i]);
    }
    return 0;


}
