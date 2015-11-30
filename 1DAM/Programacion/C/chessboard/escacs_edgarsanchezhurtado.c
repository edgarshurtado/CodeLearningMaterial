/*
 * escacs_edgarsanchezhurtado.c
 *
 *  Created on: 1/12/2014
 *      Author: Rumil
 */


#include <stdio.h>
#include <string.h>

//Board defining
#define ROWS 8
#define COLS 8
char board[ROWS][COLS];
//Board leyend.
#define EMPTY '_'
#define MOVEMENT '*'
#define KING 'K'
#define HORSE 'H'
#define BISHOP 'B'
#define TOWER 'T'
#define QUEEN 'Q'
#define IMPEDIMENT 'I'

//HELPFUL FUNCTIONS
void voidBoard(){
	int row, col;

	for(row = 0; row < ROWS; row++){
		for(col = 0; col < COLS; col++){
			board[row][col] = EMPTY;
		}
	}
}

void printBoard(){
	int row, col;

	printf(" ");
	for(col=0; col < COLS; col++){
		printf(" %i", col+1);
	}
	printf("\n");

	for(row = 0; row < ROWS; row++){
		printf("%i|", row+1);
		for(col = 0; col < COLS; col++){
			printf("%c|", board[row][col]);
		}
		printf("\n");
	}
}

void addPiece(char piece, int *position){
	board[position[0]-1][position[1]-1] = piece;
}

void pieceIndex(int *position){
	//Takes the position in the board of one piece and changes the values into vector index
	position[0] -= 1;
	position[1] -= 1;
}

void deleteMovs(){
	int row, col;

	for(row = 0; row < ROWS; row++){
		for(col = 0; col < COLS; col++){
			if(board[row][col] == MOVEMENT){
				board[row][col] = EMPTY;
			}
		}
	}
}

int intrPos(char *introducedAxis){
	int inRange = 0;
	int input;
	int maxIndex;

	if(!strcmp("fila", introducedAxis)){
		maxIndex = ROWS;
	}
	else{
		maxIndex = COLS;
	}

	while(!inRange){
		printf("\nEscribe la %s :", introducedAxis);
		scanf("%i", &input);
		if(input <= maxIndex && input > 0){
			inRange = 1;
		}
		else{
			printf("\n%i está fuera de rango.", input);
		}
	}

	return input;
}

//PIECES MOVEMENTS
void straightMovs(int *position){
	int row, col;

	//Upper mov
	for(row = position[0]-1; row >= 0; row--){
		if(board[row][position[1]] == EMPTY){
			board[row][position[1]] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//Downward mov
	for(row = position[0]+1; row < ROWS; row++){
		if(board[row][position[1]] == EMPTY){
			board[row][position[1]] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//Right mov
	for(col = position[1]+1; col < COLS; col++){
		if(board[position[0]][col] == EMPTY){
			board[position[0]][col] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//Left mov
	for(col = position[1]-1; col >= 0; col--){
		if(board[position[0]][col] == EMPTY){
			board[position[0]][col] = MOVEMENT;
		}
		else{
			break;
		}
	}
}

void diagonalMovs(int *position){
	int col, row;

//	//Up right mov
	for(row = position[0]-1, col = position[1] + 1; row >= 0 && col < COLS; row--, col++){
		if(board[row][col] == EMPTY){
			board[row][col] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//Down Right
	for(row = position[0] + 1, col = position[1] + 1; row >= 0 && col < COLS; row++, col++){
		if(board[row][col] == EMPTY){
			board[row][col] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//UP Left
	for(row = position[0] - 1, col = position[1] - 1; row >= 0 && col >= 0; row--, col--){
		if(board[row][col] == EMPTY){
			board[row][col] = MOVEMENT;
		}
		else{
			break;
		}
	}

	//Down Left
	for(row = position[0] + 1, col = position[1] - 1; row < ROWS && col >= 0; row++, col--){
		if(board[row][col] == EMPTY){
			board[row][col] = MOVEMENT;
		}
		else{
			break;
		}
	}
}


void horseMov(int *position){
	int row = position[0];
	int col = position[1];
	int straightMov = 2;
	int bendMov = 1;

	//Moves with +- 2 col positions and +- 1 row positions
	if(col + straightMov < COLS){
		if(row - bendMov >= 0 && board[row - bendMov][col + straightMov] == EMPTY){
			board[row - bendMov][col + straightMov] = MOVEMENT;
		}
		if (row + bendMov < ROWS && board[row + bendMov][col + straightMov] == EMPTY){
			board[row + bendMov][col + straightMov] = MOVEMENT;
		}
	}
	if(col - straightMov >= 0){
		if(row - bendMov >= 0 && board[row - bendMov][col - straightMov] == EMPTY){
			board[row - bendMov][col - straightMov] = MOVEMENT;
		}
		if (row + bendMov < ROWS && board[row + bendMov][col - straightMov] == EMPTY){
			board[row + bendMov][col - straightMov] = MOVEMENT;
		}
	}

	//Moves with +- 2 row positions and +- 1 col position
	if(row - straightMov >= 0){
		if(col + bendMov < COLS && board[row-straightMov][col+bendMov] == EMPTY){
			board[row-straightMov][col+bendMov]=MOVEMENT;
		}
		if(col - bendMov >= 0 && board[row-straightMov][col-bendMov] == EMPTY){
			board[row-straightMov][col-bendMov]=MOVEMENT;
		}
	}
	if(row + straightMov >= 0){
			if(col + bendMov < COLS && board[row+straightMov][col+bendMov] == EMPTY){
				board[row+straightMov][col+bendMov]=MOVEMENT;
			}
			if(col - bendMov >= 0 && board[row+straightMov][col-bendMov] == EMPTY){
				board[row+straightMov][col-bendMov]=MOVEMENT;
			}
		}
}

void kingMov(int*position){
	int row, col;

	for(row = position[0]-1; row <= position[0]+1; row++){
		for(col = position[1]-1; col <= position[1]+1; col++){
			if(board[row][col] == EMPTY){
				board[row][col] = MOVEMENT;
			}
		}
	}
}

//MAIN FUNCTIONS

void addPieceAndMov(char piece, int *position){
	int indexPosition[2] = {position[0], position[1]};

	pieceIndex(indexPosition);
	board[indexPosition[0]][indexPosition[1]] = piece;

	switch(piece){
	case QUEEN:
		straightMovs(indexPosition);
		diagonalMovs(indexPosition);
		break;
	case KING:
		kingMov(indexPosition); break;
	case TOWER:
		straightMovs(indexPosition); break;
	case HORSE:
		horseMov(indexPosition); break;
	case BISHOP:
		diagonalMovs(indexPosition);
	}
}

int selectOption(){
	int option;

	printf("\n----------OPCIONES TABLERO AJEDREZ------------\n\n");
	printf("1. Mostrar movimientos de una ficha\n");
	printf("2. Poner impedimento\n");
	printf("3. Borrar tablero\n");
	printf("4. Salir\n");

	printf("¿Qué quieres hacer?: ");
	scanf("%i", &option);

	return option;
}

int main(){
	int piecePosition[2];
	int option;
	char piece;
	char lastPieceAdded;
	int lastPiecePosition[2];

	voidBoard();
	do{
		printBoard();
		option = selectOption();
		switch(option){
		case 1:
			printBoard();
			printf("Selecciona una ficha: Q (reina), K (rey), T (torre), B (alfil), H (caballo): ");
			while(getchar() != '\n');
			scanf("%c", &piece);

			//Change lowercase into uppercase (error control)
			if(piece > 'T'){
				piece -= ('a'-'A');
			}

			if(piece == 'Q' || piece == 'K' || piece == 'T' || piece == 'B' || piece == 'H'){
				printf("\nPosición para la ficha:\n");
				piecePosition[0] = intrPos("fila");
				piecePosition[1] = intrPos("columna");

				//Add piece and movements
				deleteMovs();
				addPieceAndMov(piece, piecePosition);
				lastPieceAdded = piece;
				lastPiecePosition[0] = piecePosition[0];
				lastPiecePosition[1] = piecePosition[1];

			}
			else{
				printf("\nNo has introducido una ficha válida.\n\n");
			}
			break;

		case 2:
			printf("\nPoner impedimento\n");
			deleteMovs();
			piecePosition[0] = intrPos("fila");
			piecePosition[1] = intrPos("columna");
			if(board[piecePosition[0]-1][piecePosition[1]-1] == EMPTY){
				board[piecePosition[0]-1][piecePosition[1]-1] = IMPEDIMENT;
				addPieceAndMov(lastPieceAdded, lastPiecePosition);
			}
			else{
				printf("Ya hay una ficha en esa posición\n\n");
			}
			break;
		case 3:
			voidBoard();
			break;
		case 4: printf("\nPrograma cerrado\n");break;
		default: printf("Opción no válida\n");
		}

	}while(option != 4);
}
