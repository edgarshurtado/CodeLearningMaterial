#include <stdio.h>

int main(void)
{
    for (int i = 0; i < 10; i++) {
        printf("%d * 9 = %d \n", i+1, 9 * (i+1));
    }
    return 0;
}
