/*
 * Program to make matrix operations
*/

package matrices_edgarsanchezhurtado;

import java.io.*;
import java.util.Random;
/**
 *
 * @author Edgar S. Hurtado
 */


public class Matrices_EdgarSanchezHurtado {
    //CONSTANTS
    static final int maxMatrices = 100;
    static final int maxMatrixSize = 10;
        
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
            } catch (IOException | NumberFormatException e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInt;
    } 
    
    static int randomNumber(){
        int randomNumber;
        
        Random randomGenerator = new Random();
        
        randomNumber = randomGenerator.nextInt(10);
        
        return randomNumber;
    }
    
    
    
    static void newMatrix(int[][] destinationMatrixVector, int matrixSize[]){
       
        /*
        Fills a given matrix with random numbers storing its dimensions in a 
        second vector
        */
        
        int rows; 
        int cols;
        int number;
       
            //Fixing of the matrix dimensions
            System.out.print("Nº of rows for the new matrix: ");
            rows = intImput();
            while (rows > destinationMatrixVector.length){
                System.out.println("Rows out of range. Try again: ");
                System.out.print("Nº rows for the new matrix: ");
                rows = intImput();
            }
            matrixSize[0] = rows;
            
            System.out.print("Nº of columns for the new matrix: ");
            cols = intImput();
            while (cols > destinationMatrixVector[0].length){
               System.out.println("Cols out of range. Try again: ");
               System.out.print("Nº cols for the new matrix: ");
               cols = intImput();
            }
            matrixSize[1] = cols;

            System.out.println("");
            
            //Introducction of numbers into the matrix
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    number = randomNumber();
                    destinationMatrixVector[row][col] = number;
                }   
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
    
    static void matrixAddition(int[][] matrix1, int[][] matrix2, 
            int[] matricesSize, int[][] outputMatrix){
        
        for (int row = 0; row < matricesSize[0]; row++) {
            for (int col = 0; col < matricesSize[1]; col++) {
                outputMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
    }
    
    static void matrixSubstraction(int matrix1[][], int matrix2[][],
            int[] matricesSize,int[][] outputMatrix){
        
        for (int row = 0; row < matricesSize[0]; row++) {
            for (int col = 0; col < matricesSize[1]; col++) {
                outputMatrix[row][col] = matrix1[row][col] - matrix2[row][col];
            }
        }
    }
    
    static void matrixByNumber(int[][] matrix, int number, int[][] outputMatrix){
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                outputMatrix[row][col] = matrix[row][col] * number;
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
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    destinationMatrix[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        destinationMatrix[i][j] = matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Operation can't be done");
        }
    }
    
    static void matrixTransposition(int originMatrix[][],
            int destinationMatrix[][]){
        
        for (int i = 0; i < originMatrix.length; i++) {
            for (int j = 0; j < originMatrix[0].length; j++) {
                destinationMatrix[j][i] = originMatrix[i][j];
            }
        }
    }
    
    //PROGRAM SPECIFIC FUNCTIONS
    
    static void showMatricesSizes(int totalMatrices, int matricesSizes[][]){
        for (int i = 0; i < totalMatrices; i++) {
                        System.out.println("Matrix " + (i+1) + ": "
                                + matricesSizes[i][0] +" x "+ matricesSizes[i][1]);
                    } 
    }

    static void menu() {
        System.out.println("-------------MENU------------");
        System.out.println("");
        System.out.println("1. New Matrix");
        System.out.println("2. View matrix");
        System.out.println("3. Matrix addition");
        System.out.println("4. Matrix substraction");
        System.out.println("5. Matrix product by a number");
        System.out.println("6. Matrix multiplication");
        System.out.println("7. Transposed matrix");
        System.out.println("8. Exit");
        System.out.println("");
        System.out.print("Enter your option: "); 
    }
    
    static void saveMatrix(int[][] originMatrix, int[] originMatrixSize,
            int[][] destinationMatricesVector, int[] destinationMatricesSizesVector){
        /*
        Copies a matrix and the array where is its size.
        */
        
        //Copy the matrix
        for (int i = 0; i < originMatrixSize[0]; i++) {
            System.arraycopy(originMatrix[i], 0, destinationMatricesVector[i],
                    0, originMatrixSize[1]);
        }
        //Copy the size array
        System.arraycopy(originMatrixSize, 0, destinationMatricesSizesVector,
                0, originMatrixSize.length); 
    }
    
    static boolean case1IntroNewMatrix(int[][] destinationMatrix, 
            int[] destinationMatrixSize){
        /*
        Introduces a new matrix in destinationMatrix if it's possible. 
        The dimesion of the new matrix is stored in the vector destinationMatrixSize.
        */
       
        try {
            newMatrix(destinationMatrix,destinationMatrixSize);
            printMatrix(destinationMatrix, destinationMatrixSize);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    static void case2ShowMatrix(int totalMatrices, int matricesVector[][][],
            int matricesSizes[][]){
        int matrixSelection;
        
        System.out.println("Select the matrix you want to display:");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.print("Enter the number of the matrix: ");
        matrixSelection = intImput();
        
        if (matrixSelection <= totalMatrices && totalMatrices != 0) {
            printMatrix(matricesVector[matrixSelection-1], 
                    matricesSizes[matrixSelection-1]);
        }
    }
    
    static void case3AddingMatrices(int[][][] matricesVector, 
            int[][] outputMatrix, int[] outputMatrixSize, int[][] matricesSizes){
        int matrix1;
        int matrix2;
     
        //Selection of the matrices. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.print("Matrix 1: ");
        matrix1 = (intImput() -1);
        System.out.print("\nMatrix 2: ");
        matrix2 = (intImput() - 1);
        
        if (matricesSizes[matrix1][0] == matricesSizes[matrix2][0]
                && matricesSizes[matrix1][1] == matricesSizes[matrix2][1]) {
            
            System.arraycopy(matricesSizes[matrix1], 0, 
                    outputMatrixSize, 0, outputMatrixSize.length);
            
            matrixAddition(matricesVector[matrix1], matricesVector[matrix2],
                    outputMatrixSize, outputMatrix);
            
            printMatrix(outputMatrix, outputMatrixSize);
        }
    }
    
    static void case4SubstractingMatrices(int[][][] matricesVector, 
            int[][] outputMatrix, int[] outputMatrixSize, int[][] matricesSizes){
        int matrix1;
        int matrix2;
     
        //Selection of the matrices. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.print("Matrix 1: ");
        matrix1 = (intImput() -1);
        System.out.print("\nMatrix 2: ");
        matrix2 = (intImput() - 1);
        
        if (matricesSizes[matrix1][0] == matricesSizes[matrix2][0]
                && matricesSizes[matrix1][1] == matricesSizes[matrix2][1]) {
            
            System.arraycopy(matricesSizes[matrix1], 0, 
                    outputMatrixSize, 0, outputMatrixSize.length);
            
            matrixSubstraction(matricesVector[matrix1], matricesVector[matrix2],
                    outputMatrixSize, outputMatrix);
            
            printMatrix(outputMatrix, outputMatrixSize);
        }
    }
    
    static void case5MatrixByNumber(int[][][] matricesVector, int[][] matricesSizes,
            int[][] outputMatrix, int[] outputMatrixSize){
        
        int matrix;
        int number;
        
        //Selection of the matrix. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.print("Select the matrix : ");
        matrix = (intImput() -1);
        System.out.print("Enter the number to multiply the matrix : ");
        number = intImput();
        
        matrixByNumber(matricesVector[matrix], number, outputMatrix);
        
        printMatrix(outputMatrix, outputMatrixSize);
    }
            
    public static void main(String[] args) {
        //Array to store all the matrices.
        int matricesVector[][][] = 
                new int[maxMatrices][maxMatrixSize][maxMatrixSize];
        //Vector to know the dimensions of every matrix introduced.
        int matricesSizes[][]= new int[maxMatrices][2];
        
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        int totalMatrices = 0;
        int option = -1;
        
        while (option != 8) {
            
            menu();
            option = intImput();
            System.out.println("");
            

            switch (option) {
                case 1:
                    if (totalMatrices < maxMatrices) {
                        case1IntroNewMatrix(tempMatrix, tempMatrixSize);
                        
                        saveMatrix(tempMatrix, tempMatrixSize,
                                matricesVector[totalMatrices],
                                matricesSizes[totalMatrices]);
                        
                        totalMatrices++;
                        
                    } else{
                        System.out.println("Maximum amount of matrices reached");
                    }  
                    System.out.println("");
                    break;

                case 2:
                    case2ShowMatrix(totalMatrices, matricesVector, matricesSizes);
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Availabe matrices\n");
                    showMatricesSizes(totalMatrices, matricesSizes);
                    System.out.println("\nSelect the matrices for the addition:");
                    System.out.println("(remember that both should have the same size)\n");
                    case3AddingMatrices(matricesVector, tempMatrix,
                            tempMatrixSize, matricesSizes);
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Availabe matrices\n");
                    showMatricesSizes(totalMatrices, matricesSizes);
                    System.out.println("\nSelect the matrices for the substraction:");
                    System.out.println("(remember that both should have the same size)\n");
                    case4SubstractingMatrices(matricesVector, tempMatrix,
                            tempMatrixSize, matricesSizes);
                    System.out.println("");
                    break;
                case 5:
                    
                    break;
                case 6:
                    break;
                case 7:
                    break;                              
                case 8:
                    break;
                default:
                    System.out.println("Bad input");
            }
            System.out.println("");

        }
    }

}
