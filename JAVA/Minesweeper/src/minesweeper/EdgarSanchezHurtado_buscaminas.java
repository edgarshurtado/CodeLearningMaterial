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

    
    public static void main(String[] args) {
       Board board = new Board(4);
       board.flipCascade(new int[]{2,3});
       board.printBoard();
       
       
    }

}
