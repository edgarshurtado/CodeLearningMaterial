/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Rumil
 */
public class UsefulFunctions {
    
    static BufferedReader dataIn = new BufferedReader
        (new InputStreamReader(System.in));
    
    public static int randomNumber(int maxNumber){
        int randomNumber;
        
        Random randomGenerator = new Random();
        
        randomNumber = randomGenerator.nextInt(maxNumber);
        
        return randomNumber;
    }
    
    static int intImput(){
        //Function for allow keyboard integer inputs
        
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
    
    static String strInput(){
        String tempInput = "";
        boolean correctInput = false;
        while(!correctInput){
            try {
                tempInput = dataIn.readLine();
                correctInput = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInput;
    }
    
    static int[][] randomPositions(int sizeOfGrid, int numberOfPositions) {
        int vectorIndex = 0;
        int[][] grid = new int[sizeOfGrid][sizeOfGrid];
        int[][] tempVector = new int[grid.length][2];
        int[][] positionsArray = new int[numberOfPositions][2];
        int[] transponserVector = new int[2];
        int maxIndex = numberOfPositions;
        int coordIndex;
        //Generate a vector with all the possible positions
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                tempVector[vectorIndex][0] = row;
                tempVector[vectorIndex][1] = col;
                vectorIndex++;
            }
        }
        //Select the positions
        for (int positionIndex = 0;
                positionIndex < positionsArray.length; positionIndex++) {
            coordIndex = UsefulFunctions.randomNumber(maxIndex);
            //Copy chosen values to the final vector
            positionsArray[positionIndex][0] = tempVector[coordIndex][0];
            positionsArray[positionIndex][1] = tempVector[coordIndex][1];
            //Save last position, copy to the used index, reduce the vector max index
            transponserVector[0] = tempVector[maxIndex - 1][0];
            transponserVector[1] = tempVector[maxIndex - 1][1];
            tempVector[coordIndex][0] = transponserVector[0];
            tempVector[coordIndex][1] = transponserVector[1];
            maxIndex--;

        }
        return positionsArray;
    }
}
