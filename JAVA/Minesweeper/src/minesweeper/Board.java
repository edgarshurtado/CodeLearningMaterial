/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Rumil
 */
public class Board {
    private Square[][] boardMatrix;
    int numberOfMines;
    
    public Board(int numberOfMines){
        int[][] minesPositions;
        this.boardMatrix = new Square[8][8];
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                boardMatrix[row][col] = new Square();
            }
        }
        minesPositions = generateMinesPositions(numberOfMines);
        for (int i = 0; i < minesPositions.length; i++) {
            for (int j = 0; j < minesPositions[0].length; j++) {
                System.out.print(minesPositions[i][j] + " ");                
            }
            System.out.println("");
        }
    }
    
    private int[][] generateMinesPositions(int numberMines){
        int vectorIndex = 0;
        int[][] tempMinesVector = new int[8*8][2];
        int[][] minesPositions = new int[numberMines][2];
        int[] transponserVector = new int[2];
        int maxNumber = 64;
        int coordIndex;
        
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                tempMinesVector[vectorIndex][0] = row;
                tempMinesVector[vectorIndex][1] = col;
                vectorIndex++;
            }    
        }
        
        for (int coord = 0; coord < minesPositions.length; coord++) {
            coordIndex = UsefulFunctions.randomNumber(maxNumber);
            //Save the values in the final vector
            minesPositions[coord][0]=tempMinesVector[coordIndex][0];
            minesPositions[coord][1]=tempMinesVector[coordIndex][1];
            //Move vector item and cut it down
            transponserVector[0] = tempMinesVector[maxNumber - 1][0];
            transponserVector[1] = tempMinesVector[maxNumber - 1][1];
            tempMinesVector[coordIndex][0] = transponserVector[0];
            tempMinesVector[coordIndex][1] = transponserVector[1];
            maxNumber--;
        }
        
        return minesPositions;
    }
    
    public void printBoard(){
        for(int row = 0; row < this.boardMatrix.length; row++){            
            for(int col = 0; col < this.boardMatrix[0].length; col++){                
                if (this.boardMatrix[row][col].getShowValue()) {
                    System.out.print(this.boardMatrix[row][col].getValue() + "|");
                } else{
                    System.out.print("X|");
                }
            }
            System.out.println((row+1) + " ");
        }
        for (int col = 0; col < this.boardMatrix[0].length; col++) {
            System.out.print((col+1) + " ");
        }
        System.out.println("");
    }
}
