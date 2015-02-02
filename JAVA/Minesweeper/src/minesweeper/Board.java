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
    int[][] positionsAround = 
        {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    
    public Board(int numberOfMines){
        int[][] minesPositions;
        this.boardMatrix = new Square[8][8];
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                boardMatrix[row][col] = new Square();
            }
        }
        minesPositions = generateMinesPositions(numberOfMines);
        setMines(minesPositions);
        calcMinesAround(minesPositions);      
    }
    
    private int[][] generateMinesPositions(int numberMines){
        int vectorIndex = 0;
        int[][] tempMinesVector = new int[8*8][2];
        int[][] minesPositions = new int[numberMines][2];
        int[] transponserVector = new int[2];
        int maxIndex = 64;
        int coordIndex;
        //Generate a vector with all the possible positions
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                tempMinesVector[vectorIndex][0] = row;
                tempMinesVector[vectorIndex][1] = col;
                vectorIndex++;
            }    
        }
        //Select the positions
        for (int coord = 0; coord < minesPositions.length; coord++) {
            coordIndex = UsefulFunctions.randomNumber(maxIndex);
            //Copy chosen values to the final vector
            minesPositions[coord][0]=tempMinesVector[coordIndex][0];
            minesPositions[coord][1]=tempMinesVector[coordIndex][1];
            //Save last position, copy to the used index, reduce the vector max index
            transponserVector[0] = tempMinesVector[maxIndex - 1][0];
            transponserVector[1] = tempMinesVector[maxIndex - 1][1];
            tempMinesVector[coordIndex][0] = transponserVector[0];
            tempMinesVector[coordIndex][1] = transponserVector[1];
            maxIndex--;
        }
//        //Print the selected positions for testing
//        for (int i = 0; i < minesPositions.length; i++) {
//            for (int j = 0; j < minesPositions[0].length; j++) {
//                System.out.print(minesPositions[i][j] + " ");                
//            }
//            System.out.print("| ");
//        }
//        System.out.println("");
        
        return minesPositions;
    }
    
    private void setMines(int[][] positions){
        int row;
        int col;
        
        for (int coords = 0; coords < positions.length; coords++){
            row = positions[coords][0];
            col = positions[coords][1];
            this.boardMatrix[row][col].mine();
        }
    }
    
    private void calcMinesAround(int[][] minesPositions){
        
        int tempValue;
        for(int[] minePos : minesPositions){
            for(int[] posAr: this.positionsAround){
                try {
                    this.boardMatrix[minePos[0]+posAr[0]][minePos[1]+posAr[1]].increaseValueBy1();
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void flipCascade (int[] initialPosition){
        int[] newPos;
        try {
            boolean squareAlreadyFlipped = 
                this.boardMatrix[initialPosition[0]][initialPosition[1]].getShowValue();
            String squareValue
                    = this.boardMatrix[initialPosition[0]][initialPosition[1]].getValue();
            if (squareValue != "0" && squareAlreadyFlipped == false) {
                this.boardMatrix[initialPosition[0]][initialPosition[1]].flipSquare();
                for (int[] posAr : this.positionsAround) {
                    newPos = new int[]{posAr[0] + initialPosition[0],
                        posAr[1] + initialPosition[1]};
                    flipCascade(newPos);
                }
            }
        } catch (Exception e) {
        }
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
            System.out.println(" " + (row+1) + " ");
        }
        System.out.println("");
        for (int col = 0; col < this.boardMatrix[0].length; col++) {
            System.out.print((col+1) + " ");
        }
        System.out.println("");
    }
}
