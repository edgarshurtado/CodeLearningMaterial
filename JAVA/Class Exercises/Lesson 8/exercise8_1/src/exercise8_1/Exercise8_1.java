/*
    Exercise description
*/

package exercise8_1;

import java.io.*;

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
        for (int i = 0; i < matrix.length; i++) {
            printVectInt(matrix[i]);
        }
    }
    
    public static void main(String[] args) {
       int [][] matrix = {{1,2,3},{4,5,6}};
       
        printMatrixInt(matrix);
    }

}
