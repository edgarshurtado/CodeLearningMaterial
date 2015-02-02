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
    private final Square[][] boardMatrix;
    private int numberOfMines;
    private boolean minesExploded;
    private final int[][] positionsAround; 
    
    public Board(int numberOfMines){
        int[][] minesPositions;
        positionsAround = 
                new int[][]{{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        minesExploded = false;
        this.boardMatrix = new Square[8][8];
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                boardMatrix[row][col] = new Square();
            }
        }
        minesPositions = generateMinesPositions(numberOfMines);
        plantMines(minesPositions);
        calcMinesAround(minesPositions);      
    }
    
    public boolean getMinesExploded(){
        return this.minesExploded;
    }
    
    public void flipSquare(int[] position){
        try {
            if ("M".equals(this.boardMatrix[position[0]][position[1]].getValue())) {
            this.minesExploded = true;
        }else{
            flipCascade(position);
        }
            
        } catch (ArrayIndexOutOfBoundsException e) {
        }        
    }
    
    public void printBoard(){
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                //The condition makes available print the matrix if we still
                //on game or if we've exploded a mine
                if (this.boardMatrix[row][col].getShowValue() || this.minesExploded) {
                    System.out.print(this.boardMatrix[row][col].getValue() + "|");
                } else {
                    if (this.boardMatrix[row][col].getFlagged()) {
                        System.out.print("F|");
                    } else {
                        System.out.print("X|");
                    }
                }
            }//Print the row number at the left of the board
            System.out.println(" " + (row + 1) + " ");
        }
        System.out.println("");
        //Print the cols number at the bottom of the board
        for (int col = 0; col < this.boardMatrix[0].length; col++) {
            System.out.print((col + 1) + " ");
        }
        System.out.println("");
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
    
    private void plantMines(int[][] positions){
        int row;
        int col;
        
        for (int coords = 0; coords < positions.length; coords++){
            row = positions[coords][0];
            col = positions[coords][1];
            this.boardMatrix[row][col].mine();
        }
    }
    
    /**
     * Given a matrix with all the mines positions, calculates the number of mines
     * each square of the board is in touch. The resulting values are stored in each square.
     * @param minesPositions Matrix with the positions of the mines.
     */
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
    
    public boolean newFlag(int[] position){
        if (!this.boardMatrix[position[0]][position[1]].getShowValue()){
            this.boardMatrix[position[0]][position[1]].flag();
        }
        return true;
    }
    
    private void flipCascade (int[] initialPosition){
        int[] newPos;
        boolean flagged;
        boolean squareAlreadyFlipped;
        try {
            squareAlreadyFlipped
                    = this.boardMatrix[initialPosition[0]][initialPosition[1]].getShowValue();
            flagged = this.boardMatrix[initialPosition[0]][initialPosition[1]].getFlagged();
            String squareValue
                    = this.boardMatrix[initialPosition[0]][initialPosition[1]].getValue();            
            //Conditions to flip the square.
            if (!squareAlreadyFlipped && !"M".equals(squareValue) && !flagged) {
                this.boardMatrix[initialPosition[0]][initialPosition[1]].flipSquare();
                //Recursiveness
                if ("0".equals(squareValue)) {
                    for (int[] posAr : this.positionsAround) {
                        newPos = new int[]{posAr[0] + initialPosition[0],
                            posAr[1] + initialPosition[1]};
                        flipCascade(newPos);
                    }
                }
        }
        } catch (Exception e) {
        }
    }
    
    
}
