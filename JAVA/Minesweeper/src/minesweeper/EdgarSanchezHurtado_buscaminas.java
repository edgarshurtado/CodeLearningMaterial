/*
    Exercise description
*/

package minesweeper;

import java.io.*;

/**
 *
 * @author Edgar S. Hurtado
 */


public class EdgarSanchezHurtado_buscaminas {

    static int turnOption() {
        int option;
        
        while (true) {
        System.out.println("1. Flip square");
        System.out.println("2. New flag");
        System.out.print("Please, select an option: ");
        option = UsefulFunctions.intImput();
            if (option >= 1 && option <= 3) {
               return option; 
            }else{
                System.out.println("Incorrect option");
            }
        }
    }
    
    static int[] enterPosition(){
        int[] position = new int[2];
        System.out.print("Enter the row: ");
        position[0] = (UsefulFunctions.intImput()-1);
        System.out.println("");
        System.out.print("Enter the column: ");
        position[1] = (UsefulFunctions.intImput()-1);
        return position;
    }

    public static void main(String[] args) {
        Board board;
        int boardDimension;
        int cols;
        int mines;
        int option;
        
        System.out.println("MINESWEEPER GAME by Edgar S. Hurtado");
        System.out.println("------------------------------------");
        System.out.println("Game settings");
        System.out.print("Enter a nº for board dimension: ");
        boardDimension = UsefulFunctions.intImput();
        System.out.println("");
        System.out.print("Enter the number of mines: ");
        mines = UsefulFunctions.intImput();
        System.out.println("");
        
        board = new Board(boardDimension, mines);

        while (!board.isGameOver()) {
            board.printBoard(false);
            option = turnOption();
            
            switch (option) {
                case 1: 
                    System.out.println("Flip a square");
                    board.flipSquare(enterPosition());
                    break;
                case 2: 
                    System.out.println("Add a new Flag");
                    board.newFlag(enterPosition());
                    break;
                case 3:
                    System.out.println("Show the mines");
                    board.printBoard(true);
                    break;
                
                default:
                    throw new AssertionError();
            }
        }
        board.printGameOver();
    }

}
