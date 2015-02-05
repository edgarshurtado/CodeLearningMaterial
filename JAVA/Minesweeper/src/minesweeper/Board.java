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
    private int numberOfHidedSquares;
    private boolean minesExploded;
    private final int[][] positionsAround; 
    
    private final char MINE = '*';
    private final char FLAG = 'F';
    private final char HIDE_SQUARE = 'X';
    
    public Board(int numberOfMines, int matrixSize){
        //Atributes asignations
        int[][] minesPositions;
        positionsAround = 
                new int[][]{{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        minesExploded = false;
        this.boardMatrix = new Square[matrixSize][matrixSize];
        this.numberOfHidedSquares = matrixSize*matrixSize;
        this.numberOfMines = numberOfMines;
        
        //Create the grid of squares
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                boardMatrix[row][col] = new Square();
            }
        }
        //Operations for set the mines
        minesPositions = generateMinesPositions(numberOfMines);
        plantMines(minesPositions);
        calcMinesAround(minesPositions);      
    }
    
    public boolean isGameOver(){
        return this.minesExploded || this.numberOfHidedSquares == this.numberOfMines;
    }
    
    public boolean getMinesExploded(){
        return this.minesExploded;
    }
    
    public void flipSquare(int[] position){
        try {
            if (this.boardMatrix[position[0]][position[1]].isMined()) {
            this.minesExploded = true;
        }else{
            flipCascade(position);
        }
            
        } catch (ArrayIndexOutOfBoundsException e) {
        }        
    }
    /**
     * Prints the values of the squares that are flipped and show an X in the squares of
     * unknown value.
     * 
     * If the game is over prints all the values.
     * @param cheats True if the user wants to see the mines on the board
     */
    public void printBoard(boolean cheats){
        //Go through the board matrix
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                if (cheats && this.boardMatrix[row][col].isMined()) {
                    //Print the mines if the player have activated the cheats
                    System.out.print(MINE + "|");
                }else {
                //The condition makes available print the matrix if we still
                    //on game or if we've exploded the mines
                    if (this.boardMatrix[row][col].isFlipped() || this.minesExploded) {
                        System.out.print(this.boardMatrix[row][col].getValue() + "|");
                    } else {
                        if (this.boardMatrix[row][col].isFlagged()) {
                            System.out.print(FLAG + "|");
                        } else {
                            System.out.print(HIDE_SQUARE + "|");
                        }
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
        System.out.println(""); //scape line
    }
    
    public void printGameOver(){
        printBoard(false);
        if (minesExploded) {
            System.out.println("You've lost");            
        }else{
            System.out.println("You've won");            
        }          
    }
    
    private int[][] generateMinesPositions(int numberMines){
        int vectorIndex = 0;
        int[][] tempMinesVector = new int[this.numberOfHidedSquares][2];
        int[][] minesPositions = new int[numberMines][2];
        int[] transponserVector = new int[2];
        int maxIndex = numberOfHidedSquares;
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
        for (int minePositionIndex = 0; 
                minePositionIndex < minesPositions.length; minePositionIndex++) {
            coordIndex = UsefulFunctions.randomNumber(maxIndex);
            //Copy chosen values to the final vector
            minesPositions[minePositionIndex][0]=tempMinesVector[coordIndex][0];
            minesPositions[minePositionIndex][1]=tempMinesVector[coordIndex][1];
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
            this.boardMatrix[row][col].newMine();
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
        if (!this.boardMatrix[position[0]][position[1]].isFlipped()){
            this.boardMatrix[position[0]][position[1]].flag();
        }
        return true;
    }
    
    private void flipCascade (int[] initialPosition){
        int[] newPos;
        boolean isFlagged;
        boolean isMined;
        boolean squareAlreadyFlipped;
        try {
            squareAlreadyFlipped
                    = this.boardMatrix[initialPosition[0]][initialPosition[1]].isFlipped();
            isFlagged = 
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].isFlagged();
            isMined =
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].isMined();
            int squareValue =                    
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].getValue();
            
            //Conditions to flip the square.
            if (!squareAlreadyFlipped && !isMined && !isFlagged) {
                this.boardMatrix[initialPosition[0]][initialPosition[1]].flipSquare();
                this.numberOfHidedSquares--;
                //Recursiveness
                if (squareValue == 0) {
                    for (int[] posAr : this.positionsAround) {
                        newPos = new int[]{posAr[0] + initialPosition[0],
                            posAr[1] + initialPosition[1]};
                        flipCascade(newPos);
                    }
                } else {
                }
        }
        } catch (Exception e) {
        }
    }  
}
