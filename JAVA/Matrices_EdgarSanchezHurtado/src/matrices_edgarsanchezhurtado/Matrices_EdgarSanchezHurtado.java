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
    
    static void newMatrix(int[][] outputMatrix, int[] outputMatrixSize){
       
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
            while (rows > outputMatrix.length){
                System.out.println("Rows out of range. Try again: ");
                System.out.print("Nº rows for the new matrix: ");
                rows = intImput();
            }
            outputMatrixSize[0] = rows;
            
            System.out.print("Nº of columns for the new matrix: ");
            cols = intImput();
            while (cols > outputMatrix[0].length){
               System.out.println("Cols out of range. Try again: ");
               System.out.print("Nº cols for the new matrix: ");
               cols = intImput();
            }
            outputMatrixSize[1] = cols;

            System.out.println("");
            
            //Introducction of numbers into the matrix
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    number = randomNumber();
                    outputMatrix[row][col] = number;
                }   
            }
    }
    
    static void printMatrix(int[][] matrix, int[] matrixSize){     
        //Prints a matrix in rows and cols
        for (int row = 0; row < matrixSize[0]; row++) {
            for (int col = 0; col < matrixSize[1]; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }
    
    static void matrixAddition(int[][] matrix1, int[][] matrix2, 
            int[] matricesSize, int[][] outputMatrix){
        /*
        Sum of 2 matrices with the same size.
        */
        try {
            for (int row = 0; row < matricesSize[0]; row++) {
                for (int col = 0; col < matricesSize[1]; col++) {
                    outputMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
                }
            }
        } catch (Exception e) {
            System.out.println("operation can't be done");
        }
        
    }
    
    static void matrixSubstraction(int matrix1[][], int matrix2[][],
            int[] matricesSize,int[][] outputMatrix){
        /*
        Substraction of 2 matrices with the same size
        */
        
        try {
            for (int row = 0; row < matricesSize[0]; row++) {
                for (int col = 0; col < matricesSize[1]; col++) {
                    outputMatrix[row][col] = matrix1[row][col] - matrix2[row][col];
                }
            }
        } catch (Exception e) {
            System.out.println("operation can't be done");
        }
    }
    
    static void matrixByNumber(int[][] matrix, int number, int[][] outputMatrix){
        /*
        Multiplies each number of the matrix by a given number.
        */
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                outputMatrix[row][col] = matrix[row][col] * number;
            }
        }
    }
    
    static boolean matrixMultiplication(int[][] matrix1, int[] matrix1Size,
            int[][] matrix2, int[] matrix2Size,
            int[][] outputMatrix, int[] outputMatrixSize){
        /*
            Being A matrix size (m x n) and B matrix size (n x p). The result is
            a C matrix with the size (m x p)
        */
        int m, n, p;
        
        //Cheking out A cols = B rows
        if (matrix1Size[0] == matrix2Size[1]) {
            m = matrix1Size[0];
            p = matrix2Size[1];
            n = matrix1Size[1];
            outputMatrixSize[0] = m;
            outputMatrixSize[1] = p;
            //Multiplication logic
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    outputMatrix[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        outputMatrix[i][j] = matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            
            return true;
        }
        else{
            System.out.println("Operation can't be done");
            return false;
        }
    }
    /**
     *Stores in a vector the transposed matrix of a given matrix.
     * @param originMatrix
     * @param outputMatrix 
     */
    static void matrixTransposition(int[][] originMatrix,
            int[][] outputMatrix){
        for (int i = 0; i < originMatrix.length; i++) {
            for (int j = 0; j < originMatrix[0].length; j++) {
                outputMatrix[j][i] = originMatrix[i][j];
            }
        }
    }
    
    //PROGRAM SPECIFIC FUNCTIONS
    
    static void showMatricesSizes(int totalMatrices, int[][] matricesSizes){
        for (int i = 0; i < totalMatrices; i++) {
            System.out.println("Matrix " + (i + 1) + ": "
                    + matricesSizes[i][0] + " x " + matricesSizes[i][1]);
        }
        System.out.println("");
    }
    
    static int selectMatrixIndex(int totalMatrices){
        /*
        Take a number from the user, converts it to a vector index and cheks out
        if the index matches with any matrix.
        */
        int number;
        
        number = intImput()-1;
        while(number >= totalMatrices) {
            System.out.println("The matrix selected doesn't exist. Try again");
            number = intImput()-1;
        }
        return number;
    }

    static void menu() {
        System.out.println("-------------MENU------------");
        System.out.println("\n1. New Matrix");
        System.out.println("2. View matrix");
        System.out.println("3. Matrix addition");
        System.out.println("4. Matrix substraction");
        System.out.println("5. Matrix by a number");
        System.out.println("6. Matrix multiplication");
        System.out.println("7. Transposed matrix");
        System.out.println("8. Exit\n");
        System.out.print("Enter your option: "); 
    }
    
    static boolean saveMatrix(int[][] originMatrix, int[] originMatrixSize,
            int[][] outputMatrix, int[] outputMatrixSize){
        /*
        Copies a matrix and the array where is its size.
        */
        
        int save;
        
        System.out.print("\nDo you wanna save the matrix? 1 = Yes, 2 = No: ");
        save = intImput();
        
        if (save == 1) {
            //Copy the matrix
            for (int i = 0; i < originMatrixSize[0]; i++) {
                System.arraycopy(originMatrix[i], 0, outputMatrix[i],
                        0, originMatrixSize[1]);
            }
            //Copy the size array
            System.arraycopy(originMatrixSize, 0, outputMatrixSize,
                    0, originMatrixSize.length);
            System.out.println("The matrix have been saved\n");
            return true;
        } else {
            System.out.println("\nThe matrix hasn't been saved");
            return false;
        }
    }
    
    static boolean case1IntroNewMatrix(int[][][] matricesVector, 
            int[][] matricesSizes, int totalMatrices){
        /*
        Introduces a new matrix in destinationMatrix if it's possible. 
        The dimesion of the new matrix is stored in the vector destinationMatrixSize.
        */
        
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        boolean save;
      
        if (totalMatrices < maxMatrices) {

            try {
                newMatrix(tempMatrix, tempMatrixSize);
            } catch (Exception e) {
                System.out.println("Something went wrong");
                return false;
            }
        }else{
            System.out.println("Maximum amount of matrices reached");
        }
        System.out.println("New matrix:\n");
        printMatrix(tempMatrix, tempMatrixSize);
        
        save = saveMatrix(tempMatrix, tempMatrixSize, 
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);
        return save;
    }
    
    static void case2ShowMatrix(int[][][] matricesVector, int[][] matricesSizes,
            int totalMatrices){
        
        int matrixIndex;
        
        System.out.println("Select the matrix you want to display:");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.print("Enter the number of the matrix: ");
        matrixIndex = selectMatrixIndex(totalMatrices);
        
        printMatrix(matricesVector[matrixIndex],matricesSizes[matrixIndex]);

    }
    
    static boolean case3AddingMatrices(int[][][] matricesVector, int[][] matricesSizes, 
            int totalMatrices){
        
        int matrix1Index;
        int matrix2Index;
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        boolean save;
     
        //Selection of the matrices. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.println("Availabe matrices\n");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.println("\nSelect the matrices for the addition:");
        System.out.println("(remember that both should have the same size)\n");
        
        System.out.print("Matrix 1: ");
        matrix1Index = selectMatrixIndex(totalMatrices);
        System.out.print("\nMatrix 2: ");
        matrix2Index = selectMatrixIndex(totalMatrices);
        
        //Matrices adition logic
        if (matricesSizes[matrix1Index][0] == matricesSizes[matrix2Index][0]
                && matricesSizes[matrix1Index][1] == matricesSizes[matrix2Index][1]) {
            
            tempMatrixSize[0] = matricesSizes[matrix1Index][0];
            tempMatrixSize[1] = matricesSizes[matrix1Index][1];
            
            matrixAddition(matricesVector[matrix1Index], matricesVector[matrix2Index],
                    tempMatrixSize, tempMatrix);
            
            printMatrix(tempMatrix, tempMatrixSize);
            
            save = saveMatrix(tempMatrix, tempMatrixSize, 
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);
            return save;
        }else {
            System.out.println("The matrices doesn't have the same size");
            return false;
        }
        
    }
    
    static boolean case4SubstractingMatrices(int[][][] matricesVector, 
            int[][] matricesSizes, int totalMatrices){
        int matrix1;
        int matrix2;
     
        int matrix1Index;
        int matrix2Index;
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        boolean save;
     
        //Selection of the matrices. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.println("Availabe matrices\n");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.println("\nSelect the matrices for the addition:");
        System.out.println("(remember that both should have the same size)\n");
        
        System.out.print("Matrix 1: ");
        matrix1Index = (intImput() -1);
        System.out.print("\nMatrix 2: ");
        matrix2Index = (intImput() - 1);
        
        //Matrices substraction logic
        if (matricesSizes[matrix1Index][0] == matricesSizes[matrix2Index][0]
                && matricesSizes[matrix1Index][1] == matricesSizes[matrix2Index][1]) {
            
            tempMatrixSize[0] = matricesSizes[matrix1Index][0];
            tempMatrixSize[1] = matricesSizes[matrix1Index][1];
            
            matrixSubstraction(matricesVector[matrix1Index], matricesVector[matrix2Index],
                    tempMatrixSize, tempMatrix);
            
            printMatrix(tempMatrix, tempMatrixSize);
            save = saveMatrix(tempMatrix, tempMatrixSize, 
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);
        
            return save;
        }else{
            System.out.println("The matrices doesn't have the same size");
            return false;
        }
        
    }
    

    
    static boolean case5MatrixByNumber(int[][][] matricesVector, int[][] matricesSizes,
            int totalMatrices){
        
        int matrixIndex;
        int number;
        // The matrix size remains the same in this operation
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        boolean save;
        
        //Selection of the matrix. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.print("Select the matrix : ");
        matrixIndex = intImput() -1;
        System.out.print("Enter the number to multiply the matrix : ");
        number = intImput();
        
        matrixByNumber(matricesVector[matrixIndex], number, tempMatrix);
        
        printMatrix(tempMatrix, matricesSizes[matrixIndex]);
        
        save = saveMatrix(tempMatrix, matricesSizes[matrixIndex], 
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);
        
        return save;
    }
    
    static boolean case6MatrixMultiplication(int[][][] matricesVector, int[][] matricesSizes,
            int totalMatrices){
        
        int matrix1;
        int matrix2;
     
        int matrix1Index;
        int matrix2Index;
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        boolean save;
        boolean operationDone;
     
        //Selection of the matrices. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.println("Availabe matrices\n");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.println("\nSelect the 2 matrices you want to multiply:");
        System.out.println("(remember that the 1st has to have the same"
                + " columns as rows has the 2nd)\n");
        
        System.out.print("Matrix 1: ");
        matrix1Index = (intImput() -1);
        System.out.print("\nMatrix 2: ");
        matrix2Index = (intImput() - 1);
        
        operationDone = matrixMultiplication(matricesVector[matrix1Index],
                matricesSizes[matrix1Index],matricesVector[matrix2Index], 
                matricesSizes[matrix2Index], tempMatrix, tempMatrixSize);
        
        if (operationDone) {
            printMatrix(tempMatrix, tempMatrixSize);
            save = saveMatrix(tempMatrix, tempMatrixSize,
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);

            return save;
        }else{
            return false;
        }
        
    }
    
    static boolean case7MatrixTranspose(int[][][] matricesVector, int[][] matricesSizes,
            int totalMatrices){
        
        int matrixIndex;
        int number;
        
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        
        boolean save;
        
        //Selection of the matrix. intImput is decreased by one in order to get
        //the matrix index for use it in matricesVector.
        System.out.println("Availabe matrices\n");
        showMatricesSizes(totalMatrices, matricesSizes);
        System.out.print("Select the matrix : ");
        matrixIndex = intImput() -1;
        
        matrixTransposition(matricesVector[matrixIndex], tempMatrix);
        //Size of the transposed matrix
        tempMatrixSize[0] = matricesSizes[matrixIndex][1];
        tempMatrixSize[1] = matricesSizes[matrixIndex][0];
        
        printMatrix(tempMatrix, tempMatrixSize);
        
        save = saveMatrix(tempMatrix, tempMatrixSize, 
                    matricesVector[totalMatrices], matricesSizes[totalMatrices]);
        
        return save;
    }
    
    public static void main(String[] args) {
        //Array to store all the matrices.
        int matricesVector[][][] = 
                new int[maxMatrices][maxMatrixSize][maxMatrixSize];
        //Vector to know the dimensions of every matrix introduced.
        int matricesSizes[][]= new int[maxMatrices][2];
        
        int totalMatrices = 0;//Counts the number of matrices in matricesVector
        boolean newMatrix; //To know if a new matrix has been saved
        int option = -1;
        int tempMatrix[][] = new int[maxMatrixSize][maxMatrixSize];
        int tempMatrixSize[] = new int[2];
        
        //Main program logic
        while (option != 8) {
            menu();
            option = intImput();
            System.out.println("");
            newMatrix = false;

 
            switch (option) {
                case 1:
                    newMatrix=case1IntroNewMatrix(matricesVector, 
                            matricesSizes, totalMatrices);
                    if (newMatrix) {
                        totalMatrices++;
                    }
                    break;

                case 2:
                    if (totalMatrices > 0) {
                        case2ShowMatrix(matricesVector, matricesSizes, totalMatrices);
                    }else{
                        System.out.println("There's no matrices stored");
                    }
                    System.out.println("");

                    break;
                    
                case 3:
                    if (totalMatrices >= 2) {
                        newMatrix = case3AddingMatrices(matricesVector,
                                matricesSizes, totalMatrices);
                        if (newMatrix) {
                            totalMatrices++;
                        }
                    } else {
                        System.out.println("There's no enought matrices stored");
                    }
                    
                    
                    break;
                    
                case 4:
                    if (totalMatrices >= 2) {
                        newMatrix = case4SubstractingMatrices(matricesVector,
                                matricesSizes, totalMatrices);
                        if (newMatrix) {
                            totalMatrices++;
                        }
                    } else {
                        System.out.println("There's no enought matrices stored");
                    }
                    break;
                    
                case 5:
                    if (totalMatrices > 0) {
                        newMatrix = case5MatrixByNumber(matricesVector, matricesSizes,
                                totalMatrices);
                        if (newMatrix) {
                            totalMatrices++;
                        }
                    } else {
                        System.out.println("There's no matrices stored");
                    }
                    break;
                    
                case 6:
                    if (totalMatrices >= 2) {
                        newMatrix = case6MatrixMultiplication(matricesVector,
                                matricesSizes, totalMatrices);
                        if (newMatrix) {
                            totalMatrices++;
                        }
                    } else {
                        System.out.println("There's no enought matrices stored");
                    }
                    break;
                    
                case 7:
                    if (totalMatrices > 0) {
                        newMatrix = case7MatrixTranspose(matricesVector, matricesSizes,
                                totalMatrices);
                        if (newMatrix) {
                            totalMatrices++;
                        }
                    } else {
                        System.out.println("There's no matrices stored");
                    }
                    break; 
                    
                case 8:
                    break;
                    
                default:
                    System.out.println("Bad input");
            }
        }
    }
}
