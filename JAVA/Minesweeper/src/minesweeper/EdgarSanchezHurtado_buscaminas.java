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
            if (option == 1 || option == 2) {
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
        Board board = new Board(4);
        int option;

        while (!board.getMinesExploded()) {
            board.printBoard();
            option = turnOption();
            
            switch (option) {
                case 1: board.flipSquare(enterPosition());
                    
                    break;
                case 2:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }

       
    }

}
