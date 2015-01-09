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
    //GLOBAL VARIABLES
        //Constants
    static final int matrixMaxSize = 100;
    static final int maxMatrixSize = 10;
        //Nº of matrices introduced into matrices vector.
//    static int totalMatrices = 0;
        //Vector where the matrices are stored.
//    static int matricesVector[][][] = 
//            new int[maxMatrices][maxMatrixSize][maxMatrixSize];
        //Vector to know the dimensions of every matrix introduced.
    static int matricesSizes[][]= new int[matrixMaxSize][2];
    
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
    
    
    
    static void newMatrix(int[][][] destinationMatricesVector, int matrixSize[],
            int totalMatrices){
        
       int rows; 
       int cols;
       int number;
       
 
            System.out.print("Nº of rows for the new matrix: ");
            rows = intImput();
            while (rows > destinationMatricesVector[0].length){
                System.out.println("Rows out of range. Try again: ");
                System.out.print("Nº rows for the new matrix: ");
                rows = intImput();
            }
            matrixSize[0] = rows;
            
            System.out.print("Nº of columns for the new matrix: ");
            cols = intImput();
            while (cols > destinationMatricesVector[0][0].length){
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
                    destinationMatricesVector[totalMatrices][row][col] = number;
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
    
    static void case1IntroNewMatrix(int[][][] destinationMatricesVector, int matrixSize[],
            int totalMatrices){
        
        newMatrix(destinationMatricesVector, matrixSize, totalMatrices);
        printMatrix(destinationMatricesVector[0], matrixSize);
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
    
    static void case3AddingMatrices(int matricesVector[][][], int totalMatrices){
        int matrixSelected1;
        int matrixSelected2;
        
        System.out.println("Availabe matrices");
//        showMatricesSizes();
        System.out.println("\nSelect the matrices for the addition:");
        System.out.println("(remember they both should have the same size)\n");
        System.out.print("Matrix 1: ");
        matrixSelected1 = intImput();
        System.out.println("\nMatrix 2: ");
        matrixSelected2 = intImput();
        
        
    }
            
    public static void main(String[] args) {
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        int totalMatrices = 0;
        int option = -1;
        int matricesVector[][][] = 
            new int[matrixMaxSize][maxMatrixSize][maxMatrixSize];

        
        while (option < 8) {
            
            menu();
            option = intImput();
            System.out.println("");
            

            switch (option) {
                case 1:
//                    if (newMatrix(matricesVector)){
//                    totalMatrices++;
//                    System.out.println("Generated matrix: \n");
//                    printMatrix(matricesVector[totalMatrices - 1],
//                            matricesSizes[totalMatrices - 1]);              
//                    }
                    case1IntroNewMatrix(matricesVector, tempMatrixSize, totalMatrices);
                    break;

                case 2:
                    case2ShowMatrix(totalMatrices, matricesVector, matricesSizes);
                    break;
                case 3:
                    System.out.println("Select the matrices for the addition:");
                    System.out.println("(remember they both should have same size)\n");
//                    showMatricesSizes(totalMatrices, );
                    break;
                case 4:
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
