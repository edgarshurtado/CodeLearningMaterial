/*
    Exercise description
*/

package exercises8;


/**
 *
 * @author Edgar S. Hurtado
 */


public class Exercise8_1 {

    static void printVectInt(int [] vector){
        for (int i = 0; i < vector.length - 1; i++) {
            System.out.print(vector[i] + ", ");
        }
        System.out.println(vector[vector.length -1] + ".");
    }
    
    static void printMatrixInt(int [][] matrix){
        for (int[] row : matrix) {
            printVectInt(row);
        }
    }
}
