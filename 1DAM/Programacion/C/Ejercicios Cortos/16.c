#include <stdio.h>

# define CLAVE 1234
# define MAX_INT 5

int main(void)
{
    int intentos = 0;
    int user_pass;
    do {
        scanf("%i", &user_pass);

        if (user_pass == CLAVE) {
            printf("Correcto\n");
            return 0;
        }
        intentos += 1;
    } while (intentos < 5);
        
    printf("Error\n"); 
    return 0;
}
