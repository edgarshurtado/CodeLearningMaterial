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
        //Constants
    static final int maxMatrices = 100;
    static final int maxMatrixSize = 10;
        //Nº of matrices introduced into matrices vector.
    static int totalMatrices = 0;
        //Vector where the matrices are stored.
    static int matricesVector[][][] = 
            new int[maxMatrices][maxMatrixSize][maxMatrixSize];
        //Vector to know the dimensions of every matrix introduced.
    static int matricesSizes[][]= new int[maxMatrices][2];
    
    //USEFUL FUNCTIONS
    static int intImput(){
        //Function for allow keyboard integer inputs
        BufferedReader dataIn = new BufferedReader
                (new InputStreamReader(System.in));
        int tempInt = 0;
        boolean correctInput = false;
        while(!correctInput){
            try {
                tempInt = Integer.parseInt(dataIn.readLine());
                correctInput = true;
            } catch (Exception e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInt;
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
       int rows; 
       int cols;
       int number;
       
       if(totalMatrices < maxMatrices){
            //Fix the matrix dimesion. Dimensional values stored in a global variable
            System.out.print("Nº of rows for the new matrix: ");
            rows = intImput();
            while (rows > maxMatrixSize){
                System.out.println("Rows out of range. Try again: ");
                System.out.print("Nº rows for the new matrix: ");
                rows = intImput();
            }
            matricesSizes[totalMatrices][0] = rows;
            
            System.out.print("Nº of columns for the new matrix: ");
            cols = intImput();
            while (cols > maxMatrixSize){
               System.out.println("Cols out of range. Try again: ");
               System.out.print("Nº cols for the new matrix: ");
               cols = intImput();
            }
            matricesSizes[totalMatrices][1] = cols;

            //Introduce numbers into the matrix
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print("Write a number: ");
                    number = intImput();
                    matricesVector[totalMatrices][row][col] = number;
                }   
            }
            totalMatrices++; 
       }
       else{
           System.out.println("You've reached the maximum amount of matrices"
                   + " allowed");
       }
       
    }
    
    static void printMatrix(int matrix[][], int dimension[]){
        // The dimension vector has to have the nº of rows at the 0th position
        //and the cols at the 1st position
        
        for (int row = 0; row < dimension[0]; row++) {
            for (int col = 0; col < dimension[1]; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
            
        }
    }
    
    static void matrixAddition(int matrix1[][], int matrix2[][],
            int destinationMatrix[][]){
        
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                destinationMatrix[row][col] = matrix1[row][col] +
                        matrix2[row][col];
            }
        }
    }
    
    static void matrixSubstraction(int matrix1[][], int matrix2[][],
            int destinationMatrix[][]){
        
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                destinationMatrix[row][col] = matrix1[row][col] -
                        matrix2[row][col];
            }
        }
    }
    
    static void matrixByNumber(int matrix[][], int number, int destinationMatrix[][]){
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                destinationMatrix[row][col] = matrix[row][col] * number;
            }
        }
    }
    
    static void matrixMultiplication(int matrix1[][], int matrix2[][],
            int destinationMatrix[][]){
        /*
            Being A matrix size (m x n) and B matrix size (n x p). The result is
            a C matrix with the size (m x p)
        */
        int m, n, p;
        
        //Cheking out A cols = B rows
        if (matrix1[0].length == matrix2.length) {
            m = matrix1.length;
            p = matrix2[0].length;
            n = matrix1[0].length;
            for (int i = 0; i < 10; i++) {
                
            }
        }
        else{
            System.out.println("Operation can't be done");
        }
    }
    
    //MAIN FUNCTION
    public static void main(String[] args) {
        
        int number;
        int matrix1[][] = {{1, 2},{3, 4}};
        int matrix2[][] = {{3, 4},{1, 2}};
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = {2, 2};
        matrixByNumber(matrix2, 2, tempMatrix);
        printMatrix(tempMatrix, tempMatrixSize);
       
    }

}
