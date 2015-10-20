/*
 * main.c
 *
 *  Created on: 19/11/2014
 *      Author: Edgar S. Hurtado
 */

#include <stdio.h>
#include <string.h>
#define LENGTH 10
#define MAX_PRODUCTS 100

//Helpufl funtions
int XInMatrix (char *vector1, char matrix[][LENGTH],int filasMatriz){
	//Returns the position of a string in a matrix or returns -1 if the string it's
	//not in the matrix
    int i, position;
    int found = 0;
    position = -1;
    for(i = 0; i < filasMatriz && !found; i++){
        if (!strcmp(vector1, matrix[i])){
            position = i;
            found = 1;
        }
    }
    return position;
}

void MoveMatrixItem(char matrix[][LENGTH], int destPosition, int origPosition){
	//Moves a string inside a matrix
	strcpy(matrix[origPosition], matrix[destPosition]);
}

void EmptyBuffer(){
	while(getchar()!= '\n');
}

void ShowMenu(){
	printf("---------------Menu----------------------\n\n");
	printf("1- Introducir un artículo nuevo\n2-Hacer una venta\n3-Mostrar información\n");
	printf("4- Borrar un artículo\n5-Borrar todos los artículos\n6- Salir\n\n");
}

//Option Functions
void AddNewProduct(char products[][LENGTH], float *prices, int numberOfProducts){
	char vectorAuxiliar[LENGTH];

	printf("Introduce el nombre del nuevo artículo (máximo 10 caracteres): ");
	scanf("%s", vectorAuxiliar);
	if(XInMatrix(vectorAuxiliar, products, numberOfProducts) == -1){
		EmptyBuffer();
		strcpy(products[numberOfProducts], vectorAuxiliar);
		printf("\nIntroduce el precio del nuevo artículo: ");
		scanf("%f", &prices[numberOfProducts]);
	}
	else{
		printf("El artículo %s ya existe \n\n", vectorAuxiliar);
	}
}

void SellAProduct(char products[][LENGTH], float *soldedVector){
	//Searchs for a product and add the amount of items solded.
	char auxiliarVector[LENGTH];
	int position;
	float amountAdded;

	printf("\nIntroduce el artículo a vender: ");
	scanf("%s", auxiliarVector);
	position = XInMatrix(auxiliarVector, products, LENGTH);
	if( position >= 0){
		printf("Escribe la cantidad de artículos vendidos: ");
		//while(getchar()!= '\n');
		scanf("%f", &amountAdded);
		soldedVector[position] += amountAdded;
	}
	else{
		printf("No existe el artículo %s\n", auxiliarVector);
	}
}
void PrintTable(char matrix[][LENGTH], float *pricesVector, float *soldedVector, int numbOfRows){
	//prints a table with the articles, the price of each unit and the total amount earned with everyone
	//It shows too the most sold and the less sold item
	int i;
	float totalAmount = 0;
	int mostSolded[2], lessSolded[2];

	if(numbOfRows > 0){
		printf("\nARTÍCULO \t  PRECIO\tVENDIDOS\t IMPORTE\n");
		printf("---------------------------------------------------------------\n");
		for(i = 0; i < numbOfRows; i++){
			printf("%-10s\t %8.2f  \t  %.0f\t\t%.2f \n", matrix[i], pricesVector[i], soldedVector[i],
					pricesVector[i]*soldedVector[i]);
			totalAmount += pricesVector[i]*soldedVector[i];
			if(i == 0){
				mostSolded[0] = i;
				lessSolded[0] = i;
				mostSolded[1] = soldedVector[i];
				lessSolded[1] = soldedVector[i];
			}
			else if(soldedVector[i] > mostSolded[1]){
				mostSolded[0] = i;
				mostSolded[1] = soldedVector[i];
			}
			else if(soldedVector[i] < lessSolded[1]){
				lessSolded[0] = i;
				lessSolded[1] = soldedVector[i];
			}
		}
		printf("---------------------------------------------------------------\n");
		printf("\t\t\t\t%-10s\t%.2f", "Total", totalAmount);
		printf("\nProducto más vendido: %s\t\n", matrix[mostSolded[0]]);
		printf("\nProducto menos vendido: %s\t\n\n", matrix[lessSolded[0]]);
	}
	else{
		printf("No hay productos registrados\n");
	}
}


int DeleteAProduct(char products[][LENGTH], float *pricesVector, float *soldedVector, int addedProducts){
	//Deletes a product from the matrix. It updates too the 2 related vectors (price and solded)
	int position;
	char deletingString[LENGTH];
	char option;
	int itemDeleted = 0;

	printf("Introduce el nombre del artículo a borrar: ");
	scanf("%s", deletingString);
	position= XInMatrix(deletingString, products, LENGTH);
	if(position >= 0){
		printf("Seguro que quieres borrar %s? Esta acción es definitiva [S/n] ", deletingString);
		while(getchar()!= '\n');
		scanf("%c", &option);
		switch(option){

		case 's':
			strcpy(products[position], products[addedProducts -1]);
			pricesVector[position] = pricesVector[addedProducts - 1];
			soldedVector[position] = soldedVector[addedProducts -1];;
			itemDeleted = 1; break;

		case 'n': printf("No se ha borrado el artículo\n "); break;

		default: printf("No has introducido una opción válida\n");
		}
	}
	else{
		printf("%s no es un producto registrado", deletingString);
	}
	if (itemDeleted){
		return 1;
	}
	else return 0;
}

int deleteAll(int addedProducts, float *pricesVector, float *soldedVector){
	//Deletes al the info of all added products.
	int i;
	char deleteAll;

	printf("Esta acción borrará todos los artículos. ¿Está seguro?[S/n]\n");
	scanf("%c", &deleteAll);
	switch(deleteAll){
	case 's':
		for(i = 0; i < addedProducts; i++){
			pricesVector[i] = 0;
			soldedVector[i] = 0;
		}
		break;
	case 'n': printf("No se han borrado los artículos \n");
		break;
	default: printf ("No has introducido una opción válida\n");
	}
	if (deleteAll == 's'){
		return 1;
	}
	else{
		return 0;
	}
}




int main(){
    int choice;
    char products[MAX_PRODUCTS][LENGTH]={"ratón", "pc", "teclado", "alfombra"};
    float soldedVector[MAX_PRODUCTS]={3, 2, 1, 2};
    float prices[MAX_PRODUCTS]={15, 1000, 30, 8};
    int addedProducts = 4;


    do{

        ShowMenu();

        //Select an option
        printf("Selecciona una opción: ");
        scanf("%i",&choice);
        EmptyBuffer();

        //Cases
        switch (choice) {
            case 1:
            	AddNewProduct(products, prices, addedProducts);
            	addedProducts++;
                break;

            case 2:
            	SellAProduct(products, soldedVector);
                break;

            case 3: printf("\n------------Mostrar información------------\n");
            	PrintTable(products, prices, soldedVector, addedProducts);
                break;

            case 4: printf("Borrar un artículo\n");
            	if (DeleteAProduct(products, prices, soldedVector, addedProducts)){
            		addedProducts--;
            	}
            	break;

            case 5:
                if(deleteAll(addedProducts, prices, soldedVector)){
                	addedProducts = 0;
                }
                break;

            case 6: printf("Saliendo del programa...\nPrograma cerrado\n"); break;

            default: printf("No introdujiste una opción válida\n");break;
        }
    }
    while (choice != 6);
}
