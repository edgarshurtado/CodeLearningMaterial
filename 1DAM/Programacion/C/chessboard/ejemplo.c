#include <stdio.h>
#define TAMANNO 8
void foo(int *vector){
    int i;

    for(i = 0; i < TAMANNO; i++){
        printf("%i\n", vector[i]);
    }
}

int main(void)
{
    int ajedrez[] = {0,4,6,2,3,2,4};
   foo(ajedrez);
   return 0;
}
