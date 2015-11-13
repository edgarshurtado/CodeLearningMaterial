
#include "stdio.h"

int main(void)
{
    int notas[3];
    int notasLen = sizeof(notas)/sizeof(notas[0]);
    int opcion;

    for (int i = 0; i < notasLen; ++i)
    {
        notas[i]=-1;
    }

    do
    {
        printf("Escoge una opción de 1 a 5: ");
        scanf("%i", &opcion);
        switch(opcion){
            case 1:
                for (int i = 0; i < notasLen; ++i)
                {
                    printf("\nIntroduce nota alumno %i \n", i+1);
                    int notaIntroducida;
                    scanf("%i", &notaIntroducida);
                    if(notaIntroducida >= -1 && notaIntroducida <= 10){
                        notas[i] = notaIntroducida;
                    } else{
                        printf("Valor no válido\n");
                    }
                }
                break;
            case 2:
                printf("Has introducido la opción %i \n", opcion);
                break;
            case 3:
                printf("Alumne\tNota\n");
                for (int i = 0; i < notasLen; ++i)
                {
                    printf("%i\t%i\n", i+1, notas[i]);
                }
                break;
            case 4:
                printf("Has introducido la opción %i \n", opcion);
                break;
            case 5:
                printf("Has introducido la opción %i \n", opcion);
                break;
            default:
                printf("Opcion no válida");
        }
    } while (opcion != 5);


    return 0;
}