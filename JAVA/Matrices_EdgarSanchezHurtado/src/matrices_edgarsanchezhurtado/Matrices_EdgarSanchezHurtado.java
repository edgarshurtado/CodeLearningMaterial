/*
 * Program to make matrix operations
*/

package matrices_edgarsanchezhurtado;

import java.io.*;

/**
 *
 * @author Edgar S. Hurtado
 */


public class Matrices_EdgarSanchezHurtado {
    //GLOBAL VARIABLES
    static final int maxMatrices = 100;
    static final int maxMatrixSize = 10;
    static final int totalMatrices = 0;
    static int matricesVector[][][] = 
            new int[maxMatrices][maxMatrixSize][maxMatrixSize];
    static int matricesSizes[][][] = new int[maxMatrices][1][1];
    
    //USEFUL FUNCTIONS
    static String rawInput(){
        BufferedReader dataIn = new BufferedReader
                (new InputStreamReader(System.in));
        String temp ="";
        
        try {
            temp = dataIn.readLine();
        } catch (Exception e) {
        }
        
        return temp;
    } 

    //PROGRAM LOGIC
    static void menu() {
        System.out.println("-------------MENU------------");
        System.out.println("");
        System.out.println("1. New Matrix");
        System.out.println("2. View matrix");
        System.out.println("3. Matrix addition");
        System.out.println("4. Matrix substraction");
        System.out.println("5. Matrix product by a number");
        System.out.println("6. Matrix product");
        System.out.println("7. Transposed matrix");
        System.out.println("8. Exit");
        
    }
    static void newMatrix(){
        int cols;
        int rows;
        int number;
        
        System.out.print("Nº of rows for the new matrix: ");
        rows = Integer.parseInt(rawInput());
        
        System.out.print("Nº of columns for the new matrix: ");
        cols = Integer.parseInt(rawInput());
        
    }
    
    //MAIN
    public static void main(String[] args) {
       
        
       
        
       newMatrix();
    }

}
