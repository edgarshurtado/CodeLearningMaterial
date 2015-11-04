#include <stdio.h>

# define MAX_NUM 10
int main(void)
{
    int num_introducido;
    int sumatorio_positivos = 0;
    int total_numeros_introducidos = 0;
    int total_numeros_positivos = 0;

    do {
        scanf("%i", &num_introducido);
        total_numeros_introducidos++;
        
        if (num_introducido <= 0) {
            continue;
        }

        total_numeros_positivos++;
        sumatorio_positivos += num_introducido;

    } while (total_numeros_introducidos < MAX_NUM);

    if (total_numeros_positivos > 0) {
        printf("La media de los números es = %d \n", sumatorio_positivos/total_numeros_positivos);
    }
    return 0;
}
